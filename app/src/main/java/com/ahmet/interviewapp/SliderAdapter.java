package com.ahmet.interviewapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    String[] behaviouralAnswersArray;
    public SliderAdapter(Context context) {
        this.context = context;
        behaviouralAnswersArray = context.getResources().getStringArray(R.array.behaviouralAnswers);

    }

    @Override
    public int getCount() {
        return behaviouralAnswersArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.behavioural_slide_layout, container, false);

        TextView textView = (TextView) view.findViewById(R.id.behaviouralslideTextview);

        textView.setText(behaviouralAnswersArray[position]);
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
