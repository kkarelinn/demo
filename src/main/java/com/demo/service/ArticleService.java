package com.demo.service;

import com.demo.model.Article;
import com.demo.model.Color;
import com.demo.model.User;

import java.util.List;

public interface ArticleService {
    List<Article> getAllByColor(Color color);
    void saveArticle(Article article);
    Article getArticleById(int id);
}
