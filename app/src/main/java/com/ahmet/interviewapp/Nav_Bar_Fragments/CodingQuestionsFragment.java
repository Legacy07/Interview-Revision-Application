package com.ahmet.interviewapp.Nav_Bar_Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmet.interviewapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CodingQuestionsFragment extends Fragment {


    public CodingQuestionsFragment()
    {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coding_questions, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Coding Questions");

        return view;
    }

}
