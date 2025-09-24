package com.msc.Common;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;

import com.msc.GameItems.GameBoard;
import com.msc.GameItems.GameCell;
import com.msc.GameItems.GameState;
import com.msc.GameItems.GameStatus;

public class GameUtilities {
    public static GameResponse parseUserInput(BlockingQueue<String> inputs, Optional<GameState> GO) {
        try {
            String input = inputs.take();
            if(GO.isPresent()){
                GameState GS = GO.get();
                GameResponse GR = GS.setup ? parseSetUp(input, GS) : parseMoveInput(input, GS);
                return GR;
            } else {
                throw new Error();
            }
        } catch(Exception e) {
            return new GameResponse(null, new GameStatus(false, null, GamePhrases.GameCodes.SUCCESS));//unknown
        }
    }

    public static GameResponse parseSetUp(String input, GameState GS) {
        GameResponse errorGR = new GameResponse(GS, new GameStatus(true, GamePhrases.GameMessages.USER_INPUT_ERROR, GamePhrases.GameCodes.USER_INPUT_ERROR));
        int[] selection = new int[2];
        try{
            String[] split = input.split(",");
            if(split.length != 2){
                throw new IllegalArgumentException();
            } else {
                for(int i = 0; i < 2; i++){
                    selection[i] = Integer.parseInt(split[i]);
                }  
                GS.SetUp(selection[0], selection[1]);
            }
            return new GameResponse(GS, new GameStatus(false, null, GamePhrases.GameCodes.SUCCESS));
        } catch (Exception e){
            return errorGR;
        }
    }

    public static GameResponse parseMoveInput(String input, GameState GS){
        GameResponse errorGR = new GameResponse(GS, new GameStatus(true, GamePhrases.GameMessages.USER_INPUT_ERROR, GamePhrases.GameCodes.USER_INPUT_ERROR));
        int[] selection = new int[2];
        try{
            String[] split = input.split(",");
            if(split.length != 2){
                throw new Error();
            } else {
                for(int i = 0; i < 2; i++){
                    selection[i] = Integer.parseInt(split[i]);
                }  
            }
            if(validGameCell(selection[0], selection[1], GS.getGameBoard().returnGameBoardRow(0).length)){
               GameBoard GB = GS.getGameBoard();
               updateGameBoard(selection, GB);
               return new GameResponse(GS, new GameStatus(false, GamePhrases.GameMessages.USER_MOVE_REG, GamePhrases.GameCodes.SUCCESS_MOVE));
            } else {
                errorGR.setGameStatus(new GameStatus(true, GamePhrases.GameMessages.USER_MOVE_ERROR, GamePhrases.GameCodes.USER_INPUT_ERROR));
                return errorGR;
            }
        } catch (Exception e){
            return errorGR;
        }
    }

    public static GameResponse parseInProgress(String input, GameState GS){
        return null;
    }

    public static boolean validGameCell(int x, int y, int n){
        if(x >= 0 && x < n && y < n && y >= 0){
            return true;
        }
        return false;
    }

    public static void updateGameBoard(int[] userMove, GameBoard GB){//hanlde game over here
        GameCell gc = GB.getGameBoard()[userMove[0]][userMove[1]];
        gc.clicked = true;
    }
}
