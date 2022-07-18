package com.mysite.sbb.Controller;

import com.mysite.sbb.Domain.Article;
import com.mysite.sbb.Service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {

    private ArticleService articleService;

    @RequestMapping("/list")
    public String showList(Model model){
        List<Article> articleList = articleService.getList();

        model.addAttribute("articleList",articleList);

        return "article_list";
    }

    @RequestMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id){
        Article article = this.articleService.getArticles(id);
        model.addAttribute("article",article);

        return "article_detail";
    }
}
