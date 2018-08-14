package com.example.popo.xylm.base;

import com.example.popo.xylm.constact.MineService;
import com.example.popo.xylm.constact.Urls;
import com.example.popo.xylm.data.beans.Keys;
import com.example.popo.xylm.utils.SPUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by popo on 2018/7/26.
 */

public interface BaseModel {
    OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            //拦截器 拦截请求 Request
            Request request = chain.request().newBuilder()
                    .addHeader("apptoken", String.valueOf(SPUtil.getInstance().get(Keys.TOKEN, "")))
                    .addHeader("user-agent", String.valueOf(SPUtil.getInstance().get(Keys.USERAGENT,"")))
                    .addHeader("Authorization", "")
                    .addHeader("did", String.valueOf(SPUtil.getInstance().get(Keys.DID,"")))
                    .addHeader("cid", "dd2a152f6d132980462385b10b8487bb")
                    .addHeader("userId", String.valueOf(SPUtil.getInstance().get(Keys.ID, 0)))
                    .addHeader("oCode", "350010")
                    .addHeader("appType", "univstarUnion")
                    .build();
            return chain.proceed(request);
        }
    }).build();
     Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Urls.BASEURL)
             .client(okHttpClient)
            .build();
    MineService mineService = retrofit.create(MineService.class);
}
