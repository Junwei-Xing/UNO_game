package com.example.bradl.uno_game;

/**
 * Created by Junwei Xing on 5/10/2018.
 * this is for structuring a uno card
 */

public class unoCard {
    public enum Color {RED, BLUE, GREEN, YELLOW; };
    public enum Number {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NIGHT;}

    Color color;
    Number number;
    public unoCard (Color color, Number number){
        this.color = color;
        this.number = number;
    }

    public Color getColor(){

        return color;
    }

    public Number getNumber(){

        return number;
    }
}
