package com.ahmet.interviewapp.Models;

import android.content.Context;
import android.util.Log;

import com.ahmet.interviewapp.Adaptors.SliderAdapter;
import com.ahmet.interviewapp.Models.Answers;
import com.ahmet.interviewapp.Models.Questions;

import java.util.ArrayList;

public class AddAnswers {

    public AddAnswers() {
    }

    public void add(Context context, Answers answers, Questions questions, ArrayList answersArraylist, ArrayList questionsArraylist,
                    String[] answerArray, String[] questionsArray, SliderAdapter sliderAdapter) {
        answers = new Answers();
        questions = new Questions();
        //without this, it will duplicate itself everytime the user goes back from another fragment
        answersArraylist.clear();
        questionsArraylist.clear();

        try {
            //get the questions from arrays
            String[] arrayAnswers = answerArray;
            String[] arrayQuestions = questionsArray;

            //loop to get the answers
            for (int i = 0; i < arrayAnswers.length; i++) {
                answers = new Answers();

                String sAnswers = arrayAnswers[i];

                //add the answers from array
                answers.setAnswers(sAnswers);

                answersArraylist.add(answers);

            }
            //loop to get the questions for the corresponding answers
            for (int i = 0; i < arrayQuestions.length; i++) {
                questions = new Questions();

                String sQuestion = arrayQuestions[i];

                //add the questions from array
                questions.setQuestions(sQuestion);

                questionsArraylist.add(questions);

            }
            sliderAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.d("Slider Error", e.getMessage());
        }
    }
}
