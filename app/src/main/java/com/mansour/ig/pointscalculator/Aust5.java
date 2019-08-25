package com.mansour.ig.pointscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.mansour.ig.pointscalculator.Aust1.spinnerValue;
import static com.mansour.ig.pointscalculator.MainActivity.proffYear;
import static com.mansour.ig.pointscalculator.MainActivity.radioSelect3;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust5 extends AppCompatActivity {

    private ProgressBar indicator5;
    Button next5;
    Button prev5;
    private RadioGroup yesOrNo;
    TextView points5;
    TextView explain5;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust5);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        explain5 = (TextView) findViewById(R.id.text5);
        indicator5 = (ProgressBar) findViewById(R.id.indicator5);
        indicator5.setProgress(totalScore);
        yesOrNo = (RadioGroup) findViewById(R.id.yesorno);
        yesOrNo.check(radioSelect3);
        prev5 = (Button) findViewById(R.id.prev5);
        prev5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust5.this, Aust9.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next5 = (Button) findViewById(R.id.next5);
        next5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust5.this, Aust11.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        points5 = (TextView) findViewById(R.id.score5);
        points5.setText("Your Points are:" + totalScore);

    }

    public void pressed_2(View view) {
        radioSelect3 = yesOrNo.getCheckedRadioButtonId();
        totalScore -= proffYear;
        proffYear = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch (radioSelect3) {
            case R.id.yes:
                spinnerValue = 5;
                break;
            case R.id.no:
                spinnerValue = 0;
                break;
        }
        proffYear = spinnerValue;
        totalScore += proffYear;
        indicator5.setProgress(totalScore);
        points5.setText("Your Points are:" + totalScore);
    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust5.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}



