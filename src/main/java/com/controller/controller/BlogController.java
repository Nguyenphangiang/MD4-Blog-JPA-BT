package com.controller.controller;

import com.controller.model.Blog;
import com.controller.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView showList(){
        List<Blog> blogs = blogService.showAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveBlog(@ModelAttribute("blog")Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog",new Blog());
        modelAndView.addObject("message","Created Success");
        return modelAndView;
    }
    @GetMapping("/blog/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog",blog);
        return  modelAndView;
    }
}
