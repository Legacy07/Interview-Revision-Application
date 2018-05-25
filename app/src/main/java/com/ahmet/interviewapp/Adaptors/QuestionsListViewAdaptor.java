package com.ahmet.interviewapp.Adaptors;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.R;

import java.util.ArrayList;

public class QuestionsListViewAdaptor extends BaseAdapter {

    Context context;
    //array list for foods class
    ArrayList<Questions> questionsArrayList;
    LayoutInflater inflater;

    public QuestionsListViewAdaptor(Context c, ArrayList<Questions> questions) {
        this.context = c;
        this.questionsArrayList = questions;
    }

    //get the size of the arraylist
    @Override
    public int getCount() {
        return questionsArrayList.size();
    }

    //get the items
    @Override
    public Object getItem(int position) {
        return questionsArrayList.get(position);
    }

    //get position of the item to get the item
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflate it to custom listview layout
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.questions_listview, parent, false);
        }
        //textviews initialised
        TextView text = (TextView) convertView.findViewById(R.id.behaviouralTextView);
        //place gathered item into text view to output
        text.setText(questionsArrayList.get(position).getQuestions());


        //event handler if clicked
      /*  final int pos = position;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        return convertView;
    }
}
