package com.example.admin.openwpsdemo.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;

public class AddViewActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewGroup mContainerView;

    private Button bt_add_view;

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);

        bt_add_view = findViewById(R.id.bt_add_view);
        mContainerView = findViewById(R.id.mContainerView);

        bt_add_view.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_add_view:

                TextView newView = new TextView(this);
                newView.setHeight(300);
                newView.setText(String.valueOf(count));

                if(mContainerView.getChildCount() == 3){
                    mContainerView.removeViewAt(0);

                     newView = new TextView(this);
                    newView.setHeight(500);
                    newView.setText(String.valueOf(count));
                    mContainerView.addView(newView, 0);
                }else{
                    mContainerView.addView(newView, 0);
                }



                count ++;

                break;
        }
    }
}
