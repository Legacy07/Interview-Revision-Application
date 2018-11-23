package com.ahmet.interviewapp.Nav_Bar_Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.ahmet.interviewapp.R;
import com.xeoh.android.texthighlighter.TextHighlighter;

public class References extends Fragment {

    TextView referenceTextView;
    EditText searchText;

    TextHighlighter textHighlighter;

    boolean isHighlighted = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_references, container, false);

        StringBuilder sReferences = new StringBuilder();

        referenceTextView = (TextView) view.findViewById(R.id.referenceTextView);
//        searchText = (EditText) view.findViewById(R.id.searchEditText);

        referenceTextView.setText(Html.fromHtml(getString(R.string.referencesText)));
        //links are clickable
        referenceTextView.setMovementMethod(LinkMovementMethod.getInstance());

//        searchText.setImeActionLabel("Search", KeyEvent.KEYCODE_ENTER);
        //search text after clicked on done on keypad
//        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int action, KeyEvent keyEvent) {
//
//                if (action == EditorInfo.IME_ACTION_SEARCH) {
//                    if (!isHighlighted) {
//                        search();
//                    }
////                    else{
////                            textHighlighter.setForegroundColor(referenceTextView.getCurrentTextColor())
////                                    .setBackgroundColor(Color.TRANSPARENT)
////                                    .invalidate(TextHighlighter.BASE_MATCHER);
//
////                    }
//                    isHighlighted = !isHighlighted;
//                    return true;
//                }
//
//                return false;
//            }
//        });
//
//        searchText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (isHighlighted) {
//                    textHighlighter.setForegroundColor(referenceTextView.getCurrentTextColor())
//                            .setBackgroundColor(Color.TRANSPARENT)
//                            .invalidate(TextHighlighter.BASE_MATCHER);
//                    isHighlighted = !isHighlighted;
//
//                }
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });


//        BufferedReader reader = null;
//
//        try {
//            //read the text file
//            reader = new BufferedReader(
//                    new InputStreamReader(getActivity().getAssets().open("References.txt")));
//
//            // loop until end of file reading
//            String sLine;
//            while ((sLine = reader.readLine()) != null) {
//                sReferences.append(sLine);
//                sReferences.append('\n');
//            }
//        } catch (IOException e) {
//            Toast.makeText(getActivity(), "Error reading file!", Toast.LENGTH_LONG).show();
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                }
//            }
//
//            referenceTextView.setText((CharSequence) sReferences);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("References");
        setHasOptionsMenu(true);
        return view;
//    }
    }

    //using text highlighter library
    public void search() {

        textHighlighter = new TextHighlighter();

        textHighlighter.setBackgroundColor(Color.CYAN)
                .addTarget(referenceTextView)
                .highlight(searchText.getText().toString(), TextHighlighter.CASE_INSENSITIVE_MATCHER);

    }

//    //inflating the menu on action bar within fragment
//    @Override
//    public void onCreateOptionsMenu(
//            Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.references_menu, menu);
//    }

    //action bar button options
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        String fileName = String.valueOf(getActivity().getApplicationInfo().loadLabel(getActivity().getPackageManager())) + "_References.txt";
//        FileOutputStream outputStream;
//
//        switch (item.getItemId()) {
//            //save file internally
//            case R.id.saveFileBarButton:
////                https://developer.android.com/training/data-storage/files#java
////                File file = new File(getActivity().getFilesDir(), fileName);
//
//                try {
////                    https://stackoverflow.com/questions/35481924/write-a-string-to-a-file/35481977
//                    outputStream = getActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
//                    outputStream.write(referenceTextView.toString().getBytes());
//                    outputStream.close();
//                } catch (Exception e) {
//                    Toast.makeText(getActivity(), "Error saving file!", Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//                }
//
//                return true;
//
//            default:
//                // If we got here, the user's action was not recognized.
//                // Invoke the superclass to handle it.
//                return super.onOptionsItemSelected(item);
//
//        }
//    }

}
