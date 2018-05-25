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

import com.ahmet.interviewapp.Adaptors.SliderAdapter;
import com.ahmet.interviewapp.Models.AddAnswers;
import com.ahmet.interviewapp.Models.Answers;
import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.R;

import java.util.ArrayList;


public class AndroidTechnicalAnswers extends Fragment implements View.OnClickListener {


    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    ArrayList<Questions> questionsArrayList = new ArrayList<>();
    ArrayList<Answers> answersArrayList = new ArrayList<>();

    AddAnswers addAnswers;
    Answers answers;
    Questions questions;
    int screen = 0;
    Button androidRightButton, androidLeftButton, androidCenterButton;

    public AndroidTechnicalAnswers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android_technical_answers, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.androidViewPager);
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
        String[] answersArray = getResources().getStringArray(R.array.androidTechnicalAnswers);
        String[] questionsArray = getResources().getStringArray(R.array.androidTechnicalQuestions);
        //retrieve the answers and add to slide
        addAnswers.add(getActivity(), answers, questions, answersArrayList, questionsArrayList, answersArray, questionsArray, sliderAdapter);
        //load the corresponding slide to the question
        addAnswers.loadSlide(getActivity(), sliderAdapter, viewPager);

        //initialise buttons
        androidLeftButton = (Button) view.findViewById(R.id.androidLeftButton);
        androidRightButton = (Button) view.findViewById(R.id.androidRightButton);
        androidCenterButton = (Button) view.findViewById(R.id.androidCenterButton);
        //set click listener on buttons
        androidLeftButton.setOnClickListener(this);
        androidRightButton.setOnClickListener(this);
        androidCenterButton.setOnClickListener(this);

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
            case R.id.androidRightButton:
                addAnswers.loadNextSlide(viewPager, sliderAdapter);
                break;
            case R.id.androidLeftButton:
                addAnswers.loadPreviousSlide(viewPager, sliderAdapter);
                break;
            case R.id.androidCenterButton:
                AndroidTechnicalQuestionsFragment androidTechnicalQuestionsFragment = new AndroidTechnicalQuestionsFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, androidTechnicalQuestionsFragment).addToBackStack(null).commit();
                break;
        }

    }
}
