package com.grantthornton.assignment;

import java.util.HashMap;

public class RomanNumeralGenerator implements RomanNumeralGeneratorInterface {

    private String convertDigitToRoman(int digit, String[] roman) {
        String result = "";

        if (digit < 4) {
            for (; digit > 0; digit--)
                result += roman[0];
        }
        else if (digit == 4)
            result = roman[0] + roman[1];
        else if (digit < 9){
            result = roman[1];
            for (; digit-5 > 0; digit--)
                result += roman[0];
        }
        else
            result = roman[0] + roman[2];

        return result;
    }

    @Override
    public String generate(int number) {
        if (number < 1 || number > 3999) {
            System.out.println("The requested number is out of range");
            return "Out of range";
        }
        int thousands = number/1000;
        int hundreds = (number%1000)/100;
        int tens = (number%100)/10;
        int units = number%10;
        String output = "";

        for (; thousands > 0; thousands--) {
            output += "M";
        }
        String[] romanLetters = {"C","D","M"};
        output += convertDigitToRoman(hundreds, romanLetters);
        romanLetters = new String[] {"X","L","C"};
        output += convertDigitToRoman(tens, romanLetters);
        romanLetters = new String[] {"I","V","X"};
        output += convertDigitToRoman(units, romanLetters);

        return output;
    }

    @Override
    public int parse(String romanNumber) {
        boolean valid = romanNumber.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        if (!valid) {
            System.out.println("Bad input");
            return -1;
        }
        if (romanNumber == "") {
            System.out.println("Bad input");
            return -1;
        }

        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('M', 1000);
        romanValues.put('D', 500);
        romanValues.put('C', 100);
        romanValues.put('L', 50);
        romanValues.put('X', 10);
        romanValues.put('V', 5);
        romanValues.put('I', 1);

        int output = 0;
        char letter = romanNumber.charAt(0);
        int value1, value2;
        value1 = romanValues.getOrDefault(letter, 0);
        if (value1 == 0) {
            System.out.println("Bad input");
            return -1;
        }
        for (int i = 1; i < romanNumber.length(); i++) {
            letter = romanNumber.charAt(i);
            value2 = romanValues.getOrDefault(letter, 0);
            if (value2 == 0) {
                System.out.println("Bad input");
                return -1;
            }
            if (value2 > value1)
                output -= value1;
            else
                output += value1;

            value1 = value2;
        }

        output += value1;
        return output;
    }
}
