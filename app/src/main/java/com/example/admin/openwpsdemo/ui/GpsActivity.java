package com.example.admin.openwpsdemo.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.utils.ToastUtil;

import java.util.Iterator;

public class GpsActivity extends AppCompatActivity {

    private static final String TAG = GpsActivity.class.getSimpleName();
    private TextView tv_gps_info;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        tv_gps_info = findViewById(R.id.tv_gps_info);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        initGps();

    }

    private void initGps() {

        GpsStatus.Listener listener = new GpsStatus.Listener() {
            @Override
            public void onGpsStatusChanged(int event) {
                switch (event) {
                    //第一次定位
                    case GpsStatus.GPS_EVENT_FIRST_FIX:
                        LOGUtils.w(TAG, "第一次定位");
                        break;
                    //卫星状态改变
                    case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
                        LOGUtils.w(TAG, "卫星状态改变");
                        //获取当前状态 
                        if (ActivityCompat.checkSelfPermission(GpsActivity.this,
                                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        GpsStatus gpsStatus = locationManager.getGpsStatus(null);
                        //获取卫星颗数的默认最大值 
                        int maxSatellites = gpsStatus.getMaxSatellites();
                        //创建一个迭代器保存所有卫星  
                        Iterator<GpsSatellite> iters = gpsStatus.getSatellites().iterator();
                        int count = 0;
                        while (iters.hasNext() && count <= maxSatellites) {
                            GpsSatellite s = iters.next();

                            if (s.getSnr() > 30) {
                                count++;
                                if (count >= 4) {
                                    // 表示有信号
                                    ToastUtil.showInfo(GpsActivity.this,"表示有信号");
                                    tv_gps_info.setText("有信号");
                                } else {
                                    // 信号弱或无信号
                                    ToastUtil.showInfo(GpsActivity.this,"信号弱或无信号");
                                    tv_gps_info.setText("信号弱或无信号");
                                }
                            }
                        }
                        LOGUtils.w(TAG, "搜索到：" + count + "颗卫星  max :" + maxSatellites);
                        break;//定位启动 
                    case GpsStatus.GPS_EVENT_STARTED:
                        LOGUtils.w(TAG, "定位启动");

                        break;
                    //定位结束 
                    case GpsStatus.GPS_EVENT_STOPPED:
                        LOGUtils.w(TAG, "定位结束");
                        break;
                }
            }

            ;

        };
        locationManager.addGpsStatusListener(listener);
    }

}
