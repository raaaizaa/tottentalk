package com.example.tottentalk.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tottentalk.R;
import com.example.tottentalk.clicked_activity.clickedUpcoming;
import com.example.tottentalk.javaclass.upcoming;

import java.util.ArrayList;

public class upcomingAdapter extends RecyclerView.Adapter<upcomingAdapter.ViewHolder> {

    private final ArrayList<upcoming> upcomingList;
    private final Context context;
    OnItemClickCallback onItemClickCallback;

    public interface OnItemClickCallback{
        void onItemClicked(upcoming data);
    }

    public upcomingAdapter(ArrayList<upcoming> list, Context context){
        this.upcomingList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public upcomingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull upcomingAdapter.ViewHolder holder, int position) {
        upcoming upcoming = upcomingList.get(position);
        holder.teamOne.setImageResource(upcoming.getTeamOne());
        holder.teamTwo.setImageResource(upcoming.getTeamTwo());
        holder.gameName.setText(upcoming.getGameName());
        holder.gameDate.setText(upcoming.getGameDate());

        holder.itemView.setOnClickListener(e -> onItemClickCallback.onItemClicked(upcomingList.get(holder.getAdapterPosition())));

        holder.itemView.setOnClickListener(e -> {
            int tottenham = 0, man_utd = 1, liv = 2, crystal = 3;

            String selectedDate = upcomingList.get(position).getGameDate();

            switch (selectedDate) {
                case "April 28, 2023": {
                    int i = 0;
                    setDefault(i, man_utd, tottenham);
                    break;
                }
                case "April 30, 2023": {
                    int i = 1;
                    setDefault(i, liv, tottenham);
                    break;
                }
                case "May 6, 2023": {
                    int i = 2;
                    setDefault(i, tottenham, crystal);
                    break;
                }
            }
        });
    }

    public void setDefault(int i, int teamOne, int teamTwo){
        @SuppressLint("Recycle")
        TypedArray teamOneImage = context.getResources().obtainTypedArray(R.array.club_logo);
        @SuppressLint("Recycle")
        TypedArray teamTwoImage = context.getResources().obtainTypedArray(R.array.club_logo);

        String[] gameName = context.getResources().getStringArray(R.array.upcoming_plays);
        String[] gameDate = context.getResources().getStringArray(R.array.upcoming_date);

        Intent intent = new Intent(context, clickedUpcoming.class);
        intent.putExtra("DefaultImageOne", teamOneImage.getResourceId(teamOne, -1));
        intent.putExtra("DefaultImageTwo", teamTwoImage.getResourceId(teamTwo, -1));
        intent.putExtra("DefaultName", gameName[i]);
        intent.putExtra("DefaultDate", gameDate[i]);

        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return upcomingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView teamOne, teamTwo;
        TextView gameName, gameDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamOne = itemView.findViewById(R.id.teamOne);
            teamTwo = itemView.findViewById(R.id.teamTwo);
            gameName = itemView.findViewById(R.id.gameName);
            gameDate = itemView.findViewById(R.id.gameDate);
        }
    }
}
