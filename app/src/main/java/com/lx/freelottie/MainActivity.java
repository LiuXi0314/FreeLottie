package com.lx.freelottie;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;

/**
 * @author leo
 */
public class MainActivity extends FragmentActivity {

    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        animationView = findViewById(R.id.animationView);
        animationView.setAnimation("animation1.json");
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                log("start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                log("end");
                animationView.setAnimation("animation3.json");
                animationView.removeAnimatorListener(this);
                animationView.setProgress(Float.parseFloat("50"));
                animationView.loop(true);
                animationView.playAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                log("cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                log("repeat");
            }
        });
        animationView.loop(false);
        animationView.playAnimation();

//        animationView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                animationView.cancelAnimation();
//
//            }
//        }, 5000);
    }

    private void log(String str) {
        Log.d("lottieAni", str);
    }
}
