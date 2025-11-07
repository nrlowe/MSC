package com.msc.Common;

public class UserAction {
    public boolean showHelpText = false;
    public boolean endGame = false;
    public boolean exitGame = false;
    public boolean printBoard = false;

	public boolean isShowHelpText() {
		return showHelpText;
	}
	public void flipShowHelpText() {
        this.showHelpText = this.showHelpText == true ? false : true;
	}
	public boolean isEndGame() {
		return endGame;
	}
	public void flipEndGame() {
		this.endGame = this.endGame == true ? false : true;
	}
	public boolean isExitGame() {
		return exitGame;
	}
	public void flipExitGame() {
		this.exitGame = this.exitGame == true ? false : true;
	}
	public boolean isPrintBoard() {
		return printBoard;
	}
	public void flipPrintBoard() {
		this.printBoard = this.printBoard == true ? false : true;
	}

    public void flipAllValues(String input){
        if(GamePhrases.GameMessages.HELP.equals(input)){
            this.showHelpText = true;
            this.endGame = false;
            this.exitGame = false;
            this.printBoard = false;
        } else if(GamePhrases.GameMessages.END_GAME.equals(input)){
            this.showHelpText = false;
            this.endGame = true;
            this.exitGame = false;
            this.printBoard = false;
        } else if(GamePhrases.GameMessages.EXIT_GAME.equals(input)){
            this.showHelpText = false;
            this.endGame = false;
            this.exitGame = true;
            this.printBoard = false;
        } else {
            this.showHelpText = false;
            this.endGame = false;
            this.exitGame = false;
            this.printBoard = true;
        }
    }
}
