package com.moaaz.task001.API.Model;

import com.moaaz.task001.API.Model.Model.CategoryItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {

    @GET("GetCategories")
    Call<List<CategoryItem>> getCategories(@Query("categoryId") int categoryId,
                                           @Query("countryId") int countryId);
}
