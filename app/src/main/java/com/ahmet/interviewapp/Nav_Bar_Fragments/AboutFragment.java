package com.ahmet.interviewapp.Nav_Bar_Fragments;


import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ahmet.interviewapp.R;

public class AboutFragment extends Fragment {


    TextView aboutTextView;
    Button rateButton, contactButton, shareButton;

    public AboutFragment() {

    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        aboutTextView = (TextView) view.findViewById(R.id.aboutText);
        rateButton = (Button) view.findViewById(R.id.rateStarButton);
        contactButton = (Button) view.findViewById(R.id.contactMailButton);
        shareButton = (Button) view.findViewById(R.id.shareButton);

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "ahmetince771@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Interview Revision Application");
                    //intent.putExtra(Intent.EXTRA_TEXT, "");
                    startActivity(intent);
                } catch (ActivityNotFoundException e)
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                    dialog.setMessage("An Error Occurred:" + e);
                    dialog.setCancelable(true);

                    dialog.setNeutralButton(
                            "Okay",
                            new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = dialog.create();
                    alert11.show();
                }
            }
        });

        rateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri uri = Uri.parse("market://details?id=" + getContext().getPackageName());
                Intent playStore = new Intent(Intent.ACTION_VIEW, uri);
                //flags to go back to the application
                playStore.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try
                {
                    startActivity(playStore);
                }
                catch (ActivityNotFoundException e)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getContext().getPackageName())));
                }
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareText = "Check out the Interview Revision app - " + "https://play.google.com/store/apps/details?id=" + getContext().getPackageName();
                share.putExtra(android.content.Intent.EXTRA_TEXT, shareText);
                startActivity(Intent.createChooser(share, "Share via"));
            }
        });
        aboutTextView.setText(Html.fromHtml(getString(R.string.aboutText)));


        //actionbar title change
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("About");

        return view;
    }

}
