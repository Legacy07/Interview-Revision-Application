package com.ahmet.interviewapp.Technical_Questions;


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

import java.util.ArrayList;

public class HtmlQuestionsFragment extends Fragment {

    ListView listView;
    ArrayList<Questions> questionsArrayList = new ArrayList<>();
    Questions questions;
    QuestionsListViewAdaptor listViewAdaptor;

    public HtmlQuestionsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.questions_layout, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        //initialise Adaptor
        listViewAdaptor = new QuestionsListViewAdaptor(getActivity(), questionsArrayList);

        String[] questionsArray = getResources().getStringArray(R.array.html_questions);
        //add the questions in listview
        AddQuestions addQuestions = new AddQuestions();
        addQuestions.add(getActivity(), questions, questionsArrayList, questionsArray, listViewAdaptor);
        listView.setAdapter(listViewAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //open slides when clicked on a list item
                HtmlAnswers htmlAnswers = new HtmlAnswers();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_layout, htmlAnswers).addToBackStack(null).commit();
//                send the position of the item so it opens the corresponding slide to the question
                Bundle bundle = new Bundle();
                bundle.putInt("Position", position);
                Intent intent = getActivity().getIntent();
                intent.putExtras(bundle);
            }
        });

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("HTML Technical Questions");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }
}
