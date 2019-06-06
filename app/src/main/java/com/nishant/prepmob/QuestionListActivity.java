package com.nishant.prepmob;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.nishant.prepmob.Adapter.QuestionListAdapter;
import com.nishant.prepmob.Data.Questions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QuestionListActivity extends AppCompatActivity {

    RecyclerView mQuestionList;
    QuestionListAdapter adapter;
    List<Questions> questionsList;
    OkHttpClient client;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        mQuestionList = findViewById(R.id.questionListxml);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        mQuestionList.setLayoutManager(new LinearLayoutManager(this));
        mQuestionList.setHasFixedSize(true);

        questionsList = new ArrayList<>();

        client = new OkHttpClient();

        getQuestionList();

        adapter = new QuestionListAdapter(QuestionListActivity.this, questionsList);
        mQuestionList.setAdapter(adapter);
    }

    private void getQuestionList() {

        progressDialog.show();

        Request request = new Request.Builder()
                .url(Api.BASE_URL+"/allQuestions")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        Toast.makeText(QuestionListActivity.this, "Connection error", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            progressDialog.dismiss();
                            String result = response.body().string();
                            String id, category, type, question, opt1, opt2, opt3, opt4, correctOpt;
                            JSONArray jsonArray = new JSONArray(result);
                            int questionNumber = 1;
                            for(int i=jsonArray.length()-1 ; i>=0; i--) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                id = jsonObject.getString("id");
                                category = jsonObject.getString("category");
                                type = jsonObject.getString("type");
                                question = jsonObject.getString("question");
                                opt1 = jsonObject.getString("opt1");
                                opt2 = jsonObject.getString("opt2");
                                opt3 = jsonObject.getString("opt3");
                                opt4 = jsonObject.getString("opt4");
                                correctOpt = jsonObject.optString("correctopt");

                                if (category.equals(getIntent().getExtras().getString("category"))) {
                                    questionsList.add(new Questions(id, "", type, "Q" + questionNumber + ". " + question, opt1, opt2, opt3, opt4, correctOpt));
                                    questionNumber++;
                                }
                            }
                            adapter = new QuestionListAdapter(QuestionListActivity.this, questionsList);
                            mQuestionList.setAdapter(adapter);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

}
