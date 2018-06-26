package com.codeup.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceRoller {
    @GetMapping("/roll")
    public String startGame() {

        return "roll-dice";
    }


    @GetMapping("roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {

        int diceRoll = (int) Math.ceil(Math.random() * 6);
        String droll = String.valueOf(diceRoll);
        model.addAttribute("result",diceRoll);
        System.out.println(diceRoll);
        System.out.println(droll);
        return "diceResult";
    }
}