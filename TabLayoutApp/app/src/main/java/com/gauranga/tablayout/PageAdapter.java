package com.gauranga.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    int tab_count;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        // number of tabs in the tab layout
        tab_count = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // position refers to position of the tab currently selected
        // for each case return the class of the corresponding fragment
        switch (position) {
            case 0:
                return new TabFragment1();
            case 1:
                return new TabFragment2();
            case 2:
                return new TabFragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // count the number of tabs in the tab layout
        return tab_count;
    }
}
