package com.example.immediatebooks.model;

import com.example.immediatebooks.model.books.ImageLinks;
import com.example.immediatebooks.model.books.VolumeInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("volumeInfo")
    @Expose
    private VolumeInfo volumeInfo;



    @SerializedName("id")
    @Expose
    private String bookID;





    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }


    public VolumeInfo getVolumeInfo() { return volumeInfo; }

    public void setVolumeInfo(VolumeInfo volumeInfo) { this.volumeInfo = volumeInfo; }


}
