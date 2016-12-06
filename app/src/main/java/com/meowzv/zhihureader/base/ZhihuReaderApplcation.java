package com.meowzv.zhihureader.base;

import android.app.Application;

/**
 * Created by Meowzv on 16/11/13.
 */

public class ZhihuReaderApplcation extends Application {
    private static ZhihuReaderApplcation sReaderApplcation;

    public static ZhihuReaderApplcation getInstance(){
        return sReaderApplcation;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sReaderApplcation = this;
    }
}
