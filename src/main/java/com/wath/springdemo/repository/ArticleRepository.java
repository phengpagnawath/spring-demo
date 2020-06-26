package com.wath.springdemo.repository;

import com.wath.springdemo.model.Article;

import java.util.List;

public interface ArticleRepository {
    boolean insert(Article article);
    List<Article> select();
    Article selectByID(String id);
    void deleteByID(String id);
    void updateByID(Article newArticle);
    List<Article>  searchByTitle(String title);
}
