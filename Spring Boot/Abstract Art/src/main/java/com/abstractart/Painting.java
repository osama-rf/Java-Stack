package com.abstractart;

public class Painting extends Art{

    public String paintType;

//    public Painting(String paintType){
//        this.paintType = paintType;
//    }

    public Painting(String title, String author, String description, String paintType) {
        super(title, author, description);
        this.paintType = paintType;
    }

    @Override
    public void viewArt() {
        String result = "";
        result += "Title:  " + getTitle() + "\n";
        result += "Author:  " + getAuthor() + "\n";
        result += "Description:  " + getDescription() + "\n";
        result += "Paint Type:  " + paintType + "\n";

        System.out.println(result);
    }
}
