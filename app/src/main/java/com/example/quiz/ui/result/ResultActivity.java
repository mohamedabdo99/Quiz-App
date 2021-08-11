package com.example.quiz.ui.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.data.ResultInterFace;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity{
    private TextView tv_result_java;
    private Button buttonDoneJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_result_java = findViewById(R.id.tv_result);
        buttonDoneJava = findViewById(R.id.buttonDone);
        Intent intent = getIntent();
        String show = intent.getStringExtra("result");

        if (show.equals(4+""))
        {
            tv_result_java.setText("You're good. ! ");
        }
        else if (show.equals(6+""))
        {
            tv_result_java.setText("Your level is very good. ");
        }
        else if (show.equals(10+""))
        {
            tv_result_java.setText("Your level is excellent.");
        }
        else
        {
            tv_result_java.setText("You need to study more.");
        }

        buttonDoneJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

}