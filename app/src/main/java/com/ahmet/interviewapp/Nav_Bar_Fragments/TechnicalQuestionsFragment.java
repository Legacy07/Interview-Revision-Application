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
import com.ahmet.interviewapp.Technical_Questions.AndroidTechnicalQuestionsFragment;
import com.ahmet.interviewapp.Technical_Questions.CSharpTechnicalQuestionsFragment;
import com.ahmet.interviewapp.Technical_Questions.GeneralWebQuestionsFragment;
import com.ahmet.interviewapp.Technical_Questions.HtmlQuestionsFragment;
import com.ahmet.interviewapp.Technical_Questions.JavaScriptQuestionsFragment;
import com.ahmet.interviewapp.Technical_Questions.JavaTechnicalQuestionsFragment;
import com.ahmet.interviewapp.Technical_Questions.ObjectOrientedQuestionsFragment;


public class TechnicalQuestionsFragment extends Fragment implements View.OnClickListener {


    Button javaButton, androidButton, cSharpButton, objectOrientedButton, generalWebButton, htmlButton, jsButton, phpButton, cssButton;
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
        objectOrientedButton = (Button) view.findViewById(R.id.objectOrientedButton);
        generalWebButton = (Button) view.findViewById(R.id.generalWebButton);
        htmlButton = (Button) view.findViewById(R.id.htmlButton);
        jsButton = (Button) view.findViewById(R.id.jsButton);

//        phpButton = (Button) view.findViewById(R.id.phpButton);
//        cssButton = (Button) view.findViewById(R.id.cssButton);

        javaButton.setOnClickListener(this);
        androidButton.setOnClickListener(this);
        cSharpButton.setOnClickListener(this);
        objectOrientedButton.setOnClickListener(this);
        generalWebButton.setOnClickListener(this);
        htmlButton.setOnClickListener(this);
        jsButton.setOnClickListener(this);

//        phpButton.setOnClickListener(this);
//        cssButton.setOnClickListener(this);

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
                AndroidTechnicalQuestionsFragment androidTechnicalQuestionsFragment = new AndroidTechnicalQuestionsFragment();
                manager.beginTransaction().replace(R.id.content_layout, androidTechnicalQuestionsFragment).addToBackStack(null).commit();

                break;
            case R.id.csharpButton:
                CSharpTechnicalQuestionsFragment cSharpTechnicalQuestionsFragment = new CSharpTechnicalQuestionsFragment();
                manager.beginTransaction().replace(R.id.content_layout, cSharpTechnicalQuestionsFragment).addToBackStack(null).commit();

                break;

            case R.id.objectOrientedButton:
                ObjectOrientedQuestionsFragment objectOrientedQuestionsFragment = new ObjectOrientedQuestionsFragment();
                manager.beginTransaction().replace(R.id.content_layout, objectOrientedQuestionsFragment).addToBackStack(null).commit();

                break;

            case R.id.generalWebButton:
                GeneralWebQuestionsFragment generalWebQuestionsFragment = new GeneralWebQuestionsFragment();
                manager.beginTransaction().replace(R.id.content_layout, generalWebQuestionsFragment).addToBackStack(null).commit();

                break;
            case R.id.htmlButton:
                HtmlQuestionsFragment htmlQuestionsFragment = new HtmlQuestionsFragment();
                manager.beginTransaction().replace(R.id.content_layout, htmlQuestionsFragment).addToBackStack(null).commit();

                break;
            case R.id.jsButton:
                JavaScriptQuestionsFragment javaScriptQuestionsFragment = new JavaScriptQuestionsFragment();
                manager.beginTransaction().replace(R.id.content_layout, javaScriptQuestionsFragment).addToBackStack(null).commit();

                break;
//            case R.id.phpButton:
//
//                break;
//            case R.id.cssButton:
//
//                break;
        }
    }
}
