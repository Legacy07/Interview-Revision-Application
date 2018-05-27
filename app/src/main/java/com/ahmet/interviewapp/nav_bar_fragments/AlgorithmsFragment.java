package com.ahmet.interviewapp.nav_bar_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ahmet.interviewapp.Adaptors.QuestionsListViewAdaptor;
import com.ahmet.interviewapp.Algorithms.Advanced;
import com.ahmet.interviewapp.Algorithms.DataStructures;
import com.ahmet.interviewapp.Algorithms.Graph;
import com.ahmet.interviewapp.Algorithms.Searching;
import com.ahmet.interviewapp.Algorithms.Sorting;
import com.ahmet.interviewapp.Models.AddQuestions;
import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.R;

import java.util.ArrayList;


public class AlgorithmsFragment extends Fragment {


    ListView listView;

    ArrayList<Questions> arrayList = new ArrayList<>();
    Questions questions;
    QuestionsListViewAdaptor listViewAdaptor;

    FragmentManager fragmentManager;

    public AlgorithmsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.questions_layout, container, false);

        final DataStructures dataStructures = new DataStructures();
        final Searching searching = new Searching();
        final Sorting sorting = new Sorting();
        final Graph graph = new Graph();
        final Advanced advanced = new Advanced();

        fragmentManager = getFragmentManager();

        listView = (ListView) view.findViewById(R.id.listView);
        //initialise Adaptor
        listViewAdaptor = new QuestionsListViewAdaptor(getActivity(), arrayList);

        String[] questionsArray = getResources().getStringArray(R.array.algorithm_topics);
        //add the topics in listview
        AddQuestions addQuestions = new AddQuestions();
        addQuestions.add(getActivity(), questions, arrayList, questionsArray, listViewAdaptor);
        listView.setAdapter(listViewAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selected = ((TextView) view.findViewById(R.id.questionsTextView)).getText().toString();
                String text = selected.substring(3);
//
                if (text.equals("Data Structures")) {
                    fragmentManager.beginTransaction().replace(R.id.content_layout, dataStructures).addToBackStack(null).commit();
                }
                if (text.contains("Searching")) {
                fragmentManager.beginTransaction().replace(R.id.content_layout, searching).addToBackStack(null).commit();
                }
                if (text.contains("Sorting")) {
                fragmentManager.beginTransaction().replace(R.id.content_layout, sorting).addToBackStack(null).commit();
                }
                if (text.contains("Graph Algorithm")) {
                fragmentManager.beginTransaction().replace(R.id.content_layout, graph).addToBackStack(null).commit();
                }
                if (text.contains("Advanced Algorithms")) {
                fragmentManager.beginTransaction().replace(R.id.content_layout, advanced).addToBackStack(null).commit();
                }
            }
        });

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Algorithms");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

}
