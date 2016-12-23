package com.meowzv.zhihureader.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.meowzv.zhihureader.R;
import com.meowzv.zhihureader.api.ReaderApi;
import com.meowzv.zhihureader.base.BaseActivity;
import com.meowzv.zhihureader.bean.LogoBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Meowzv on 16/11/13.
 */

public class SplashActivity extends BaseActivity {

    @Bind(R.id.splash_image)
    ImageView mSplashImage;
    @Bind(R.id.splash_text)
    TextView mSplashText;

    private SharedPreferences mSharedPreferences;
    private File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setView();
        downLoadImageWithText();
    }

    private void downLoadImageWithText() {
        ReaderApi.getInstance().getStartImage().subscribeOn(Schedulers.newThread()).subscribe(new Action1<LogoBean>() {
            @Override
            public void call(LogoBean logoBean) {
                if(logoBean != null){
                    if(mSharedPreferences != null) {
                        mSharedPreferences.edit().putString("splash_info_text", logoBean.getText()).apply();
                    }
                    try {
                        Bitmap bitmap = Glide.with(SplashActivity.this).load(logoBean.getImg()).asBitmap().into(Target.SIZE_ORIGINAL,Target.SIZE_ORIGINAL).get();
                        saveImageToDisk(bitmap);
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void setView() {
        mSharedPreferences = getSharedPreferences("splash_info",MODE_PRIVATE);
        mSplashText.setText(mSharedPreferences.getString("splash_info_text",""));
        Bitmap bitmap = readImageFormDisk();
        if(bitmap != null){
            mSplashImage.setImageBitmap(bitmap);
        }else{
            mSplashImage.setImageResource(R.mipmap.ic_launcher);
        }
        mSplashImage.startAnimation(loadAnimation());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private Animation loadAnimation() {
        final ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);//动画效果
        scaleAnim.setFillAfter(true);//动画持续执行
        scaleAnim.setDuration(3000);//3秒

        scaleAnim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }
            /**结束时调用*/
            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return scaleAnim;
    }

    private void saveImageToDisk(Bitmap bitmap) {
        FileOutputStream fos = null;
        try {
            if(imageFile != null && imageFile.exists()){
                imageFile.delete();
            }
            if (imageFile != null) {
                fos = new FileOutputStream(imageFile);
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fos);
            if (fos != null) {
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void startActivity() {
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
        finish();
    }

    private Bitmap readImageFormDisk() {
        File filesDir = getFilesDir();
        imageFile = new File(filesDir,"start_image.jpg");
        Bitmap bm = null;
        if(imageFile.exists()){
            bm = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        }
        return bm;
    }
}
