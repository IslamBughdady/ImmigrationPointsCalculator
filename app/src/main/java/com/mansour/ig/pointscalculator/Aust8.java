package com.mansour.ig.pointscalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.mansour.ig.pointscalculator.Aust1.spinnerValue;
import static com.mansour.ig.pointscalculator.MainActivity.austWrkExp;
import static com.mansour.ig.pointscalculator.MainActivity.spinnerSelect4;
import static com.mansour.ig.pointscalculator.MainActivity.spinnerSelect5;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust8 extends AppCompatActivity {

    Spinner opt5;
    private ProgressBar indicator8;
    Button next8;
    Button prev8;
    ArrayAdapter<CharSequence> adapter3;
    private String spinnerItem;
    TextView points8;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust8);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        indicator8 = (ProgressBar) findViewById(R.id.indicator8);
        indicator8.setProgress(totalScore);
        prev8 = (Button) findViewById(R.id.prev8);
        prev8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust8.this, Aust7.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next8 = (Button) findViewById(R.id.next8);
        next8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust8.this, Aust12.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        points8 = (TextView) findViewById(R.id.score8);
        //spinner code
        opt5 = (Spinner) findViewById(R.id.option5);
        adapter3 = ArrayAdapter.createFromResource(this,
                R.array.AustworkExperience, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opt5.setAdapter(adapter3);
        opt5.setSelection(spinnerSelect5);
        opt5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSelect5 = i;
                totalScore -= austWrkExp;
                austWrkExp = 0;
                spinnerItem = adapterView.getItemAtPosition(i).toString();
                switch (spinnerItem) {
                    case "Less than one year":
                        spinnerValue = 0;
                        break;
                    case "1-2 years":

                        spinnerValue = 5;
                        break;
                    case "3-4 years":
                        spinnerValue = 10;
                        break;
                    case "5-7 years":
                        spinnerValue = 15;
                        break;
                    case "8-10 years":
                        spinnerValue = 20;
                        break;
                    default:
                        spinnerValue = 0;
                }
                austWrkExp = spinnerValue;
                totalScore += austWrkExp;
                indicator8.setProgress(totalScore);
                points8.setText("Your Points are:" + totalScore);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust8.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}
