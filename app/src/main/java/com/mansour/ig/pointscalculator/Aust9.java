package com.mansour.ig.pointscalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.mansour.ig.pointscalculator.Aust1.spinnerValue;
import static com.mansour.ig.pointscalculator.MainActivity.checkBoxSelect1;
import static com.mansour.ig.pointscalculator.MainActivity.checkBoxSelect2;
import static com.mansour.ig.pointscalculator.MainActivity.checkBoxSelect3;
import static com.mansour.ig.pointscalculator.MainActivity.partnerSkills;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust9 extends AppCompatActivity {


    private ProgressBar indicator9;
    Button next9;
    Button prev9;
    TextView points9;
    CheckBox checkBoxx1;
    CheckBox checkBoxx2;
    CheckBox checkBoxx3;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust9);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        checkBoxx1 = (CheckBox) findViewById(R.id.checkBox1);

        checkBoxx2 = (CheckBox) findViewById(R.id.checkBox2);

        checkBoxx3 = (CheckBox) findViewById(R.id.checkBox3);
        indicator9 = (ProgressBar) findViewById(R.id.indicator9);
        indicator9.setProgress(totalScore);
        prev9 = (Button) findViewById(R.id.prev9);
        prev9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust9.this, Aust4.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next9 = (Button) findViewById(R.id.next9);
        next9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust9.this, Aust5.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        points9 = (TextView) findViewById(R.id.score9);
        points9.setText("Your Points are:" + totalScore);
        checkBoxx1.setChecked(checkBoxSelect1);
        checkBoxx2.setChecked(checkBoxSelect2);
        checkBoxx3.setChecked(checkBoxSelect3);
    }

    public void selected(View view) {
        checkBoxSelect1 = checkBoxx1.isChecked();
        Log.i("checkbox1", String.valueOf(checkBoxSelect1));
        checkBoxSelect2 = checkBoxx2.isChecked();
        Log.i("checkbox2", String.valueOf(checkBoxSelect2));

        checkBoxSelect3 = checkBoxx3.isChecked();
        Log.i("checkbox3", String.valueOf(checkBoxSelect3));

        totalScore -= partnerSkills;
        partnerSkills = 0;
        boolean checked = ((CheckBox) view).isChecked();
        if (checkBoxx1.isChecked() && checkBoxx2.isChecked() && checkBoxx3.isChecked()) {
            spinnerValue = 5;
        } else
            spinnerValue = 0;

        partnerSkills = spinnerValue;
        totalScore += partnerSkills;
        indicator9.setProgress(totalScore);
        points9.setText("Your Points are:" + totalScore);
    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust9.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}

