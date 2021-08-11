package com.example.quiz.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import com.example.quiz.R;
import com.example.quiz.data.ResultInterFace;
import com.example.quiz.pojo.QuestionModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleView;
    private AdapterQuestion adapterQuestion;
    private QuestionViewModel questionViewModel ;
    public static  Button button_submit_java;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionViewModel = ViewModelProviders.of(this).get(QuestionViewModel.class);
        questionViewModel.getQuestions();
        recycleView = findViewById(R.id.recycleView);
        button_submit_java = findViewById(R.id.button_submit);
        adapterQuestion = new AdapterQuestion(button_submit_java,this);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(adapterQuestion);
        questionViewModel.questionMutableLiveData.observe(this,
                new Observer<List<QuestionModel>>() {
            @Override
            public void onChanged(List<QuestionModel> questionModels)
            {
            adapterQuestion.setQuestionList(questionModels);
            }
        });
    }


}