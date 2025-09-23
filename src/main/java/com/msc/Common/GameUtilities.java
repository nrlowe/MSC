package com.msc.Common;

import java.util.concurrent.BlockingQueue;

import com.msc.GameItems.GameBoard;
import com.msc.GameItems.GameState;
import com.msc.GameItems.GameStatus;

import graphql.com.google.common.base.Optional;

public class GameUtilities {
    public static GameResponse parseUserInput(BlockingQueue<String> inputs, Optional<GameState> GO) {
        try {
            int[] selection = new int[2];
            if(GO.isPresent()){ //user move
                GameState GS = GO.get();
                return null;
            } else { //setup
                GameResponse errorGR = new GameResponse(null, new GameStatus(true, GamePhrases.GameMessages.USER_INPUT_ERROR, GamePhrases.GameCodes.USER_INPUT_ERROR));
                try{
                    String input = inputs.take();
                    String[] split = input.split(",");
                    if(split.length != 2){
                        throw new IllegalArgumentException();
                    } else {
                        for(int i = 0; i < 2; i++){
                        selection[i] = Integer.parseInt(split[i]);
                        }   
                    }
                    return new GameResponse(null, new GameStatus(false, null, GamePhrases.GameCodes.SUCCESS));
                } catch (Exception e){
                    return errorGR;
                }
            }
        } catch(Exception e) {
            return new GameResponse(null, new GameStatus(false, null, GamePhrases.GameCodes.SUCCESS));
        }
    }

    public static boolean validGameCell(int x, int y, int n, GameBoard GB){
        int limits = GB.returnGameBoardRow(0).length;
        if(x >= 0 && x < limits && y < limits && y >= 0){
            return true;
        }
        return false;
    }

    public static GameBoard updateGameBoard(int[] userMove, GameBoard GB){
        
        return GB;
    }
}
