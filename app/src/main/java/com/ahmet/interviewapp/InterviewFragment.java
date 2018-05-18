package com.ahmet.interviewapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InterviewFragment extends Fragment {

    Button behaviouralButton, technicalButton, clicheButton, tipsbutton;

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

        behaviouralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BehaviouralQuestionsFragment behaviouralQuestionsFragment = new BehaviouralQuestionsFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, behaviouralQuestionsFragment).addToBackStack(null).commit();
            }
        });

        //actionbar title change
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Interview");
        return view;
    }

}
