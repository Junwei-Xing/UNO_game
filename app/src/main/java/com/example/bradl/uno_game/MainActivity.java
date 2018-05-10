package com.example.bradl.uno_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView opponent, topOfPile, cardOfTop, remainCard, user;
    GridView myCards;
    Button drawing;

    myAdapter adapter;

    String oppo1 = "Your opponent (the computer)\nhas ";
    String oppo2 = " cards remaining";
    String topOf1 = "Top of pile";
    String remain1 = " cards\nremaining\nin desk";
    String user1 = "your hand:\nSelect card to play:";
    ArrayList<Integer> color = new ArrayList<Integer>();
    ArrayList<Integer> number  = new ArrayList<Integer>();
    ArrayList<Integer> update  = new ArrayList<Integer>();
    game myGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opponent = (TextView) findViewById(R.id.opponent);
        topOfPile = (TextView) findViewById(R.id.topOfPile);
        cardOfTop = (TextView) findViewById(R.id.cardOfTop);
        remainCard = (TextView) findViewById(R.id.remainCard);
        user = (TextView) findViewById(R.id.user);
        drawing = (Button) findViewById(R.id.drawing);
        myCards = (GridView) findViewById(R.id.myCards);

        setUp();

        //when user clicks the drawone button
        drawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update = myGame.userDrawOne();

                //if there is more than one card
                if(update!=null) {
                    color.add(update.get(0));
                    number.add(update.get(1));
                }

                //update the views related with it
                remainCard.setText(myGame.getRemaining() + remain1);
                adapter.notifyDataSetChanged();
            }
        });

        myCards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int whichOneNumber = Integer.valueOf(((TextView) view).getText().toString());

                //if the one user chose is matched.
                if (myGame.userTurn(i)) {

                    color.remove(i);
                    number.remove(i);

                    //update the relevant views
                    cardOfTop.setText(Integer.toString(myGame.getPileNumber()));
                    cardOfTop.setBackgroundColor(myGame.getPileColor());
                    adapter.notifyDataSetChanged();

                    //check the result
                    if (myGame.userWins()) {
                        Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_LONG).show();
                        setUp();
                    }

                    //computer's turn
                    myGame.computerTurn();
                    remainCard.setText(myGame.getRemaining() + remain1);
                    cardOfTop.setText(Integer.toString(myGame.getPileNumber()));
                    cardOfTop.setBackgroundColor(myGame.getPileColor());
                    opponent.setText(oppo1 + myGame.getOppoRemain() + oppo2);

                    //check the result
                    if (myGame.computerWins()) {
                        Toast.makeText(getApplicationContext(), "You lose!", Toast.LENGTH_LONG).show();
                        setUp();
                    }
                }
            }
        });

    }

    //initializing the views and starting game.
        public void setUp (){
            myGame = new game();
            opponent.setText(oppo1 + myGame.getOppoRemain()+ oppo2);
            topOfPile.setText(topOf1);
            remainCard.setText(myGame.getRemaining() + remain1);
            user.setText(user1);

            cardOfTop.setText(Integer.toString(myGame.getPileNumber()));
            cardOfTop.setGravity(Gravity.CENTER);
            cardOfTop.setBackgroundColor(myGame.getPileColor());
            cardOfTop.setTextColor(Color.WHITE);

            color = myGame.displayUserColors();
            number = myGame.displayUserNumbers();

            adapter = new myAdapter(getApplicationContext(), color, number);
            myCards.setAdapter(adapter);
    }

}
