package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts(){
        return "View all posts.";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable long id){
        return "View an individual Post.";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm(){
        return "View form to create a Post.";
    }

    // When you submit the form on the /posts/create page,
    // the information will be posted to the same URL
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Creates new post.";
    }
}

