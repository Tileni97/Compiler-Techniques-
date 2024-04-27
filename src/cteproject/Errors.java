/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cteproject;

import java.util.ArrayList;

/**
 *
 * @author shiko
 */
public class Errors extends CteProject implements Compiler{
    
    public static String prev = "";
    public static boolean pass = false;
    public static ArrayList<String> tokenholder = new ArrayList<>();

    @Override
    public boolean isNum(ArrayList<String> word) {
        
        String number [] = {"0","1","2","3","4","5","6","7","8","9"};
        for (String chr : number) {
            word.stream().filter((key) -> (key.equalsIgnoreCase(chr))).forEachOrdered((_item) -> {
                ready = false;
                isError = true;
            });
        }
        return isError;
    }

    @Override
    public boolean isSpecialChar(ArrayList<String> word) {
        
        String number [] = {"!","`","~","@","#","$","%","^","&",")","(",",","?"};
        for (String chr : number) {
            word.stream().filter((key) -> (key.equalsIgnoreCase(chr))).forEachOrdered((_item) -> {
                isError = true;
                ready = false;
            });
        }
        return isError;
    }

    @Override
    public boolean isTwoSighn(ArrayList<String> word) {
        
        String sgn [] = {"/","*","+","-"};

        for(String words: word) {
            if(!pass){
                pass = true;
                continue;
            }
            else
            {
                for(String sighn: sgn){
                    if(prev.equalsIgnoreCase(sighn)){
                        for (String chk: sgn){
                            if(words.equalsIgnoreCase(chk)){
                                isError = true;
                                ready = false;
                            }
                        }
                    }
                } 
            }
            prev = words;
        }
        pass = false;
        return isError;
    }

    @Override
    public boolean isTwoletter(ArrayList<String> word) {
        
        String letter [] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        for(String words: word) {
            if(!pass){
                pass = true;
                continue;
            }
            else
            {
                for(String sighn: letter){
                    if(prev.equalsIgnoreCase(sighn)){
                        for (String chk: letter){
                            if(words.equalsIgnoreCase(chk)){
                                isError = true;
                                ready = false;
                            }
                        }
                    }
                } 
            }
            prev = words;
        }
        pass = false;
        return isError;
    }

    @Override
    public boolean isMisspeling(String word) {
        
        String number [] = {"stopp","writee","integerr"};
        for (String chr : number) {
            if(chr.equalsIgnoreCase(word)){
                isError = true;
                ready = false;
            }
        }
        return isError;
    }

    @Override
    public boolean isKeyword(String word) {
        
        String number [] = {"Stop","Write","Integer","Assign","Read","Start"};
        for (String chr : number) {
            if(chr.equalsIgnoreCase(word)){
                isError = true;
                ready = false;
            }
        }
        return isError;
    }

    @Override
    public boolean isContainSpace(String word) {
        
        int wordsize = (word.length()-1);
        
        for(int i =0; i<wordsize; i++){
            if(word.charAt(i)==' '){
                isError = true;
                ready = false;
            }
        }
        return isError;
    }

    @Override
    public boolean isContainSympols(String word) {
        
        int wordsize = (word.length());
        char symbols [] = {'=',';'};
        
        for(int i =0; i<wordsize; i++){
            for(char symb: symbols){
                if(word.charAt(i)==symb){
                    isError = true;
                    ready = false;
                }
            }
        }
        
        return isError;
    }
    
}
