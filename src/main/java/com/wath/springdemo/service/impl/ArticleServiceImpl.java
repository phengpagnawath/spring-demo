package com.wath.springdemo.service.impl;

import com.wath.springdemo.model.Article;
import com.wath.springdemo.repository.impl.ArticleRepositoryImpl;
import com.wath.springdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepositoryImpl articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepositoryImpl articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article insert(Article article) {
        return articleRepository.insert(article) ? article : null;
    }

    @Override
    public List<Article> select() {
        List<Article> dgbArticles = new ArrayList<>();

        for(Article article : articleRepository.select()){
            article.setTitle(article.getTitle());
            dgbArticles.add(article);
        }
        return dgbArticles;
    }

    @Override
    public void delete(String id) {
        articleRepository.deleteByID(id);
    }

    @Override
    public void update(Article article) {
        articleRepository.updateByID(article);
    }

    @Override
    public Article selectById(String id) {
        return articleRepository.selectByID(id);
    }

    @Override
    public List<Article> searchByTitle(String title) {
        return articleRepository.searchByTitle(title);
    }
}
