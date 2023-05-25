package com.example.controllers;

import com.example.repositories.IAuthorRepository;
import com.example.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {

    @Autowired
    private IAuthorRepository _repo;

    @RequestMapping("/author/list")
    public ModelAndView Author(Model model){
        return new ModelAndView("author/list", "authors", _repo.findAll());
    }

    @RequestMapping("/author/add")
    public ModelAndView Add(Model model){
        return new ModelAndView("author/add");
    }

    @PostMapping("/author/add")
    public String AddAuthor(@RequestParam String firstName, @RequestParam String lastName, Model model){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        _repo.save(author);
        //_repo.save(new Author(firstName, lastName));
        return "redirect:/author/list";
    }
}