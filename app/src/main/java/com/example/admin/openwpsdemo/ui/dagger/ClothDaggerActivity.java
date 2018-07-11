package com.example.admin.openwpsdemo.ui.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * dagger的使用说明连接: http://blog.izouxiang.cn/2016/10/22/Dagger2%20%E5%85%A5%E9%97%A8/
 *
 *  此demo 是按照说明写的
 */
public class ClothDaggerActivity extends AppCompatActivity {


    private TextView tv_red;
    private TextView tv_blue;

    @Inject
    @Named("red")
    Cloth redCloth;

    @Inject
    @Named("blue")
    Cloth blueCloth;

    @Inject
    Shoe shoe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_dagger);

        intitView();

        ClothComponent build = DaggerClothComponent.builder().clothModule(new ClothModule()).build();
        build.inject(this);
        tv_red.setText("颜色:"+ redCloth.getColor() +  "穿着" + shoe.getName());
        tv_blue.setText("颜色:"+ blueCloth.getColor());

    }

    private void intitView() {

        tv_red = findViewById(R.id.tv_red);
        tv_blue =  findViewById(R.id.tv_blue);

    }
}
