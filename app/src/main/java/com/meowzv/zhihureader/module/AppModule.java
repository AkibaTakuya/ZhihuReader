package com.meowzv.zhihureader.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luwang on 2016/12/6.
 */
@Module
public class AppModule {
    private Context mContext;
    public AppModule(Context context){
        this.mContext = context;
    }
    @Provides
    public Context provideContext(){
        return this.mContext;
    }
}
