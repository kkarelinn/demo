package com.demo.service;

import com.demo.model.Article;
import com.demo.model.Color;
import com.demo.model.User;
import com.demo.repository.ArticleRepository;
import com.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public UserServiceImpl(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<User> getUsersByAgeGreaterThan(int age) {
        return userRepository.getUsersByAgeGreaterThan(age);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsersByColor(Color color) {
        List<Article> articles = articleRepository.getAllByColor(color);
        List<User> users = new ArrayList<>();
        Set<User> uniqueValues = new HashSet<>();
        for (Article e : articles) {
            User user = e.getUser();
            if (uniqueValues.add(user)) {
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public List<String> uniqUsersWith3Art() {
        List<User> users = userRepository.findAll().stream().filter(e->e.getArticles().size()>3).collect(Collectors.toList());
        return users.stream().map(User::getName).distinct().collect(Collectors.toList());
    }
}
