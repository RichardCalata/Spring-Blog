package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String index(Model view) {

        List<Post> posts = postService.findAll();

        view.addAttribute("posts", posts);

        return "/posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view){

        Post post = postService.findOne(id);

        view.addAttribute("post", post);

        return"posts/show";
    }

    @RequestMapping("/posts/{id}/edit")
     public String edit(@PathVariable long id, Model view){

        view.addAttribute("post", postService.findOne(id));

        return "/posts/edit";
    }

    @GetMapping("/posts/create")
    public String create(Model view) {
        view.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/{id}")
    public String save(@ModelAttribute Post post) {
        postService.save(post);
        System.out.println("savePost");
        return "redirect:/posts";
    }


}
