package com.meowzv.zhihureader.api;

import com.meowzv.zhihureader.bean.LatestEntity;
import com.meowzv.zhihureader.bean.LogoBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Meowzv on 16/11/13.
 */

public interface ReaderApiService {
    //获取首页图片
    @GET("start-image/1080*1776")
    Observable<LogoBean> getStartImage();
    //获取主页数据
    @GET("news/latest")
    Observable<LatestEntity> getLatestNews();

    @GET("news/before/{date}")
    Observable<LatestEntity> getBeforeNews(@Path("date") String date);
}
