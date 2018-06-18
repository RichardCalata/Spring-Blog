package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyFirstController {
    @GetMapping("/say-hello")
    public @ResponseBody String myFirstSpringView(){
    return "Hello From Spring";
    }


    @GetMapping("/say-hello/{name}")
    public @ResponseBody String sayHello(@PathVariable String name){
        return String.format("Hello %s", name);
    }
}
