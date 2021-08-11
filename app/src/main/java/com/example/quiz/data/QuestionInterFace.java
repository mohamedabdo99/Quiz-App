package com.example.quiz.data;

import com.example.quiz.pojo.QuestionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuestionInterFace {

    @GET("questions")
    Call<List<QuestionModel>> getQuestion(@Query("apiKey") String apiKey
            ,@Query("category") String category,@Query("limit") int limit);
}
