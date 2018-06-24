package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
class PostController {
    private final PostService postService;
    private final UserRepository userRepository;


    public PostController(PostService postService, UserRepository userRepository){
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public String index(Model view) {

        List<Post> posts = postService.findAll();

        view.addAttribute("posts", posts);

        return "/posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view){
        System.out.println("what is the error?");
        Post post = postService.findOne(id);
        view.addAttribute("post",post);

        return"posts/show";
    }

    @GetMapping("posts/{id}/edit")
    public String edit(@PathVariable long id, Model view){
        Post post = postService.findOne(id);
        view.addAttribute("post", post);
        return "/posts/edit";
    }

    @RequestMapping("/posts/{id}/edit")
     public String update(@PathVariable long id, @Valid Post postDetails){
        Post post = postService.findOne(id);
        post.setTitle(postDetails.getTitle());
        post.setBody(postDetails.getBody());
        postService.save(post);

        return "redirect:/posts";
    }

    @DeleteMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postService.findOne(id);
        postService.deletePost(id);
         return "redirect:/posts";
    }

    @PostMapping("posts/{id}/delete")
    public String delete(@PathVariable long id){
        postService.delete(id);
        return "redirect:/posts";
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
