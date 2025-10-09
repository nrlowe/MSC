package com.msc.Common;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;

import com.msc.Common.GamePhrases.GameMessages;
import com.msc.GameItems.GameBoard;
import com.msc.GameItems.GameCell;
import com.msc.GameItems.GameState;
import com.msc.GameItems.GameStatus;

public class GameUtilities {
    public static GameResponse parseUserInput(BlockingQueue<String> inputs, GameState GO) {
        try {
            String input = inputs.take();
            GameResponse GR = GO.setup ? parseSetUp(input, GO) : parseMoveInput(input, GO);
            return GR;
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
                    int v = selection[i] = Integer.parseInt(split[i]);
                    if(v < 11 && v >= 1 ) {
                        selection[i] = Integer.parseInt(split[i]);
                    } else {
                        errorGR.setGameStatus(new GameStatus(true, GameMessages.GAMEBOARD_LIMITS, GamePhrases.GameCodes.USER_INPUT_ERROR));
                        throw new Exception();
                    }
                }  
                GS.SetUp(selection[0], selection[1]);
            }
            return new GameResponse(GS, new GameStatus(false, GameMessages.GAMEBOARD_CREATED(selection[0], selection[0], selection[1]), GamePhrases.GameCodes.SUCCESS));
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
               return updateGameBoard(selection, GS);
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

    public static GameResponse updateGameBoard(int[] userMove, GameState GS){
        GameBoard GB = GS.getGameBoard();
        GameCell gc = GB.getGameBoard()[userMove[0]][userMove[1]];
        gc.clicked = true;
        if(gc.mine){
            return new GameResponse(GS, new GameStatus(false, GamePhrases.GameMessages.USER_MOVE_REG, GamePhrases.GameCodes.GAME_OVER));
        } else {
            return new GameResponse(GS, new GameStatus(false, GamePhrases.GameMessages.USER_MOVE_REG, GamePhrases.GameCodes.SUCCESS_MOVE));
        }
    }
}
