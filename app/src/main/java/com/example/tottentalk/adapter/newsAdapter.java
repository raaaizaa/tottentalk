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
import com.example.tottentalk.clicked_activity.clickedNews;
import com.example.tottentalk.activity.news;

import java.util.ArrayList;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.ViewHolder> {

    private final ArrayList<news> newsList;
    private final Context context;
    OnItemClickCallback onItemClickCallback;

    public interface OnItemClickCallback{
        void onItemClicked(news data);
    }

    public newsAdapter(ArrayList<news> list, Context context){
        this.newsList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public newsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsAdapter.ViewHolder holder, int position) {
        news news = newsList.get(position);
        holder.picture.setImageResource(news.getPicture());
        holder.headline.setText(news.getHeadline());
        holder.date.setText(news.getDate());

        holder.itemView.setOnClickListener(e -> onItemClickCallback.onItemClicked(newsList.get(holder.getAdapterPosition())));

        holder.itemView.setOnClickListener(e -> {
            String isHeadline = newsList.get(position).getHeadline();

            if(isHeadline.contains("Harry Kane now")){
                int i = 0;
                setDefaultContent(i);

            }else if(isHeadline.contains("Journalist reveals why")){
                int i = 1;
                setDefaultContent(i);

            }else if(isHeadline.contains("‘Unbelievable’ manager still in running for Tottenham")){
                int i = 2;
                setDefaultContent(i);

            }else if(isHeadline.contains("Tottenham keen on 25–year–old")){
                int i = 3;
                setDefaultContent(i);

            }else if(isHeadline.contains("REPORT: TOTTENHAM TELL INTER MILAN")){
                int i = 4;
                setDefaultContent(i);

            }
        });
    }

    public void setDefaultContent(int i){
        @SuppressLint("Recycle")
        TypedArray image = context.getResources().obtainTypedArray(R.array.news_picture);

        String[] headline = context.getResources().getStringArray(R.array.news_headline);
        String[] date = context.getResources().getStringArray(R.array.news_date);
        String[] description = context.getResources().getStringArray(R.array.news_description);

        Intent intent = new Intent(context, clickedNews.class);
        intent.putExtra("DefaultImage", image.getResourceId(i, -1));
        intent.putExtra("DefaultHeadline", headline[i]);
        intent.putExtra("DefaultDate", date[i]);
        intent.putExtra("DefaultDescription", description[i]);

        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView picture;
        TextView headline, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.news_image);
            headline = itemView.findViewById(R.id.news_headline);
            date = itemView.findViewById(R.id.news_date);

        }
    }
}
