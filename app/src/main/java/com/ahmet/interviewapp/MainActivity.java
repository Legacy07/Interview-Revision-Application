package com.ahmet.interviewapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ahmet.interviewapp.Nav_Bar_Fragments.AboutFragment;
import com.ahmet.interviewapp.Nav_Bar_Fragments.AlgorithmsFragment;
import com.ahmet.interviewapp.Nav_Bar_Fragments.BlogFragment;
import com.ahmet.interviewapp.Nav_Bar_Fragments.CodingQuestionsFragment;
import com.ahmet.interviewapp.Nav_Bar_Fragments.InterviewFragment;
import com.ahmet.interviewapp.Nav_Bar_Fragments.References;
import com.ahmet.interviewapp.Nav_Bar_Fragments.TechnicalQuestionsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        manager = getSupportFragmentManager();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //open interview fragment on launch
        if (savedInstanceState == null) {
            //open interview fragment
            InterviewFragment interviewFragment = new InterviewFragment();
            //replacing the fragment with the layout
            manager.beginTransaction().replace(R.id.content_layout, interviewFragment).addToBackStack(null).commit();

        }
//        Interview fragment checked on nav
        navigationView.getMenu().getItem(0).setChecked(true);

        //to start nav bar from right
//        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //if it hits the activity stack then ask for exit
            int fragments = getSupportFragmentManager().getBackStackEntryCount();
            if (fragments == 1) {

                //exit application
                new AlertDialog.Builder(this).setIcon(R.drawable.ic_alert).setTitle("Exit")
                        .setMessage("Exit the application?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                System.gc();
                                System.exit(0);
                            }
                        }).setNegativeButton("Cancel", (null)).show();
            } else {
                if (getFragmentManager().getBackStackEntryCount() > 1) {
                    getFragmentManager().popBackStack();
                } else {
                    super.onBackPressed();
                }
            }

        }

//        //exit application
//        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
//                .setMessage("Are you sure?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
//                        System.gc();
//                        System.exit(0);
//                    }
//                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                //open interview fragment
//                InterviewFragment interviewFragment = new InterviewFragment();
//                //replacing the fragment with the layout
//                manager.beginTransaction().replace(R.id.content_layout, interviewFragment).addToBackStack(null).commit();
//            }
//        }).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.interview) {
            //open interview fragment
            InterviewFragment interviewFragment = new InterviewFragment();
            //replacing the fragment with the layout
            manager.beginTransaction().replace(R.id.content_layout, interviewFragment).addToBackStack(null).commit();

        } else if (id == R.id.technical) {
            //open technical questions fragment
            TechnicalQuestionsFragment technicalQuestionsFragment = new TechnicalQuestionsFragment();
            //replacing the fragment with the layout
            manager.beginTransaction().replace(R.id.content_layout, technicalQuestionsFragment).addToBackStack(null).commit();

        } else if (id == R.id.algorithm) {
            AlgorithmsFragment algorithmsFragment = new AlgorithmsFragment();
            manager.beginTransaction().replace(R.id.content_layout, algorithmsFragment).addToBackStack(null).commit();

        } else if (id == R.id.coding) {
            CodingQuestionsFragment codingQuestionsFragment = new CodingQuestionsFragment();
            manager.beginTransaction().replace(R.id.content_layout, codingQuestionsFragment).addToBackStack(null).commit();

        } else if (id == R.id.about) {
            AboutFragment aboutFragment = new AboutFragment();
            manager.beginTransaction().replace(R.id.content_layout, aboutFragment).addToBackStack(null).commit();

        } else if (id == R.id.references) {
            References references = new References();
            manager.beginTransaction().replace(R.id.content_layout, references).addToBackStack(null).commit();
        } else if (id == R.id.blog) {
            BlogFragment blog = new BlogFragment();
            manager.beginTransaction().replace(R.id.content_layout, blog).addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportActionBar().show();

    }
}
