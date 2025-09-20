package com.msc.GameItems;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GameBoardTest {
    private GameCell[][] testGameBoard;

    @Test
    public void gameBoardConstructorTest(){
        testGameBoard = new GameBoard(5, 5).getGameBoard();
        int mines = 0;
        for(GameCell[] cr : testGameBoard){
            for(GameCell c : cr){
                if(c.mine){
                    mines++;
                }
            }
        }
        final int m = mines;
        assertAll(
            () -> assertTrue(testGameBoard[0].length == 5),
            () -> assertTrue(m == 5)
        );
    }
}
