package com.example.immediatebooks;

public class BookListItem {
    private String title;
    private String id;
    private String thumbnail;



    private String author;

    public BookListItem(String title, String id, String author, String thumbnail) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() { return author; }

    public String getThumbnail() { return thumbnail; }

}
