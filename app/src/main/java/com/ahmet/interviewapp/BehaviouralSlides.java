package com.ahmet.interviewapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;


public class BehaviouralSlides extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    int screen = 0;
    Button rightButton, leftButton, centerButton;

    public BehaviouralSlides() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_behavioural_slides, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        sliderAdapter = new SliderAdapter(getActivity());
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
        loadSlide();
        leftButton = (Button) view.findViewById(R.id.leftButton);
        rightButton = (Button) view.findViewById(R.id.rightButton);
        centerButton = (Button) view.findViewById(R.id.centerButton);

        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        centerButton.setOnClickListener(this);
        //hide the title bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rightButton:
                loadNextSlide();

                break;
            case R.id.leftButton:
                loadPreviousSlide();
                break;
            case R.id.centerButton:
                BehaviouralQuestionsFragment behaviouralQuestionsFragment = new BehaviouralQuestionsFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //replacing the fragment with the layout
                manager.beginTransaction().replace(R.id.content_layout, behaviouralQuestionsFragment).addToBackStack(null).commit();
                break;
        }

    }

    //go to next slide
    private void loadNextSlide() {

        int nextSlide = viewPager.getCurrentItem() + 1;

        if (nextSlide < sliderAdapter.getCount()) {

            viewPager.setCurrentItem(nextSlide);
        }
    }

    //go to previous slide
    private void loadPreviousSlide() {
        int previousSlide = viewPager.getCurrentItem() - 1;

        if (previousSlide < sliderAdapter.getCount()) {

            viewPager.setCurrentItem(previousSlide);
        }
    }

    //load the initial slide from the clicked list item
    private void loadSlide() {
        //get the position
        Bundle bundle = getActivity().getIntent().getExtras();
        int pos = bundle.getInt("Position");
        //set the current position
        if (pos < sliderAdapter.getCount()) {
            viewPager.setCurrentItem(pos);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

    }
}
