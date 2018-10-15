package com.example.admin.openwpsdemo.glide;

import android.content.Context;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.example.admin.openwpsdemo.biz.CustomImageSizeModel;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/7/7.
 */
public class CustomImageSizeModelFactory implements ModelLoaderFactory<CustomImageSizeModel, InputStream> {
    public final static String TAG  =  "CustomImageSizeModelFactory";
    @Override
    public ModelLoader<CustomImageSizeModel, InputStream> build(Context context, GenericLoaderFactory factories) {
        return new CustomImageModelLoader(context);
    }

    @Override
    public void teardown() {
    }
}
