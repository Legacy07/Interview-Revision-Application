package com.ahmet.interviewapp.nav_bar_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ahmet.interviewapp.R;
import com.ahmet.interviewapp.technical_questions.JavaTechnicalQuestionsFragment;


public class TechnicalQuestionsFragment extends Fragment implements View.OnClickListener {


    Button javaButton, androidButton, cSharpButton, htmlButton, phpButton, cssButton;
    FragmentManager manager;

    public TechnicalQuestionsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_technical_questions, container, false);

        javaButton = (Button) view.findViewById(R.id.javaButton);
        androidButton = (Button) view.findViewById(R.id.androidButton);
        cSharpButton = (Button) view.findViewById(R.id.csharpButton);
        htmlButton = (Button) view.findViewById(R.id.htmlButton);
        phpButton = (Button) view.findViewById(R.id.phpButton);
        cssButton = (Button) view.findViewById(R.id.cssButton);

        javaButton.setOnClickListener(this);
        androidButton.setOnClickListener(this);
        cSharpButton.setOnClickListener(this);
        htmlButton.setOnClickListener(this);
        phpButton.setOnClickListener(this);
        cssButton.setOnClickListener(this);

        manager = getActivity().getSupportFragmentManager();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Technical Questions");

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.javaButton:
            JavaTechnicalQuestionsFragment javaTechnicalQuestionsFragment = new JavaTechnicalQuestionsFragment();
            manager.beginTransaction().replace(R.id.content_layout, javaTechnicalQuestionsFragment).addToBackStack(null).commit();

                break;

            case R.id.androidButton:

                break;
            case R.id.csharpButton:

                break;
            case R.id.htmlButton:

                break;
            case R.id.phpButton:

                break;
            case R.id.cssButton:

                break;
        }
    }
}
