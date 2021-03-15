package Adapter;

import Fragements.Leagues;
import Fragements.MyLeagues;
import Fragements.MyTeams;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class UpComingMatchTabsAdapter extends FragmentStatePagerAdapter {
    //integer to count number of tabs
    private int tabCount;

    //Constructor to the class
    public UpComingMatchTabsAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount=tabCount;
    }
    //Overriding method getItem
    @NonNull
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Leagues leagues=new Leagues();
                return leagues;
            case 1:
                MyLeagues myLeagues= new MyLeagues();
                return myLeagues;
            case 2:
                MyTeams myTeams=new MyTeams();
                return myTeams;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
