package com.example.mike.tictactoe;

import java.io.Serializable;


public class Game implements Serializable {
    // constant and variable to hold the board
    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    // variables that keep track of game
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        // set all tiles in game to blank
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        // default settings before first move
        playerOneTurn = true;
        gameOver = false;
    }

    public TileState choose(int row, int column) {
        // when clicked tile is blank
        if (board[row][column] == TileState.BLANK) {

            // if player ones turn, draw cross and keep count of moves
            if (playerOneTurn) {
                playerOneTurn = false;
                board[row][column] = TileState.CROSS;
                movesPlayed += 1;

                // when all tiles are full
                if (movesPlayed == 9) {
                    gameOver = true;
                }
                return TileState.CROSS;
            }
            // if player two's turn, draw circle and keep count of moves
            else {
                playerOneTurn = true;
                board[row][column] = TileState.CIRCLE;
                movesPlayed += 1;
                if (movesPlayed == 9) {
                    gameOver = true;
                }
//                Log.d("Gameover", String.valueOf(gameOver));
                return TileState.CIRCLE;
            }
        }
        // when clicked tile is not blank
        else {
            return TileState.INVALID;
        }
    }

    // check who won
    public GameState won() {
        // horizontal wins
        for (int i = 0; i < BOARD_SIZE; i++) {

            // for player one
            if (board[i][0] == TileState.CROSS && board[i][1] == TileState.CROSS && board[i][2] ==
                    TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }

            // for player two
            if (board[i][0] == TileState.CIRCLE && board[i][1] == TileState.CIRCLE && board[i][2] ==
                    TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        }

        // vertical wins
        for (int j = 0; j < BOARD_SIZE; j++) {

            // for player one
            if (board[0][j] == TileState.CROSS && board[1][j] == TileState.CROSS && board[2][j] ==
                    TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }

            // for player two
            if (board[0][j] == TileState.CIRCLE && board[1][j] == TileState.CIRCLE && board[2][j] ==
                    TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        }

        // diagonal wins for player one
        if (board[0][0] == TileState.CROSS && board[1][1] == TileState.CROSS && board[2][2] ==
                TileState.CROSS) {
            gameOver = true;
            return GameState.PLAYER_ONE;
        }
        if (board[0][2] == TileState.CROSS && board[1][1] == TileState.CROSS && board[2][0] ==
                TileState.CROSS) {
            gameOver = true;
            return GameState.PLAYER_ONE;
        }

        // diagonal wins for player two
        if (board[0][0] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[2][2] ==
                TileState.CIRCLE) {
            gameOver = true;
            return GameState.PLAYER_TWO;
        }
        if (board[0][2] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[2][0] ==
                TileState.CIRCLE) {
            gameOver = true;
            return GameState.PLAYER_TWO;
        }
        if (movesPlayed == 9) {
            gameOver = true;
            return GameState.DRAW;
        }

    // if no ones has won yet
    return GameState.IN_PROGRESS;
    }

}
