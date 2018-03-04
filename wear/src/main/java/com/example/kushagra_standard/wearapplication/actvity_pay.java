package com.example.kushagra_standard.wearapplication;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class actvity_pay extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actvity_pay);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }
    public void clickpayqrcode (View v)
    {
        ((ImageView)findViewById(R.id.qrcode)).setVisibility(View.VISIBLE);
    }
    public void clickpaytune (View v)
    {
        ((ImageView)findViewById(R.id.tune)).setVisibility(View.VISIBLE);
    }
}
