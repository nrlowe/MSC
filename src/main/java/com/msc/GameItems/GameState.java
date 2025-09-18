package com.msc.GameItems;

public class GameState {
    public boolean setup = false;
    public boolean inProgress = false;
    public boolean gameOver = false;
    public boolean terminateState = false;
    private GameBoard gameBoard;

    public GameState(){
        this.setup = true;
    }

    public void SetUp(int n, int m){
        this.gameBoard = new GameBoard(n, m);
        this.setup = false;
        this.inProgress = true;
    }
}
