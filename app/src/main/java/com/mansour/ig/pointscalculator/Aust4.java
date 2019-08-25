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
import static com.mansour.ig.pointscalculator.MainActivity.radioSelect2;
import static com.mansour.ig.pointscalculator.MainActivity.study;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust4 extends AppCompatActivity {

    private ProgressBar indicator4;
    Button next4;
    Button prev4;
    private RadioGroup yesOrNo;
    TextView points4;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust4);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        indicator4 = (ProgressBar) findViewById(R.id.indicator4);

        Log.i("spinnervalue ac2", spinnerValue.toString());
        yesOrNo = (RadioGroup) findViewById(R.id.yesorno);
        yesOrNo.check(radioSelect2);
        points4 = (TextView) findViewById(R.id.score4);
        points4.setText("Your Points are:" + totalScore);
        indicator4.setProgress(totalScore);
        prev4 = (Button) findViewById(R.id.prev4);
        prev4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust4.this, Aust10.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next4 = (Button) findViewById(R.id.next4);
        next4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust4.this, Aust9.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
    }

    public void pressed_1(View view) {
        radioSelect2 = yesOrNo.getCheckedRadioButtonId();
        totalScore -= study;
        study = 0;
        Log.i("radio selection", String.valueOf(radioSelect2));
        boolean checked = ((RadioButton) view).isChecked();
        switch (radioSelect2) {
            case R.id.yes:
                spinnerValue = 5;
                break;
            case R.id.no:
                spinnerValue = 0;
                break;
        }
        study = spinnerValue;
        totalScore += study;
        indicator4.setProgress(totalScore);
        points4.setText("Your Points are:" + totalScore);

    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust4.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}


