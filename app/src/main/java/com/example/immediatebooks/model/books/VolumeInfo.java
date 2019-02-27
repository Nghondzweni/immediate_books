package com.example.immediatebooks.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VolumeInfo {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    /*
    @SerializedName("authors")
    @Expose
    private String authors;*/

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
/*
    public String getAuthors() {
        return authors;
    }
*/
}
