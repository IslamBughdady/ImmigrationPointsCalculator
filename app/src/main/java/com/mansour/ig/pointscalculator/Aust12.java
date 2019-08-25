package com.mansour.ig.pointscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.mansour.ig.pointscalculator.Aust1.spinnerValue;
import static com.mansour.ig.pointscalculator.MainActivity.astStudyReq;
import static com.mansour.ig.pointscalculator.MainActivity.radioSelect6;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust12 extends AppCompatActivity {
    private ProgressBar indicator12;
    Button next12;
    Button prev12;
    private RadioGroup yesOrNo;
    TextView points12;
    TextView explain12;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust12);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        explain12 = (TextView) findViewById(R.id.text);
        indicator12 = (ProgressBar) findViewById(R.id.indicator12);
        indicator12.setProgress(totalScore);
        yesOrNo = (RadioGroup) findViewById(R.id.yesorno);
        yesOrNo.check(radioSelect6);

        prev12 = (Button) findViewById(R.id.prev12);
        prev12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust12.this, Aust8.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next12 = (Button) findViewById(R.id.next12);
        next12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust12.this, Aust3.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        points12 = (TextView) findViewById(R.id.score12);
        points12.setText("Your Points are:" + totalScore);
    }

    public void pressed_6(View view) {
        radioSelect6 = yesOrNo.getCheckedRadioButtonId();
        totalScore -= astStudyReq;
        astStudyReq = 0;
        switch (radioSelect6) {
            case R.id.yes:
                spinnerValue = 5;
                break;
            case R.id.no:
                spinnerValue = 0;
                break;
        }
        astStudyReq = spinnerValue;
        totalScore += astStudyReq;
        indicator12.setProgress(totalScore);

        points12.setText("Your Points are:" + totalScore);
    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust12.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

}

