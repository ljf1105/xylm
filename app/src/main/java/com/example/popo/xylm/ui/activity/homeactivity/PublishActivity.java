package com.example.popo.xylm.ui.activity.homeactivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.ui.activity.MainActivity;
import com.example.popo.xylm.utils.PhotoUtils;
import com.example.popo.xylm.utils.ToastUtils;
import com.example.popo.xylm.utils.ToolBarUtils;

import java.io.File;

public class PublishActivity extends BaseActivity implements View.OnClickListener {

    private TextView fy_text;
    private Toolbar fy_toolbar;
    private LinearLayout lin_add;
    private Button fb_submit;
    private TextView sc_video;
    private TextView zj_video;
    private TextView zj_audio;
    private TextView sc_photo;
    private TextView zj_photo;
    private Button cancel;
    private PopupWindow popupWindow;
    private LinearLayout lin22;
    /* private final static int REQUEST_CAREMA = 1;
     private final static int REQUEST_GET_PERMISSION = 2;
     public static String SAVED_IMAGE_DIR_PATH = Environment.getExternalStorageDirectory().getPath() + "/ImageCut/camera/";// 拍照路径
     String cameraPath;*/
    private ImageView xj_img;
    /*  private static final int RESULT_CAPTURE_IMAGE = 1;// 照相的requestCode
      private static final int REQUEST_CODE_TAKE_VIDEO = 2;// 摄像的照相的requestCode
      private static final int RESULT_CAPTURE_RECORDER_SOUND = 3;// 录音的requestCode

      private String strImgPath = "";// 照片文件绝对路径
      private String strVideoPath = "";// 视频文件的绝对路径
      private String strRecorderPath = "";// 录音文件的绝对路径*/
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        initView();
        ToolBarUtils.newInstance().setToolBar(this, fy_toolbar, fy_text, "发布课程作品");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish;
    }

    private void initView() {
        fy_text = (TextView) findViewById(R.id.fy_text);
        fy_toolbar = (Toolbar) findViewById(R.id.fy_toolbar);
        lin_add = (LinearLayout) findViewById(R.id.lin_add);
        lin_add.setOnClickListener(this);
        fb_submit = (Button) findViewById(R.id.fb_submit);
        fb_submit.setOnClickListener(this);

        lin22 = (LinearLayout) findViewById(R.id.lin22);
        lin22.setOnClickListener(this);
        xj_img = (ImageView) findViewById(R.id.xj_img);
        xj_img.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //添加
            case R.id.lin_add:
                initPopup();
                //从底部弹出
                popupWindow.showAtLocation(findViewById(R.id.lin22), Gravity.BOTTOM, 0, 0);
                break;
            //提交
            case R.id.fb_submit:
                break;
            //上传视频
            case R.id.sc_video:

                break;
            //直接录影
            case R.id.zj_video:
//                videoMethod();
                break;
            //直接录音
            case R.id.zj_audio:
//                soundRecorderMethod();
                break;
            //上踹照片
            case R.id.sc_photo:
                autoObtainStoragePermission();

                break;
            //直接拍照
            case R.id.zj_photo:
//                cameraMethod();
                //获取相机权限，如果不开启会报错
             /*   if (ContextCompat.checkSelfPermission(PublishActivity.this, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(PublishActivity.this,
                            new String[]{Manifest.permission.CAMERA}, REQUEST_GET_PERMISSION);
                    takePhotoIn7();
                }*/

                autoObtainCameraPermission();

                break;
            //取消
            case R.id.cancel:
                break;
        }
    }


    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ToastUtils.showShort(this, "您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        } else {//有权限直接调用系统相机拍照
            if (hasSdcard()) {
                imageUri = Uri.fromFile(fileUri);
                //通过FileProvider创建一个content类型的Uri
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    imageUri = FileProvider.getUriForFile(PublishActivity.this, "com.zz.fileprovider", fileUri);
                }
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
            } else {
                ToastUtils.showShort(this, "设备没有SD卡！");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            //调用系统相机申请拍照权限回调
            case CAMERA_PERMISSIONS_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (hasSdcard()) {
                        imageUri = Uri.fromFile(fileUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            imageUri = FileProvider.getUriForFile(PublishActivity.this, "com.zz.fileprovider", fileUri);//通过FileProvider创建一个content类型的Uri
                        PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                } else {

                    ToastUtils.showShort(this, "请允许打开相机！！");
                }
                break;


            }
            //调用系统相册申请Sdcard权限回调
            case STORAGE_PERMISSIONS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
                } else {

                    ToastUtils.showShort(this, "请允许打操作SDCard！！");
                }
                break;
            default:
        }
    }


    private static final int OUTPUT_X = 480;
    private static final int OUTPUT_Y = 480;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                //拍照完成回调
                case CODE_CAMERA_REQUEST:
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    break;
                //访问相册完成回调
                case CODE_GALLERY_REQUEST:
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            newUri = FileProvider.getUriForFile(this, "com.zz.fileprovider", new File(newUri.getPath()));
                        }
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        showImages(bitmap);
                    }
                    break;
                default:
            }
        }
    }


    private void autoObtainStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }
    }

    private void showImages(Bitmap bitmap) {
        xj_img.setVisibility(View.VISIBLE);
        xj_img.setImageBitmap(bitmap);
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

   /* private void takePhotoIn7() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //图片名称
            String cameraPath = SAVED_IMAGE_DIR_PATH + System.currentTimeMillis() + ".png";
            String out_file_path = SAVED_IMAGE_DIR_PATH;
            //创建存放图片的文件夹
            File dir = new File(out_file_path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        FileProvider.getUriForFile(PublishActivity.this,
                                "com.example.android.androidngetfile.fileprovide", new File(cameraPath)));
                xj_img.setVisibility(View.VISIBLE);
                Glide.with(PublishActivity.this).load(cameraPath).into(xj_img);
            } else {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(cameraPath)));
                xj_img.setVisibility(View.VISIBLE);
                Glide.with(PublishActivity.this).load(cameraPath).into(xj_img);
            }
            startActivityForResult(intent, REQUEST_CAREMA);
        } else {
            Toast.makeText(PublishActivity.this, "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAREMA://相机
                    Log.i("ruxing", "拍照成功！carema path=" + cameraPath);
                    break;
            }
        }
    }*/


/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_CAPTURE_IMAGE://拍照
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, strImgPath, Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_TAKE_VIDEO://拍摄视频
                if (resultCode == RESULT_OK) {
                    Uri uriVideo = data.getData();
                    Cursor cursor = this.getContentResolver().query(uriVideo, null, null, null, null);
                    if (cursor.moveToNext()) {
                        *//** _data：文件的绝对路径 ，_display_name：文件名 *//*
                        strVideoPath = cursor.getString(cursor.getColumnIndex("_data"));
                        Toast.makeText(this, strVideoPath, Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case RESULT_CAPTURE_RECORDER_SOUND://录音
                if (resultCode == RESULT_OK) {
                    Uri uriRecorder = data.getData();
                    Cursor cursor = this.getContentResolver().query(uriRecorder, null, null, null, null);
                    if (cursor.moveToNext()) {
                        *//** _data：文件的绝对路径 ，_display_name：文件名 *//*
                        strRecorderPath = cursor.getString(cursor.getColumnIndex("_data"));
                        Toast.makeText(this, strRecorderPath, Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    *//**
     * 照相功能
     *//*
    private void cameraMethod() {
        Intent imageCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        strImgPath = Environment.getExternalStorageDirectory().toString() + "/CONSDCGMPIC/";//存放照片的文件夹
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg";//照片命名
        File out = new File(strImgPath);
        if (!out.exists()) {
            out.mkdirs();
        }
        out = new File(strImgPath, fileName);
        strImgPath = strImgPath + fileName;//该照片的绝对路径
        Uri uri = Uri.fromFile(out);
        imageCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        imageCaptureIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(imageCaptureIntent, RESULT_CAPTURE_IMAGE);

    }

    *//**
     * 拍摄视频
     *//*
    private void videoMethod() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
        startActivityForResult(intent, REQUEST_CODE_TAKE_VIDEO);
    }

    *//**
     * 录音功能
     *//*
    private void soundRecorderMethod() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/amr");
        startActivityForResult(intent, RESULT_CAPTURE_RECORDER_SOUND);
    }

    */

    /**
     * 提示信息
     *
     * @param text
     * @param duration
     *//*
    private void showToast(String text, int duration) {
        Toast.makeText(this, text, duration).show();
    }*/
    private void initPopup() {
        popupWindow = new PopupWindow();
        View view = LayoutInflater.from(this).inflate(R.layout.popup, null);
        popupWindow.setContentView(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        sc_video = (TextView) view.findViewById(R.id.sc_video);
        sc_video.setOnClickListener(this);
        zj_video = (TextView) view.findViewById(R.id.zj_video);
        zj_video.setOnClickListener(this);
        zj_audio = (TextView) view.findViewById(R.id.zj_audio);
        zj_audio.setOnClickListener(this);
        sc_photo = (TextView) view.findViewById(R.id.sc_photo);
        sc_photo.setOnClickListener(this);
        zj_photo = (TextView) view.findViewById(R.id.zj_photo);
        zj_photo.setOnClickListener(this);
        cancel = (Button) view.findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
    }
}
