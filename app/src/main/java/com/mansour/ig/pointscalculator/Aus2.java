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
import static com.mansour.ig.pointscalculator.MainActivity.englishScore;
import static com.mansour.ig.pointscalculator.MainActivity.spinnerSelect2;
import static com.mansour.ig.pointscalculator.MainActivity.totalScore;

public class Aus2 extends AppCompatActivity {

    Spinner opt2;
    private ProgressBar indicator2;
    Button next2;
    Button prev2;
    ArrayAdapter<CharSequence> adapter;
    private String spinnerItem;
    TextView points2;
    TextView Tips;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aus2);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Tips = (TextView) findViewById(R.id.tips);
        points2 = (TextView) findViewById(R.id.score2);
        indicator2 = (ProgressBar) findViewById(R.id.indicator2);
        indicator2.setProgress(totalScore);
        prev2 = (Button) findViewById(R.id.prev2);
        prev2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aus2.this, Aust1.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        next2 = (Button) findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Aus2.this, Aust6.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        //spinner code
        opt2 = (Spinner) findViewById(R.id.option2);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.level, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opt2.setAdapter(adapter);
        opt2.setSelection(spinnerSelect2);

        //end of spinner
        opt2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSelect2 = i;
                totalScore -= englishScore;
                englishScore = 0;
                spinnerItem = adapterView.getItemAtPosition(i).toString();
                switch (spinnerItem) {
                    case "Competent":
                        spinnerValue = 0;
                        Tips.setText("Passport from UK, USA, Ireland, Canada or NZ; or IELTS: 6+ in each component; or PTE Academic: 50+ in each component; or Cambridge (CAE): 169+ in each component; or TOEFL iBT: 12 in Listening, 13 Reading, 21 Writing, 18 Speaking");
                        break;
                    case "Proficient":
                        spinnerValue = 10;
                        Tips.setText("IELTS: 7+ in each component; or OET: B pass in each component; or PTE Academic: 65+ in each component; or Cambridge (CAE): 185+ in each component; or TOEFL iBT: 24 in Listening, 24 Reading, 27 Writing, 23 Speaking");
                        break;
                    case "Superior":
                        spinnerValue = 20;
                        Tips.setText("IELTS: 8+ in each component; or OET: A pass in each component; or PTE Academic: 79+ in each component; or Cambridge (CAE): 200+ in each component; or TOEFL iBT: 28 in Listening, 29 Reading, 30 Writing, 26 Speaking");
                        break;
                    default:
                        spinnerValue = 0;
                }

                englishScore = spinnerValue;
                totalScore += englishScore;
                indicator2.setProgress(totalScore);
                points2.setText("Your Points are:" + totalScore);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent exitIntent = new Intent(Aus2.this, MainActivity.class);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}