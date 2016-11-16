package com.meowzv.zhihureader.api;

import com.meowzv.zhihureader.base.Constant;
import com.meowzv.zhihureader.model.LatestEntity;
import com.meowzv.zhihureader.model.LogoBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Meowzv on 16/11/13.
 */

public class ReaderApi {
    private static final String TAG = "ReaderApi";
    private static final long DEFLAUT_TIMEOUT = 5;
    private static ReaderApi sReaderApi;
    private ReaderApiService mReaderApiService;

    //构造方法私有化
    private ReaderApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        mReaderApiService = retrofit.create(ReaderApiService.class);
    }

    public static ReaderApi getInstance(){
        //手动创建一个OkHttpClient,并且设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFLAUT_TIMEOUT, TimeUnit.SECONDS);
        return getInstance(builder.build());
    }

    public static synchronized ReaderApi getInstance(OkHttpClient okHttpClient) {
        if (sReaderApi == null)
            sReaderApi = new ReaderApi(okHttpClient);
        return sReaderApi;
    }

    /**
     * 获取首页的背景图片
     * @return
     */
    public Observable<LogoBean> getStartImage(){
        return mReaderApiService.getStartImage();
    }

    public Observable<LatestEntity> getLatestNews(){
        return mReaderApiService.getLatestNews();
    }
}
