package com.ahmet.interviewapp.technical_questions;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ahmet.interviewapp.Adaptors.SliderAdapter;
import com.ahmet.interviewapp.Models.AddAnswers;
import com.ahmet.interviewapp.Models.Answers;
import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.R;
import com.ahmet.interviewapp.behavioural_questions.BehaviouralQuestionsFragment;

import java.util.ArrayList;


public class JavaTechnicalAnswers extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    ArrayList<Questions> questionsArrayList = new ArrayList<>();
    ArrayList<Answers> answersArrayList = new ArrayList<>();

    AddAnswers addAnswers;
    Answers answers;
    Questions questions;
    int screen = 0;
    Button javaRightButton, javaLeftButton, javaCenterButton;

    public JavaTechnicalAnswers() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_java_technical_answers, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.javaViewPager);
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
        String[] answersArray = getResources().getStringArray(R.array.javaTechnicalAnswers);
        String[] questionsArray = getResources().getStringArray(R.array.javaTechnicalQuestions);
        //retrieve the answers and add to slide
        addAnswers.add(getActivity(), answers, questions, answersArrayList, questionsArrayList, answersArray, questionsArray, sliderAdapter);
        //load the corresponding slide to the question
        addAnswers.loadSlide(getActivity(), sliderAdapter, viewPager);

        //initialise buttons
        javaLeftButton = (Button) view.findViewById(R.id.javaLeftButton);
        javaRightButton = (Button) view.findViewById(R.id.javaRightButton);
        javaCenterButton = (Button) view.findViewById(R.id.javaCenterButton);
        //set click listener on buttons
        javaLeftButton.setOnClickListener(this);
        javaRightButton.setOnClickListener(this);
        javaCenterButton.setOnClickListener(this);

        //hide the title bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.javaRightButton:
                addAnswers.loadNextSlide(viewPager, sliderAdapter);
                break;
            case R.id.javaLeftButton:
                addAnswers.loadPreviousSlide(viewPager, sliderAdapter);
                break;
            case R.id.javaCenterButton:
                JavaTechnicalQuestionsFragment javaTechnicalQuestionsFragment = new JavaTechnicalQuestionsFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, javaTechnicalQuestionsFragment).addToBackStack(null).commit();
                break;
        }
    }
}
