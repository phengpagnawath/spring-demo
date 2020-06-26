package com.wath.springdemo.repository.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.wath.springdemo.model.Article;
import com.wath.springdemo.repository.ArticleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    private List<Article> data;

    public ArticleRepositoryImpl(){
        data=new ArrayList<>();
        String[] titles = {"Xcode","Java","C#","C++","Kotlin"};
        for(int i=0;i<titles.length;i++) {
            data.add(new Article(UUID.randomUUID().toString(),titles[i],"programming language"));
        }
    }



    @Override
    public boolean insert(Article article) {
        return data.add(article);
    }

    @Override
    public List<Article> select() {
        return data;
    }

    @Override
    public void deleteByID(int index) {
        data.remove(index);
    }

    @Override
    public void updateByID(Article newArticle) {
        for(Article article:data){
            if(article.getId().equals(newArticle.getId())){
                BeanUtils.copyProperties(newArticle,article);
            }
        }
    }

    @Override
    public Article selectByID(String id) {
        for (Article article:data){
            if(article.getId().equals(id)){
                return article;
            }
        }
        return null;
    }

    @Override
    public List<Article>  searchByTitle(String title) {
        return data.stream().filter(article ->
                article.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}
