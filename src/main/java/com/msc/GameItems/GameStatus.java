package com.msc.GameItems;

public class GameStatus {
    public boolean error = false;
    public String errorMessage;
    public int errorCode;

    public GameStatus(boolean error, String message, int code){
        this.error = error;
        this.errorMessage = message;
        this.errorCode = code;
    }
}
