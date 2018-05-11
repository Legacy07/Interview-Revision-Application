package com.ahmet.interviewapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class InterviewPrepGridFragment extends Fragment {


    public InterviewPrepGridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_interview_prep_grid, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Interview Preparation Grid");

        return view;
    }

}
