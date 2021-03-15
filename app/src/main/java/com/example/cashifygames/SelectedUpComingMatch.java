package com.example.cashifygames;

import Adapter.UpComingMatchTabsAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class SelectedUpComingMatch extends AppCompatActivity implements  TabLayout.OnTabSelectedListener{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_up_coming_match);
        //binding View Widget to Object
        toolbar=findViewById(R.id.globalToolbar);
        tabLayout=findViewById(R.id.upComingMatchTabLayout);
        viewPager=findViewById(R.id.upComingMatchViewPager);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Leagues"));
        tabLayout.addTab(tabLayout.newTab().setText("My Leagues"));
        tabLayout.addTab(tabLayout.newTab().setText("My Teams"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        UpComingMatchTabsAdapter selectedUpComingMatchTabsAdapter=new UpComingMatchTabsAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        //Adding adapter to pager
        viewPager.setAdapter(selectedUpComingMatchTabsAdapter);
        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}