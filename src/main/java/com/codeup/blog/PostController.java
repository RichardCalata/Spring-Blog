package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody public String index(){

        return "posts index page";
    }

    @RequestMapping("/posts/{id}")
    @ResponseBody public String post(@PathVariable long id){

        return "An individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "view the form for Creating a Post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "saving to the database";
    }
}
