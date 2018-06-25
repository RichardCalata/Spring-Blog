package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@ResponseBody
@Controller
public class RelationshipController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public RelationshipController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/seed")
    public String seed() {
        User user = new User();
        user.setEmail ("Monica@monica.com");
        user.setUsername("monica");
        user.setPassword("password");
        userRepository.save(user);

        List<Post> posts = Arrays.asList(
                new Post("the First", "Lorem"),
                new Post("the second one", "lorem"),
                new Post("third ad", "lorem"),
                new Post("the fourth one", "lorem")
        );

        for (Post post : posts) {
            post.setUser(user);
        }

        postRepository.save(posts);
        return "check the console";
    }

    @GetMapping("/example-profile")
    public String profile() {
        User user = userRepository.findOne(1l);

        System.out.println("Showing ads belonging to user " + user.getUsername());

        List<Post> posts = user.getPosts();

        for (Post post : posts) {
            System.out.println("  - " + post.getTitle());
        }

        return "Again, it's in the console.";
    }

    @GetMapping("/example-show")
    public String show() {
        Post post = postRepository.findOne(1l);

        System.out.println(post.getUser().getEmail());


        return "Console!";
    }

}
