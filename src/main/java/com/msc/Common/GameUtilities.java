package com.msc.Common;

public class GameUtilities {
    public int[] parseUserInput(String input) {
        int[] selection = new int[2];
        try{
            String[] split = input.split(",");
            if(split.length != 2){
                throw new IllegalArgumentException();
            } else {
                for(int i = 0; i < 2; i++){
                 selection[i] = Integer.parseInt(split[i]);
                }   
            }
        return selection;
        } catch (Exception e){
            System.out.println(GamePhrases.USER_INPUT_ERROR);
        }
        return selection;
    }

    public boolean validGameCell(int x, int y, int n){
        return false;
    }
}
