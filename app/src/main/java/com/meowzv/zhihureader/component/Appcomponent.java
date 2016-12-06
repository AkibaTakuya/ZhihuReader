package com.meowzv.zhihureader.component;

import android.content.Context;

import com.meowzv.zhihureader.api.ReaderApi;
import com.meowzv.zhihureader.module.AppModule;
import com.meowzv.zhihureader.module.ReaderApiModule;

import dagger.Component;

/**
 * Created by luwang on 2016/12/6.
 */
@Component(modules = {AppModule.class, ReaderApiModule.class})
public interface Appcomponent {
    Context getContext();
    ReaderApi getReaderApi();
}
