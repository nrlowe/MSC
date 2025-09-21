package com.msc.GameItems;

public class GameResponse {
    public boolean error = false;
    public String errorMessage;
    public int errorCode;

    GameResponse(boolean error, String message, int code){
        this.error = error;
        this.errorMessage = message;
        this.errorCode = code;
    }
}
