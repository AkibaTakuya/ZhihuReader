package com.meowzv.zhihureader.module;

import com.meowzv.zhihureader.api.ReaderApi;
import com.meowzv.zhihureader.utils.LogUtils;
import com.meowzv.zhihureader.utils.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Meowzv on 2016/12/6.
 */
@Module
public class ReaderApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient() {

        LoggingInterceptor logging = new LoggingInterceptor(new MyLog());
        logging.setLevel(LoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(logging);
        return builder.build();
    }

    @Provides
    protected ReaderApi provideBookService(OkHttpClient okHttpClient) {
        return ReaderApi.getInstance(okHttpClient);
    }

    public static class MyLog implements LoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            LogUtils.i("oklog: " + message);
        }
    }
}
