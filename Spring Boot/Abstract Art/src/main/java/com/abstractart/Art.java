package com.abstractart;

public abstract class Art {
    public String title;
    public String author;
    public String description;

    public Art(String title, String author, String description){
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public abstract void viewArt();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
