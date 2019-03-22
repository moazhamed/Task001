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

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    List<CategoryItem> list;
    OnItemClickListener onImageClickListener ;

    public CategoriesAdapter(List<CategoryItem> list) {
        this.list = list;
    }

    public void setOnImageClickListener(OnItemClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_item_categories, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int pos) {

        final CategoryItem CategoryItem = list.get(pos);
        if (Locale.getDefault().getISO3Language().equals("ar")) {
            viewHolder.categoryName.setText(CategoryItem.getTitleAR() + " ( " + CategoryItem.getProductCount() + " ) ");
            if ((CategoryItem.getPhoto()).contains("no_image.png")) {
                viewHolder.categoryImage.setImageResource(R.drawable.cat_no_img);
            } else {
                Glide.with(viewHolder.itemView).load(CategoryItem.getPhoto())
                        .into(viewHolder.categoryImage);
            }
            if(onImageClickListener!=null){
                viewHolder.categoryImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onImageClickListener.OnItemClick(pos , CategoryItem);
                    }
                });
            }


        } else {//for english
            viewHolder.categoryName.setText(CategoryItem.getTitleEN() + " ( " + CategoryItem.getProductCount() + " ) ");
            if ((CategoryItem.getPhoto()).contains("no_image.png")) {
                viewHolder.categoryImage.setImageResource(R.drawable.cat_no_img);
            } else {

                Glide.with(viewHolder.itemView).load(CategoryItem.getPhoto())
                        .into(viewHolder.categoryImage);
            }
            if(onImageClickListener!=null){
                viewHolder.categoryImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onImageClickListener.OnItemClick(pos , CategoryItem);
                    }
                });
            }
        }

    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;

        return list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryName;

        public ViewHolder(View view) {
            super(view);
            categoryImage = view.findViewById(R.id.categoryImage);
            categoryName = view.findViewById(R.id.categoryName);
        }

    }

    public interface OnItemClickListener {

        public void OnItemClick(int pos, CategoryItem item );
    }




}
