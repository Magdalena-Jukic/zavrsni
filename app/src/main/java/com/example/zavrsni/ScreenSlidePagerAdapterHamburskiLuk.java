package com.example.zavrsni;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Locale;

public class ScreenSlidePagerAdapterHamburskiLuk extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 2;

    public ScreenSlidePagerAdapterHamburskiLuk(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentHamburskiLukNorma();
            default:
                return new FragmentHamburskiLukUnos();


        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return String.format(Locale.getDefault(), "Norma",position+1);
            default:
                return String.format(Locale.getDefault(), "Unos",position+1);

        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}
