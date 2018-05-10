package com.example.bradl.uno_game;

import java.util.ArrayList;

/**
 * Created by bradl on 5/8/2018.
 *
 */

public class pile {
    ArrayList<unoCard> myPile;
    unoCard top;

    public pile (){
        myPile = new ArrayList<unoCard>();
    }

    //recording the played cards
    public void putIn (unoCard myCard){
        myPile.add(myCard);
    }

    //getting the top card of pile
    public unoCard getTop (){
        if(myPile.size()>0){
            top = myPile.get(myPile.size()-1);
            return top;
        }else{
            return null;
        }
    }

    //return the played cards back
    public ArrayList<unoCard> Played (){
        if(myPile.size()>0){
        top = myPile.remove(myPile.size()-1);
        }
        return myPile;
    }

    //when restart, set up pile
    public void reStart (){
        myPile = new ArrayList<unoCard>();
        myPile.add(top);
    }
}
