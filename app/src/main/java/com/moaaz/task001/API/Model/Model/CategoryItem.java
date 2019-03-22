package com.moaaz.task001.API.Model.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CategoryItem {

	@SerializedName("TitleAR")
	private String titleAR;

	@SerializedName("ProductCount")
	private String productCount;

	@SerializedName("Photo")
	private String photo;

	@SerializedName("HaveModel")
	private String haveModel;

	@SerializedName("Id")
	private int id;

	@SerializedName("TitleEN")
	private String titleEN;

	@SerializedName("SubCategories")
	private List<SubCategoriesItem> subCategories;

	public void setTitleAR(String titleAR){
		this.titleAR = titleAR;
	}

	public String getTitleAR(){
		return titleAR;
	}

	public void setProductCount(String productCount){
		this.productCount = productCount;
	}

	public String getProductCount(){
		return productCount;
	}

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setHaveModel(String haveModel){
		this.haveModel = haveModel;
	}

	public String getHaveModel(){
		return haveModel;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitleEN(String titleEN){
		this.titleEN = titleEN;
	}

	public String getTitleEN(){
		return titleEN;
	}

	public void setSubCategories(List<SubCategoriesItem> subCategories){
		this.subCategories = subCategories;
	}

	public List<SubCategoriesItem> getSubCategories(){
		return subCategories;
	}

	@Override
 	public String toString(){
		return 
			"CategoryItem{" +
			"titleAR = '" + titleAR + '\'' + 
			",productCount = '" + productCount + '\'' + 
			",photo = '" + photo + '\'' + 
			",haveModel = '" + haveModel + '\'' + 
			",id = '" + id + '\'' + 
			",titleEN = '" + titleEN + '\'' + 
			",subCategories = '" + subCategories + '\'' + 
			"}";
		}
}