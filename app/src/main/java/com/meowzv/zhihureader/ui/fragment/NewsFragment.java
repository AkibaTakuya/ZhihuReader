package com.meowzv.zhihureader.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meowzv.zhihureader.R;
import com.meowzv.zhihureader.api.ReaderApi;
import com.meowzv.zhihureader.model.LatestEntity;
import com.meowzv.zhihureader.ui.view.flashview.FlashView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class NewsFragment extends Fragment {
    private View rootView;
    private FlashView mBannerView;
    private List<LatestEntity.TopStoriesBean> top_stories;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_news,container,false);
        mBannerView = (FlashView) rootView.findViewById(R.id.flash_view);
        ReaderApi.getInstance().getLatestNews().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<LatestEntity>() {
            @Override
            public void call(LatestEntity latestEntity) {
                if(latestEntity != null){
                    top_stories = latestEntity.getTop_stories();
                    if(top_stories != null){
                        ArrayList<String> banners = new ArrayList<String>();
                        for(Iterator iterator = top_stories.iterator(); iterator.hasNext();){
                            banners.add(((LatestEntity.TopStoriesBean)iterator.next()).getImage());
                        }
                        mBannerView.setImageUris(banners);
                    }
                }
            }
        });
//        mBannerView.setImageUris();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
    }
}
