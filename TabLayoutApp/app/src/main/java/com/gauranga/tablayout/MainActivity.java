package com.gauranga.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

// YOUTUBE VIDEO TUTORIAL LINK - https://www.youtube.com/watch?v=528-udFokS4
public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tab1,tab2,tab3;
    ViewPager viewPager;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a 'TabLayout' in the layout resource file
        // Add tab items to the tab layout
        // Create a 'ViewPager' in the layout resource file
        // Go to the folder where 'MainActivity.java' file is stored
        // Right-click and go to New->Java Class and create a new java class 'PageAdapter.java'
        // Setup the tab layout in the 'PageAdapter.java' file
        // Create fragments for each tab

        tabLayout = findViewById(R.id.tabLayout);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        viewPager = findViewById(R.id.viewPager);

        // setup the page adapter and  view pager
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        // detect when a tab is selected
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                // set the view pager to the current tab selected
                viewPager.setCurrentItem(tab.getPosition());

//                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2) {
//                    pageAdapter.notifyDataSetChanged();
//                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // detect when page is changed
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}