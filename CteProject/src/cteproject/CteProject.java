/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cteproject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author shiko
 */
public class CteProject {

    public static boolean isNone = true;
    public static int count =0;
    public static int controler =0;
    public static Scanner kb = new Scanner(System.in);
    
    public static String subt1;
    public static String subt2;
    
    public static String divt1;
    public static String divt2;
    
    public static String mult1;
    public static String mult2;
    
    public static String addt1;
    public static String addt2;
    
    public static String t1;
    public static String t2;
    public static String t3;
    public static String t4;
    
    public static String DIV;
    public static String MUL;
    public static String SUB;
    public static String ADD;
    
    public static String DIV_STR;
    public static String DIV_LDA;
    
    public static String MUL_STR;
    public static String MUL_LDA;
    
    public static String SUB_STR;
    public static String SUB_LDA;
    
    public static String ADD_STR;
    public static String ADD_LDA;
    
    public static String D_CODE="01000100";
    public static String M_CODE="01001101";
    public static String S_CODE="01010011";
    public static String A_CODE="01000001";
    public static String T_CODE="01010100";
    
    public static boolean isError = false;
    
    public static ArrayList<String> tokens = new ArrayList<>();
    public static Errors errors = new Errors();
    public static ArrayList<String> newlist = new ArrayList<>();
    public static String word ="";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String BLUE = "\u001B[34m";
    public static String TRY = "\u001B[35m";
    
    public static boolean ready = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       landingpage();
    }
    
    public static void landingpage(){
        System.out.println("      WELCOME TO CLEVER-PROGRAMMER COMPILER");
        System.out.println("\nCHOOSE ONE OF THIS OPTIONS: \n\n1 - LINE BY LINE COMPILER\n\n2 - ALL AT ONCE COMPILER");
        
        String option = kb.nextLine();
        if(option.equals("1")){
            lineByLine();
        }
        else if(option.equals("2")){
            allAtOnce();
        }
        else if(option.equals("99")){
            System.out.println("NICE TO MEET YOU !!!");
        }
        else{
            System.out.println(RED+"\nPLEASE CHOOSE ONE OF THIS OPTIONS: \n\n1 - LINE BY LINE COMPILER\n\n2 - ALL AT ONCE COMPILER");
        }
    }
    
    public static void allAtOnce(){
        System.out.println(TRY+"NB\nEnter key-word RUN or run to execute after entering your desired words !!!\n\n");
        
        
        // getting string from a user !!!
       
        tokens.removeAll(tokens);
        while(!word.equalsIgnoreCase("RUN")){
            System.out.print(BLUE+"Enter your next word: ");
            word = kb.nextLine();
            if(word.equalsIgnoreCase("run")){
                
            }
            else{
                tokens.add(word);
            }
        }
        
        for(int i =0; i<tokens.size(); i++){
            
            String token = tokens.get(i);
            int size = token.length();
            System.out.println("\nword "+i+" "+token+"\n");
            
            
            // calling our functions for error checking, this functions return true if an eror occured and false if no error !!!
            // and if an error occured we will throw an error for user understanding.
            if(errors.isKeyword(token)){
                System.out.println(TRY+token.toUpperCase()+" is one of acceptable keywords *INTEGER, ASSIGN, READ, WRITE, START, STOP*");
                isError = false;
            }
            if( errors.isMisspeling(token)){
                System.out.println(RED+"LEXICAL ERROR- "+token.toUpperCase()+" should be a Misspelling of keyword WRITE.");
                isError = false;
            }
            if(errors.isContainSpace(token)){
                System.out.println(RED+"SYNTAX ERROR- "+token+" must not have space between");
                isError = false;
            }
            if(errors.isContainSympols(token)){
                System.out.println(TRY+"SYMBOL FOUND- "+token+" must not contain = or ;");
                isError = false;
            }
            
                for(int j =0; j<size; j++){
                    String chr = ""+token.charAt(j);
                    newlist.add(chr);
                }
               
                
                if(errors.isNum(newlist)){
                    System.out.println(RED+"SYNTAX ERROR- Numbers 0,1 to 9 are not allowed. String should contain A to Z and a to z & operators +,-,*,/");
                    isError = false;
                }
                if(errors.isTwoSighn(newlist)){
                    System.out.println(RED+"SEMANTIC ERROR- two operators (*,-,+,/) or Identifier (A to Z and a to z) cannot be written together!");
                    isError = false;
                }
                if(errors.isTwoletter(newlist)){
                    System.out.println(RED+"SEMANTIC ERROR- two operators (*,-,+,/) or Identifier (A to Z and a to z) cannot be written together!");
                    isError = false;
                }
                if (errors.isSpecialChar(newlist)){
                    System.out.println(RED+"SYNTAX ERROR- Use of Special Characters ie &, &&, $, %, !, , etc, not permitted.");
                    isError = false;
                }

            // if there is no error we call our operational function !!!
                
            if(!ready){
                System.out.println("\n");
                newlist.removeAll(newlist);
                ready = true;
                
            }
            else {
                 // inserting tokens into our array list called newlist !!!
                
               
                operation(newlist);
                newlist.removeAll(newlist);
                
            }
            
        }
        
    }
    
    
    public static void lineByLine(){
        
        // getting string from a user !!!
        System.out.print(BLUE+"Enter a word: ");
        word = kb.nextLine();
         
        
        // if a user enter 99 the program will end !!!
        if (!word.equals("99")){
            int size = word.length();
            
            // calling our functions for error checking, this functions return true if an eror occured and false if no error !!!
            // and if an error occured we will throw an error for user understanding.
            if(errors.isKeyword(word)){
                System.out.println(TRY+word.toUpperCase()+" is one of acceptable keywords *INTEGER, ASSIGN, READ, WRITE, START, STOP*");
                isError = false;
            }
            if( errors.isMisspeling(word)){
                System.out.println(RED+"LEXICAL ERROR- "+word.toUpperCase()+" should be a Misspelling of keyword WRITE.");
                isError = false;
            }
            if(errors.isContainSpace(word)){
                System.out.println(RED+"SYNTAX ERROR- "+word+" must not have space between");
                isError = false;
            }
            if(errors.isContainSympols(word)){
                System.out.println(TRY+"SYMBOL FOUND- "+word+" must not contain = or ;");
                isError = false;
            }
            
                for(int i =0; i<size; i++){
                    String chr = ""+word.charAt(i);
                    tokens.add(chr);
                }
               
                
                if(errors.isNum(tokens)){
                    System.out.println(RED+"SYNTAX ERROR- Numbers 0,1 to 9 are not allowed. String should contain A to Z and a to z & operators +,-,*,/");
                    isError = false;
                }
                if(errors.isTwoSighn(tokens)){
                    System.out.println(RED+"SEMANTIC ERROR- two operators (*,-,+,/) or Identifier (A to Z and a to z) cannot be written together!");
                    isError = false;
                }
                if(errors.isTwoletter(tokens)){
                    System.out.println(RED+"SEMANTIC ERROR- two operators (*,-,+,/) or Identifier (A to Z and a to z) cannot be written together!");
                    isError = false;
                }
                if (errors.isSpecialChar(tokens)){
                    System.out.println(RED+"SYNTAX ERROR- Use of Special Characters ie &, &&, $, %, !, , etc, not permitted.");
                    isError = false;
                }

            // if there is no error we call our operational function !!!
                
            if(!ready){
                System.out.println("\n");
                tokens.removeAll(tokens);
                ready = true;
                anothertrasection();
            }
            else {
                 // inserting tokens into our array list called newlist !!!
                for(int i =0; i<size; i++){
                    String chr = ""+word.charAt(i);
                    newlist.add(chr);
                }
               
                operation(newlist);
                tokens.removeAll(tokens);
                anothertrasection();
                
            }
            
        }
        else {
            System.out.println(GREEN+"Good bye !!!");
        }
        
    }
    
    public static void anothertrasection(){
        lineByLine();
    }
    
    
    
    public static void operation(ArrayList<String> words){
        
        System.out.println(BLUE+"======STAGE1: COMPILER TECHNIQUES--> LEXICAL ANALYSIS-Scanner\n" +
        "\n" +
        "SYMBOL TABLE COMPRISING ATTRIBUTES AND TOKENS:");

        String word = "";

        for(String wordchr : words){
            word =word+wordchr;
        }
        
        for(String letter : words) {
            
            if(letter.equalsIgnoreCase("+") || letter.equalsIgnoreCase("-") || letter.equalsIgnoreCase("/") || letter.equalsIgnoreCase("*")){
                System.out.println(BLUE+"TOKEN#"+(count)+" "+letter+" Operator                                                              ");
            }
            else {
                System.out.println(BLUE+"TOKEN#"+(count)+" "+letter+" Identifier                                                            ");
            }
            
            count++;
        }
        System.out.println(BLUE+"Total number of Tokens: "+words.size());
        System.out.println(GREEN+"The Grammar and Production rules:\nE -> E\nE -> |E+E|E/E|E*E|E+E|\nE -> E1|E2|E3|E4...E26\n [E1|E2|E3|...|E26] -> {A|B|C|...|Z|a|b|c...|z]}");
        
        parser(words);
        Semantic();
        ICG(words);
        
        System.out.println("\n");
        
    }
    
    // parser syntax
    public static void parser(ArrayList<String> words){
        System.out.println("\n"+BLUE+"============STAGE2: SYNTAX ANALYSIS \n\n");
        String word = "";

        for(String wordchr : words){
            word =word+wordchr;
        }

        String deriv;
        switch (word.length()) {
            case 3:
                deriv = "E\n" +
                        "E" + word.charAt(1) + "E\n" +
                        "E1" + word.charAt(1) + "E\n" +
                        "E1" + word.charAt(1) + "E2\n" +
                        word.charAt(0) + word.charAt(1) + "E2\n" +
                        word + "\t\t\t" + "The final string";
                break;
            case 5:
                deriv = "E\n" +
                        "E" + word.charAt(1) + "E\n" +
                        "E" + word.charAt(1) + "E" + word.charAt(3) + "E\n" +
                        "E1" + word.charAt(1) + "E" + word.charAt(3) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E3\n" +
                        word.charAt(0) + word.charAt(1) + "E2" + word.charAt(3) + "E3\n" +
                        word.charAt(0) + word.charAt(1) + word.charAt(2) + word.charAt(3) + "E3\n" +
                        word + "\t\t\t" + "The final string";
                break;
            case 7:
                deriv = "E\n" +
                        "E" + word.charAt(1) + "E\n" +
                        "E" + word.charAt(1) + "E" + word.charAt(3) + "E\n" +
                        "E" + word.charAt(1) + "E" + word.charAt(3) + "E" + word.charAt(5) + "E\n" +
                        "E1" + word.charAt(1) + "E" + word.charAt(3) + "E" + word.charAt(5) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E" + word.charAt(5) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E3" + word.charAt(5) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E3" + word.charAt(5) + "E4\n" +
                        word.charAt(0) + word.charAt(1) + "E2" + word.charAt(3) + "E3" + word.charAt(5) + "E4\n" +
                        word.charAt(0) + word.charAt(1) + word.charAt(2) + word.charAt(3) + "E3" + word.charAt(5) + "E4\n" +
                        word.charAt(0) + word.charAt(1) + word.charAt(2) + word.charAt(3) + word.charAt(4) + word.charAt(5) + "E4\n" +
                        word + "\t\t\t" + "The final string";
                break;
            case 9:
                deriv = "E\n" +
                        "E" + word.charAt(1) + "E\n" +
                        "E" + word.charAt(1) + "E" + word.charAt(3) + "E\n" +
                        "E" + word.charAt(1) + "E" + word.charAt(3) + "E" + word.charAt(5) + "E\n" +
                        "E" + word.charAt(1) + "E" + word.charAt(3) + "E" + word.charAt(5) + "E" + word.charAt(7) + "E\n" +
                        "E1" + word.charAt(1) + "E" + word.charAt(3) + "E" + word.charAt(5) + "E" + word.charAt(7) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E" + word.charAt(5) + "E" + word.charAt(7) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E3" + word.charAt(5) + "E" + word.charAt(7) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E3" + word.charAt(5) + "E4" + word.charAt(7) + "E\n" +
                        "E1" + word.charAt(1) + "E2" + word.charAt(3) + "E3" + word.charAt(5) + "E4" + word.charAt(7) + "E5\n" +
                        word.charAt(0) + word.charAt(1) + "E2" + word.charAt(3) + "E3" + word.charAt(5) + "E4" + word.charAt(7) + "E5\n" +
                        word.charAt(0) + word.charAt(1) + word.charAt(2) + word.charAt(3) + "E3" + word.charAt(5) + "E4" + word.charAt(7) + "E5\n" +
                        word.charAt(0) + word.charAt(1) + word.charAt(2) + word.charAt(3) + word.charAt(4) + word.charAt(5) + "E4" + word.charAt(7) + "E5\n" +
                        word.charAt(0) + word.charAt(1) + word.charAt(2) + word.charAt(3) + word.charAt(4) + word.charAt(5) + word.charAt(6) + word.charAt(7) + "E5\n" +
                        word + "\t\t\t" + "The final string";
                break;
            default:
                deriv = "Something wrong";
                break;
        }
        System.out.println(deriv);

    }
    
    public static void Semantic(){
        System.out.println("\n"+BLUE+"======STAGE3: COMPILER TECHNIQUES--> SEMANTIC\n" +
        "\n" +
        "INPUT STRING: "+word);
        
        System.out.println("EXPRESION: "+word+" IS SYNTACTICALLY AND SEMANTICALLY VALID");
    }
    
    public static void ICG(ArrayList<String> words){
        
        
        System.out.println("\n"+BLUE+"======STAGE4: COMPILER TECHNIQUES--> ITERMEDIATE CODE GENERATION\n");
        word="";
        for(String wordchr : words){
            word = word+wordchr;
        }

        System.out.println("Input String: "+word+"\n");

        
        int newsize = (words.size()-1);
        
        count =0;
        controler =0;
        while(count<newsize){
            for (int i = 0; i < newsize; i++) {
                if (word.charAt(i) == '/') {
                    divt1 = ""+ word.charAt(i-1);
                    divt2 = ""+ word.charAt(i + 1);
                    controler++;
                    System.out.println("t" + controler + "= " + divt1 + word.charAt(i) + divt2);
                    DIV_LDA = "LDA " + word.charAt(i + 1);
                    DIV = "DIV " + word.charAt(i - 1);
                    t1 = "STR t" + controler;
                    DIV_STR = "DIV t" + controler + ", " + divt2 + ", " + divt1;
                    isNone = false;
                } 
            }
            
            isNone = true;
            for (int j = 0; j < newsize; j++) {
                if (word.charAt(j) == '*') {
                    mult1 = ""+word.charAt(j - 1);
                    mult2 = ""+word.charAt(j + 1);
                    
                    if(mult1.equalsIgnoreCase(divt1) || mult1.equalsIgnoreCase(divt2)){
                        controler++;
                        System.out.println("t" + controler + "= " + "t"+(controler-1) + word.charAt(j) + mult2);
                        MUL_LDA = "LDA t1";
                        MUL = "MUL " + mult2;
                        t2 = "STR t" + controler;
                        MUL_STR = "MUL t" + controler + ", " + "t"+(controler-1) + ", " + mult2;
                        isNone = false;
                    }
                    if(mult2.equalsIgnoreCase(divt1) || mult2.equalsIgnoreCase(divt2)){
                        controler++;
                        System.out.println("t" + controler + "= " + mult1 + word.charAt(j) + "t"+(controler-1));
                        MUL_LDA = "LDA " + mult2;
                        MUL = "MUL t1";
                        t2 = "STR t" + controler;
                        MUL_STR = "MUL t" + controler + ", " + mult1 + ", " + "t"+(controler-1);
                        isNone = false;
                    }
                    
                    if(isNone){
                        controler++;
                        System.out.println("t" + controler + "= " + mult1 + word.charAt(j) + mult2);
                        MUL_LDA = "LDA " + mult1;
                        MUL = "MUL "+ mult2;
                        t3 = "STR t" + controler;
                        MUL_STR = "MUL t" + controler + ", " + mult1 + ", " + mult2;
                    } 
                }
            }
            isNone =true;
            for (int j = 0; j < newsize; j++) {
                if (word.charAt(j) == '+') {
                    addt1 = ""+word.charAt(j - 1);
                    addt2 = ""+word.charAt(j + 1);
                    
                    if(addt1.equalsIgnoreCase(divt1) || addt1.equalsIgnoreCase(divt2)){
                        controler++;
                        System.out.println("t" + controler + "= " + "t"+(controler-2) + word.charAt(j) + addt2);
                        ADD_LDA = "LDA t1";
                        ADD = "ADD " + addt2;
                        t3 = "STR t" + controler;
                        ADD_STR = "ADD t" + controler + ", " + "t"+(controler-2) + ", " + addt2;
                        isNone = false;
                    }
                    
                    if((addt1.equalsIgnoreCase(mult1) || addt1.equalsIgnoreCase(mult2)) && (addt2.equalsIgnoreCase(divt1) || addt2.equalsIgnoreCase(divt2))){
                        controler++;
                        System.out.println("t" + controler + "= " + "t"+(controler-1) + word.charAt(j) + "t"+(controler-2));
                        ADD_LDA = "LDA t2";
                        ADD = "ADD " + addt2;
                        t3 = "STR t" + controler;
                        ADD_STR = "ADD t" + controler + ", " + "t"+(controler-1) + ", " + addt2;
                        isNone = false;
                    }
                    if((addt1.equalsIgnoreCase(divt1) || addt1.equalsIgnoreCase(divt2)) && (addt2.equalsIgnoreCase(mult1) || addt2.equalsIgnoreCase(mult2))){
                        controler++;
                        System.out.println("t" + controler + "= " + "t"+(controler-2) + word.charAt(j) + "t"+(controler-1));
                        ADD_LDA = "LDA t2";
                        ADD = "ADD " + addt2;
                        t3 = "STR t" + controler;
                        ADD_STR = "ADD t" + controler + ", " + "t"+(controler-1) + ", " + addt2;
                        isNone = false;
                    }
                    
                    if((addt2.equalsIgnoreCase(mult1) || addt2.equalsIgnoreCase(mult2)) &&(!addt2.equalsIgnoreCase(divt1) || !addt2.equalsIgnoreCase(divt2))){
                        controler++;
                        System.out.println("t" + controler + "= " + "t"+(controler-1) + word.charAt(j) + addt1);
                        ADD_LDA = "LDA t2";
                        ADD = "ADD "+addt1;
                        t3 = "STR t" + controler;
                        ADD_STR = "ADD t" + controler + ", " + "t"+(controler-1) + ", " + addt1;
                        isNone = false;
                    }
                    
                    if(isNone){
                        controler++;
                        System.out.println("t" + controler + "= " + addt1 + word.charAt(j) + addt2);
                        ADD_LDA = "LDA " + addt1;
                        ADD = "ADD "+ addt2;
                        t3 = "STR t" + controler;
                        ADD_STR = "ADD t" + controler + ", " + addt1 + ", " + addt2;
                    } 
                }
            }
            
            isNone =true;
            for (int j = 0; j < newsize; j++) {
                if (word.charAt(j) == '-') {
                    subt1 = ""+word.charAt(j - 1);
                    subt2 = ""+word.charAt(j + 1);
                    
                    if(subt1.equalsIgnoreCase(divt1) || subt1.equalsIgnoreCase(divt2)){
                        controler++;
                        System.out.println("t" + controler + "= " + "t"+(controler-3) + word.charAt(j) + subt2);
                        SUB_LDA = "LDA t1";
                        SUB = "SUB " + subt2;
                        t4 = "STR t" + controler;
                        SUB_STR = "SUB t" + controler + ", " + "t"+(controler-3) + ", " + subt2;
                        isNone = false;
                    }
                    if((subt2.equalsIgnoreCase(divt1) || subt2.equalsIgnoreCase(divt2))){
                        controler++;
                        System.out.println("t" + controler + "= " + subt1 + word.charAt(j) + "t"+(controler-3));
                        SUB_LDA = "LDA " + subt1;
                        SUB = "SUB t1";
                        t4 = "STR t" + controler;
                        SUB_STR = "SUB t" + controler + ", " + subt1 + ", " + "t"+(controler-3);
                        isNone = false;
                    }
                    
                    if((subt1.equalsIgnoreCase(mult1) || subt1.equalsIgnoreCase(mult2)) && (subt2.equalsIgnoreCase(divt1) || subt2.equalsIgnoreCase(divt2))){
                        controler++;
                        System.out.println("t" + controler + "= " + "t"+(controler-2) + word.charAt(j) + "t"+(controler-3));
                        SUB_LDA = "LDA t2";
                        SUB = "SUB " + subt2;
                        t4 = "STR t" + controler;
                        SUB_STR = "SUB t" + controler + ", " + "t"+(controler-2) + ", " + subt2;
                        isNone = false;
                    }
                    if((subt1.equalsIgnoreCase(divt1) || subt1.equalsIgnoreCase(divt2)) && (subt2.equalsIgnoreCase(mult1) || subt2.equalsIgnoreCase(mult2))){
                        controler++;
                        System.out.println("t" + controler + "= " + "t"+(controler-3) + word.charAt(j) + "t"+(controler-2));
                        SUB_LDA = "LDA t2";
                        SUB = "SUB " + subt2;
                        t4 = "STR t" + controler;
                        SUB_STR = "SUB t" + controler + ", " + "t"+(controler-2) + ", " + subt2;
                        isNone = false;
                    }
                    
                    if((subt2.equalsIgnoreCase(mult1) || subt2.equalsIgnoreCase(mult2)) &&(!subt1.equalsIgnoreCase(divt1) || !subt1.equalsIgnoreCase(divt2))){
                        controler++;
                        System.out.println("t" + controler + "= " + subt1 + word.charAt(j) + "t"+(controler-1));
                        SUB_LDA = "LDA " + subt1;
                        SUB = "SUB t2";
                        t4 = "STR t" + controler;
                        SUB_STR = "SUB t" + controler + ", " + subt1 + ", " + "t"+(controler-1);
                        isNone = false;
                    }
                    
                    if(isNone){
                        controler++;
                        System.out.println("t" + controler + "= " + subt1 + word.charAt(j) + subt2);
                        SUB_LDA = "LDA " + subt1;
                        SUB = "SUB "+ subt2;
                        t4 = "STR t" + controler;
                        SUB_STR = "SUB t" + controler + ", " + subt1 + ", " + subt2;
                    } 
                }
            }
            
            break;
        }
        ICR(words);
    }
    
    public static void ICR(ArrayList<String> words){
        System.out.println(" ");
        System.out.println(BLUE+"==============STAGE 5: CODE GENERATION  ");
        
        if(words.contains("/")){
            System.out.println(DIV_LDA);
            System.out.println(DIV);
            System.out.println(t1);
        }
        System.out.println("");
        if(words.contains("*")){
            System.out.println(MUL_LDA);
            System.out.println(MUL);
            System.out.println(t2);
        }
        System.out.println("");
        if(words.contains("+")){
            System.out.println(ADD_LDA);
            System.out.println(ADD);
            System.out.println(t3);
        }
        System.out.println("");
        if(words.contains("-")){
            System.out.println(SUB_LDA);
            System.out.println(SUB);
            System.out.println(t4);
        }
        
        COP(words);
        
    }
    
    public static void COP(ArrayList<String> words){
        System.out.println(" ");
        System.out.println(BLUE+"============STAGE 6: CODE OPTIMISATION  ");
        
        if(words.contains("/")){
            System.out.println(DIV_STR);
        }
        if(words.contains("*")){
            System.out.println(MUL_STR);
        }
        if(words.contains("+")){
            System.out.println(ADD_STR);
        }
        if(words.contains("-")){
            System.out.println(SUB_STR);
        }

        MCD(words);
        
    }

    public static void MCD(ArrayList<String> words){
        System.out.println(" ");
        System.out.println(BLUE+"============STAGE 7: CODE OPTIMISATION  ");
        
        if(words.contains("/")){
            System.out.print(D_CODE);
            System.out.print(" "+T_CODE+" ");
            System.out.print(" "+toBinary(""+DIV_LDA.charAt(4), 8));
            System.out.print(" "+toBinary(""+DIV.charAt(4), 8));
        }
        System.out.println("");
        if(words.contains("*")){
            System.out.print(M_CODE);
            System.out.print(" "+T_CODE+" ");
            System.out.print(" "+toBinary(""+MUL_LDA.charAt(4), 8));
            System.out.print(" "+toBinary(""+MUL.charAt(4), 8));
        }
        System.out.println("");
        if(words.contains("+")){
            System.out.print(A_CODE);
            System.out.print(" "+T_CODE+" ");
            System.out.print(" "+toBinary(""+ADD_LDA.charAt(4), 8));
            System.out.print(" "+toBinary(""+ADD.charAt(4), 8));
        }
        System.out.println("");
        if(words.contains("-")){
            System.out.print(S_CODE);
            System.out.print(" "+T_CODE+" ");
            System.out.print(" "+toBinary(""+SUB_LDA.charAt(4), 8));
            System.out.print(" "+toBinary(""+SUB.charAt(4), 8));
        }

        System.out.println("\n\n================================");
        System.out.println(BLUE+"            DONE ");
        System.out.println("================================\n\n");

        reset();
        
    }

    public static String toBinary(String str, int bits) {
        String result = "";
        String tmpStr;
        int tmpInt;
        char[] messChar = str.toCharArray();
    
        for (int i = 0; i < messChar.length; i++) {
            tmpStr = Integer.toBinaryString(messChar[i]);
            tmpInt = tmpStr.length();
            if(tmpInt != bits) {
                tmpInt = bits - tmpInt;
                if (tmpInt == bits) {
                    result += tmpStr;
                } else if (tmpInt > 0) {
                    for (int j = 0; j < tmpInt; j++) {
                        result += "0";
                    }
                    result += tmpStr;
                } else {
                    System.err.println("argument 'bits' is too small");
                }
            } else {
                result += tmpStr;
            }
            result += " "; // separator
        }
    
        return result;
    }

    public static void reset() {
        newlist.removeAll(newlist);

    }
}

