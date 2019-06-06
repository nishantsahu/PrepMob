package com.example.prepmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    CardView mQuantitative, mLogical, mVerbal, mDatainterpretation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuantitative = findViewById(R.id.quantitative);
        mLogical = findViewById(R.id.logical);
        mVerbal = findViewById(R.id.verbal);
        mDatainterpretation = findViewById(R.id.datainterpretation);

        mQuantitative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quantitative = new Intent(getApplicationContext(), QuestionListActivity.class);
                quantitative.putExtra("category", "quantitative");
                startActivity(quantitative);
            }
        });

        mLogical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logical = new Intent(getApplicationContext(), QuestionListActivity.class);
                logical.putExtra("category", "logical");
                startActivity(logical);
            }
        });

        mVerbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verbal = new Intent(getApplicationContext(), QuestionListActivity.class);
                verbal.putExtra("category", "verbal");
                startActivity(verbal);
            }
        });

        mDatainterpretation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datainter = new Intent(getApplicationContext(), QuestionListActivity.class);
                datainter.putExtra("category", "datainterpretation");
                startActivity(datainter);
            }
        });
    }
}
