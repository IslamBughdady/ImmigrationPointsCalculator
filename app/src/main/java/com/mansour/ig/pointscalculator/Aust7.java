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
import static com.mansour.ig.pointscalculator.MainActivity.spinnerSelect3;
import static com.mansour.ig.pointscalculator.MainActivity.spinnerSelect4;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;
import static com.mansour.ig.pointscalculator.MainActivity.workExp;

public class Aust7 extends AppCompatActivity {

    Spinner opt4;
    private ProgressBar indicator7;
    Button next7;
    Button prev7;
    ArrayAdapter<CharSequence> adapter2;
    private String spinnerItem;
    TextView points7;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust7);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        indicator7 = (ProgressBar) findViewById(R.id.indicator7);
        indicator7.setProgress(totalScore);
        prev7 = (Button) findViewById(R.id.prev7);
        prev7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust7.this, Aust6.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next7 = (Button) findViewById(R.id.next7);
        next7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust7.this, Aust8.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        points7 = (TextView) findViewById(R.id.score7);
        //spinner code
        opt4 = (Spinner) findViewById(R.id.option4);
        adapter2 = ArrayAdapter.createFromResource(this,
                R.array.workExperience, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opt4.setAdapter(adapter2);
        opt4.setSelection(spinnerSelect4);
        opt4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSelect4 = i;
                totalScore -= workExp;
                workExp = 0;
                spinnerItem = adapterView.getItemAtPosition(i).toString();
                switch (spinnerItem) {
                    case "Less than 3 years":
                        spinnerValue = 0;
                        break;
                    case "3-4 years":
                        spinnerValue = 5;
                        break;
                    case "5-7 years":
                        spinnerValue = 10;
                        break;
                    case "8-10 years":
                        spinnerValue = 15;
                        break;
                    default:
                        spinnerValue = 0;
                }
                workExp = spinnerValue;
                totalScore += workExp;
                indicator7.setProgress(totalScore);
                points7.setText("Your Points are:" + totalScore);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aust7.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}
