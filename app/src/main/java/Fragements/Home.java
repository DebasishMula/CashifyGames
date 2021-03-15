package Fragements;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cashifygames.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.CircketHomeMainRecyclerAdapter;
import Adapter.CricketHomeBannerAdapter;
import Adapter.CricketHomeMyMatchesAdapter;

import Custom.MultiSwipeRefreshLayout;
import PojoClasses.CricketHomeAllCategory;
import PojoClasses.CricketHomeMatchCategory;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

public class Home extends Fragment
{
    private TextView myMatchTitle;
    private ViewPager viewPager;
    private int[] imageResource;
    private CricketHomeBannerAdapter bannerAdapter;
    private RecyclerView mainCategoryRecycler,parentRecycler;
    private CircketHomeMainRecyclerAdapter circketHomeMainRecyclerAdapter;
   MultiSwipeRefreshLayout pullToRefresh;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragement_home, container,false);
        mainCategoryRecycler=view.findViewById(R.id.cricketHomeRecyclerView);
        pullToRefresh = view.findViewById(R.id.CricketHomeswiperefresh);

        return view;
    }



    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // added in first category
        final List<CricketHomeMatchCategory> cricketHomeMatchCategoryList1 = new ArrayList<>();
        cricketHomeMatchCategoryList1.add(new CricketHomeMatchCategory("1", "IPL 2020", "DC", "KKR", "ODI", "00h 00m", R.drawable.dc, R.drawable.kkr));
        cricketHomeMatchCategoryList1.add(new CricketHomeMatchCategory("2", "IPL 2020", "DC", "KKR", "ODI", "00h 00m", R.drawable.dc, R.drawable.kkr));
        cricketHomeMatchCategoryList1.add(new CricketHomeMatchCategory("3", "IPL 2020", "DC", "KKR", "ODI", "00h 00m", R.drawable.dc, R.drawable.kkr));
        cricketHomeMatchCategoryList1.add(new CricketHomeMatchCategory("4", "IPL 2020", "DC", "KKR", "ODI", "00h 00m", R.drawable.dc, R.drawable.kkr));


        //added in second category
        List<CricketHomeMatchCategory> cricketHomeMatchCategoryList2 = new ArrayList<>();
        cricketHomeMatchCategoryList2.add(new CricketHomeMatchCategory("1", "IPL 2020", "DC", "KKR", "ODI", "00h 00m", R.drawable.dc, R.drawable.kkr));
        cricketHomeMatchCategoryList2.add(new CricketHomeMatchCategory("2", "IPL 2020", "DC", "KKR", "ODI", "00h 00m", R.drawable.dc, R.drawable.kkr));
        cricketHomeMatchCategoryList2.add(new CricketHomeMatchCategory("3", "IPL 2020", "DC", "KKR", "ODI", "00h 00m", R.drawable.dc, R.drawable.kkr));
        cricketHomeMatchCategoryList2.add(new CricketHomeMatchCategory("4", "IPL 2020", "DC", "KKR", "ODI", "00h 00m", R.drawable.dc, R.drawable.kkr));

        //add all category item List to All Category
        List<CricketHomeAllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new CricketHomeAllCategory("My Matches", cricketHomeMatchCategoryList1));

        allCategoryList.add(new CricketHomeAllCategory("Upcoming Matches", cricketHomeMatchCategoryList2));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mainCategoryRecycler.setLayoutManager(layoutManager);
        circketHomeMainRecyclerAdapter = new CircketHomeMainRecyclerAdapter(view.getContext(), allCategoryList,pullToRefresh);
        mainCategoryRecycler.setAdapter(circketHomeMainRecyclerAdapter);

        pullToRefresh.setSwipeableChildren(R.id.cricketHomeRecyclerView);

        //binding View Widget to Object

        //dotsLayout=view.findViewById(R.id.cricketHomeBannerlayoutDots);

        // bannerAdapter=new CricketHomeBannerAdapter(this.getActivity());
        //  viewPager.setAdapter(bannerAdapter);
        //making page Refreshable


        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Toast.makeText(getContext(), "Refreshed", Toast.LENGTH_SHORT).show();
                pullToRefresh.setRefreshing(false);

            }
        });



    }

    @Override
    public  void onResume() {
        super.onResume();
    }
}






