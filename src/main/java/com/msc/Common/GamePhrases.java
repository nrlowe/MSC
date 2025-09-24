package com.msc.Common;

public class GamePhrases {
    public class GameMessages {
        public static final String INTRO_TEXT = "To begin please input the size of the grid and number of mines";
        public static final String INPUT_HELP_TEXT = "All entries should be in the pattern of 'NUM,NUM' with no space";
        public static final String USER_INPUT_ERROR = "Input was in incorrect format";
        public static final String USER_MOVE_ERROR = "Not a valid move!";
        public static final String USER_MOVE_REG = "GameBoard Updated!";
    }
    public class GameCodes {
        public static final int SUCCESS = 400;
        public static final int SUCCESS_MOVE = 401;
        public static final int USER_INPUT_ERROR = 100;
    }
}
