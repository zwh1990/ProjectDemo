package com.example.admin.openwpsdemo.biz;

/**
 * Created by Administrator on 2016/7/7.
 */
public interface CustomImageSizeModel {
    String requestCustomSizeUrl(int width, int height);

    String getBaseUrl();
}
