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
import androidx.recyclerview.widget.RecyclerView;

public class CricketHomeUpComingMatchesAdapter extends RecyclerView.Adapter<CricketHomeUpComingMatchesAdapter.CustomHolder> {

    private Context context;
    private List<CricketHomeMatchCategory> cricketHomeMatchList;

    public CricketHomeUpComingMatchesAdapter(Context context, List<CricketHomeMatchCategory> cricketHomeMatchList) {
        this.context = context;
        this.cricketHomeMatchList = cricketHomeMatchList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomHolder(LayoutInflater.from(context).inflate(R.layout.match_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        holder.matchId=cricketHomeMatchList.get(position).getMatchId();
        holder.seriesName.setText(cricketHomeMatchList.get(position).getSeriesName());
        holder.team1Title.setText(cricketHomeMatchList.get(position).getTeam1Title());
        holder.team2Title.setText(cricketHomeMatchList.get(position).getTeam2Title());
        holder.team1Image.setImageResource(cricketHomeMatchList.get(position).getTeam1ImageUrl());
        holder.team2Image.setImageResource(cricketHomeMatchList.get(position).getTeam2ImageUrl());
        holder.gameFormat.setText(cricketHomeMatchList.get(position).getGameFormat());
        holder.timeLeft.setText(cricketHomeMatchList.get(position).getTimeLeft());
    }

    @Override
    public int getItemCount() {
        return cricketHomeMatchList.size();
    }

    public static class CustomHolder extends RecyclerView.ViewHolder {
        private TextView seriesName,team1Title,team2Title,gameFormat,timeLeft;
        private ImageView team1Image,team2Image;
        private String matchId;

        public CustomHolder(@NonNull final View itemView) {
            super(itemView);
            seriesName=itemView.findViewById(R.id.cricket_matchcard_series_title);
            team1Image=itemView.findViewById(R.id.cricket_matchcard_team1_image);
            team2Image=itemView.findViewById(R.id.cricket_matchcard_team2_image);
            team1Title=itemView.findViewById(R.id.cricket_matchcard_team1_title);
            team2Title=itemView.findViewById(R.id.cricket_matchcard_team2_title);
            gameFormat=itemView.findViewById(R.id.cricket_matchcard_gamefomat);
            timeLeft=itemView.findViewById(R.id.cricket_matchcard_timeleft);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(),matchId,Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
