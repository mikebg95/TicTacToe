package com.example.mike.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Game game;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // link variables to grid buttons
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);

        // create variable to show game result
        TextView result = findViewById(R.id.textView);

        // save result of game
        if (!result.getText().toString().equals("")) {
            String resultText = result.getText().toString();
            outState.putString("resultText", resultText);
        }

        // save game
        outState.putSerializable("game", game);

        // remember symbols on grid
        outState.putString("b_9", b9.getText().toString());
        outState.putString("b_8", b8.getText().toString());
        outState.putString("b_7", b7.getText().toString());
        outState.putString("b_6", b6.getText().toString());
        outState.putString("b_5", b5.getText().toString());
        outState.putString("b_4", b4.getText().toString());
        outState.putString("b_3", b3.getText().toString());
        outState.putString("b_2", b2.getText().toString());
        outState.putString("b_1", b1.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind grid buttons to variables
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);

        // retrieve game being played
        if (savedInstanceState != null) {
            game = (Game) savedInstanceState.getSerializable("game");

            if (savedInstanceState.getString("resultText") != null) {

                String endResult = savedInstanceState.getString("resultText");
                TextView resultText = findViewById(R.id.textView);
                resultText.setText(endResult);
            }

            // retrieve x's and o's and project them
            b9.setText(savedInstanceState.getString("b_9"));
            b8.setText(savedInstanceState.getString("b_8"));
            b7.setText(savedInstanceState.getString("b_7"));
            b6.setText(savedInstanceState.getString("b_6"));
            b5.setText(savedInstanceState.getString("b_5"));
            b4.setText(savedInstanceState.getString("b_4"));
            b3.setText(savedInstanceState.getString("b_3"));
            b2.setText(savedInstanceState.getString("b_2"));
            b1.setText(savedInstanceState.getString("b_1"));
        } else {
            // if no game in progress, start new game
            game = new Game();
        }
    }

    // when one of the tiles is clicked
    public void tileClicked(View view) {

        // find the state of the game
        GameState winner = game.won();

        // if game is still in progress
        if (winner == GameState.IN_PROGRESS) {

            // create variable for textview to show game result
            TextView resultText = findViewById(R.id.textView);

            // clear commentary after every move
            resultText.setText("");

            Button button = (Button) view;
            int row;
            int column;
            int id = button.getId();

            // give each square in grid an id
            if (id == R.id.button9) {
                row = 0;
                column = 0;
            } else if (id == R.id.button8) {
                row = 0;
                column = 1;
            } else if (id == R.id.button7) {
                row = 0;
                column = 2;
            } else if (id == R.id.button6) {
                row = 1;
                column = 0;
            } else if (id == R.id.button5) {
                row = 1;
                column = 1;
            } else if (id == R.id.button4) {
                row = 1;
                column = 2;
            } else if (id == R.id.button3) {
                row = 2;
                column = 0;
            } else if (id == R.id.button2) {
                row = 2;
                column = 1;
            } else {
                row = 2;
                column = 2;
            }


            TileState state = game.choose(row, column);

            // set relevant symbol to clicked square
            switch (state) {
                case CROSS:
                    button.setText("X");
                    break;
                case CIRCLE:
                    button.setText("O");
                    break;

                // when move is invalid
                case INVALID:
                    String invalid = "Invalid move!";
                    resultText.setText(invalid);
                    break;
            }

            // when game is over
            winner = game.won();
            String whoWon;
            if (winner == GameState.PLAYER_ONE) {
                whoWon = "Player 1 wins!";
            } else if (winner == GameState.PLAYER_TWO) {
                whoWon = "Player 2 wins!";
            } else if (winner == GameState.DRAW) {
                whoWon = "It's a draw!";
            } else {
                whoWon = "";
            }

            resultText.setText(whoWon);
        }
    }

    public void resetClicked (View view) {
            // when clicked on reset, restart game
            game = new Game();
            setContentView(R.layout.activity_main);
        }

}
