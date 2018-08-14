package com.example.popo.xylm.ui.activity;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;
import com.example.popo.xylm.utils.EditTextUtil;
import com.example.popo.xylm.utils.ImageUtils;
import com.example.popo.xylm.utils.RegexCst;
import com.example.popo.xylm.utils.RetrofitUtils;
import com.example.popo.xylm.xylm.XylmContract;
import com.example.popo.xylm.xylm.XylmModel;
import com.example.popo.xylm.xylm.XylmPresenter;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import static com.example.popo.xylm.base.BaseModel.mineService;

public class PerfectActivity extends BaseActivity<XylmModel,XylmPresenter> implements XylmContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.argImage)
    ImageView argImage;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.perEorry)
    ImageView perEorry;
    @BindView(R.id.perPass)
    EditText perPass;
    @BindView(R.id.perEorry2)
    ImageView perEorry2;
    @BindView(R.id.complete)
    Button complete;
    @BindView(R.id.addImage)
    ImageView addImage;
    @BindView(R.id.boy)
    RadioButton boy;
    @BindView(R.id.girl)
    RadioButton girl;
    @BindView(R.id.radiogp)
    RadioGroup radiogp;
    private String userName;
    private String pass;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    private String imagePath;
    private String phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect);
        ButterKnife.bind(this);
        EditTextUtil.deleteA(name, perEorry);
        EditTextUtil.deleteA(perPass, perEorry2);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        Log.e("TAG------","PHONE-----"+phone);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_perfect;
    }


    @OnClick({R.id.argImage, R.id.name, R.id.perEorry, R.id.perPass, R.id.perEorry2, R.id.complete, R.id.addImage})
    public void onViewClicked(View view) {
        userName = name.getText().toString();
        pass = perPass.getText().toString();
        switch (view.getId()) {
            case R.id.argImage:
                break;
            case R.id.addImage:
                showChoosePicDialog();
                break;
            case R.id.name:

                break;
            case R.id.perEorry:
                name.setText("");
                perEorry.setVisibility(View.GONE);
                break;
            case R.id.perPass:

                break;
            case R.id.perEorry2:
                perPass.setText("");
                perEorry2.setVisibility(View.GONE);
                break;
            case R.id.complete:
                if (userName.matches(RegexCst.REGEX_USERNAME)) {
                    if (pass.matches(RegexCst.REGEX_EN_NUM)) {
                    } else {
                        startActivity(new Intent(this,LabelActivity.class));
                        Toast.makeText(this, "密码不符合规则，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "账号不符合规则，请重新输入", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    protected void showChoosePicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] items = {"选择本地照片", "拍照"};
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     * @param
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            photo = ImageUtils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
            argImage.setImageBitmap(photo);
            uploadPic(photo);
        }
    }

    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了

        imagePath = ImageUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        if (imagePath != null) {
            // 拿着imagePath上传了
            // ...'
            Uri uri = getUri(imagePath);
            Log.e("----url-----", ""+uri);
            Log.e("----image-----", ""+ imagePath);
        }
    }

    private Uri getUri(String path) {
        Uri uri = null;
        if (path != null) {
            path = Uri.decode(path);
            Log.d("--------path", "path2 is " + path);
            ContentResolver cr = this.getContentResolver();
            StringBuffer buff = new StringBuffer();
            buff.append("(")
                    .append(MediaStore.Images.ImageColumns.DATA)
                    .append("=")
                    .append("'" + path + "'")
                    .append(")");
            Cursor cur = cr.query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Images.ImageColumns._ID},
                    buff.toString(), null, null);
            int index = 0;
            for (cur.moveToFirst(); !cur.isAfterLast(); cur
                    .moveToNext()) {
                index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID);
// set _id value
                index = cur.getInt(index);
            }
            if (index == 0) {
//do nothing
            } else {
                Uri uri_temp = Uri.parse("content://media/external/images/media/" + index);
                Log.d("--------url", "uri_temp is " + uri_temp);
                if (uri_temp != null) {
                    uri = uri_temp;
                }
            }
        }
        return uri;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        } else {
            // 没有获取 到权限，从新请求，或者关闭app
            Toast.makeText(this, "需要存储权限", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showUser(User user) {
        String message = user.getMessage();
        Log.e("TAG------message","user---"+message);

    }

    @Override
    public void showPreference(Preference preference) {

    }

    @Override
    public void showResetPass(ResetPass resetPass) {

    }

    @Override
    public void showYzm(Code code) {

    }

    @Override
    public void showYzmSucess(Code code) {

    }

    @Override
    public void showLogin(Login login) {

    }

    @Override
    public void showToken(TokenBean tokenBean) {

    }

    @Override
    public void showHome(HomeBean homeBean) {

    }
}
