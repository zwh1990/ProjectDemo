package com.example.admin.openwpsdemo.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import java.io.BufferedReader;


/**
 * 差值动画
 */
public class ValueAniActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ValueAniActivity.class.getSimpleName();
    private Button bt_begin;
    private Button bt_end;
    private TextView tv_show;
    private ImageView circle;

    private LinearLayout ll_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_ani);

        initView();
        setListener();
    }

    private void initView() {
        bt_begin = findViewById(R.id.bt_begin);
        bt_end = findViewById(R.id.bt_end);
        tv_show = findViewById(R.id.tv_show);
        circle = findViewById(R.id.circle);

        ll_value = findViewById(R.id.ll_value);
        for (int i = 0; i < 3; i++) {
            TextView tv = new TextView(this);
            tv.setHeight(150);
            tv.setText("jjadjklagdf");
            ll_value.addView(tv);
        }

    }

    private void setListener() {
        bt_begin.setOnClickListener(this);
        bt_end.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_begin:
                //开始动画
//                startValueAni();

//                startObjectAni();

//                startAnimatorSet();
                increaseHeight();
                break;

            case R.id.bt_end:

                break;
        }
    }

    private void startObjectAni() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(tv_show, "translationX",
                200f);
        animation.setDuration(2000);
        animation.start();
    }

    private void increaseHeight() {
        ValueAnimator animation = ValueAnimator.ofInt(200, 2000);
        animation.setDuration(1000);
        animation.start();

        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                // You can use the animated value in a property that uses the
                // same type as the animation. In this case, you can use the
                // float value in the translationX property.
                int animatedValue = (int) updatedAnimation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = ll_value.getLayoutParams();
                LOGUtils.w(TAG,"layoutParams.height1--->" + layoutParams.height);
                layoutParams.height = animatedValue;
                LOGUtils.w(TAG,"layoutParams.height2--->" + layoutParams.height);

                ll_value.setLayoutParams(layoutParams);
            }
        });
    }

    private void startValueAni() {
        ValueAnimator animation = ValueAnimator.ofFloat(0f, 200f);
        animation.setDuration(2000);
        animation.start();

        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                // You can use the animated value in a property that uses the
                // same type as the animation. In this case, you can use the
                // float value in the translationX property.
                float animatedValue = (float) updatedAnimation.getAnimatedValue();
                tv_show.setTranslationX(animatedValue);
            }
        });

    }

    private void startAnimatorSet() {
        AnimatorSet bouncer = new AnimatorSet();

        //圆球上弹动画
        ObjectAnimator bounceAnim = ObjectAnimator.ofFloat(circle, "translationY",
                -200f);
        bounceAnim.setDuration(1000);
        bounceAnim.start();


        //圆球下弹动画
        ObjectAnimator bounceBackAnim = ObjectAnimator.ofFloat(circle, "translationY",
                0f);
        bounceAnim.setDuration(1000);
        bounceAnim.start();


        bouncer.play(bounceAnim).before(bounceBackAnim);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(bouncer);
        animatorSet.start();
    }

}
