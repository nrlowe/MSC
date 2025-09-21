package com.msc.Common;

import com.msc.GameItems.GameState;

public class GameResponse {
    public GameState gameState;
    public GameResponse gameResponse;
    GameResponse(GameState gameState, GameResponse gameResponse){
        this.gameState = gameState;
        this.gameResponse = gameResponse;
    }
}
