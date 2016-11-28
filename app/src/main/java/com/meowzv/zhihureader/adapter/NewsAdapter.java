package com.meowzv.zhihureader.adapter;

import android.content.Context;

import com.meowzv.zhihureader.R;
import com.meowzv.zhihureader.model.LatestEntity;
import com.yuyh.easyadapter.abslistview.EasyLVAdapter;
import com.yuyh.easyadapter.abslistview.EasyLVHolder;

import java.util.List;

/**
 * Created by luwang on 2016/11/28.
 */

public class NewsAdapter extends EasyLVAdapter<LatestEntity.StoriesBean> {
    public NewsAdapter(Context context, List list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    @Override
    public void convert(EasyLVHolder holder, int position, LatestEntity.StoriesBean storiesBean) {
        holder.setText(R.id.tv,storiesBean.getGa_prefix()).setImageUrl(R.id.iv,storiesBean.getImages().get(0));
    }
}
