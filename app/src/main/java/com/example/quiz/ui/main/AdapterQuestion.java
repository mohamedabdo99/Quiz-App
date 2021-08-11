package com.example.quiz.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quiz.R;
import com.example.quiz.data.ResultInterFace;
import com.example.quiz.pojo.QuestionModel;
import com.example.quiz.ui.result.ResultActivity;

import java.util.ArrayList;
import java.util.List;

public class AdapterQuestion extends RecyclerView.Adapter<AdapterQuestion.ViewHolder> {

    List<QuestionModel> questionList = new ArrayList<>();
    private int result = 0;
    boolean selected = true;
    int [] array;
    private Button btn_result;
    private Context context;

    public AdapterQuestion(Button btn_result, Context context) {
        this.btn_result = btn_result;
        this.context = context;
    }

    public void setQuestionList(List<QuestionModel> questionList) {
        this.questionList = questionList;
        notifyDataSetChanged();
       array = new int[questionList.size()];
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position)
    {
        if (array[position]==0)
        {
            holder.answer1_TV.setBackgroundColor(Color.TRANSPARENT);
            holder.answer2_TV.setBackgroundColor(Color.TRANSPARENT);
            holder.answer3_TV.setBackgroundColor(Color.TRANSPARENT);
            holder.answer4_TV.setBackgroundColor(Color.TRANSPARENT);
        }
        else
        {
            int i = array[position];
            if (i == 1) {
                holder.answer1_TV.setBackgroundColor(Color.CYAN);
            }
             if (i == 2){
            holder.answer2_TV.setBackgroundColor(Color.CYAN);}
             if (i == 3)
             {
            holder.answer3_TV.setBackgroundColor(Color.CYAN);}
             if (i==4){
            holder.answer4_TV.setBackgroundColor(Color.CYAN);}
        }

        holder.queestionTV.setText(position + 1 + " - " + questionList
                .get(position).getQuestion());
        holder.answer1_TV.setText(questionList.get(position).getAnswers().getAnswer_a());
        holder.answer2_TV.setText(questionList.get(position).getAnswers().getAnswer_b());
        holder.answer3_TV.setText(questionList.get(position).getAnswers().getAnswer_c());
        holder.answer4_TV.setText(questionList.get(position).getAnswers().getAnswer_d());
        final String correctAnswer = questionList.get(position).getCorrect_answers()
                .getAnswer_a_correct();

        holder.answer1_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
             array[position]=1;
             view.setBackgroundColor(Color.CYAN);
             System.out.println("setBackgroundColor");
             holder.answer2_TV.setBackgroundColor(Color.TRANSPARENT);
             holder.answer3_TV.setBackgroundColor(Color.TRANSPARENT);
             holder.answer4_TV.setBackgroundColor(Color.TRANSPARENT);
                    if (correctAnswer.equals("true"))
                    {
                        result+=1;
                    }
            }
        });
        // answer 2
        holder.answer2_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                    array[position]=2;
                    view.setBackgroundColor(Color.CYAN);
                    holder.answer1_TV.setBackgroundColor(Color.TRANSPARENT);
                    holder.answer3_TV.setBackgroundColor(Color.TRANSPARENT);
                    holder.answer4_TV.setBackgroundColor(Color.TRANSPARENT);
                    if (correctAnswer.equals("true"))
                    {
                        result+=1;
                    }


            }
        });
        // answer 3
        holder.answer3_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                    array[position]=3;
                    view.setBackgroundColor(Color.CYAN);
                    holder.answer1_TV.setBackgroundColor(Color.TRANSPARENT);
                    holder.answer2_TV.setBackgroundColor(Color.TRANSPARENT);
                    holder.answer4_TV.setBackgroundColor(Color.TRANSPARENT);
                    if (correctAnswer.equals("true"))
                    {
                        result+=1;
                    }

            }
        });
        // answer 4
        holder.answer4_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                    array[position]=4;
                    view.setBackgroundColor(Color.CYAN);
                    holder.answer1_TV.setBackgroundColor(Color.TRANSPARENT);
                    holder.answer3_TV.setBackgroundColor(Color.TRANSPARENT);
                    holder.answer2_TV.setBackgroundColor(Color.TRANSPARENT);
                    if (correctAnswer.equals("true"))
                    {
                        result+=1;
                    }
            }
        });

    }
    @Override
    public int getItemCount() {
        return questionList.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{

        TextView queestionTV;
        TextView answer1_TV, answer2_TV, answer3_TV, answer4_TV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            queestionTV = itemView.findViewById(R.id.tv_question);
            answer1_TV = itemView.findViewById(R.id.tv_answer1);
            answer2_TV = itemView.findViewById(R.id.tv_answer2);
            answer3_TV = itemView.findViewById(R.id.tv_answer3);
            answer4_TV = itemView.findViewById(R.id.tv_answer4);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context,ResultActivity.class);
                intent.putExtra("result",result+"");
                System.out.println("setOnClickListener"+result);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });

        }
    }
}
