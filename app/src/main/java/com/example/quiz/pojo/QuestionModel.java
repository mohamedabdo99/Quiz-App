package com.example.quiz.pojo;

public class QuestionModel {
    private int id;
    private String question;
    private AnswersModel answers;
    private CorrectAnswers correct_answers;
    private String correct_answer;
    private String category;
    private String difficulty;
    private boolean isClicked =false ;

    public boolean isClicked() {
        return isClicked;
    }
    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public CorrectAnswers getCorrect_answers() {
        return correct_answers;
    }

    public void setCorrect_answers(CorrectAnswers correct_answers) {
        this.correct_answers = correct_answers;
    }

    public AnswersModel getAnswers() {
        return answers;
    }

    public void setAnswers(AnswersModel answers) {
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
