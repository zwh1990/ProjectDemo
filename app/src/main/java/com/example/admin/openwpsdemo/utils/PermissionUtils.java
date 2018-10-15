package com.example.admin.openwpsdemo.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.example.admin.openwpsdemo.BuildConfig;
import com.example.admin.openwpsdemo.R;

/**
 * @Created by zwh.
 * @description：android M(棉花糖)权限管理工具类
 * @date 2018/7/13 10:22
 * @邮箱：zhaowh@zgjzd.cn
 */
public class PermissionUtils {

    public static final String TAG = PermissionUtils.class.getSimpleName();
    public static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;

    public static void initPermissions(Activity mCxt, String[] permissions) {
        if (!PermissionUtils.checkPermissions(mCxt, permissions)) {
            PermissionUtils.requestPermissions(mCxt, permissions);
        }
    }

    /**
     * 检测APP需要的权限是否全部允许
     * Return the current state of the permissions needed.
     */
    private static boolean checkPermissions(Activity mCxt, String[] permissions) {

        for (String permission : permissions) {
            int permissionState = ActivityCompat.checkSelfPermission(mCxt,
                    permission);

            //只要有一个没有申请的就需要再次提醒用户
            if (permissionState == PackageManager.PERMISSION_DENIED) {
                return false;
            };
        }
        return true;
    }


    /**
     * 请求权限
     */
    private static void requestPermissions(final Activity activity, final String[] permissions) {

        boolean shouldProvideRationale = false;

        for (String permission : permissions) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    permission)) {
                shouldProvideRationale = true;
                break;
            }
            ;
        }

        if (shouldProvideRationale) {
            LOGUtils.w(TAG, "Displaying permission rationale to provide additional context.");
            Snackbar.make(
                    activity.findViewById(R.id.activity_main),
                    R.string.permission_rationale,
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.ok, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Request permission
                            ActivityCompat.requestPermissions(activity,
                                    permissions,
                                    REQUEST_PERMISSIONS_REQUEST_CODE);
                        }
                    })
                    .show();
        } else {
            LOGUtils.w(TAG, "Requesting permission");
            ActivityCompat.requestPermissions(activity,
                    permissions,
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }


    //权限反馈
    public static void onRequestPermissionsResult(final Activity mCxt,
                                                  int requestCode, @NonNull int[] grantResults) {
        LOGUtils.w(TAG, "onRequestPermissionResult--->" + grantResults.length);
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length <= 0) {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
                LOGUtils.w(TAG, "User interaction was cancelled.");
            } else if (permissionsAllGranted(grantResults)) {
                //buildGoogleApiClient();
            } else {
                Snackbar.make(
                        mCxt.findViewById(R.id.activity_main),
                        R.string.permission_denied_explanation,
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.settings, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // Build intent that displays the App settings screen.
                                Intent intent = new Intent();
                                intent.setAction(
                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package",
                                        BuildConfig.APPLICATION_ID, null);
                                intent.setData(uri);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                mCxt.startActivity(intent);
                            }
                        })
                        .show();
            }
        }

    }

    /**
     * 判断权限是否全部允许
     *
     * @param grantResults
     * @return
     */
    private static boolean permissionsAllGranted(@NonNull int[] grantResults) {

        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                return false;
            }
            ;
        }
        return true;
    }

}
