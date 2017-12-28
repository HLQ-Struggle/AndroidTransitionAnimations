package com.hlq.androidtransitionanimations.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;

import com.hlq.androidtransitionanimations.R;

public class ActivityOptionsCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_compat);
        Fade fade = new Fade();
        fade.setDuration(800);
        getWindow().setExitTransition(fade);
        getWindow().setEnterTransition(fade);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
