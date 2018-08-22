package com.ahmet.interviewapp.Nav_Bar_Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ahmet.interviewapp.R;
import com.ahmet.interviewapp.Behavioural_Questions.BehaviouralQuestionsFragment;
import com.ahmet.interviewapp.Cliche_Questions.Cliche_Questions;


public class InterviewFragment extends Fragment implements View.OnClickListener {

    Button behaviouralButton, technicalButton, clicheButton, tipsbutton;

    FragmentManager manager;

    public InterviewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_interview, container, false);

        behaviouralButton = (Button) view.findViewById(R.id.behaviouralButton);
        technicalButton = (Button) view.findViewById(R.id.technicalButton);
        clicheButton = (Button) view.findViewById(R.id.clicheButton);
        tipsbutton = (Button) view.findViewById(R.id.tipsButton);

        behaviouralButton.setOnClickListener(this);
        technicalButton.setOnClickListener(this);
        clicheButton.setOnClickListener(this);
        tipsbutton.setOnClickListener(this);

        manager = getActivity().getSupportFragmentManager();

        //actionbar title change
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Interview");
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.behaviouralButton:
                BehaviouralQuestionsFragment behaviouralQuestionsFragment = new BehaviouralQuestionsFragment();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, behaviouralQuestionsFragment).addToBackStack(null).commit();

                break;

            case R.id.technicalButton:
                TechnicalQuestionsFragment technicalQuestionsFragment = new TechnicalQuestionsFragment();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, technicalQuestionsFragment).addToBackStack(null).commit();

                break;

            case R.id.clicheButton:
                Cliche_Questions cliche_questions = new Cliche_Questions();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, cliche_questions).addToBackStack(null).commit();

                break;

            case R.id.tipsButton:
                TipsFragment tipsFragment = new TipsFragment();
                manager.beginTransaction().replace(R.id.content_layout, tipsFragment).addToBackStack(null).commit();
                break;
        }
    }
}
