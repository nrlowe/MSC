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
                int mine = (int) (Math.random() * 10) + 1;
                GameCell newCell = new GameCell(x, y, 0);
                if(mine % 2 == 0 && m > 0){
                    newCell.mine = true;
                    mx[m - 1] = x;
                    my[m - 1] = y;
                    m--;
                } 
                newGrid[x][y] = newCell;
            }
        }
        for(int mi = 0; mi < mx.length; mi++){
            for(int di = 0; di < dx.length; di++){
                GameCell mineCell = newGrid[mx[mi]][my[mi]];
                int nextx = dx[di] + mineCell.x;
                int nexty = dy[di] + mineCell.y;
                if(nexty >= 0 && nextx >= 0 && nexty < n && nextx < n && !newGrid[nextx][nexty].mine){
                    newGrid[nextx][nexty].flag++;
                }
            }
        }
        this.gameBoard = newGrid;
    }

    public GameCell[][] getGameBoard(){
        return this.gameBoard;
    }

    public GameCell[] returnGameBoardRow(int rowIndex){
        return this.gameBoard[rowIndex];
    }


}
