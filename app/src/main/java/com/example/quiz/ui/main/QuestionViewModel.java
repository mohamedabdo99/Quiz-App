package com.example.quiz.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quiz.data.QuestionClient;
import com.example.quiz.pojo.QuestionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionViewModel extends ViewModel {
    MutableLiveData<List<QuestionModel>> questionMutableLiveData = new MutableLiveData<>();

        public void getQuestions(){
            QuestionClient.getInstance().getQuestion().enqueue(new Callback<List<QuestionModel>>() {
                @Override
                public void onResponse(Call<List<QuestionModel>> call, Response<List<QuestionModel>> response)
                {

                    questionMutableLiveData.setValue(response.body());
                }

                @Override
                public void onFailure(Call<List<QuestionModel>> call, Throwable t) {

                }
            });
        }
}
