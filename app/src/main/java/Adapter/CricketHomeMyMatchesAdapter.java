package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cashifygames.R;

import java.util.List;

import PojoClasses.CricketHomeMatchCategory;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class CricketHomeMyMatchesAdapter extends PagerAdapter {
    private Context context;
    private List<CricketHomeMatchCategory> cricketHomeMatchList;
    LayoutInflater layoutInflater;


    public CricketHomeMyMatchesAdapter(Context context, List<CricketHomeMatchCategory> cricketHomeMatchList) {
        this.context = context;
        this.cricketHomeMatchList = cricketHomeMatchList;

    }

    @Override
    public int getCount() {
        return cricketHomeMatchList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view=LayoutInflater.from(context).inflate(R.layout.match_card,container,false);
         TextView seriesName,team1Title,team2Title,gameFormat,timeLeft;
         ImageView team1Image,team2Image;
         //
        seriesName=view.findViewById(R.id.cricket_matchcard_series_title);
        team1Image=view.findViewById(R.id.cricket_matchcard_team1_image);
        team2Image=view.findViewById(R.id.cricket_matchcard_team2_image);
        team1Title=view.findViewById(R.id.cricket_matchcard_team1_title);
        team2Title=view.findViewById(R.id.cricket_matchcard_team2_title);
        gameFormat=view.findViewById(R.id.cricket_matchcard_gamefomat);
        timeLeft=view.findViewById(R.id.cricket_matchcard_timeleft);

        seriesName.setText(cricketHomeMatchList.get(position).getSeriesName());
        team1Title.setText(cricketHomeMatchList.get(position).getTeam1Title());
        team2Title.setText(cricketHomeMatchList.get(position).getTeam2Title());
        team1Image.setImageResource(cricketHomeMatchList.get(position).getTeam1ImageUrl());
        team2Image.setImageResource(cricketHomeMatchList.get(position).getTeam2ImageUrl());
        gameFormat.setText(cricketHomeMatchList.get(position).getGameFormat());
        timeLeft.setText(cricketHomeMatchList.get(position).getTimeLeft());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,cricketHomeMatchList.get(position).getMatchId(),Toast.LENGTH_SHORT).show();
            }
        });

        ((ViewPager)container).addView(view);
     return  view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View)object);
    }

}
