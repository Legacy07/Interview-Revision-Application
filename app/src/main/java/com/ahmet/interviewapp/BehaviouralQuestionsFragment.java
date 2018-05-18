package com.ahmet.interviewapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BehaviouralQuestionsFragment extends Fragment {


    ListView behaviouraListview;

    ArrayList<BehaviouralQuestions> questionsArrayList = new ArrayList<>();
    BehaviouralQuestions behaviouralQuestions;
    BehaviouralQuestionsListViewAdaptor listViewAdaptor;

    AlertDialog alert;

    public BehaviouralQuestionsFragment() {
    }

    //    https://stackoverflow.com/questions/39019824/populate-listview-with-text-and-value-from-strings-xml

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_behavioural_questions, container, false);

        behaviouraListview = (ListView) view.findViewById(R.id.behaviouralListView);
        //initialise Adaptor
        listViewAdaptor = new BehaviouralQuestionsListViewAdaptor(getActivity(), questionsArrayList);

        addQuestions();
        behaviouraListview.setAdapter(listViewAdaptor);

        behaviouraListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //open slides when clicked on a list item
                BehaviouralSlides behaviouralSlides = new BehaviouralSlides();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_layout, behaviouralSlides).addToBackStack(null).commit();
                //send the position of the item so it opens the corresponding slide to the question
                Bundle bundle = new Bundle();
                bundle.putInt("Position", position);
                Intent intent = getActivity().getIntent();
                intent.putExtras(bundle);
            }
        });

        // slider https://www.youtube.com/watch?v=byLKoPgB7yA
        //actionbar title change
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Behavioural Questions");

        //showing the button in action bar
        setHasOptionsMenu(true);
        return view;
    }

    //inflating the menu on action bar within fragment
    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.behavioural_questions_menu, menu);
    }

    //action bar button options
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //open a diaog containing some info
            case R.id.informationBarButton:
                final AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                //inflate the dialog layout to import it into alert dialog in order to view
                LayoutInflater inflater = getActivity().getLayoutInflater();
                //when inflated, then able to get or set value in text view
                View vi = inflater.inflate(R.layout.behavioural_questions_alert_dialog_menu, null);
                TextView textView = (TextView) vi.findViewById(R.id.informationTextView);
                Button interviewButton = (Button) vi.findViewById((R.id.interviewPrepButton));

                try {
                    //set the text to explain in brief what the behavioural questions are
                    textView.setText(R.string.what_is_behavioural_questions);
                    //open interview grid fragment when clicked on the button within the dialog
                    interviewButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            InterviewPrepGridFragment interviewPrepGridFragment = new InterviewPrepGridFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.content_layout, interviewPrepGridFragment).addToBackStack(null).commit();
                        alert.dismiss();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                    showMessage("Error", e.getMessage());
                }
                //set custom layout in dialog
                dialog.setView(vi);

                dialog.setCancelable(false);
                dialog.setPositiveButton("Okay", null);

                alert = dialog.create();
                alert.show();

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    //add questions in listview
    public void addQuestions() {
        behaviouralQuestions = new BehaviouralQuestions();
        //without this, it will duplicate itself everytime the user goes back from another fragment
        questionsArrayList.clear();
        try {
            //get the questions from resources
            String[] array = getResources().getStringArray(R.array.behaviouralQuestions);

            //output the questions in a listview
            for (int i = 0; i < array.length; i++) {
                behaviouralQuestions = new BehaviouralQuestions();

                String questions = array[i];
                //add the questions from array
                behaviouralQuestions.setQuestions(i + 1 + "- " + questions);
                questionsArrayList.add(behaviouralQuestions);

            }
            listViewAdaptor.notifyDataSetChanged();
        } catch (Exception e) {
            showMessage("Error", e.getMessage());
        }

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        //show the title bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

    }
}
