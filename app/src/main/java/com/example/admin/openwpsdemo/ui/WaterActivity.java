package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.weight.WaterMarkLineaLayout;

public class WaterActivity extends AppCompatActivity {

    private WaterMarkLineaLayout markView;
    private TextView tv_record_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        init();
    }

    private void init() {
        markView = findViewById(R.id.mark_view);
        markView.setMarkText( "张三","748934594879348574");

        tv_record_content = findViewById(R.id.tv_record_content);
        tv_record_content.setText("jfdskdjkdlajfkldsfjldfkdlgjkdfgklfdgkdflkdflgdffdkgkldfgkldfglk" +
                "gksdjgdfjgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "gjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" +
                "gjjjjjjjjjjjjjjjjjjjjjjjkdifkfdllllllllllllllllllllllllldlljfdskdjkdlajfkldsfjldfkdlgjkdfgklfdgkdflkdflgdffdkgkldfgkldfglk\" +\n" +
                "                \"gksdjgdfjgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg\" +\n" +
                "                \"gjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj\" +\n" +
                "                \"gjjjjjjjjjjjjjjjjjjjjjjjkdifkfdllllllllllllllllllllllllldlljfdskdjkdlajfkldsfjldfkdlgjkdfgklfdgkdflkdflgdffdkgkldfgkldfglk\" +\n" +
                "                \"gksdjgdfjgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg\" +\n" +
                "                \"gjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj\" +\n" +
                "                \"gjjjjjjjjjjjjjjjjjjjjjjjkdifkfdllllllllllllllllllllllllldlljfdskdjkdlajfkldsfjldfkdlgjkdfgklfdgkdflkdflgdffdkgkldfgkldfglk\" +\n" +
                "                \"gksdjgdfjgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg\" +\n" +
                "                \"gjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj\" +\n" +
                "                \"gjjjjjjjjjjjjjjjjjjjjjjjkdifkfdllllllllllllllllllllllllldll");
    }


}
