package com.meowzv.zhihureader.model;

/**
 * Created by Miki on 2016/11/16.
 */

public class ImageWithTextBean {
    private String imageUrl;
    private String imageWithText;

    public ImageWithTextBean(String imageUrl, String imageWithText) {
        setImageUrl(imageUrl);
        setImageWithText(imageWithText);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageWithText() {
        return imageWithText;
    }

    public void setImageWithText(String imageWithText) {
        this.imageWithText = imageWithText;
    }
}
