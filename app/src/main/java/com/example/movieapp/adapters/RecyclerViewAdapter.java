package com.example.movieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieapp.R;
import com.example.movieapp.model.Movies;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movies> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Movies> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option =new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.movie_item_design,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.movie_title.setText(mData.get(position).getTitle());
        holder.movie_year.setText(mData.get(position).getYear());
        holder.movie_rating.setText(mData.get(position).getImdb_rating());
        holder.movie_releaseDate.setText(mData.get(position).getReleased_Date());
        holder.movie_Director.setText(mData.get(position).getDirector());
        holder.movie_Runtime.setText(mData.get(position).getRuntime());
        holder.movie_Language.setText(mData.get(position).getLanguage());

        Glide.with(mContext).load(mData.get(position).getPoster_url()).apply(option).into(holder.movie_poster);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class  MyViewHolder extends RecyclerView.ViewHolder {

        TextView movie_title;
        TextView movie_year;
        TextView movie_rating;
        TextView movie_releaseDate;
        TextView movie_Director;
        TextView movie_Runtime;
        TextView movie_Language;
        ImageView movie_poster;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            movie_title = itemView.findViewById(R.id.movie_title);
            movie_year = itemView.findViewById(R.id.movie_year);
            movie_rating = itemView.findViewById(R.id.rating);
            movie_releaseDate = itemView.findViewById(R.id.rel_date);
            movie_Director = itemView.findViewById(R.id.name_director);
            movie_Runtime = itemView.findViewById(R.id.runtime);
            movie_Language = itemView.findViewById(R.id.language);
            movie_poster =itemView.findViewById(R.id.img_thumb);

        }
    }
}
