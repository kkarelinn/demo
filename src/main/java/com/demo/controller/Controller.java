package com.demo.controller;

import com.demo.model.Article;
import com.demo.model.Color;
import com.demo.model.User;
import com.demo.service.ArticleService;
import com.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Locale;

@RestController
@EnableWebMvc
@RequestMapping("/api")

public class Controller {
    private final UserService userService;
    private final ArticleService articleService;


    public Controller(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;

    }

    @GetMapping
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("Welcome to karelin API test !!", HttpStatus.OK);
    }

    @GetMapping({"/usersAge/{age}", "/usersAge"})
    public ResponseEntity<List<User>> getUsersByAge(@PathVariable(required = false) Integer age) {
       if (age==null) {age = 0;}
        System.out.println(age);
       List<User> users = userService.getUsersByAgeGreaterThan(age);
       if (users.isEmpty()) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping({"/usersColor/{colorS}", "/usersColor"})
    public ResponseEntity<List<User>>  getUsersByColor(@PathVariable(required = false) String colorS) {
        if (colorS == null) colorS = "";
        Color color;
        try {
            color = Color.valueOf(colorS.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<User> users = userService.getUsersByColor(color);
        if (users.isEmpty()) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/uniqUsersWith3Art")
    public ResponseEntity<List<String>>   uniqUsersWith3Art() {
        List<String> users = userService.uniqUsersWith3Art();
        if (users.isEmpty()) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        if (user==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.saveUser(user);
        System.out.println(user);
      return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(value = "/saveArticle", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<Article> saveArt(@RequestBody Article article) {
        if (article==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        articleService.saveArticle(article);
        System.out.println(article);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable(required = false) int id) {

      Article article = articleService.getArticleById(id);
        if (article == null) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        System.out.println(article);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}

