package com.msc.GameItems;

import com.msc.Common.UserAction;

public class GameStatus {
    public boolean error = false;
    public UserAction userAction;
    public String errorMessage;
    public int errorCode;

    public GameStatus(boolean error, String message, int code){
        this.error = error;
        this.errorMessage = message;
        this.errorCode = code;
        this.userAction = new UserAction();
    }

    public String returnMessage() {
        return this.errorMessage;
    }

    public int returnCode() {
        return this.errorCode;
    }

    public UserAction getUserAction(){
        return userAction;
    }
    
    public void setUserAction(UserAction ua){
        this.userAction = ua;
    }
}
