package com.ahmet.interviewapp.Behavioural_Questions;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import com.ahmet.interviewapp.Models.AddAnswers;
import com.ahmet.interviewapp.Models.Answers;
import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.R;
import com.ahmet.interviewapp.Adaptors.SliderAdapter;

import java.util.ArrayList;


public class BehaviouralAnswers extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    ArrayList<Questions> questionsArrayList = new ArrayList<>();
    ArrayList<Answers> answersArrayList = new ArrayList<>();

    AddAnswers addAnswers;
    Answers answers;
    Questions questions;
    int screen = 0;
    FloatingActionButton rightButton, leftButton, centerButton;

    AlphaAnimation animation1, animation2;

    public BehaviouralAnswers() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.answer_slides, container, false);

        //initialise buttons
        leftButton = view.findViewById(R.id.leftButton);
        rightButton = view.findViewById(R.id.rightButton);
        centerButton = view.findViewById(R.id.centerButton);
        //set click listener on buttons
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        centerButton.setOnClickListener(this);

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
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_UP:
//                        animation1 = new AlphaAnimation(1, 0);
//                        animation1.setDuration(500);
//                        animation1.setStartOffset(500);
//                        animation1.setFillAfter(true);
//                        rightButton.startAnimation(animation1);
//                        break;
//                    case MotionEvent.ACTION_DOWN:
//                        animation2 = new AlphaAnimation(0,1);
//                        animation2.setDuration(500);
//                        animation2.setStartOffset(500);
//                        animation2.setFillAfter(true);
//                        rightButton.startAnimation(animation2);
//
//                        break;
//                }
//
//                return false;
//            }
//        });

        addAnswers = new AddAnswers();
        //get the string arrays
        String[] answersArray = getResources().getStringArray(R.array.behaviouralAnswers);
        String[] questionsArray = getResources().getStringArray(R.array.behaviouralQuestions);
        //retrieve the answers and add to slide
        addAnswers.add(getActivity(), answers, questions, answersArrayList, questionsArrayList, answersArray, questionsArray, sliderAdapter);
        //load the corresponding slide to the question
        addAnswers.loadSlide(getActivity(), sliderAdapter, viewPager);

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
                BehaviouralQuestionsFragment behaviouralQuestionsFragment = new BehaviouralQuestionsFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, behaviouralQuestionsFragment).addToBackStack(null).commit();
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

    }

    //    @Override
//    public boolean onTouch(View view, MotionEvent event) {
//
//        animation1 = new AlphaAnimation(1, 0);
//        animation1.setDuration(500);
//        animation1.setStartOffset(500);
//        animation1.setFillAfter(true);
//        rightButton.startAnimation(animation1);
//
//        return false;
//    }
}
