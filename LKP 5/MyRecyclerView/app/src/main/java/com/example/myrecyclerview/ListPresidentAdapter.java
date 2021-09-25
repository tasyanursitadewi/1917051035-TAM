package com.example.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListPresidentAdapter  extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder>{
    private Context context;
    private ArrayList<President> listPresident;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }
        @NonNull
        @Override
    public class CategoryViewHolder onCreateViewHolder(@NonNull
    ViewGroup viewGroup, int i){
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_president, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position){
        categoryViewHolder.tvName.setTtext(getListPresident().get(position).getName());
        categoryViewHolder.tvRemarks.setTtext(getListPresident().get(position).getRemarks());

        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount(){
            return getListPresident().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

            public CategoryViewHolder(@NonNull View itemView){
                super(itemView);
                tvName = itemView.findViewById(R.id.tv_item_name);
                tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
                imgPhoto = itemView.findViewById(R.id.img_item_photo);
            }
    }

}




