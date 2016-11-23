package com.meowzv.zhihureader.ui.fragment;

import android.content.Context;

import com.yuyh.easyadapter.abslistview.EasyLVAdapter;
import com.yuyh.easyadapter.abslistview.EasyLVHolder;

import java.util.List;

/**
 * Created by Meowzv on 2016/11/23.
 */

public class NewsAdapter extends EasyLVAdapter {

    public NewsAdapter(Context context, List list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    public NewsAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public void convert(EasyLVHolder holder, int position, Object o) {

    }
}
