package asd.com.myapplication;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import asd.com.fragment.DetailFragment;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("fuck you...");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("内容简介0"));
        tabLayout.addTab(tabLayout.newTab().setText("作者简介0"));
        tabLayout.addTab(tabLayout.newTab().setText("目录0"));
        tabLayout.addTab(tabLayout.newTab().setText("内容简介0"));
        tabLayout.addTab(tabLayout.newTab().setText("作者简介0"));
        tabLayout.addTab(tabLayout.newTab().setText("目录0"));
        tabLayout.addTab(tabLayout.newTab().setText("内容简介0"));
        tabLayout.addTab(tabLayout.newTab().setText("作者简介0"));
        tabLayout.addTab(tabLayout.newTab().setText("目录0"));
    }

}