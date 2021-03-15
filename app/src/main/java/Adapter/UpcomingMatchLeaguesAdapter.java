package Adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cashifygames.R;

import java.util.List;

import PojoClasses.UpcomingMatchesLeagueCategory;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingMatchLeaguesAdapter extends RecyclerView.Adapter<UpcomingMatchLeaguesAdapter.ViewHolder> {
     private Context context;
     private List<UpcomingMatchesLeagueCategory> leaguesList;

    public UpcomingMatchLeaguesAdapter(Context context, List<UpcomingMatchesLeagueCategory> leaguesList) {
        this.context = context;
        this.leaguesList = leaguesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.league_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, final int position) {
        final ViewHolder holder1;
        holder1=holder;
        holder.winningAmount.setText(leaguesList.get(position).getWinningAmount());
        holder.entryAmount.setText(leaguesList.get(position).getEntryAmount());
        holder.teamLeft.setText(leaguesList.get(position).getTeamLeft());
        holder.teamTotal.setText(leaguesList.get(position).getTeamTotal());
        holder.entryFormat.setText(leaguesList.get(position).getEntryFormat());
        holder.totalWinners.setText(leaguesList.get(position).getTotalWinners());
        final int[] progressStatus = {Integer.parseInt(leaguesList.get(position).getTeamTotal())-Integer.parseInt(leaguesList.get(position).getTeamLeft())};
         final Handler handler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus[0] < Integer.parseInt(leaguesList.get(position).getTeamTotal())) {
                    progressStatus[0] += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            holder1.progressBar.setProgress(progressStatus[0]);

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    @Override
    public int getItemCount() {
        return leaguesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView winningAmount,entryAmount,teamLeft,teamTotal,entryFormat,totalWinners;
        Button join;
        ProgressBar progressBar;
        ImageButton share;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            winningAmount=itemView.findViewById(R.id.cricket_leagueCard_winAmount);
            entryAmount=itemView.findViewById(R.id.cricket_leagueCard_entry_amount);
            teamLeft=itemView.findViewById(R.id.cricket_leagueCard_team_amountLeft);
            teamTotal=itemView.findViewById(R.id.cricket_leagueCard_totalTeamAmount);
            entryFormat=itemView.findViewById(R.id.cricket_leagueCard_entryFormat);
            totalWinners=itemView.findViewById(R.id.cricket_leagueCard_totalWinners);
            join=itemView.findViewById(R.id.cricket_leagueCard_joinButton);
            share=itemView.findViewById(R.id.cricket_leagueCard_share);
            progressBar=itemView.findViewById(R.id.cricket_leagueCard_progressBar);
        }
    }
}
