package com.moaaz.task001;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.moaaz.task001.Base.BaseActivity;
import com.moaaz.task001.Base.BaseFragment;

public class MainActivity extends BaseActivity {

    Fragment categoriesfragment;
    Fragment subCategoriesFragment;
    int selectedCategoryId;
    String selectedCategoryNameEn;
    String selectedCategoryNameAr;

    public String getSelectedCategoryNameEn() {
        return selectedCategoryNameEn;
    }

    public void setSelectedCategoryNameEn(String selectedCategoryName) {
        this.selectedCategoryNameEn = selectedCategoryName;
    }

    public String getSelectedCategoryNameAr() {
        return selectedCategoryNameAr;
    }

    public void setSelectedCategoryNameAr(String selectedCategoryNameAr) {
        this.selectedCategoryNameAr = selectedCategoryNameAr;
    }

    public int getSelectedCategoryId() {
        return selectedCategoryId;
    }

    public void setSelectedCategoryId(int selectedCategoryId) {
        this.selectedCategoryId = selectedCategoryId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        categoriesfragment = new CategoriesFragment();
        subCategoriesFragment = new SubCategoriesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, categoriesfragment)
                .commit();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount()==0){
            findViewById(R.id.logo)
                    .setVisibility(View.VISIBLE);
            findViewById(R.id.title).setVisibility(View.GONE);

        }
    }

    public void pushSubCategoriesFragment(String title) {
        findViewById(R.id.logo)
                .setVisibility(View.GONE);
        ((TextView) findViewById(R.id.title)).setText(title);
        findViewById(R.id.title).setVisibility(View.VISIBLE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, subCategoriesFragment)
                .addToBackStack(null)
                .commit();


    }
}
