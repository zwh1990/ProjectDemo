package com.example.admin.openwpsdemo.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;

import java.io.BufferedReader;


/**
 * 差值动画
 */
public class ValueAniActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_begin;
    private Button bt_end;
    private TextView tv_show;
    private ImageView circle;

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

                startAnimatorSet();
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
                float animatedValue = (float)updatedAnimation.getAnimatedValue();
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

//        //变大动画
//        ValueAnimator squashAnim1 = ValueAnimator.ofInt(50,100);
//        squashAnim1.setDuration(1500);
//        squashAnim1.start();
//        squashAnim1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int animatedValue = (int) animation.getAnimatedValue();
//                circle.setMaxWidth(animatedValue);
//                circle.setMaxHeight(animatedValue);
//            }
//        });

        //圆球下弹动画
        ObjectAnimator bounceBackAnim = ObjectAnimator.ofFloat(circle, "translationY",
                0f);
        bounceAnim.setDuration(1000);
        bounceAnim.start();


        bouncer.play(bounceAnim).before(bounceBackAnim);
//        bouncer.play(squashAnim1).with(squashAnim2);
//        bouncer.play(squashAnim1).with(stretchAnim1);
//        bouncer.play(squashAnim1).with(stretchAnim2);
//        bouncer.play(bounceBackAnim).after(squashAnim1);
//        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(newBall, "alpha", 1f, 0f);
//        fadeAnim.setDuration(250);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(bouncer);
        animatorSet.start();
    }

}
