package com.nishant.prepmob;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class QuestionActivity extends AppCompatActivity {

    TextView mQuestionType, mQuestion;
    CardView mOpt1, mOpt2, mOpt3, mOpt4;
    TextView mOpt1text, mOpt2text, mOpt3text, mOpt4text;
    String correctColor = "#83FE79", incorrectColor = "#FF6C6C";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mQuestionType = findViewById(R.id.sectionQuestionType);
        mQuestion = findViewById(R.id.sectionQuestion);
        mOpt1 = findViewById(R.id.opt1);
        mOpt2 = findViewById(R.id.opt2);
        mOpt3 = findViewById(R.id.opt3);
        mOpt4 = findViewById(R.id.opt4);
        mOpt1text = findViewById(R.id.opt1text);
        mOpt2text = findViewById(R.id.opt2text);
        mOpt3text = findViewById(R.id.opt3text);
        mOpt4text = findViewById(R.id.opt4text);
        getQuestionContent();

        mOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOpt1text.getText().toString().equals(getIntent().getExtras().getString("correctOpt"))) {
                    YoYo.with(Techniques.RubberBand).playOn(mOpt1);
                    mOpt1.setBackgroundColor(Color.parseColor(correctColor));
                    mOpt1.setClickable(false);
                    mOpt2.setClickable(false);
                    mOpt3.setClickable(false);
                    mOpt4.setClickable(false);
                } else {
                    YoYo.with(Techniques.Shake).playOn(mOpt1);
                    mOpt1.setBackgroundColor(Color.parseColor(incorrectColor));
                    mOpt1.setClickable(false);
                    mOpt2.setClickable(false);
                    mOpt3.setClickable(false);
                    mOpt4.setClickable(false);
                    findCorrect();
                }
            }
        });

        mOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOpt2text.getText().toString().equals(getIntent().getExtras().getString("correctOpt"))) {
                    YoYo.with(Techniques.RubberBand).playOn(mOpt2);
                    mOpt2.setBackgroundColor(Color.parseColor(correctColor));
                    mOpt1.setClickable(false);
                    mOpt2.setClickable(false);
                    mOpt3.setClickable(false);
                    mOpt4.setClickable(false);
                } else {
                    YoYo.with(Techniques.Shake).playOn(mOpt2);
                    mOpt2.setBackgroundColor(Color.parseColor(incorrectColor));
                    mOpt1.setClickable(false);
                    mOpt2.setClickable(false);
                    mOpt3.setClickable(false);
                    mOpt4.setClickable(false);
                    findCorrect();
                }
            }
        });

        mOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOpt3text.getText().toString().equals(getIntent().getExtras().getString("correctOpt"))) {
                    YoYo.with(Techniques.RubberBand).playOn(mOpt3);
                    mOpt3.setBackgroundColor(Color.parseColor(correctColor));
                    mOpt1.setClickable(false);
                    mOpt2.setClickable(false);
                    mOpt3.setClickable(false);
                    mOpt4.setClickable(false);
                } else {
                    YoYo.with(Techniques.Shake).playOn(mOpt3);
                    mOpt3.setBackgroundColor(Color.parseColor(incorrectColor));
                    mOpt1.setClickable(false);
                    mOpt2.setClickable(false);
                    mOpt3.setClickable(false);
                    mOpt4.setClickable(false);
                    findCorrect();
                }
            }
        });

        mOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOpt4text.getText().toString().equals(getIntent().getExtras().getString("correctOpt"))) {
                    YoYo.with(Techniques.RubberBand).playOn(mOpt4);
                    mOpt4.setBackgroundColor(Color.parseColor(correctColor));
                    mOpt1.setClickable(false);
                    mOpt2.setClickable(false);
                    mOpt3.setClickable(false);
                    mOpt4.setClickable(false);
                } else {
                    YoYo.with(Techniques.Shake).playOn(mOpt4);
                    mOpt4.setBackgroundColor(Color.parseColor(incorrectColor));
                    mOpt1.setClickable(false);
                    mOpt2.setClickable(false);
                    mOpt3.setClickable(false);
                    mOpt4.setClickable(false);
                    findCorrect();
                }
            }
        });

    }

    private void findCorrect() {

        String correct, o1, o2, o3, o4;
        correct = getIntent().getExtras().getString("correctOpt");
        o1 = mOpt1text.getText().toString();
        o2 = mOpt2text.getText().toString();
        o3 = mOpt3text.getText().toString();
        o4 = mOpt4text.getText().toString();

        if (o1.equals(correct)) {
            mOpt1.setBackgroundColor(Color.parseColor(correctColor));
            YoYo.with(Techniques.RubberBand).playOn(mOpt1);
        }
        if (o2.equals(correct)) {
            mOpt2.setBackgroundColor(Color.parseColor(correctColor));
            YoYo.with(Techniques.RubberBand).playOn(mOpt2);
        }
        if (o3.equals(correct)) {
            mOpt3.setBackgroundColor(Color.parseColor(correctColor));
            YoYo.with(Techniques.RubberBand).playOn(mOpt3);
        }
        if (o4.equals(correct)) {
            mOpt4.setBackgroundColor(Color.parseColor(correctColor));
            YoYo.with(Techniques.RubberBand).playOn(mOpt4);
        }

    }

    private void getQuestionContent() {
        mQuestionType.setText(getIntent().getExtras().getString("type"));
        mQuestion.setText(getIntent().getExtras().getString("question"));
        mOpt1text.setText(getIntent().getExtras().getString("opt1"));
        mOpt2text.setText(getIntent().getExtras().getString("opt2"));
        mOpt3text.setText(getIntent().getExtras().getString("opt3"));
        mOpt4text.setText(getIntent().getExtras().getString("opt4"));
    }
}
