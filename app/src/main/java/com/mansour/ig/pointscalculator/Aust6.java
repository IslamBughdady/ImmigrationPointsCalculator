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
import static com.mansour.ig.pointscalculator.MainActivity.qualifications;
import static com.mansour.ig.pointscalculator.MainActivity.spinnerSelect3;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust6 extends AppCompatActivity {

    Spinner opt3;
    private ProgressBar indicator6;
    Button next6;
    Button prev6;
    ArrayAdapter<CharSequence> adapter1;
    private String spinnerItem;
    TextView points6;
    TextView info;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust6);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        info = (TextView) findViewById(R.id.info);
        indicator6 = (ProgressBar) findViewById(R.id.indicator6);
        indicator6.setProgress(totalScore);
        prev6 = (Button) findViewById(R.id.prev6);
        prev6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust6.this, Aus2.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next6 = (Button) findViewById(R.id.next6);
        next6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust6.this, Aust7.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        points6 = (TextView) findViewById(R.id.score6);
        //spinner code
        opt3 = (Spinner) findViewById(R.id.option3);
        adapter1 = ArrayAdapter.createFromResource(this,
                R.array.qualifications, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opt3.setAdapter(adapter1);
        opt3.setSelection(spinnerSelect3);
        opt3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSelect3 = i;
                totalScore -= qualifications;
                qualifications = 0;
                spinnerItem = adapterView.getItemAtPosition(i).toString();
                switch (spinnerItem) {
                    case "Recognised phD(Doctorate)":
                        spinnerValue = 20;
                        info.setText("A Doctorate degree from an Australian educational institution or a Doctorate from another educational institution that is of a recognised standard.");
                        break;
                    case "Recognised Bachelor degree or higher":
                        spinnerValue = 15;
                        info.setText("A Bachelor degree from an Australian educational institution or a Bachelor qualification, from another educational institution that is of a recognised standard.");
                        break;
                    case "Recognised Trade Qualifications or Diploma":
                        spinnerValue = 10;
                        info.setText("A diploma or trade qualification completed in Australia");
                        break;
                    case "Recognised award or qualification":
                        spinnerValue = 10;
                        info.setText("An award or qualification recognised by the relevant assessing authority for your nominated skilled occupation.");
                        break;
                    case "No Recognised Qualifications":
                        spinnerValue = 0;
                        break;
                    default:
                        spinnerValue = 0;
                }
                qualifications = spinnerValue;
                totalScore += qualifications;
                indicator6.setProgress(totalScore);
                points6.setText("Your Points are:" + totalScore);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust6.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}
