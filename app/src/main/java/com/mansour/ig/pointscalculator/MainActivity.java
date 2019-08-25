package com.mansour.ig.pointscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private AdView mAdView;


    public static Integer ageScore = 0;
    public static Integer englishScore = 0;
    public static Integer qualScore = 0;
    public static Integer study = 0;
    public static Integer proffYear = 0;
    public static Integer qualifications = 0;
    public static Integer workExp = 0;
    public static Integer austWrkExp = 0;
    public static Integer desLang = 0;
    public static Integer partnerSkills = 0;
    public static Integer visaSubclass = 0;
    public static Integer astStudyReq = 0;

    public static Integer spinnerSelect1 = 0;
    public static Integer spinnerSelect2 = 0;
    public static Integer spinnerSelect3 = 0;
    public static Integer spinnerSelect4 = 0;
    public static Integer spinnerSelect5 = 0;
    public static Integer radioSelect1 = 0;
    public static Integer radioSelect2 = 0;
    public static Integer radioSelect3 = 0;
    public static Integer radioSelect4 = 0;
    public static Integer radioSelect5 = 0;
    public static Integer radioSelect6 = 0;
    public static boolean checkBoxSelect1 = false;
    public static boolean checkBoxSelect2 = false;
    public static boolean checkBoxSelect3 = false;
    public static Integer totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  MobileAds.initialize(this,"ca-app-pub-9339624373452507~1496527037");


        Button Australia =  findViewById(R.id.Aus);
        Australia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                totalScore = 0;
                ageScore = 0;
                englishScore = 0;
                qualScore = 0;
                study = 0;
                proffYear = 0;
                qualifications = 0;
                workExp = 0;
                austWrkExp = 0;
                desLang = 0;
                partnerSkills = 0;
                visaSubclass = 0;
                Intent myIntent = new Intent(MainActivity.this, Aust1.class);
                startActivity(myIntent);
                spinnerSelect1 = 0;
                spinnerSelect2 = 0;
                spinnerSelect3 = 0;
                spinnerSelect4 = 0;
                spinnerSelect5 = 0;
                radioSelect1 = 0;
                radioSelect2 = 0;
                radioSelect3 = 0;
                radioSelect4 = 0;
                radioSelect5 = 0;
                radioSelect6 = 0;
                checkBoxSelect1 = false;
                checkBoxSelect2 = false;
                checkBoxSelect3 = false;
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }

    @Override
    public void onBackPressed() {

        finish();

    }
}