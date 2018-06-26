package com.codeup.blog.services;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;

    }

//    private List<Post> posts;

    public List<Post> findAll() {

        return postRepository.findAll();
    }

    public Post findOne(long id) {
        Post post = postRepository.findOne(id);
        return post;
    }


    public Post save( Post post) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(sessionUser.getId());
        post.setUser(user);
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

    public List<Post> search(String searchTerm) {
        return postRepository.search("%" + searchTerm + "%");
    }


}