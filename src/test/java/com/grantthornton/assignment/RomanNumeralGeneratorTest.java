package com.grantthornton.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralGeneratorTest {

    @Test
    public void generateOutOfRangeInput() {
        String expected = "Out of range";
        RomanNumeralGenerator generator = new RomanNumeralGenerator();

        String actual = generator.generate(0);
        assertEquals(expected , actual);

        actual = generator.generate(-100);
        assertEquals(expected, actual);

        actual = generator.generate(4000);
        assertEquals(expected, actual);

        actual = generator.generate(5672);
        assertEquals(expected, actual);
    }

    @Test
    public void generate1DigitNumbers() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();
        String expected = "IV";
        String actual = generator.generate(4);
        assertEquals(expected , actual);

        expected = "VIII";
        actual = generator.generate(8);
        assertEquals(expected , actual);

        expected = "IX";
        actual = generator.generate(9);
        assertEquals(expected , actual);
    }

    @Test
    public void generate2DigitNumbers() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();
        String expected = "XLVI";
        String actual = generator.generate(46);
        assertEquals(expected , actual);

        expected = "LXXXIII";
        actual = generator.generate(83);
        assertEquals(expected , actual);

        expected = "XCV";
        actual = generator.generate(95);
        assertEquals(expected , actual);
    }

    @Test
    public void generate3DigitNumbers() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();
        String expected = "CDXXXII";
        String actual = generator.generate(432);
        assertEquals(expected , actual);

        expected = "DCCCXVII";
        actual = generator.generate(817);
        assertEquals(expected , actual);

        expected = "CMLXXI";
        actual = generator.generate(971);
        assertEquals(expected , actual);
    }

    @Test
    public void generate4DigitNumbers() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();
        String expected = "MCCCXXVIII";
        String actual = generator.generate(1328);
        assertEquals(expected , actual);

        expected = "MMDCCCXCI";
        actual = generator.generate(2891);
        assertEquals(expected , actual);

        expected = "MMMCMXCIX";
        actual = generator.generate(3999);
        assertEquals(expected , actual);
    }

    @Test
    public void parseInvalidRomanStrings() {
        int expected = -1;
        RomanNumeralGenerator generator = new RomanNumeralGenerator();

        int actual = generator.parse("MCaXIV");
        assertEquals(expected, actual);

        actual = generator.parse("");
        assertEquals(expected, actual);

        actual = generator.parse("  MMCDXIV");
        assertEquals(expected, actual);

        actual = generator.parse("  XIV  ");
        assertEquals(expected, actual);

        actual = generator.parse("MXMID");
        assertEquals(expected, actual);

        actual = generator.parse("XVDID");
        assertEquals(expected, actual);

        actual = generator.parse("VDIL");
        assertEquals(expected, actual);

        actual = generator.parse("MMMMXIV");
        assertEquals(expected, actual);

        actual = generator.parse("MMCCCCVV");
        assertEquals(expected, actual);

        actual = generator.parse("DDLIX");
        assertEquals(expected, actual);
    }

    @Test
    public void parseRomanNumbersBelow10() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();
        int expected = 4;
        int actual = generator.parse("IV");
        assertEquals(expected, actual);

        expected = 8;
        actual = generator.parse("VIII");
        assertEquals(expected, actual);

        expected = 9;
        actual = generator.parse("IX");
        assertEquals(expected, actual);
    }

    @Test
    public void parseRomanNumbersBetween9And100() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();
        int expected = 46;
        int actual = generator.parse("XLVI");
        assertEquals(expected, actual);

        expected = 83;
        actual = generator.parse("LXXXIII");
        assertEquals(expected, actual);

        expected = 95;
        actual = generator.parse("XCV");
        assertEquals(expected, actual);
    }

    @Test
    public void parseRomanNumbersBetween99And1000() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();
        int expected = 432;
        int actual = generator.parse("CDXXXII");
        assertEquals(expected, actual);

        expected = 817;
        actual = generator.parse("DCCCXVII");
        assertEquals(expected, actual);

        expected = 971;
        actual = generator.parse("CMLXXI");
        assertEquals(expected, actual);
    }

    @Test
    public void parseRomanNumbersBetween999And4000() {
        RomanNumeralGenerator generator = new RomanNumeralGenerator();
        int expected = 1328;
        int actual = generator.parse("MCCCXXVIII");
        assertEquals(expected, actual);

        expected = 2891;
        actual = generator.parse("MMDCCCXCI");
        assertEquals(expected, actual);

        expected = 3999;
        actual = generator.parse("MMMCMXCIX");
        assertEquals(expected, actual);
    }
}
