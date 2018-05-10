package com.example.bradl.uno_game;

/**
 * Created by Junwei Xing on 5/10/2018.
 * playing the card that user chose.
 */

public class user extends player {

    public unoCard playing(int position) {
       return myCards.get(position);
    }
}
