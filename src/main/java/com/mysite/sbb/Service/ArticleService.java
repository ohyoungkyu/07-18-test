package com.mysite.sbb.Service;

import com.mysite.sbb.Dao.ArticleRepository;
import com.mysite.sbb.Domain.Article;
import com.mysite.sbb.Util.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article getArticles(Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()) {
            return article.get();
        } else {
            throw new DataNotFoundException("게시물을 찾지 못했습니다.");
        }
    }

}
