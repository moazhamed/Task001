package com.moaaz.task001.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moaaz.task001.API.Model.Model.CategoryItem;
import com.moaaz.task001.API.Model.Model.SubCategoriesItem;
import com.moaaz.task001.R;

import java.util.List;
import java.util.Locale;

public class SubCategoriesAdapter extends RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder> {

   List<CategoryItem> list;

    public SubCategoriesAdapter(List<CategoryItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_item_sub_categories, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        CategoryItem item = list.get(i);
        if (Locale.getDefault().getISO3Language().equals("ar")) {
            //if language is arabic
            viewHolder.subCategoryName.setText(item.getTitleAR() + " ( " + item.getProductCount() + " ) ");
            if ((item.getPhoto()).contains("no_image.png")) {
                viewHolder.subCategoryImage.setImageResource(R.drawable.cat_no_img);
            } else {
                Glide.with(viewHolder.itemView).load(item.getPhoto())
                        .into(viewHolder.subCategoryImage);
            }

        }else {
            //if language is english
            viewHolder.subCategoryName.setText(item.getTitleEN() + " ( " + item.getProductCount() + " ) ");
            if ((item.getPhoto()).contains("no_image.png")) {
                viewHolder.subCategoryImage.setImageResource(R.drawable.cat_no_img);
            } else {

                Glide.with(viewHolder.itemView).load(item.getPhoto())
                        .into(viewHolder.subCategoryImage);
            }

        }


    }

    @Override
    public int getItemCount() {
       if (list==null) return 0;

       return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView subCategoryImage;
        TextView subCategoryName;

        public ViewHolder(View view) {
            super(view);
            subCategoryImage = view.findViewById(R.id.subcategoryImage);
            subCategoryName  = view.findViewById(R.id.subcategoryName);

        }


    }


}
