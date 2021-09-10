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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    private Context context;
    private ArrayList<ExampleItem> exampleList;

    public Adapter(Context context, ArrayList<ExampleItem> exampleList) {
        this.context = context;
        this.exampleList = exampleList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item_layout, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        ExampleItem currentItem = exampleList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String countryName = currentItem.getCountryName();
        String capitalName = currentItem.getCapitalName();
        String region = currentItem.getRegionName();
        String subRegion = currentItem.getSubRegionName();
        String population = currentItem.getPopulation();

//        Picasso.get()
//                .load(imageUrl)
//                .fit()
//                .centerInside()
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(holder.imgFlag);

//        Glide.with(context)
//                .load(imageUrl)
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(holder.imgFlag);

        GlideApp.with(context).load(imageUrl).into(holder.imgFlag);

        holder.txtViewCountryName.setText("Name : " + countryName);
        holder.txtViewCapitalName.setText("Capital Name : " + capitalName);
        holder.txtViewRegion.setText("Region : " + region);
        holder.txtViewSubRegion.setText("Sub Region : " + subRegion);
        holder.txtViewPopulation.setText("Population : " + population);

    }

    @Override
    public int getItemCount() {
        return exampleList.size();
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
