package com.mysite.sbb.Controller;

import com.mysite.sbb.Domain.Article;
import com.mysite.sbb.Service.ArticleService;
import com.mysite.sbb.Service.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reply")
@AllArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
    private final ArticleService articleService;

    @RequestMapping("/create/{id}")
    public String Createreply(Model model , @PathVariable("id") Integer id, @RequestParam String content) {
        Article article = articleService.getArticles(id);
        this.replyService.create(article, content);

        model.addAttribute("article",article);
        return String.format("redirect:/article/detail/%s",id);
    }

}
