package com.ahmet.interviewapp.Adaptors;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmet.interviewapp.Models.Questions;
import com.ahmet.interviewapp.Models.Answers;
import com.ahmet.interviewapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    ArrayList<Answers> answersList;
    ArrayList<Questions> questionsList;


    public SliderAdapter(Context context, ArrayList<Questions> questions, ArrayList<Answers> answers) {
        this.context = context;
        this.questionsList = questions;
        this.answersList = answers;

    }

    @Override
    public int getCount() {
        return answersList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_adaptor_layout, container, false);

        TextView answersTextView = (TextView) view.findViewById(R.id.behaviouralslideTextview);
        TextView questionsTextView = (TextView) view.findViewById(R.id.behaviouralslideQuestionsTextview);

        answersTextView.setText(Html.fromHtml(String.valueOf((CharSequence) answersList.get(position).getAnswers())));
        answersTextView.setMovementMethod(LinkMovementMethod.getInstance());
        questionsTextView.setText(position + 1 + "- " + questionsList.get(position).getQuestions());

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
