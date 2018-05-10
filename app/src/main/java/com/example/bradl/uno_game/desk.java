package com.example.bradl.uno_game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Junwei Xing on 5/10/2018.
 * this class is for the remaining cards on desk, and which cards can be drawn by users.
 */

public class desk {

    final static int FORTOP = 0;

    ArrayList<unoCard> thisTurn = new ArrayList<unoCard> (); //holding the remaining cards

    //generating
    public desk () {
        for (unoCard.Color eachColor : unoCard.Color.values()) {
            for(unoCard.Number eachNumber : unoCard.Number.values()){
                unoCard eachCard = new unoCard(eachColor, eachNumber);
                thisTurn.add(eachCard);
                thisTurn.add(eachCard);
            }
        }
        Collections.shuffle(thisTurn); //shuffling the cards

    }

    //randomly drawing a card
    public unoCard getOne (){
        if(thisTurn.size()>0){
            return thisTurn.remove(FORTOP);
        }else{
            return null;
        }
    }

    public int deskSize (){
        return thisTurn.size();
    }

    public void reStart (ArrayList<unoCard> remaining){
        thisTurn = remaining;
        Collections.shuffle(thisTurn);
    }
}
