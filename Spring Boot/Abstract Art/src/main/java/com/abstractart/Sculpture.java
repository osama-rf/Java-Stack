package com.abstractart;

public class Sculpture extends Art{

    public String material;


    public Sculpture(String title, String author, String description, String material) {
        super(title, author, description);
        this.material = material;
    }


    @Override
    public void viewArt() {
        String result = "";
        result += "Title:  " + getTitle() + "\n";
        result += "Author:  " + getAuthor() + "\n";
        result += "Description:  " + getDescription() + "\n";
        result += "Material:  " + material + "\n";

        System.out.println(result);
    }
}
