package com.mysite.sbb.Service;

import com.mysite.sbb.Dao.ReplyRepository;
import com.mysite.sbb.Domain.Article;
import com.mysite.sbb.Domain.Reply;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public void create(Article article, String content) {
        Reply reply = new Reply();
        reply.setCreateDate(LocalDateTime.now());
        reply.setContent(content);
        reply.setArticle(article);
        replyRepository.save(reply);
    }
}
