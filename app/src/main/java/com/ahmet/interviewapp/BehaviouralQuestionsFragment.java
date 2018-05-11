package com.ahmet.interviewapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BehaviouralQuestionsFragment extends Fragment {


    ListView behaviouraListview;

    ArrayList<BehaviouralQuestions> questionsArrayList = new ArrayList<>();
    BehaviouralQuestions behaviouralQuestions;
    BehaviouralQuestionsListViewAdaptor listViewAdaptor;

    public BehaviouralQuestionsFragment() {
    }

    //    https://stackoverflow.com/questions/39019824/populate-listview-with-text-and-value-from-strings-xml

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_behavioural_questions, container, false);

        behaviouraListview = (ListView) view.findViewById(R.id.behaviouralListView);
        //initialise Adaptor
        listViewAdaptor = new BehaviouralQuestionsListViewAdaptor(getActivity(), questionsArrayList);

        addQuestions();
        behaviouraListview.setAdapter(listViewAdaptor);

        Button interviewPrepButton = (Button) view.findViewById(R.id.interviewPrepButton);

        interviewPrepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InterviewPrepGridFragment interviewPrepGridFragment = new InterviewPrepGridFragment();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_layout, interviewPrepGridFragment).commit();
            }
        });

        behaviouraListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BehaviouralSlides behaviouralSlides = new BehaviouralSlides();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_layout, behaviouralSlides).commit();
            }
        });

        // slider https://www.youtube.com/watch?v=byLKoPgB7yA
        //actionbar title change
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Behavioural Questions");
        return view;
    }

    //add questions in listview
    public void addQuestions() {
//        behaviouralQuestions = new BehaviouralQuestions();
        try {
            //get the questions from resources
            String[] array = getResources().getStringArray(R.array.behaviouralQuestions);

            //output the questions in a listview
            for (int i = 0; i < array.length; i++) {
                behaviouralQuestions = new BehaviouralQuestions();

                String questions = array[i];
                //add the questions from array
                behaviouralQuestions.setQuestions(i + 1 + "- " + questions);
                questionsArrayList.add(behaviouralQuestions);

            }
            listViewAdaptor.notifyDataSetChanged();
        } catch (Exception e) {
            showMessage("Error", e.getMessage());
        }

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
