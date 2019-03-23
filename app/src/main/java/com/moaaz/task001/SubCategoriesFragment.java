package com.moaaz.task001;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.moaaz.task001.API.Model.ApiManager;
import com.moaaz.task001.API.Model.Model.CategoryItem;
import com.moaaz.task001.Adapters.SubCategoriesAdapter;
import com.moaaz.task001.Base.BaseFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubCategoriesFragment extends BaseFragment {
    RecyclerView recyclerView;
    SubCategoriesAdapter adapter;
    RecyclerView.LayoutManager manager;
    public int selectedCategoryId;
    public static final int countryId = 1;
    public String englishTitle, arabicTitle;

    public SubCategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_categories, container, false);
        recyclerView = view.findViewById(R.id.recyclerView2);


        //Toast.makeText(activity,"there's your id "+((MainActivity) getActivity()).getSelectedCategoryId() , Toast.LENGTH_LONG).show();
        selectedCategoryId = ((MainActivity) getActivity()).getSelectedCategoryId();
        englishTitle = ((MainActivity) getActivity()).getSelectedCategoryNameEn();
        arabicTitle = ((MainActivity) getActivity()).getSelectedCategoryNameAr();
        getSubCategories();


        manager = new GridLayoutManager(activity, 2);
        recyclerView.setLayoutManager(manager);


        return view;

    }

    public void getSubCategories() {
        ApiManager
                .getAPIs()
                .getCategories(selectedCategoryId, countryId)
                .enqueue(new Callback<List<CategoryItem>>() {
                    @Override
                    public void onResponse(Call<List<CategoryItem>> call, Response<List<CategoryItem>> response) {
                        adapter = new SubCategoriesAdapter(response.body());
                        recyclerView.setAdapter(adapter);


                    }

                    @Override
                    public void onFailure(Call<List<CategoryItem>> call, Throwable t) {
                    }
                });


    }

}
