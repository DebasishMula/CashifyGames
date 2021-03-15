package Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cashifygames.R;

import java.util.List;


import Custom.MultiSwipeRefreshLayout;
import Fragements.Home;
import PojoClasses.CricketHomeAllCategory;
import PojoClasses.CricketHomeMatchCategory;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class CircketHomeMainRecyclerAdapter extends RecyclerView.Adapter<CircketHomeMainRecyclerAdapter.CustomViewRecyclerHolder> {
    private Context context;
    private List<CricketHomeAllCategory> allCategoryList;
    private MultiSwipeRefreshLayout swipeRefreshLayout;

    private static  final int myMatches=1;
    private static final int upComingMatches=2;

    public CircketHomeMainRecyclerAdapter(Context context, List<CricketHomeAllCategory> allCategoryList, MultiSwipeRefreshLayout swipeRefreshLayout) {
        this.context = context;
        this.allCategoryList = allCategoryList;
        this.swipeRefreshLayout=swipeRefreshLayout;

    }

    @NonNull
    @Override
    public CustomViewRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

       if(viewType==upComingMatches)
      {
          view=LayoutInflater.from(context).inflate(R.layout.cricket_home_upcoming_matchs,parent,false);
          return  new UpcomingMatchViewHolder(view);
        }

       else
        {
            view=LayoutInflater.from(context).inflate(R.layout.cricket_home_mymatches,parent,false);
            return new MyMatchViewHolder(view);





         }

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewRecyclerHolder holder, int position) {


        try
        {
            if (holder instanceof MyMatchViewHolder)
            {
              MyMatchViewHolder vh=(MyMatchViewHolder) holder;
              vh.bindViewMyMatches(position);
            }
            else if(holder instanceof UpcomingMatchViewHolder)
            {
                UpcomingMatchViewHolder vh=(UpcomingMatchViewHolder) holder;
                vh.bindViewUpcomingMatches(position);
            }
        }
     catch(Exception e) {
         e.printStackTrace();
     }

    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public  class CustomViewRecyclerHolder extends RecyclerView.ViewHolder {
        TextView catTitle1,catTitle2;
        RecyclerView itemRecycler;
         LinearLayout dotsLayout;
        private ImageView[] dots;

        ViewPager viewPager;

        public CustomViewRecyclerHolder(@NonNull View itemView) {
            super(itemView);

                catTitle1=itemView.findViewById(R.id.crickeHomeMyMatchesCategoryTitle);
                viewPager=itemView.findViewById(R.id.CricketHomeMatchItemViewPager);
                dotsLayout=itemView.findViewById(R.id.cricketHomeMyMatchSliderDots);

              catTitle2=itemView.findViewById(R.id.crickeHomeMatchCategoryTitle);
                itemRecycler=itemView.findViewById(R.id.CricketHomeMatchItemRecycler);


        }

     //binding MyMatches values to MyMatches view


        @SuppressLint("ClickableViewAccessibility")
        public void bindViewMyMatches(int pos) {
            final int Pos = pos;

            catTitle1.setText(allCategoryList.get(pos).getCategoryTitle());
            setCatItemViewPager(viewPager, allCategoryList.get(pos).getCategoryItem());
            viewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_MOVE:
                            swipeRefreshLayout.setEnabled(false);
                            break;
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:
                            swipeRefreshLayout.setEnabled(true);
                            break;
                    }

                    return false;
                }
            });

            //implementing dots slider
            dots = new ImageView[allCategoryList.get(pos).getCategoryItem().size()];
            //making every image inactive and giving margins right and left
            for (int i = 0; i < allCategoryList.get(pos).getCategoryItem().size(); i++) {

                dots[i] = new ImageView(itemView.getContext());
                dots[i].setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.inactive_dot));

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                params.setMargins(8, 0, 8, 0);

                dotsLayout.addView(dots[i], params);

            }
            //making 1st image by default active
            dots[0].setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.active_dot));

            //making position image active
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                     if(position!=0)
                     {
                         swipeRefreshLayout.setEnabled(false);
                     }
                }

                @Override
                public void onPageSelected(int position) {
                    for (int i = 0; i < allCategoryList.get(Pos).getCategoryItem().size(); i++) {
                        dots[i].setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.inactive_dot));
                    }

                    dots[position].setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.active_dot));



                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    //viewPager.getParent().getParent().requestDisallowInterceptTouchEvent(false);
                  swipeRefreshLayout.setEnabled(true);

                }

            });






        }


        //binding UpComingMatches values to MyMatches view
        @SuppressLint("ClickableViewAccessibility")
        public void bindViewUpcomingMatches(int pos) {

            catTitle2.setText(allCategoryList.get(pos).getCategoryTitle());
            setCatItemRecycler(itemRecycler,allCategoryList.get(pos).getCategoryItem());


        }


    }


    //method to know type of view
    @Override
    public int getItemViewType(int position) {
       if(allCategoryList.get(position).getCategoryTitle().equals("My Matches"))
       {
           return myMatches;
       }
       else
           return upComingMatches;
    }
   //method to bind category Item to Recycler Adapter
    private void setCatItemRecycler(RecyclerView recyclerView, List<CricketHomeMatchCategory> matchCategoryItemList){

        CricketHomeUpComingMatchesAdapter matchItemRecyclerAdapter = new CricketHomeUpComingMatchesAdapter(context, matchCategoryItemList);

            recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            recyclerView.setAdapter(matchItemRecyclerAdapter);


    }
    //method to bind category Item to Pager Adapter
    private void setCatItemViewPager(ViewPager viewPager, List<CricketHomeMatchCategory> matchCategoryItemList) {
        CricketHomeMyMatchesAdapter matchItemRecyclerAdapter = new CricketHomeMyMatchesAdapter(context, matchCategoryItemList);

        viewPager.setAdapter(matchItemRecyclerAdapter);

    }
    //classes to determine type of CustomRecycler
    //
    public class UpcomingMatchViewHolder extends CustomViewRecyclerHolder {
        public UpcomingMatchViewHolder(View itemView) {
            super(itemView);
        }
    }
    public class MyMatchViewHolder extends CustomViewRecyclerHolder {
        public MyMatchViewHolder(View itemView) {
            super(itemView);
        }
    }


 }
