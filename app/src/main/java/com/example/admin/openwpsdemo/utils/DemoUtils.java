package com.example.admin.openwpsdemo.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/7/6 11:34
 * @邮箱：zhaowh@zgjzd.cn
 */
public class DemoUtils {

    //获取本地文件的json
    public static String getAssetsJson(Context mContext, String fileName) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        AssetManager am = mContext.getAssets();
        try {
            InputStream ins = am.open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    ins));

            String next = "";
            while (null != (next = br.readLine())) {
                sb.append(next);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }
}
