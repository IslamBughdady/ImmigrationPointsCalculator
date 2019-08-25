package com.mansour.ig.pointscalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.mansour.ig.pointscalculator.Aust1.spinnerValue;
import static com.mansour.ig.pointscalculator.MainActivity.radioSelect5;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;
import static com.mansour.ig.pointscalculator.MainActivity.visaSubclass;

public class Aust11 extends AppCompatActivity {

    private ProgressBar indicator11;
    Button prev11;
    private RadioGroup yesOrNo;
    TextView points11;
    TextView Warning;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust11);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Warning = (TextView) findViewById(R.id.warning);
        indicator11 = (ProgressBar) findViewById(R.id.indicator11);
        indicator11.setProgress(totalScore);
        yesOrNo = (RadioGroup) findViewById(R.id.yesorno);
        yesOrNo.check(radioSelect5);
        points11 = (TextView) findViewById(R.id.score11);
        points11.setText("Your Points are:" + totalScore);

        prev11 = (Button) findViewById(R.id.prev11);
        prev11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust11.this, Aust5.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });

        if (totalScore < 65) {
            Warning.setText("your points are less than 65, so you are not eligible to apply");
        }
        else
            Warning.setText("");
    }

    public void pressed_5(View view) {
        radioSelect5 = yesOrNo.getCheckedRadioButtonId();
        totalScore -= visaSubclass;
        visaSubclass = 0;

        boolean checked = ((RadioButton) view).isChecked();
        switch (radioSelect5) {
            case R.id.indep:
                spinnerValue = 0;
                break;
            case R.id.nomi:
                spinnerValue = 5;
                break;
            case R.id.reg:
                spinnerValue = 10;
                break;
        }
        visaSubclass = spinnerValue;
        totalScore += visaSubclass;
        indicator11.setProgress(totalScore);
        points11.setText("Your Points are:" + totalScore);
        if (totalScore < 65) {
            Warning.setText("your points are less than 65, so you are not eligible to apply");
        }
        else
            Warning.setText("");

    }


    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust11.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}

