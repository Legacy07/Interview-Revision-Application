package com.ahmet.interviewapp.Tips;


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
import android.widget.TextView;

import com.ahmet.interviewapp.Adaptors.QuestionsListViewAdaptor;
import com.ahmet.interviewapp.Models.AddQuestions;
import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TelephoneInterviewTips extends Fragment {

    ListView listView;

    ArrayList<Questions> questionsArrayList = new ArrayList<>();
    Questions questions;
    QuestionsListViewAdaptor listViewAdaptor;

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
        String[] array = getResources().getStringArray(R.array.telephoneInterviewTopics);
        //add the questions in listview
        addQuestions.add(getActivity(), questions,questionsArrayList, array, listViewAdaptor );
        listView.setAdapter(listViewAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //open slides when clicked on a list item
                TelephoneInterviewTipsAnswers telephoneInterviewTipsAnswers = new TelephoneInterviewTipsAnswers();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_layout, telephoneInterviewTipsAnswers).addToBackStack(null).commit();
                //send the position of the item so it opens the corresponding slide to the question
                Bundle bundle = new Bundle();
                bundle.putInt("Position", position);
                Intent intent = getActivity().getIntent();
                intent.putExtras(bundle);
            }
        });

        // slider https://www.youtube.com/watch?v=byLKoPgB7yA
        //actionbar title change
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Telephone Interview Tips");

        return view;
    }

}
