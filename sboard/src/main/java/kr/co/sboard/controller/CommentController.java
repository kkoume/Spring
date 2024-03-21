package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.entity.Article;
import kr.co.sboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/{no}")
    public ResponseEntity<List<ArticleDTO>> comment(@PathVariable("no") int no){
        return commentService.selectComments(no);
    }

    @PostMapping("/comment")
    public ResponseEntity<Article> comment(@RequestBody ArticleDTO articleDTO, HttpServletRequest req){

        String regip = req.getRemoteAddr();
        articleDTO.setRegip(regip);
        log.info("articleDTO : " + articleDTO);

        return commentService.insertComment(articleDTO);
    }
}
