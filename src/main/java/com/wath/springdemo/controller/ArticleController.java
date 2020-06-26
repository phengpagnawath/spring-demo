package com.wath.springdemo.controller;

import com.wath.springdemo.model.Article;
import com.wath.springdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/add")
    public String addArticleView(ModelMap map){
        map.addAttribute("article",new Article());
        return "add-article";
    }

    @PostMapping("/articles/add")
    public String add(@ModelAttribute Article newArticle){
        newArticle.setId(UUID.randomUUID().toString());
        articleService.insert(newArticle);
        return "redirect:/articles";
    }

    @GetMapping("/articles")
    public String index(ModelMap map){

        List<Article> articles = articleService.select();
        map.addAttribute("articles",articles);
        return "article";
    }

    @GetMapping("/articles/update/{id}")
    public String updateArticleView(ModelMap map, @PathVariable("id") String id){
        map.addAttribute("article",articleService.selectById(id));
        map.addAttribute("isUpdate",true);
        return "add-article";
    }

    @PostMapping("/articles/update")
    public String updateArticle(@ModelAttribute Article article){
        articleService.update(article);
        return "redirect:/articles";
    }

    @GetMapping("/articles/search")
    public String searchByTitle(@RequestParam String title,ModelMap map){
        map.addAttribute("articles",articleService.searchByTitle(title));
        return "article";
    }
    @GetMapping("/articles/delete/{id}")
    public String deleteByID(@PathVariable String id){
        articleService.delete(id);
        return "redirect:/articles";
    }


}
