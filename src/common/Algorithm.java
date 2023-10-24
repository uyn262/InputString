/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.StringModel;

/**
 *
 * @author Admin
 */
public class Algorithm {
    Library l;
    StringModel strModel;
    public Algorithm() {
        l = new Library();
        strModel = new StringModel();
    }
    public void getInput() {
        String s = l.getString("Input String: ");
        strModel.setInputString(s);
    }
    public void getResult() {
        System.out.println("------- Result Analysis -------");
        HashMap<String, List<Integer>> hmNumber = new HashMap<>(); //hash map chứa số
        getResultNumber(hmNumber);
        HashMap<String, String> hmString = new HashMap<>(); //hashmap chứa chuỗi
        getResultString(hmString);
    }

    private void getResultNumber(HashMap<String, List<Integer>> hmNumber) {
        String number = strModel.getInputString().replaceAll("\\D+", ",");
        if (!number.isEmpty()) {
            if (number.charAt(0) == ',')
                number = number.substring(1);
            if (number.charAt(number.length() - 1) == ',')
                number = number.substring(0, number.length() - 1);
        }

        String[] listNumber = number.isEmpty() ? new String[0] : number.split(",");
        int lenNumber = listNumber.length;

        List<Integer> liPerfectSquare = new ArrayList<>();
        List<Integer> liOdd = new ArrayList<>();
        List<Integer> liEven = new ArrayList<>();
        List<Integer> liAll = new ArrayList<>();
        for (int i = 0; i < lenNumber; i++) {
            int numberCheck = Integer.parseInt(listNumber[i]);
            if (numberCheck % 2 == 1)
                liOdd.add(numberCheck);
            if (numberCheck % 2 == 0)
                liEven.add(numberCheck);
            if (checkSquareNumber(numberCheck))
                liPerfectSquare.add(numberCheck);
            liAll.add(numberCheck);
        }
        hmNumber.put("Perfect Square Numbers: ", liPerfectSquare);
        hmNumber.put("Odd Numbers: ", liOdd);
        hmNumber.put("Even Numbers: ", liEven);
        hmNumber.put("All Numbers: ", liAll);
        
        for (Map.Entry<String, List<Integer>> m : hmNumber.entrySet())
            System.out.println(m.getKey() + " " + m.getValue());
    }

    private void getResultString(HashMap<String, String> hmString) {
        String uppercase = strModel.getInputString().replaceAll("\\W|[0-9]|[a-z]", "");
        String lowercase = strModel.getInputString().replaceAll("\\W|[0-9]|[A-Z]", "");
        String special = strModel.getInputString().replaceAll("\\w", "");
        String allCharacter = strModel.getInputString().replaceAll("\\W", "");
        hmString.put("Uppercase: ", uppercase);
        hmString.put("Lowercase: ", lowercase);
        hmString.put("Special: ", special);
        hmString.put("All Character: ", allCharacter);

        for (Map.Entry<String, String> m : hmString.entrySet())
            System.out.println(m.getKey() + " " + m.getValue());
    }

    private boolean checkSquareNumber(int n) {
        double x =  Math.sqrt(n);
        return (x * x == n);
    }
}
