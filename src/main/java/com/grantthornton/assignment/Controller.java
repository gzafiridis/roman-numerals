package com.grantthornton.assignment;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello!\nTo test this REST interface, either send a POST request to /integer-to-roman with an integer"
                + " parameter named number, or a POST request to /roman-to-integer with a String parameter"
                + "named romanNumberString.\nHave fun!";
    }

    @RequestMapping(value = "/integer-to-roman", method = RequestMethod.POST)
    public String convertInteger(@RequestBody IntToRomanRequest request) {
        return new RomanNumeralGenerator().generate(request.number);
    }

    @RequestMapping(value = "/roman-to-integer", method = RequestMethod.POST)
    public int convertString(@RequestBody RomanToIntRequest request) {
        return new RomanNumeralGenerator().parse(request.romanNumberString);
    }
}
