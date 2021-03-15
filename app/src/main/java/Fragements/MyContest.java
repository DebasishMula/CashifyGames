package Fragements;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cashifygames.R;

import Adapter.CricketHomeBannerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

public class MyContest extends Fragment
{
    private ViewPager viewPager;
    private CricketHomeBannerAdapter bannerAdapter;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.fragement_my_contest, null);

        return view;
    }
    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }


}
