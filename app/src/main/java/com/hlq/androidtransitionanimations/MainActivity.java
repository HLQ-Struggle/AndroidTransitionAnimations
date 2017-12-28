package com.hlq.androidtransitionanimations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.hlq.androidtransitionanimations.activity.ActivityOptionsCompatActivity;
import com.hlq.androidtransitionanimations.activity.ActivityOptionsMoreActivity;
import com.hlq.androidtransitionanimations.activity.OverridePendingTransitionActivity;
import com.hlq.androidtransitionanimations.activity.StyleActivity;

public class MainActivity extends AppCompatActivity {

    private MainActivity selfActivity = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 设置允许使用转场动画 此属性同样可以在style设置
        // <item name="android:windowContentTransitions">true</item>
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getOverridePendingTransition(View view) {
        startActivity(new Intent(selfActivity, OverridePendingTransitionActivity.class));
        overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    public void getStyleActivity(View view) {
        startActivity(new Intent(selfActivity, StyleActivity.class));
    }

    public void getActivityOptions(View view) {
        Button btn = findViewById(R.id.btn);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(
                        this, // 当前Activity
                        btn, // 共享元素View
                        "activityOption"); // 共享元素名称
        Intent intent = new Intent(selfActivity, ActivityOptionsCompatActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

    public void getActivityOptionsMore(View view) {
        Button btn = findViewById(R.id.btn1);
        ImageView iv = findViewById(R.id.img1);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(
                        this,
                        Pair.create((View) btn, "btn1"),
                        new Pair<View, String>(iv, "img1")
                );
        Intent intent = new Intent(selfActivity, ActivityOptionsMoreActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

    public void getActivityOptionSlide(View view) {
        Slide slide = new Slide();
        slide.setDuration(800);
        getWindow().setExitTransition(slide);
        getWindow().setEnterTransition(slide);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(selfActivity);
        Intent intent = new Intent(selfActivity, ActivityOptionsCompatActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

    public void getActivityOptionsExplode(View view) {
        Explode explode = new Explode();
        explode.setDuration(800);
        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(selfActivity);
        Intent intent = new Intent(selfActivity, ActivityOptionsCompatActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

    public void getActivityOptionsFade(View view) {
        Fade fade = new Fade();
        fade.setDuration(800);
        getWindow().setExitTransition(fade);
        getWindow().setEnterTransition(fade);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(selfActivity);
        Intent intent = new Intent(selfActivity, ActivityOptionsCompatActivity.class);
        startActivity(intent, optionsCompat.toBundle());
    }

}
