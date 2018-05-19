package com.ahmet.interviewapp.Models;

import android.content.Context;
import android.util.Log;

import com.ahmet.interviewapp.Adaptors.QuestionsListViewAdaptor;
import com.ahmet.interviewapp.Models.Questions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddQuestions {


    public AddQuestions() {
    }

    public void add(Context context, Questions questions, ArrayList questionsArrayList, String[] questionsArray, QuestionsListViewAdaptor listViewAdaptor) {
        questions = new Questions();
        //without this, it will duplicate itself everytime the user goes back from another fragment
        questionsArrayList.clear();
        try {
            //get the questions from resources
            String[] array = questionsArray;

            //output the questions in a listview
            for (int i = 0; i < array.length; i++) {
                questions = new Questions();

                String sQuestions = array[i];
                //add the questions from array
                questions.setQuestions(i + 1 + "- " + sQuestions);
                questionsArrayList.add(questions);

            }
            listViewAdaptor.notifyDataSetChanged();
        } catch (Exception e) {
            Log.d("Listview Error", e.getMessage());
        }
    }
}
