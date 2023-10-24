/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import common.Algorithm;
import view.Menu;

/**
 *
 * @author Admin
 */
public class InputStringProgram extends Menu<String>{
    static String[] options = {"Input", "Result", "Exit"};
    Algorithm ar;

    public InputStringProgram() {
        super("==== ANALYSIS STRING PROGRAM =====", options);
        ar = new Algorithm();
    }
    @Override
    public void execute(int n) {
        switch(n) {
            case 1: ar.getInput();
                break;
            case 2: ar.getResult();
                break;
            case 3: System.exit(0);
                break;
        }
    }
}
