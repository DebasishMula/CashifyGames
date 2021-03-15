package Fragements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cashifygames.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Adapter.UpcomingMatchLeagueMainRecyclerAdapter;
import Custom.MultiSwipeRefreshLayout;
import PojoClasses.UpcomingMatchesLeagueAllCategory;
import PojoClasses.UpcomingMatchesLeagueCategory;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class Leagues extends Fragment  {
     SwipeRefreshLayout pullToRefresh;
    private RecyclerView mainRecycler;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_leagues, container,false);
        pullToRefresh=view.findViewById(R.id.cricketLeaguesSwiperefresh);
        mainRecycler=view.findViewById(R.id.cricketLeaguesRecyclerView);
        fab=view.findViewById(R.id.cricketLeaguesFAB);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        // added in first category
        final List<UpcomingMatchesLeagueCategory> leagueCategory1 = new ArrayList<>();
        leagueCategory1.add(new UpcomingMatchesLeagueCategory("1","10000","100","10000","100000","0","S","10000"));
        leagueCategory1.add(new UpcomingMatchesLeagueCategory("2","30000","250","10000","100000","0","M","10000"));
        final List<UpcomingMatchesLeagueCategory> leagueCategory2 = new ArrayList<>();
        leagueCategory2.add(new UpcomingMatchesLeagueCategory("3","3000000","49","1000000","100000000","1","M","10000"));
        leagueCategory2.add(new UpcomingMatchesLeagueCategory("4","2000000","35","10000","1000000","1","M","10000"));
        leagueCategory2.add(new UpcomingMatchesLeagueCategory("5","2000000","35","10000","1000000","1","M","10000"));
        final  List<UpcomingMatchesLeagueAllCategory> upcomingMatchesLeagueAllCategories=new ArrayList<>();
        upcomingMatchesLeagueAllCategories.add(new UpcomingMatchesLeagueAllCategory("Hot Leagues",leagueCategory1));
        upcomingMatchesLeagueAllCategories.add(new UpcomingMatchesLeagueAllCategory("Grand Leagues",leagueCategory2));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        mainRecycler.setLayoutManager(layoutManager);
        mainRecycler.setAdapter(new UpcomingMatchLeagueMainRecyclerAdapter(view.getContext(),upcomingMatchesLeagueAllCategories));

        //making page Refreshable
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Toast.makeText(getContext(), "Refreshed", Toast.LENGTH_SHORT).show();
                pullToRefresh.setRefreshing(false);
            }
        });

    }

}
