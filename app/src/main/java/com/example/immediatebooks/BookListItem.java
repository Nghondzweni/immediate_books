package com.example.immediatebooks;

public class BookListItem {
    private String title;
    private String id;

    public BookListItem(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
