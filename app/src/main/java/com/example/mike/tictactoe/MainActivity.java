package com.example.mike.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Game game;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("game", game);

        // remember text on textview
        if (((TextView)findViewById(R.id.textView)).getText().toString().equals("Player 1 wins!")) {
            outState.putString("resultText", "Player 1 wins!");
        }
        if (((TextView)findViewById(R.id.textView)).getText().toString().equals("Player 2 wins!")) {
            outState.putString("resultText", "Player 2 wins!");
        }
        if (((TextView)findViewById(R.id.textView)).getText().toString().equals("It's a draw!")) {
            outState.putString("resultText", "It's a draw!");
        }

        // remember text of buttons
        if (((Button)findViewById(R.id.button9)).getText().toString().equals("X")) {
            outState.putString("b_9", "X");
        }
        if (((Button)findViewById(R.id.button9)).getText().toString().equals("O")) {
            outState.putString("b_9", "O");
        }

        if (((Button)findViewById(R.id.button8)).getText().toString().equals("X")) {
            outState.putString("b_8", "X");
        }
        if (((Button)findViewById(R.id.button8)).getText().toString().equals("O")) {
            outState.putString("b_8", "O");
        }

        if (((Button)findViewById(R.id.button7)).getText().toString().equals("X")) {
            outState.putString("b_7", "X");
        }
        if (((Button)findViewById(R.id.button7)).getText().toString().equals("O")) {
            outState.putString("b_7", "O");
        }

        if (((Button)findViewById(R.id.button6)).getText().toString().equals("X")) {
            outState.putString("b_6", "X");
        }
        if (((Button)findViewById(R.id.button6)).getText().toString().equals("O")) {
            outState.putString("b_6", "O");
        }

        if (((Button)findViewById(R.id.button5)).getText().toString().equals("X")) {
            outState.putString("b_5", "X");
        }
        if (((Button)findViewById(R.id.button5)).getText().toString().equals("O")) {
            outState.putString("b_5", "O");
        }

        if (((Button)findViewById(R.id.button4)).getText().toString().equals("X")) {
            outState.putString("b_4", "X");
        }
        if (((Button)findViewById(R.id.button4)).getText().toString().equals("O")) {
            outState.putString("b_4", "O");
        }

        if (((Button)findViewById(R.id.button3)).getText().toString().equals("X")) {
            outState.putString("b_3", "X");
        }
        if (((Button)findViewById(R.id.button3)).getText().toString().equals("O")) {
            outState.putString("b_3", "O");
        }

        if (((Button)findViewById(R.id.button2)).getText().toString().equals("X")) {
            outState.putString("b_2", "X");
        }
        if (((Button)findViewById(R.id.button2)).getText().toString().equals("O")) {
            outState.putString("b_2", "O");
        }

        if (((Button)findViewById(R.id.button)).getText().toString().equals("X")) {
            outState.putString("b_1", "X");
        }
        if (((Button)findViewById(R.id.button)).getText().toString().equals("O")) {
            outState.putString("b_1", "O");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize game
        // game = new Game();



        if (savedInstanceState != null) {
            // retrieve game
            game = (Game) savedInstanceState.getSerializable("game");

            if (savedInstanceState.getString("resultText") == "Player 1 wins!") {
                TextView resultText = findViewById(R.id.textView);
                resultText.setText("Player 1 wins!");
            }
            if (savedInstanceState.getString("resultText") == "Player 2 wins!") {
                TextView resultText = findViewById(R.id.textView);
                resultText.setText("Player 2 wins!");
            }
            if (savedInstanceState.getString("resultText") == "It's a draw!") {
                TextView resultText = findViewById(R.id.textView);
                resultText.setText("It's a draw!");
            }

            if (savedInstanceState.getString("b_9") == ("X")) {
                Button button9 = findViewById(R.id.button9);
                button9.setText("X");
            }
            if (savedInstanceState.getString("b_9") == ("O")) {
                Button button9 = findViewById(R.id.button9);
                button9.setText("O");
            }

            if (savedInstanceState.getString("b_8") == ("X")) {
                Button button8 = findViewById(R.id.button8);
                button8.setText("X");
            }
            if (savedInstanceState.getString("b_8") == ("O")) {
                Button button8 = findViewById(R.id.button8);
                button8.setText("O");
            }

            if (savedInstanceState.getString("b_7") == ("X")) {
                Button button7 = findViewById(R.id.button7);
                button7.setText("X");
            }
            if (savedInstanceState.getString("b_7") == ("O")) {
                Button button7 = findViewById(R.id.button7);
                button7.setText("O");
            }

            if (savedInstanceState.getString("b_6") == ("X")) {
                Button button6 = findViewById(R.id.button6);
                button6.setText("X");
            }
            if (savedInstanceState.getString("b_6") == ("O")) {
                Button button6 = findViewById(R.id.button6);
                button6.setText("O");
            }

            if (savedInstanceState.getString("b_5") == ("X")) {
                Button button5 = findViewById(R.id.button5);
                button5.setText("X");
            }
            if (savedInstanceState.getString("b_5") == ("O")) {
                Button button5 = findViewById(R.id.button5);
                button5.setText("O");
            }

            if (savedInstanceState.getString("b_4") == ("X")) {
                Button button4 = findViewById(R.id.button4);
                button4.setText("X");
            }
            if (savedInstanceState.getString("b_4") == ("O")) {
                Button button4 = findViewById(R.id.button4);
                button4.setText("O");
            }

            if (savedInstanceState.getString("b_3") == ("X")) {
                Button button3 = findViewById(R.id.button3);
                button3.setText("X");
            }
            if (savedInstanceState.getString("b_3") == ("O")) {
                Button button3 = findViewById(R.id.button3);
                button3.setText("O");
            }

            if (savedInstanceState.getString("b_2") == ("X")) {
                Button button2 = findViewById(R.id.button2);
                button2.setText("X");
            }
            if (savedInstanceState.getString("b_2") == ("O")) {
                Button button2 = findViewById(R.id.button2);
                button2.setText("O");
            }

            if (savedInstanceState.getString("b_1") == ("X")) {
                Button button1 = findViewById(R.id.button);
                button1.setText("X");
            }
            if (savedInstanceState.getString("b_1") == ("O")) {
                Button button1 = findViewById(R.id.button);
                button1.setText("O");
            }
        }
        else {
            game = new Game();
        }
    }




    public void tileClicked(View view) {
        GameState winner = game.won();

        if (winner == GameState.IN_PROGRESS) {

            // create variable for textview to show game result
            TextView resultText = findViewById(R.id.textView);

            // clear commentary after every move
            resultText.setText("");

            Button button = (Button) view;
            int row;
            int column;
            int id = button.getId();
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

            switch (state) {
                case CROSS:
                    button.setText("X");
                    break;
                case CIRCLE:
                    button.setText("O");
                    break;
                case INVALID:
                    resultText.setText("Invalid move!");
                    break;
            }

            winner = game.won();
            if (winner == GameState.PLAYER_ONE) {
                resultText.setText("Player 1 wins!");
            } else if (winner == GameState.PLAYER_TWO) {
                resultText.setText("Player 2 wins!");
            } else if (winner == GameState.DRAW) {
                resultText.setText("It's a draw!");
            }
        }
    }

    public void resetClicked (View view) {
            game = new Game();
            setContentView(R.layout.activity_main);
        }

}
