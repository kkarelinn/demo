package com.demo.service;

import com.demo.model.Article;
import com.demo.model.Color;
import com.demo.repository.ArticleRepository;
import com.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleServiceImpl(UserRepository userRepository, ArticleRepository articleRepository, UserRepository userRepository1) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository1;
    }
    @Override
    public List<Article> getAllByColor(Color color) {
        return articleRepository.getAllByColor(color);
    }

    @Override
    public void saveArticle(Article article) {
        int userId = article.getUser().getId();
        article.setUser(userRepository.getUserById(userId));
        articleRepository.save(article);
    }

    @Override
    public Article getArticleById(int id) {
        return articleRepository.getArticleById(id);
    }
}
