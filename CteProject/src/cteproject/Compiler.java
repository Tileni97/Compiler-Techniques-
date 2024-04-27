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
public interface Compiler {
    public boolean isNum(ArrayList<String> word);
    public boolean isSpecialChar(ArrayList<String> word);
    public boolean isTwoSighn(ArrayList<String> word);
    public boolean isTwoletter(ArrayList<String> word);
    public boolean isMisspeling(String word);
    public boolean isKeyword(String word);
    public boolean isContainSpace(String word);
    public boolean isContainSympols(String word);
}
