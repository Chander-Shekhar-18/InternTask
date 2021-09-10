package com.example.interntask;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.example.interntask.database.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
//    private Context context;
//    private ArrayList<ExampleItem> exampleList;
//
//    public Adapter(Context context, ArrayList<ExampleItem> exampleList) {
//        this.context = context;
//        this.exampleList = exampleList;
//    }

    private Context context;
    private List<User> userList;

    public Adapter(Context context) {
        this.context = context;
    }
    public void setUserList(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item_layout, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
//        ExampleItem currentItem = exampleList.get(position);
//
//        String imageUrl = currentItem.getImageUrl();
//        String countryName = currentItem.getCountryName();
//        String capitalName = currentItem.getCapitalName();
//        String region = currentItem.getRegionName();
//        String subRegion = currentItem.getSubRegionName();
//        String population = currentItem.getPopulation();


        GlideApp.with(context).load(this.userList.get(position).flag).into(holder.imgFlag);

        holder.txtViewCountryName.setText(this.userList.get(position).name);
        holder.txtViewCapitalName.setText(this.userList.get(position).capital);
        holder.txtViewRegion.setText(this.userList.get(position).region);
        holder.txtViewSubRegion.setText(this.userList.get(position).subRegion);
        holder.txtViewPopulation.setText(this.userList.get(position).population);

//        holder.txtViewCountryName.setText("Name : " + countryName);
//        holder.txtViewCapitalName.setText("Capital Name : " + capitalName);
//        holder.txtViewRegion.setText("Region : " + region);
//        holder.txtViewSubRegion.setText("Sub Region : " + subRegion);
//        holder.txtViewPopulation.setText("Population : " + population);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgFlag;
        public TextView txtViewCountryName, txtViewCapitalName, txtViewRegion, txtViewSubRegion, txtViewPopulation;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewCountryName = itemView.findViewById(R.id.txtViewCountryName);
            txtViewCapitalName = itemView.findViewById(R.id.txtViewCapitalName);
            txtViewRegion = itemView.findViewById(R.id.txtViewRegion);
            txtViewSubRegion = itemView.findViewById(R.id.txtViewSubRegion);
            txtViewPopulation = itemView.findViewById(R.id.txtViewPopulation);
            imgFlag = itemView.findViewById(R.id.imgFlag);
        }
    }
}
