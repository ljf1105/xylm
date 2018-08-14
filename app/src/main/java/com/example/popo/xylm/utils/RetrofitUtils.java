package com.example.popo.xylm.utils;

import com.example.popo.xylm.constact.MineService;
import com.example.popo.xylm.constact.Urls;
import com.example.popo.xylm.data.beans.Keys;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private RetrofitUtils() {
        okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截器 拦截请求
                Request request = chain.request().newBuilder()
                        .addHeader("apptoken", String.valueOf(SPUtil.getInstance().get(Keys.TOKEN, "")))
                        .addHeader("user-agent", String.valueOf(SPUtil.getInstance().get(Keys.USERAGENT, "")))
                        .addHeader("Authorization", "")
                        .addHeader("did", String.valueOf(SPUtil.getInstance().get(Keys.DID, "")))
                        .addHeader("cid", "dd2a152f6d132980462385b10b8487bb")
                        .addHeader("userId", String.valueOf(SPUtil.getInstance().get(Keys.ID, 0)))
                        .addHeader("oCode", "350010")
                        .addHeader("appType", "univstarUnion")
                        .build();
                return chain.proceed(request);
            }
        }).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null)
                    retrofitUtils = new RetrofitUtils();
            }
        }
        return retrofitUtils;
    }

    public MineService getMineService() {
        return retrofit.create(MineService.class);
    }


}
