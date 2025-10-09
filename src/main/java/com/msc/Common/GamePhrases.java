package com.msc.Common;

public class GamePhrases {
    public class GameMessages {
        public static final String INTRO_TEXT = "To begin please input the size of the grid and number of mines";
        public static final String INPUT_HELP_TEXT = "All entries should be in the pattern of 'NUM,NUM' with no space";
        public static final String USER_INPUT_ERROR = "Input was in incorrect format";
        public static final String USER_MOVE_ERROR = "Not a valid move!";
        public static final String USER_MOVE_REG = "GameBoard Updated!";
        public static final String GAME_OVER = "You selected a mine! Game Over!!";
        public static final String TRY_AGAIN = "Would you like to try again?";
        public static final String YES = "YES";
        public static final String NO = "NO";
        public static final String THANKS = "Thank you for playing!";
        public static final String GAMEBOARD_LIMITS = "Please keep the grid within 10x10";
    }
    public class GameCodes {
        public static final int SUCCESS = 400;
        public static final int SUCCESS_MOVE = 401;
        public static final int GAME_OVER = 402;
        public static final int USER_INPUT_ERROR = 100;
        public static final int EXIT = 500;
    }
}
