package com.example.bradl.uno_game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Junwei Xing on 5/10/2018.
 * computer figures out which card should be chose. If there are more than one, randomly choose.
 */

public class computer extends player {
    ArrayList<unoCard> avaiCards; //available cards can be chose.
    unoCard theOne; //the one after randomly selection.

    //automatically judge whether there are cards are available.
    public unoCard playing(unoCard pile) {
        avaiCards = new ArrayList<unoCard>();
       for(unoCard eachCard : myCards){
           if((eachCard.color).equals(pile.color) || (eachCard.number).equals(pile.number)){
               avaiCards.add(eachCard);
           }
       }
       if(avaiCards.size() > 0) {

           Collections.shuffle(avaiCards); //shuffle the result set.
           theOne = avaiCards.get(0);

           return theOne;

       }else{
           return null;
       }
    }


}
