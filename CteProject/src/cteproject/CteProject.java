/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cteproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author shiko
 */
public class CteProject {
    
    public static boolean status = false;
    public static boolean isValid = false;
    public static int count =0;
    public static int size =0;
    public static int newanssize =0;
    public static String prev = "";
    public static boolean pass = false;
    public static int controler =0;
    public static Scanner kb = new Scanner(System.in);
    
    public static ArrayList<String> derived = new ArrayList<>();
    
    public static boolean isError = false;
    
    public static ArrayList<String> tokens = new ArrayList<>();
    public static Errors errors = new Errors();
    public static ArrayList<String> newlist = new ArrayList<>();
    public static String word ="";
    public static ArrayList<String> placeholder = new ArrayList<>();
    public static ArrayList<String> answerlist = new ArrayList<>();
    
    public static String YELLOW = "\u001B[33m";
    public static String RED = "\u001B[31m";
    public static String RESET = "\u001B[0m";
    public static String GREEN = "\u001B[32m";
    public static String BLUE = "\u001B[34m";
    public static String TRY = "\u001B[35m";
    
    public static boolean ready = true;
    public static boolean valid = false;

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
            System.out.println(token);
            
            
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
    
    
    
    public static void operation(ArrayList<String> word){
        
        System.out.println(BLUE+"======STAGE1: COMPILER TECHNIQUES--> LEXICAL ANALYSIS-Scanner\n" +
        "\n" +
        "SYMBOL TABLE COMPRISING ATTRIBUTES AND TOKENS:");
        
        for(String letter : word) {
            
            if(letter.equalsIgnoreCase("+") || letter.equalsIgnoreCase("-") || letter.equalsIgnoreCase("/") || letter.equalsIgnoreCase("*")){
                System.out.println(BLUE+"TOKEN#"+(count)+" "+letter+" Operator                                                              ");
            }
            else {
                System.out.println(BLUE+"TOKEN#"+(count)+" "+letter+" Identifier                                                            ");
            }
            
            count++;
        }
        System.out.println(BLUE+"Total number of Tokens: "+word.size());
        System.out.println(GREEN+"The Grammar and Production rules:\nE -> E\nE -> |E+E|E/E|E*E|E+E|\nE -> E1|E2|E3|E4...E26\n [E1|E2|E3|...|E26] -> {A|B|C|...|Z|a|b|c...|z]}");
        
        parser(word);
        Semantic();
        ICG(word);
        
        System.out.println("\n");
        
    }
    
    // parser syntax
    public static void parser(ArrayList<String> word){
        count =0;
        pass = false;
        String sgn [] = {"/","*","+","-"};
        String letter [] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayList<String> alpha = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        
        System.out.println("");
        
        System.out.println(BLUE+"======STAGE2: COMPILER TECHNIQUES--> SYNTAX ANALYSIS-Parser\n");
        System.out.print(BLUE+"GET A DERIVATION FOR : ");
        
        word.forEach((words) -> {
            System.out.print(GREEN+words);
        });
        
        alpha.addAll(Arrays.asList(letter));
        
        System.out.println("\n");
        
        for(String words: word){
            alpha.stream().filter((chr) -> (words.equalsIgnoreCase(chr))).map((chr) -> {
                pass = true;
                return chr;
            }).map((chr) -> {
                System.out.print(BLUE+"E"+(alpha.indexOf(chr)+1));
                return chr;
            }).map((chr) -> {
                answer.add(""+(alpha.indexOf(chr)+1));
                return chr;
            }).forEachOrdered((chr) -> {
                derived.add(words+(alpha.indexOf(chr)+1));
            });
            if(!pass){
                System.out.print(BLUE+" "+words+" ");
                answer.add(words);
                derived.add(words);
            }
            pass = false;
        }
        
        System.out.println("");
        derived.forEach((words) -> {
            System.out.print(TRY+words+" ");
        });
        
        System.out.println("");
        
        count = (answer.size()-1);
        
        while(count >= 0){
            answer.stream().filter((words) -> (words.equalsIgnoreCase(answer.get(count)))).forEachOrdered((_item) -> {
                derived.set(count, "digit");
            });
            derived.forEach((derv) -> {
                System.out.print(GREEN+derv+" ");
            });
            
            System.out.println("");
            
            count = count-2;
        }
        
        count = (answer.size()-1);
        
        while(count >= 0){
            answer.stream().filter((words) -> (words.equalsIgnoreCase(answer.get(count)))).forEachOrdered((words) -> {
                derived.set(count, words);
            });
            
            derived.forEach((derv) -> {
                System.out.print(GREEN+derv+" ");
            });
            
            System.out.println("");
            
            count = count-2;
        }
    }
    
    public static void Semantic(){
        System.out.println("\n"+BLUE+"======STAGE3: COMPILER TECHNIQUES--> SEMANTIC\n" +
        "\n" +
        "INPUT STRING: "+word);
        
        System.out.println("EXPRESION: "+word+" IS SYNTACTICALLY AND SEMANTICALLY VALID");
    }
    
    public static void ICG(ArrayList<String> words){
        
        
        System.out.println("\n"+BLUE+"======STAGE4: COMPILER TECHNIQUES--> ITERMEDIATE CODE GENERATION\n" +
        "\n" +
        "INPUT STRING: "+word);
        
        int newsize = (words.size()-1);
        
        count =0;
        while(count<newsize){
            controler =0;
            pass =false;
            for(String chr:words){
                if(!pass){
                    pass=true;
                    //continue;
                }
                else{
                    if(chr.equals("/")){
                        if(answerlist.isEmpty()){
                            answerlist.add("T"+count+prev+chr+words.get(controler+1));
                            System.out.println(answerlist.get(0));
                            break;
                        }
                        else{
                            size = answerlist.size();
                            answerlist.add("T"+count+prev+chr+words.get(controler+1));
                            System.out.println(answerlist.get(size-1));
                            break;
                        }
                    }
                }
                controler++;
                prev = chr;
            }
            
            count++;
            controler =0;
            pass = false;
            for(String chr:words){
                if(!pass){
                    pass=true;
                }
                else{
                    if(chr.equals("*")){
                        if(answerlist.isEmpty()){
                            answerlist.add("T"+count+prev+chr+words.get(controler+1));
                            System.out.println(answerlist.get(0));
                            break;
                        }
                        else{
                            size = answerlist.size();
                            answerlist.add("T"+count+prev+chr+words.get(controler+1));
                            System.out.println(answerlist.get(size-1));
                            break;
                        }
                    }
                }
                controler++;
                prev = chr;
            }
            
            count++;
            controler =0;
            pass = false;
            for(String chr:words){
                if(!pass){
                    pass=true;
                }
                else{
                    if(chr.equals("+")){
                        
                        if(answerlist.isEmpty()){
                            answerlist.add("T"+count+prev+chr+words.get(controler+1));
                            System.out.println(answerlist.get(0));
                            break;
                        }
                        else{
                            size = answerlist.size();
                            answerlist.add("T"+count+prev+chr+words.get(controler+1));
                            System.out.println(answerlist.get(size-1));
                            break;
                        }
                    }
                }
                controler++;
                prev = chr;
            }
            
            count++;
            controler =0;
            pass = false;
            for(String chr:words){
                if(!pass){
                    pass=true;
                }
                else{
                    if(chr.equals("-")){
                        if(answerlist.isEmpty()){
                            answerlist.add("T"+count+prev+chr+words.get(controler+1));
                            System.out.println(answerlist.get(0));
                        }
                        else{
                            size = answerlist.size();
                            answerlist.add("T"+count+prev+chr+words.get(controler+1));
                            System.out.println(answerlist.get(size-1));
                        }
                    }
                }
                controler++;
                prev = chr;
            }
            controler =0;
            pass = false;
            count++;
            break;
        }
        
    }
    
}
