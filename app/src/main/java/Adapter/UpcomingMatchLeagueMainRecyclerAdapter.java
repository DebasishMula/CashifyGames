package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cashifygames.R;

import java.util.ArrayList;
import java.util.List;

import PojoClasses.UpcomingMatchesLeagueAllCategory;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingMatchLeagueMainRecyclerAdapter extends RecyclerView.Adapter<UpcomingMatchLeagueMainRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<UpcomingMatchesLeagueAllCategory> allCategoryList=new ArrayList<>();

    public UpcomingMatchLeagueMainRecyclerAdapter(Context context, List<UpcomingMatchesLeagueAllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cricket_upcoming_matches_leagues,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.leagueTitle.setText(allCategoryList.get(position).getLeagueTitle());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(new UpcomingMatchLeaguesAdapter(context,allCategoryList.get(position).getLeagueList()));
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView leagueTitle;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leagueTitle=itemView.findViewById(R.id.cricketUpcomingMatchLeagueTitle);
            recyclerView=itemView.findViewById(R.id.cricketUpcomingMatchLeagueRecycler);
        }
    }
}



