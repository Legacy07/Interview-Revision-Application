package com.ahmet.interviewapp.Nav_Bar_Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ahmet.interviewapp.Algorithms.Advanced;
import com.ahmet.interviewapp.Algorithms.DataStructures;
import com.ahmet.interviewapp.Algorithms.Graph;
import com.ahmet.interviewapp.Algorithms.Searching;
import com.ahmet.interviewapp.Algorithms.Sorting;
import com.ahmet.interviewapp.R;


public class AlgorithmsFragment extends Fragment implements View.OnClickListener {


    FragmentManager fragmentManager;
    Button dataStructuresButton, sortingButton, searchingButton, graphButton;

    public AlgorithmsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_algorithms, container, false);

        fragmentManager = getFragmentManager();

        dataStructuresButton = (Button) view.findViewById(R.id.dataStructuresButton);
        sortingButton = (Button) view.findViewById(R.id.sortingButton);
        searchingButton = (Button) view.findViewById(R.id.searchingButton);
        graphButton = (Button) view.findViewById(R.id.graphAlgorithmsButton);

        dataStructuresButton.setOnClickListener(this);
        sortingButton.setOnClickListener(this);
        searchingButton.setOnClickListener(this);
        graphButton.setOnClickListener(this);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Algorithms");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onClick(View view) {
        final DataStructures dataStructures = new DataStructures();
        final Searching searching = new Searching();
        final Sorting sorting = new Sorting();
        final Graph graph = new Graph();
//        final Advanced advanced = new Advanced();

        switch (view.getId()) {
            case R.id.dataStructuresButton:
                fragmentManager.beginTransaction().replace(R.id.content_layout, dataStructures).addToBackStack(null).commit();
                break;

            case R.id.sortingButton:
                fragmentManager.beginTransaction().replace(R.id.content_layout, sorting).addToBackStack(null).commit();
                break;

            case R.id.searchingButton:
                fragmentManager.beginTransaction().replace(R.id.content_layout, searching).addToBackStack(null).commit();
                break;

            case R.id.graphAlgorithmsButton:
                fragmentManager.beginTransaction().replace(R.id.content_layout, graph).addToBackStack(null).commit();
                break;
        }
    }
}
