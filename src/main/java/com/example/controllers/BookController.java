package com.example.controllers;

import com.example.repositories.IBookRepository;
import com.example.repositories.ILibrarianRepository;
import com.example.repositories.IUCardRepository;
import com.example.repositories.IUserRepository;
import com.example.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class BookController {
    @Autowired
    private IBookRepository _repo;
    @Autowired
    private IUCardRepository _repos;
    @Autowired
    private IUserRepository _user;
    @Autowired
    private ILibrarianRepository _lib;

    @RequestMapping("/book/list")
    public ModelAndView Book(Model model){
        return new ModelAndView("book/list", "books", _repo.findAll());
    }

    @RequestMapping("/book/onhand")
    public ModelAndView BookOnHand(Model model){
        return new ModelAndView("book/list", "books", _repo.findOnHandBooks());
    }

    @RequestMapping("/book/instock")
    public ModelAndView BookInStock(Model model){
        return new ModelAndView("book/list", "books", _repo.findInStockBooks());
    }

    @RequestMapping("/book/overdue")
    public ModelAndView BookOverdue(Model model){
        return new ModelAndView("book/list", "books", _repo.findOverdueBooks());
    }

    @RequestMapping("/book/gives")
    public ModelAndView BookGiveOutU(Model model){
        Map<String, Object> models = new HashMap<String, Object>();
        models.put("books", _repo.findInStockBooks());
        models.put("users", _user.findAll());
        models.put("librarians", _lib.findAll());
        return new ModelAndView("book/gives", "models", models);
    }

    @PostMapping("/book/gives")
    public String GiveOutU(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateIn, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateOut,
                           @RequestParam("studentId") Long userId, @RequestParam Long librarianId, @RequestParam Long bookId, Model model){
        _repos.save(new UCard(dateOut, dateIn, _user.findById(userId), _lib.findById(librarianId), _repo.findById(bookId)));
        return "redirect:/book/list";
    }
}