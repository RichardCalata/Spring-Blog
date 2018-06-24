package com.codeup.blog.controllers;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{x}/{y}")
    public @ResponseBody
    String add(@PathVariable int x, @PathVariable int y) {
        int sum = x + y;


        return String.format("The sum of %d and %d is %d", x,y,sum);

    }
    // a comment some comments
    //remove some comments

    @GetMapping("/increment/{n}")
    public @ResponseBody String increment(@PathVariable int n) {
        return String.format("%d + 1 = %d", n, n + 1);
    }
}