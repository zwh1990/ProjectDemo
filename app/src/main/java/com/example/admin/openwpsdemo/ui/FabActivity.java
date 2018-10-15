package com.example.admin.openwpsdemo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.weight.DiatanceScrollView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class FabActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = FabActivity.class.getSimpleName();
    private FloatingActionMenu menu;
    private FloatingActionButton fab_pass;
    private FloatingActionButton fab_return;

    private DiatanceScrollView sc_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);

        sc_container = findViewById(R.id.sc_container);
        menu = findViewById(R.id.menu);
        fab_pass = findViewById(R.id.fab_pass);
        fab_return = findViewById(R.id.fab_return);

        menu.setIconAnimated(false);
        menu.showMenuButton(true);

        fab_pass.setOnClickListener(this);
        fab_return.setOnClickListener(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                menu.setMenuButtonShowAnimation(AnimationUtils.loadAnimation(FabActivity.this, R.anim.show_from_bottom));
                menu.setMenuButtonHideAnimation(AnimationUtils.loadAnimation(FabActivity.this, R.anim.hide_to_bottom));
            }
        }, 200);

        sc_container.setOnScrollListener(new DiatanceScrollView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(DiatanceScrollView view, int scrollState) {

            }

            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                // 这里的t就是我们想要的距离
                LOGUtils.w(TAG,"t--->" + t);
                if(t > 20){
                    menu.hideMenu(true);
                }else{
                    menu.showMenu(true);
                }
            }

            @Override
            public void onBottomArrived() {
            }
        });

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.fab_pass:
                menu.close(true);


                break;

            case R.id.fab_return:
                menu.close(true);


                break;
        }
    }
}
