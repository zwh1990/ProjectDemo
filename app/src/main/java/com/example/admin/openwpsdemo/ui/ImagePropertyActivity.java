package com.example.admin.openwpsdemo.ui;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 图片属性
 */
public class ImagePropertyActivity extends AppCompatActivity implements OnClickListener{

    private static final String TAG = ImagePropertyActivity.class.getSimpleName();
    private Button bt_property;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_property);

        initView();
    }

    private void initView() {
        bt_property = findViewById(R.id.bt_property);
        bt_property.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pickImageProperty();
                } catch (IOException e) {
                    LOGUtils.w(TAG, "e.toString-->" + e.toString());
                }
            }
        }).start();

    }

    private void pickImageProperty() throws IOException {
        download("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535971357471&di=40ab329c05e12bd65fd530b70cfd6765&imgtype=0&src=http%3A%2F%2Fpic23.photophoto.cn%2F20120503%2F0034034456597026_b.jpg");
    }

    public void download(String url) throws IOException {
        URL urlGet = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlGet.openConnection();
        Map<String, List<String>> headerFields = conn.getHeaderFields();
        LOGUtils.w(TAG,"headerFields--->" + headerFields.size());
        Set<Map.Entry<String, List<String>>> entries = headerFields.entrySet();
        for (Map.Entry<String, List<String>> e : entries) {
            LOGUtils.w(TAG,"key：" + e.getKey() + " value:"
                    + e.getValue());

        }
        String width = conn.getHeaderField("X-Img-Original-Width");
        LOGUtils.w(TAG,"width--->" + width);

        String height = conn.getHeaderField("X-Img-Original-Height");
        LOGUtils.w(TAG,"height--->" + height);
    }



}
