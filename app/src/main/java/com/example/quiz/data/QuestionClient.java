package com.example.quiz.data;

import com.example.quiz.pojo.QuestionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionClient {
    private static final String BASE_UEL = "https://quizapi.io/api/v1/";
    private  QuestionInterFace questionInterFace;
    private static QuestionClient INSTANT;

    public QuestionClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_UEL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        questionInterFace = retrofit.create(QuestionInterFace.class);
    }

    public static  QuestionClient getInstance(){
        if (null == INSTANT)
        {
            INSTANT = new QuestionClient();
        }
        return  INSTANT;
    }

    public Call<List<QuestionModel>> getQuestion()
    {
    return questionInterFace.getQuestion("VA4IKH1NGc06uUvBvpUJ4ylYPH4ZZKADvFtqs2Kb"
            ,"sql",10);
    }
}
