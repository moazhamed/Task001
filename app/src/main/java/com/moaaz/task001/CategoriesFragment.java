package com.moaaz.task001;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moaaz.task001.API.Model.ApiManager;
import com.moaaz.task001.API.Model.Model.CategoryItem;
import com.moaaz.task001.API.Model.Model.SubCategoriesItem;
import com.moaaz.task001.Adapters.CategoriesAdapter;
import com.moaaz.task001.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends BaseFragment {

    RecyclerView recyclerView;
    CategoriesAdapter adapter;
    RecyclerView.LayoutManager manager;
    private static final int categoryId = 0;
    private static final int countryId = 1;
    public int selectedCategoryId;
    public String titleEn, titleAr;


    public CategoriesFragment() {
        // Required empty public constructor
    }


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        manager = new GridLayoutManager(activity, 2);
        recyclerView.setLayoutManager(manager);
        getCategories();


        return view;
    }

    public void getCategories() {
        ApiManager.getAPIs()
                .getCategories(categoryId, countryId)
                .enqueue(new Callback<List<CategoryItem>>() {
                    @Override
                    public void onResponse(Call<List<CategoryItem>> call, final Response<List<CategoryItem>> response) {
                        adapter = new CategoriesAdapter(response.body());
                        adapter.setOnImageClickListener(new CategoriesAdapter.OnItemClickListener() {
                            @Override
                            public void OnItemClick(int pos, CategoryItem item) {
                                selectedCategoryId = item.getId();
                                titleEn = item.getTitleEN();
                                titleAr = item.getTitleAR();
                                ((MainActivity) getActivity()).pushSubCategoriesFragment(item.getTitleEN());
                                ((MainActivity) getActivity()).setSelectedCategoryId(selectedCategoryId);
                                ((MainActivity) getActivity()).setSelectedCategoryNameEn(titleEn);
                                ((MainActivity) getActivity()).setSelectedCategoryNameAr(titleAr);
                            }
                        });
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<List<CategoryItem>> call, Throwable t) {

                    }
                });


    }


}
