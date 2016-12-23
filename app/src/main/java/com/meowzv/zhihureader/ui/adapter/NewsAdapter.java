package com.meowzv.zhihureader.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.meowzv.zhihureader.R;
import com.meowzv.zhihureader.bean.LatestEntity;
import com.yuyh.easyadapter.abslistview.EasyLVAdapter;
import com.yuyh.easyadapter.abslistview.EasyLVHolder;

import java.util.List;

/**
 * Created by Meowzv on 2016/11/28.
 */

public class NewsAdapter extends EasyLVAdapter<LatestEntity.StoriesBean> {
    public NewsAdapter(Context context, List list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    @Override
    public void convert(EasyLVHolder holder, int position, LatestEntity.StoriesBean storiesBean) {
        for (int i = 0; i < storiesBean.getImages().size(); i++){
            Log.i("jenny",storiesBean.getImages().get(i));
        }
        holder.setText(R.id.tv,storiesBean.getTitle());
        Glide.with(mContext).load(storiesBean.getImages().get(0)).into((ImageView) holder.getView(R.id.iv));
    }
}
