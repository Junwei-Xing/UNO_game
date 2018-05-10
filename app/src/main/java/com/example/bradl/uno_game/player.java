package com.example.bradl.uno_game;

import java.util.ArrayList;

/**
 * Created by Junwei Xing on 5/10/2018.
 * common attributes and actions a player should have
 */

public abstract class player {

    ArrayList<unoCard> myCards = new ArrayList<unoCard>(); //own uno cards

    public void drawing (unoCard top){
        myCards.add(top);
    }

    public boolean win(){
        if(myCards.size() > 0){
            return false;
        }else{
            return true;
        }
    }

}