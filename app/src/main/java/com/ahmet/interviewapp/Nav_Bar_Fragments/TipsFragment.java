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
import com.ahmet.interviewapp.Tips.CvTips;
import com.ahmet.interviewapp.Tips.GroupTips;
import com.ahmet.interviewapp.Tips.InterviewTips;
import com.ahmet.interviewapp.Tips.TelephoneInterviewTips;

public class TipsFragment extends Fragment implements View.OnClickListener {

    Button interviewButton, telephoneButton, cvtipsButton, groupButton;

    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        interviewButton = (Button) view.findViewById(R.id.interviewTipsButton);
        telephoneButton = (Button) view.findViewById(R.id.telephoneTipsButton);
        cvtipsButton = (Button) view.findViewById(R.id.cvTipsButton);
        groupButton = (Button) view.findViewById(R.id.groupTipsButton);

        interviewButton.setOnClickListener(this);
        telephoneButton.setOnClickListener(this);
        cvtipsButton.setOnClickListener(this);
        groupButton.setOnClickListener(this);

        fragmentManager = getActivity().getSupportFragmentManager();

        //actionbar title change
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Tips");
        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.interviewTipsButton:
                InterviewTips interviewTips = new InterviewTips();
                fragmentManager.beginTransaction().replace(R.id.content_layout, interviewTips).addToBackStack(null).commit();
                break;
            case R.id.telephoneTipsButton:
                TelephoneInterviewTips telephoneInterviewTips = new TelephoneInterviewTips();
                fragmentManager.beginTransaction().replace(R.id.content_layout, telephoneInterviewTips).addToBackStack(null).commit();

                break;

            case R.id.cvTipsButton:
                CvTips cvTips = new CvTips();
                fragmentManager.beginTransaction().replace(R.id.content_layout, cvTips).addToBackStack(null).commit();

                break;

            case R.id.groupTipsButton:
                GroupTips groupTips = new GroupTips();
                fragmentManager.beginTransaction().replace(R.id.content_layout, groupTips).addToBackStack(null).commit();

                break;


        }
    }
}
