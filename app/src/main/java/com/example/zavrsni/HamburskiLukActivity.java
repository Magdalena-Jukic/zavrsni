package com.example.zavrsni;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HamburskiLukActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ScreenSlidePagerAdapterHamburskiLuk pagerAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initViews();
        setUpPager();

    }


    private void initViews() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout=findViewById(R.id.tab);

    }

    private void setUpPager() {
        pagerAdapter=new ScreenSlidePagerAdapterHamburskiLuk(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }



}
