package com.codeup.springblog.controllers;

import com.codeup.springblog.Repositories.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.Repositories.PostRepository;
import org.springframework.stereotype.Controller;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        boolean isPostOwner = false;
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            isPostOwner = currentUser.getId() == post.getUser().getId();
        }
        model.addAttribute("post", post);
        model.addAttribute("isPostOwner", isPostOwner);
        return "posts/show";
    }


//    @GetMapping("/posts/edit/{id}")
//    public String editForm(@PathVariable long id, Model model) {
//        model.addAttribute("post", postDao.getById(id));
//        return "posts/edit";
//    }
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post post = postDao.getById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postDao.delete(postDao.getById(id));
        return "redirect:/posts";
    }


    // When you visit the URL you will see the form to create a post.
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

    @GetMapping("posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User user = userDao.getById(1L);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post,"You created: " + post.getTitle(), post.)
        return "redirect:/posts";
    }
}