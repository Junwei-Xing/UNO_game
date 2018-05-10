package com.example.bradl.uno_game;

import android.graphics.Color;
import java.util.ArrayList;

/**
 * Created by Junwei Xing on 5/10/2018.
 */

public class game {

        private desk myDesk;
        private pile myPile;
        private user myUser;
        private computer myComputer;
        final static int INITIALCARDS = 7;

        //initiaize
        public game() {

            myDesk = new desk();
            myPile = new pile();
            myUser = new user();
            myComputer = new computer();
            //7 cards for each player, and 1 card for pile
            for (int i = 0; i < INITIALCARDS; i++) {
                myUser.drawing(myDesk.getOne());
                myComputer.drawing(myDesk.getOne());
            }
            myPile.putIn(myDesk.getOne());

        }

        //computer's turn
        public void computerTurn () {
            unoCard targetOne;
            boolean stop = false;

            while(!stop) {
                targetOne = myComputer.playing(myPile.getTop()); //get the card from computer
                if (targetOne != null && matching(targetOne, myPile.getTop())) {
                    myComputer.myCards.remove(targetOne); //matched, delete it from computer's cards.
                    myPile.putIn(targetOne);  // add it to pile
                    stop = true;
                } else {
                    if(myDesk.deskSize() > 0) {
                        myComputer.drawing(myDesk.getOne()); // automatically drawing
                    }else{
                        //not enough cards, put the pile cards back.
                        myDesk.reStart(myPile.Played());
                        myPile.reStart();
                    }
                }
            }
        }

        public boolean userTurn(int myIndex){
            //get it based on index
            unoCard target = myUser.playing(myIndex);
            if(matching(target, myPile.getTop())){
                myUser.myCards.remove(myIndex); //matched, delete it from user's cards.
                myPile.putIn(target); // add it to pile
                return true;
            }else{
                return false;
            }

        }

        //send the colors of user's cards back
        public ArrayList<Integer> displayUserColors (){
            ArrayList<Integer> forMyColors = new ArrayList<Integer>();
            for(unoCard eachCard : myUser.myCards){
                forMyColors.add(transColor(eachCard));
            }

            return forMyColors;
        }

        //send the numbers of user's cards back
        public ArrayList<Integer> displayUserNumbers () {
            ArrayList<Integer> forMyNumbers = new ArrayList<Integer>();

            for (unoCard eachCard : myUser.myCards) {
                forMyNumbers.add(transNumber(eachCard));
            }
            return forMyNumbers;
         }

         //when user selects to draw one card from desk.
        public ArrayList<Integer> userDrawOne (){
            ArrayList<Integer> forCN = new ArrayList<Integer>();

            if(myDesk.deskSize() > 0) {
                unoCard theOne = myDesk.getOne();
                forCN.add(transColor(theOne));
                forCN.add(transNumber(theOne));
                myUser.drawing(theOne);
                return forCN;
            }else {
                myDesk.reStart(myPile.Played());
                myPile.reStart();
                return null;
            }

        }

        //judge whether two cards are matched.
        private boolean matching(unoCard target, unoCard pile){
            if((target.color).equals(pile.color) || (target.number).equals(pile.number)){
                return true;
            }else{
                return false;
            }
        }


        public int getPileColor(){
            return transColor(myPile.getTop());
        }

        public int getPileNumber(){
            return transNumber(myPile.getTop());
        }

        public int getRemaining (){return myDesk.deskSize();}

        public int getOppoRemain (){
            return myComputer.myCards.size();
        }

        public boolean userWins (){
            return myUser.win();
        }

        public boolean computerWins (){
            return myComputer.win();
        }

        //color converter
        private int transColor(unoCard eachCard) {
            switch(eachCard.color){
                case RED:
                    return Color.RED;
                case BLUE:
                    return Color.BLUE;
                case GREEN:
                    return Color.GREEN;
                default:
                    return Color.YELLOW;
            }
        }

        //number converter
        private int transNumber(unoCard eachCard) {
            switch (eachCard.number) {
                case ZERO:
                    return 0;
                case ONE:
                    return 1;
                case TWO:
                    return 2;
                case THREE:
                    return 3;
                case FOUR:
                    return 4;
                case FIVE:
                    return 5;
                case SIX:
                    return 6;
                case SEVEN:
                    return 7;
                case EIGHT:
                    return 8;
                default:
                    return 9;
            }
        }






}
