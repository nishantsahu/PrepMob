package com.nishant.prepmob.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nishant.prepmob.Data.Questions;
import com.nishant.prepmob.QuestionActivity;
import com.nishant.prepmob.R;

import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionListViewHolder>{

    Context mCtx;
    List<Questions> questionsList;

    public QuestionListAdapter(Context mCtx, List<Questions> questionsList) {
        this.mCtx = mCtx;
        this.questionsList = questionsList;
    }

    @NonNull
    @Override
    public QuestionListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.question_card, parent, false);
        QuestionListViewHolder questionListViewHolder = new QuestionListViewHolder(view);
        return questionListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionListViewHolder holder, int position) {

        final Questions questions = questionsList.get(position);

        YoYo.with(Techniques.FlipInX).playOn(holder.mQuestionCard);
        holder.mQuestionType.setText(questions.getQuestionType());
        holder.mQuestion.setText(questions.getQuestion());
        holder.mQuestionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent question = new Intent(mCtx, QuestionActivity.class);
                question.putExtra("id", questions.getId());
                question.putExtra("type", questions.getQuestionType());
                question.putExtra("question", questions.getQuestion());
                question.putExtra("opt1", questions.getOpt1());
                question.putExtra("opt2", questions.getOpt2());
                question.putExtra("opt3", questions.getOpt3());
                question.putExtra("opt4", questions.getOpt4());
                question.putExtra("correctOpt", questions.getCorrectopt());
                mCtx.startActivity(question);
            }
        });

    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public class QuestionListViewHolder extends RecyclerView.ViewHolder {

        TextView mQuestionType, mQuestion;
        CardView mQuestionCard;
        public QuestionListViewHolder(@NonNull View itemView) {
            super(itemView);

            mQuestionCard = itemView.findViewById(R.id.questionCard);
            mQuestionType = itemView.findViewById(R.id.questionType);
            mQuestion = itemView.findViewById(R.id.question);
        }
    }
}
