package com.example.admin.openwpsdemo.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.openwpsdemo.BuildConfig;
import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.anim.AddViewActivity;
import com.example.admin.openwpsdemo.anim.ValueAniActivity;
import com.example.admin.openwpsdemo.anim.ZoomInActivity;
import com.example.admin.openwpsdemo.ui.daggerTwo.StudentActivity;
import com.example.admin.openwpsdemo.ui.thread.ConcurrenceActivity;
import com.example.admin.openwpsdemo.ui.thread.ThreadActivity;
import com.example.admin.openwpsdemo.utils.PermissionUtils;
import com.example.admin.openwpsdemo.utils.Screen;
import com.example.admin.openwpsdemo.utils.ToastUtil;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
    private Button bt_threadLocal;
    private Button bt_concurrence;
    private Button bt_thread;
    private Button bt_dagger;
    private Button bt_flex;
    private Button bt_zoom_in;
    private Button bt_add_view;
    private Button bt_value;
    private Button bt_spiner;
    private Button bt_glide;
    private Button bt_split;
    private Button bt_edit;
    private Button bt_fab;
    private Button bt_regular;
    private Button bt_water;
    private Button bt_imageProperty;
    private Button bt_map;
    private Button bt_tabs;
    private Button bt_bottom_sheet;
    private Button bt_bottom_sheet_dialog;
    private Button bt_scroll_appBar;
    private PDFView pdfView;

    Integer pageNumber = 0;
    String pdfFileName;
    String[] permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        int px = Screen.sp2px(this, 1);
        int dp = Screen.dp2px(this, 1);
        LOGUtils.w(TAG, "px--->" + px);
        LOGUtils.w(TAG, "dp--->" + dp);

        permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ACCESS_FINE_LOCATION};

        //申请权限
        PermissionUtils.initPermissions(this, permissions);

    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        LOGUtils.w(TAG, "permissions--->" + permissions.toString());
        PermissionUtils.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @SuppressLint("ResourceAsColor")
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
        bt_threadLocal = findViewById(R.id.bt_threadLocal);
        bt_concurrence = findViewById(R.id.bt_concurrence);
        bt_thread = findViewById(R.id.bt_thread);
        bt_dagger = findViewById(R.id.bt_dagger);
        bt_flex = findViewById(R.id.bt_flex);
        bt_zoom_in = findViewById(R.id.bt_zoom_in);
        bt_add_view = findViewById(R.id.bt_add_view);
        bt_value = findViewById(R.id.bt_value);
        bt_spiner = findViewById(R.id.bt_spiner);
        bt_glide = findViewById(R.id.bt_glide);
        bt_split = findViewById(R.id.bt_split);
        bt_edit = findViewById(R.id.bt_edit);
        bt_fab = findViewById(R.id.bt_fab);
        bt_regular = findViewById(R.id.bt_regular);
        bt_water = findViewById(R.id.bt_water);
        bt_imageProperty = findViewById(R.id.bt_imageProperty);
        bt_map = findViewById(R.id.bt_map);
        bt_tabs = findViewById(R.id.bt_tabs);
        bt_bottom_sheet = findViewById(R.id.bt_bottom_sheet);
        bt_bottom_sheet_dialog = findViewById(R.id.bt_bottom_sheet_dialog);
        bt_scroll_appBar = findViewById(R.id.bt_scroll_appBar);
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
        bt_threadLocal.setOnClickListener(this);
        bt_concurrence.setOnClickListener(this);
        bt_thread.setOnClickListener(this);
        bt_dagger.setOnClickListener(this);
        bt_flex.setOnClickListener(this);
        bt_zoom_in.setOnClickListener(this);
        bt_add_view.setOnClickListener(this);
        bt_value.setOnClickListener(this);
        bt_spiner.setOnClickListener(this);
        bt_glide.setOnClickListener(this);
        bt_split.setOnClickListener(this);
        bt_edit.setOnClickListener(this);
        bt_fab.setOnClickListener(this);
        bt_regular.setOnClickListener(this);
        bt_water.setOnClickListener(this);
        bt_imageProperty.setOnClickListener(this);
        bt_map.setOnClickListener(this);
        bt_tabs.setOnClickListener(this);
        bt_bottom_sheet.setOnClickListener(this);
        bt_bottom_sheet_dialog.setOnClickListener(this);
        bt_scroll_appBar.setOnClickListener(this);

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
//                intent = new Intent(this, ShowActivity.class);
//                startActivity(intent);
                break;

            case R.id.bt_gson:
                intent = new Intent(this, GsonActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_threadLocal:
                intent = new Intent(this, ThreadLocalActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_concurrence:
                intent = new Intent(this, ConcurrenceActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_thread:
                intent = new Intent(this, ThreadActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_dagger:
                intent = new Intent(this, StudentActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_flex:
                intent = new Intent(this, FlexActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_zoom_in:
                intent = new Intent(this, ZoomInActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_add_view:
                intent = new Intent(this, AddViewActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_value:
                intent = new Intent(this, ValueAniActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_spiner:
                intent = new Intent(this, SpinerActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_glide:
                intent = new Intent(this, GlideActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_split:
                intent = new Intent(this, SplitActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_edit:
                intent = new Intent(this, EditActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_fab:
                intent = new Intent(this, FabActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_regular:
                intent = new Intent(this, RegularActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_water:
                intent = new Intent(this, WaterActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_imageProperty:
                intent = new Intent(this, ImagePropertyActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_map:
                intent = new Intent(this, BaiduMapActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_tabs:
                intent = new Intent(this, TabLayoutActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_bottom_sheet:
                intent = new Intent(this, BottomSheetActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_bottom_sheet_dialog:
                intent = new Intent(this, BottomSheetDialogActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_scroll_appBar:
                intent = new Intent(this, ScrollingActivity.class);
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