package com.mansour.ig.pointscalculator;

import android.content.Intent;
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

import java.lang.*;

import static com.mansour.ig.pointscalculator.MainActivity.ageScore;
import static com.mansour.ig.pointscalculator.MainActivity.spinnerSelect1;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aust1 extends AppCompatActivity {


    Spinner opt1;
    private ProgressBar indicator1;
    Button next1;
    Button prev1;
    private String spinnerItem;
    public static Integer spinnerValue;
    ArrayAdapter<CharSequence> adapter;
    TextView points1;
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust1);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        points1=(TextView)findViewById(R.id.score1);
        prev1 = (Button) findViewById(R.id.prev1);
        prev1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust1.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next1 = (Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aust1.this, Aus2.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        indicator1 = (ProgressBar) findViewById(R.id.indicator1);
        indicator1.setProgress(totalScore);

        //spinner code
        opt1 = (Spinner) findViewById(R.id.option1);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.age,android. R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opt1.setAdapter(adapter);
        opt1.setSelection(spinnerSelect1);
        //end of spinner
        opt1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSelect1=i;
                Log.i("spinnerselect inside", String.valueOf(spinnerSelect1));

                totalScore -= ageScore;
                ageScore = 0;
                spinnerItem = adapterView.getItemAtPosition(i).toString();
                switch (spinnerItem) {
                    case "Under 18":
                        spinnerValue=0;
                        break;
                    case "18-24":
                        spinnerValue = 25;
                        break;
                    case "25-32":
                        spinnerValue = 30;
                        break;
                    case "33-39":
                        spinnerValue = 25;
                        break;
                    case "40-44":
                        spinnerValue = 15;
                        break;

                    default:
                        spinnerValue = 0;
                }

                ageScore = spinnerValue;
                totalScore += ageScore;
                indicator1.setProgress(totalScore);
                points1.setText("Your Points are:"+totalScore);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    @Override
    public void onBackPressed(){

        Intent exitIntent = new Intent(Aust1.this,MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
