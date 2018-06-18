package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
    @GetMapping("/")
    public @ResponseBody String landing(){

        String meow = "meow";
        return "This is the landing page "+ meow;
    }
}
