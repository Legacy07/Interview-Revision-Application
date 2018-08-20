package com.ahmet.interviewapp.cliche_questions;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmet.interviewapp.Adaptors.SliderAdapter;
import com.ahmet.interviewapp.Models.AddAnswers;
import com.ahmet.interviewapp.Models.Answers;
import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.R;
import com.ahmet.interviewapp.technical_questions.AndroidTechnicalQuestionsFragment;

import java.util.ArrayList;

public class Cliche_Answers extends Fragment implements View.OnClickListener{

    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    ArrayList<Questions> questionsArrayList = new ArrayList<>();
    ArrayList<Answers> answersArrayList = new ArrayList<>();

    AddAnswers addAnswers;
    Answers answers;
    Questions questions;
    int screen = 0;
    FloatingActionButton androidRightButton, androidLeftButton, androidCenterButton;

    public Cliche_Answers() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.answer_slides, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        sliderAdapter = new SliderAdapter(getActivity(), questionsArrayList, answersArrayList);

        viewPager.setAdapter(sliderAdapter);
        //on page scrolled
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        addAnswers = new AddAnswers();
        //get the string arrays
        String[] answersArray = getResources().getStringArray(R.array.cliche_answers);
        String[] questionsArray = getResources().getStringArray(R.array.cliche_questions);
        //retrieve the answers and add to slide
        addAnswers.add(getActivity(), answers, questions, answersArrayList, questionsArrayList, answersArray, questionsArray, sliderAdapter);
        //load the corresponding slide to the question
        addAnswers.loadSlide(getActivity(), sliderAdapter, viewPager);

        //initialise buttons
        androidLeftButton = view.findViewById(R.id.leftButton);
        androidRightButton = view.findViewById(R.id.rightButton);
        androidCenterButton = view.findViewById(R.id.centerButton);
        //set click listener on buttons
        androidLeftButton.setOnClickListener(this);
        androidRightButton.setOnClickListener(this);
        androidCenterButton.setOnClickListener(this);

        //hide the title bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return view;
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rightButton:
                addAnswers.loadNextSlide(viewPager, sliderAdapter);
                break;
            case R.id.leftButton:
                addAnswers.loadPreviousSlide(viewPager, sliderAdapter);
                break;
            case R.id.centerButton:
                Cliche_Questions cliche_questions = new Cliche_Questions();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, cliche_questions).addToBackStack(null).commit();
                break;
        }

    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

    }

}
