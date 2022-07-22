package com.grantthornton.assignment;

public interface RomanNumeralGeneratorInterface {
    public String generate(int number); // convert from int -> roman
    public int parse(String romanNumber); // convert from roman -> int
}
