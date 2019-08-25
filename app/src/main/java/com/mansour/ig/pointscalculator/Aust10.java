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
import static com.mansour.ig.pointscalculator.MainActivity.desLang;
import static com.mansour.ig.pointscalculator.MainActivity.radioSelect2;
import static com.mansour.ig.pointscalculator.MainActivity.radioSelect4;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust10 extends AppCompatActivity {

    private ProgressBar indicator10;
    Button next10;
    Button prev10;
    private RadioGroup yesOrNo;
    TextView points10;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust10);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        indicator10 = (ProgressBar) findViewById(R.id.indicator10);
        indicator10.setProgress(totalScore);
        //Log.i("spinnervalue ac2", spinnerValue.toString());
        yesOrNo = (RadioGroup) findViewById(R.id.yesorno);
        yesOrNo.check(radioSelect4);
        points10 = (TextView) findViewById(R.id.score10);
        points10.setText("Your Points are:" + totalScore);

        prev10 = (Button) findViewById(R.id.prev10);
        prev10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust10.this, Aust3.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next10 = (Button) findViewById(R.id.next10);
        next10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust10.this, Aust4.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
    }

    public void pressed_3(View view) {
        radioSelect4 = yesOrNo.getCheckedRadioButtonId();
        totalScore -= desLang;
        desLang = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch (radioSelect4) {
            case R.id.translator:
                spinnerValue = 5;
                break;
            case R.id.none:
                spinnerValue = 0;
                break;
        }
        desLang = spinnerValue;
        totalScore += desLang;
        indicator10.setProgress(totalScore);
        points10.setText("Your Points are:" + totalScore);

    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust10.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}

