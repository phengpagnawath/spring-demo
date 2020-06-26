package com.wath.springdemo.service;

import com.wath.springdemo.model.Article;

import java.util.List;

public interface ArticleService {

    Article insert(Article article);
    List<Article> select();
    Article selectById(String id);
    void delete(String id);
    void update(Article newArticle);
    List<Article> searchByTitle(String title);

}
