package com.example.tottentalk;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class upcomingAdapter extends RecyclerView.Adapter<upcomingAdapter.ViewHolder> {
    private ArrayList<upcoming> upcomingList;
    private OnItemClickCallback onItemClickCallback;
    private Context context;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

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
        holder.teamone.setImageResource(upcoming.getTeamone());
        holder.teamtwo.setImageResource(upcoming.getTeamtwo());
        holder.gamename.setText(upcoming.getGamename());
        holder.gamedate.setText(upcoming.getGamedate());

        holder.itemView.setOnClickListener(e -> onItemClickCallback.onItemClicked(upcomingList.get(holder.getAdapterPosition())));

        holder.itemView.setOnClickListener(e -> {
            int tottenham = 0, manutd = 1, liv = 2, crystal = 3;

            String dateIs = upcomingList.get(position).getGamedate();

            if(dateIs.equals("April 28, 2023")){
                int i = 0;
                setDefault(i, manutd, tottenham);
            }else if(dateIs.equals("April 30, 2023")){
                int i = 1;
                setDefault(i, liv, tottenham);
            }else if(dateIs.equals("May 6, 2023")){
                int i = 2;
                setDefault(i, tottenham, crystal);
            }
        });
    }

    public void setDefault(int i, int teamone, int teamtwo){
        TypedArray teamoneImage = context.getResources().obtainTypedArray(R.array.club_logo);
        TypedArray teamtwoImage = context.getResources().obtainTypedArray(R.array.club_logo);
        String[] gamename = context.getResources().getStringArray(R.array.upcoming_plays);
        String[] gamedate = context.getResources().getStringArray(R.array.upcoming_date);

        Intent intent = new Intent(context, clickedUpcoming.class);
        intent.putExtra("DefaultImageOne", teamoneImage.getResourceId(teamone, -1));
        intent.putExtra("DefaultImageTwo", teamtwoImage.getResourceId(teamtwo, -1));
        intent.putExtra("DefaultName", gamename[i]);
        intent.putExtra("DefaultDate", gamedate[i]);

        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return upcomingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView teamone, teamtwo;
        TextView gamename, gamedate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamone = itemView.findViewById(R.id.teamone);
            teamtwo = itemView.findViewById(R.id.teamtwo);
            gamename = itemView.findViewById(R.id.gamename);
            gamedate = itemView.findViewById(R.id.gamedate);
        }
    }
}
