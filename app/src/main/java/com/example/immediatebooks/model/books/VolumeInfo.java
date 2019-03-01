package com.example.immediatebooks.model.books;

import com.example.immediatebooks.model.Items;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class VolumeInfo {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;


    @SerializedName("authors")
    @Expose
    private List<String> authors;


    @SerializedName("imageLinks")
    @Expose
    private ImageLinks imageLinks;

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }



    public List<String> getAuthors() {
        return authors;
    }






    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
