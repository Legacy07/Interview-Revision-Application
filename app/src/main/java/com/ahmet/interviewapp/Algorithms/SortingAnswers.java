package com.ahmet.interviewapp.Algorithms;


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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortingAnswers extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    ArrayList<Questions> questionsArrayList = new ArrayList<>();
    ArrayList<Answers> answersArrayList = new ArrayList<>();

    AddAnswers addAnswers;
    Answers answers;
    Questions questions;
    int screen = 0;
    FloatingActionButton rightButton, leftButton, centerButton;

    public SortingAnswers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

        addAnswers = new AddAnswers();
        //get the string arrays
        String[] answersArray = getResources().getStringArray(R.array.sorting_answers);
        String[] questionsArray = getResources().getStringArray(R.array.sorting);
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
                Sorting sorting = new Sorting();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, sorting).addToBackStack(null).commit();
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

    }


}
