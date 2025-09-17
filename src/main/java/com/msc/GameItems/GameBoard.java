package com.msc.GameItems;

public class GameBoard {
    private static final int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private GameCell[][] gameBoard;
    
    GameBoard(int n, int m){
        GameCell[][] newGrid = new GameCell[n][n];
        int[] mx = new int[m];
        int[] my = new int[m];
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                int mine = (int) Math.random() * (10 - 1) + 1;
                if(mine % 2 == 0 && m > 0){
                    newGrid[x][y].mine = true;
                    mx[m] = x;
                    my[m] = y;
                    m--;
                }
                if(m == 0){
                    break;
                }
            }
            if(m == 0){
                break;
            }
        }
        for(int mi = 0; mi < mx.length; mi++){
            for(int di = 0; di < dx.length; di++){
                GameCell c = newGrid[mx[mi]][my[mi]];
                int nextx = dx[di] + c.x;
                int nexty = dy[di] + c.y;
                if(nexty >= 0 && nextx >= 0 && nexty < n && nextx < n && !c.mine){
                    c.flag++;
                }
            }
        }
        this.gameBoard = newGrid;
    }
}
