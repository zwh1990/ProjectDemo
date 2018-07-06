package com.example.admin.openwpsdemo.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.utils.Screen;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        OnPageChangeListener, OnLoadCompleteListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button bt_open;

    private Button bt_wps;
    private Button bt_txt;
    private Button bt_file;
    private Button bt_sdk;
    private Button bt_timeLine;
    private Button bt_pie;
    private Button bt_rec;
    private Button bt_upBugs;
    private Button bt_location;
    private Button bt_show;
    private Button bt_gson;
    private PDFView pdfView;

    Integer pageNumber = 0;
    String pdfFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        int px = Screen.sp2px(this, 1);
        int dp = Screen.dp2px(this, 1);
        LOGUtils.w(TAG, "px--->" + px);
        LOGUtils.w(TAG, "dp--->" + dp);

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                )
                .withListener(new MultiplePermissionsListener() {

                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        Log.w(TAG, "report--->" + report.getDeniedPermissionResponses());
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Log.w(TAG, "permissions--->" + permissions.toString());

                    }
                })
                .check();
    }

    private void initView() {

        bt_open = findViewById(R.id.bt_open);
        bt_open.setBackgroundColor(R.color.white);

        bt_wps = findViewById(R.id.bt_wps);
        bt_txt = findViewById(R.id.bt_txt);
        bt_file = findViewById(R.id.bt_file);
        bt_sdk = findViewById(R.id.bt_sdk);
        bt_timeLine = findViewById(R.id.bt_timeLine);
        bt_pie = findViewById(R.id.bt_pie);
        bt_rec = findViewById(R.id.bt_rec);
        bt_upBugs = findViewById(R.id.bt_upBugs);
        bt_location = findViewById(R.id.bt_location);
        bt_show = findViewById(R.id.bt_show);
        bt_gson = findViewById(R.id.bt_gson);
        pdfView = findViewById(R.id.pdfview);


        bt_open.setOnClickListener(this);
        bt_wps.setOnClickListener(this);
        bt_txt.setOnClickListener(this);
        bt_file.setOnClickListener(this);
        bt_sdk.setOnClickListener(this);
        bt_timeLine.setOnClickListener(this);
        bt_rec.setOnClickListener(this);
        bt_pie.setOnClickListener(this);
        bt_upBugs.setOnClickListener(this);
        bt_location.setOnClickListener(this);
        bt_show.setOnClickListener(this);
        bt_gson.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_open:
                String path = Environment.getExternalStorageDirectory().getPath() + "/test.pdf";
                File file = new File(path);
                Log.w(TAG, "file--->" + file.getName());
                pdfView.fromFile(file)
                        .defaultPage(pageNumber)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .onLoad(this)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .spacing(10) // in dp
                        .load();
                break;

            case R.id.bt_wps:
                Intent intent = new Intent(this, WpsActivity.class);
                startActivity(intent);

                break;

            case R.id.bt_txt:
                intent = new Intent(this, TxtActivity.class);
                startActivity(intent);

                break;

            case R.id.bt_file:
                intent = new Intent(this, FileActivity.class);
                startActivity(intent);

                break;

            case R.id.bt_sdk:
                String extSDCardPath = getStoragePath(MainActivity.this, true);
                LOGUtils.w(TAG, "extSDCardPath--->" + extSDCardPath);
                File file1 = new File(extSDCardPath + File.separator + "123.txt");
                boolean mkdir = file1.mkdir();
                LOGUtils.w(TAG, "是否成功--->" + mkdir);
                break;

            case R.id.bt_timeLine:
                intent = new Intent(this, TimeLineActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_pie:
                intent = new Intent(this, PieActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_rec:
                intent = new Intent(this, RecycleViewActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_upBugs:
                intent = new Intent(this, UpLoadBugActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_location:
                intent = new Intent(this, GaoDeActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_show:
                intent = new Intent(this, ShowActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_gson:
                intent = new Intent(this, RxJavaActivity.class);
                startActivity(intent);
                break;

        }


    }


    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    public void onPageChanged(int page, int pageCount) {

        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));

    }

    private String getStoragePath(Context mContext, boolean is_removale) {

        StorageManager mStorageManager = (StorageManager) mContext.getSystemService(Context.STORAGE_SERVICE);
        Class<?> storageVolumeClazz = null;
        try {
            storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList");
            Method getPath = storageVolumeClazz.getMethod("getPath");
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable");
            Object result = getVolumeList.invoke(mStorageManager);
            final int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String path = (String) getPath.invoke(storageVolumeElement);
                boolean removable = (Boolean) isRemovable.invoke(storageVolumeElement);
                if (is_removale == removable) {
                    return path;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}