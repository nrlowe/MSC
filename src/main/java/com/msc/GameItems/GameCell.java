package com.msc.GameItems;

public class GameCell {
    public int x, y, flag;
    public boolean clicked = false, mine = false;

    GameCell(int x, int y, int flag){
        this.x = x; 
        this.y = y;
        this.flag = flag;
    }
}
