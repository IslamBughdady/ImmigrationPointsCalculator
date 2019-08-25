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
import static com.mansour.ig.pointscalculator.MainActivity.qualScore;
import static com.mansour.ig.pointscalculator.MainActivity.radioSelect1;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust3 extends AppCompatActivity {

    private ProgressBar indicator3;
    Button next3;
    Button prev3;
    private RadioGroup yesOrNo;
    TextView points3;
    TextView explain3;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust3);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        explain3 = (TextView) findViewById(R.id.text);
        indicator3 = (ProgressBar) findViewById(R.id.indicator3);
        indicator3.setProgress(totalScore);
        Log.i("spinnervalue ac2", spinnerValue.toString());
        yesOrNo = (RadioGroup) findViewById(R.id.yesorno);
        yesOrNo.check(radioSelect1);

        prev3 = (Button) findViewById(R.id.prev3);
        prev3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust3.this, Aust12.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next3 = (Button) findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust3.this, Aust10.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        points3 = (TextView) findViewById(R.id.score3);
        points3.setText("Your Points are:" + totalScore);
    }

    public void pressed(View view) {
        radioSelect1 = yesOrNo.getCheckedRadioButtonId();
        totalScore -= qualScore;
        qualScore = 0;
        switch (radioSelect1) {
            case R.id.yes:
                spinnerValue = 5;
                break;
            case R.id.no:
                spinnerValue = 0;
                break;
        }
        qualScore = spinnerValue;
        totalScore += qualScore;
        indicator3.setProgress(totalScore);
        points3.setText("Your Points are:" + totalScore);
    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust3.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

}