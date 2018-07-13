package com.example.admin.openwpsdemo.utils;

import android.content.Context;

import com.sdsmdg.tastytoast.TastyToast;

/**
 * Created by Administrator on 2017/5/4.
 */

public class ToastUtil {

    public static void showInfo(Context cxt, String info){
        TastyToast.makeText(cxt, info, TastyToast.LENGTH_SHORT, TastyToast.INFO);
    }

    public static void showSucess(Context cxt, String sucess){
        TastyToast.makeText(cxt, sucess, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
    }

    public static void showError(Context cxt, String error){
        TastyToast.makeText(cxt, error, TastyToast.LENGTH_SHORT, TastyToast.ERROR);
    }

    public static void showWarning(Context cxt, String error){
        TastyToast.makeText(cxt, error, TastyToast.LENGTH_SHORT, TastyToast.WARNING);
    }

}
