package com.example.admin.openwpsdemo.glide;

import android.content.Context;

import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;
import com.example.admin.openwpsdemo.biz.CustomImageSizeModel;


/**
 * Created by Administrator on 2016/7/7.
 */
public class CustomImageModelLoader extends BaseGlideUrlLoader<CustomImageSizeModel> {
    public CustomImageModelLoader(Context context) {
        super(context);
    }

    @Override
    protected String getUrl(CustomImageSizeModel model, int width, int height) {
        return model.requestCustomSizeUrl(width, height);
    }
}
