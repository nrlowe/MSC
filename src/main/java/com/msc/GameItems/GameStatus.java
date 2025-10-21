package com.msc.GameItems;

public class GameStatus {
    public boolean error = false;
    public boolean showHelpText = false;
    public String errorMessage;
    public int errorCode;

    public GameStatus(boolean error, String message, int code){
        this.error = error;
        this.errorMessage = message;
        this.errorCode = code;
    }

    public String returnMessage() {
        return this.errorMessage;
    }

    public int returnCode() {
        return this.errorCode;
    }

    public void setShowHelpText(boolean ht){
        this.showHelpText = ht;
    }
    
    public boolean getShowHelpText(){
        return showHelpText;
    }
}
