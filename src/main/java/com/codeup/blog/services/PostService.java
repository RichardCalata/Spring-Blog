package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

//    private List<Post> posts;

    public List<Post> findAll() {
       Iterable<Post>posts = postRepository.findAll();
        return (List<Post>) posts;
    }

    public Post findOne(long id) {
        Post post = postRepository.findOne(id);
        return post;
    }


    public Post save( Post post) {

        postRepository.save(post);
        return post;

    }

    public Post deletePost (long id) {
        postRepository.delete(id);
        return deletePost(id);
    }

    public void delete (long id){
        postRepository.delete(id);
    }

}