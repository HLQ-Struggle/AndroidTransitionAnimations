package com.hlq.androidtransitionanimations.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hlq.androidtransitionanimations.R;

public class OverridePendingTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void getFinish(View view) {
        finish();
        overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

}
