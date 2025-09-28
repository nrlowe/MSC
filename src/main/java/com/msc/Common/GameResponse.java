package com.msc.Common;

import com.msc.GameItems.GameStatus;
import com.msc.GameItems.GameState;

public class GameResponse {
    public GameState gameState;
    public GameStatus gameStatus;
    public int[] cellSelection;

    public GameResponse(GameState gameState, GameStatus gameStatus){
        this.gameState = gameState;
        this.gameStatus = gameStatus;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public GameStatus getgGameStatus(){
        return this.gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setCellSelection(int[] cells) {
        this.cellSelection = cells;
    }
}
