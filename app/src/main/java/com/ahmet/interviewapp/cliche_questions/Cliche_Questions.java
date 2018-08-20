package com.ahmet.interviewapp.cliche_questions;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ahmet.interviewapp.Adaptors.QuestionsListViewAdaptor;
import com.ahmet.interviewapp.Models.AddQuestions;
import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.R;
import com.ahmet.interviewapp.behavioural_questions.BehaviouralAnswers;

import java.util.ArrayList;

public class Cliche_Questions extends Fragment {



    ListView listView;

    ArrayList<Questions> questionsArrayList = new ArrayList<>();
    Questions questions;
    QuestionsListViewAdaptor listViewAdaptor;

    public Cliche_Questions() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.questions_layout, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        //initialise Adaptor
        listViewAdaptor = new QuestionsListViewAdaptor(getActivity(), questionsArrayList);

        AddQuestions addQuestions = new AddQuestions();
        //get the questions from array string
        String[] array = getResources().getStringArray(R.array.cliche_questions);
        //add the questions in listview
        addQuestions.add(getActivity(), questions,questionsArrayList, array, listViewAdaptor );
        listView.setAdapter(listViewAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //open slides when clicked on a list item
                Cliche_Answers cliche_answers = new Cliche_Answers();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_layout, cliche_answers).addToBackStack(null).commit();
                //send the position of the item so it opens the corresponding slide to the question
                Bundle bundle = new Bundle();
                bundle.putInt("Position", position);
                Intent intent = getActivity().getIntent();
                intent.putExtras(bundle);
            }
        });

        // slider https://www.youtube.com/watch?v=byLKoPgB7yA
        //actionbar title change
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Cliché Questions");

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        //show the title bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

    }
}
