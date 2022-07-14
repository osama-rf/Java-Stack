package com.abstractart;

import java.util.ArrayList;

// inside of Museum.java
public class Museum {
    public static void main(String[] args) {

        // TODO: create paintings and sculptures here

        // Paintings

        Painting paint1 = new Painting(
                "Mona Lisa",
                "Leonardo Da Vinci",
                "Mona Lisa’s look of preternatural calm comports with the idealized landscape behind her, which dissolves into the distance through Leonardo’s use of atmospheric perspective.",
                "Oil");
        Painting paint2 = new Painting(
                "The Starry Night",
                "Vincent van Gogh",
                "Vincent Van Gogh’s most popular painting, The Starry Night was created by Van Gogh at the asylum in Saint-Rémy, where he’d committed himself in 1889.",
                "Oil");
        Painting paint3 = new Painting(
                "The Harvesters",
                "Pieter Bruegel",
                "The time is probably early September. A group of peasants on the left cut and bundle ripened wheat, while the on the right, another group takes their midday meal. One figure is sacked out under a tree with his pants unbuttoned.",
                "Oil");


        // Sculptures

        Sculpture sculpture1 = new Sculpture(
                "Guitar",
                "Pablo Picasso",
                "Guitar transferred collage’s cut and paste techniques from two dimensions to three.",
                "Bronze");

        Sculpture sculpture2 = new Sculpture(
                "Bust of Nefertiti",
                "Ancient Egyptian ",
                "The life of his queen, Nefertiti, is something of mystery",
                "Marble");

        ArrayList<Art> museum = new ArrayList<Art>();
        museum.add(paint1);
        museum.add(paint2);
        museum.add(paint3);

        museum.add(sculpture1);
        museum.add(sculpture2);

        for (Art art : museum){
            art.viewArt();
        }
    }
}