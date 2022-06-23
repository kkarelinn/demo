package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

    List<Article> getAllByColor(Color color);
    Article getArticleById(int id);


}