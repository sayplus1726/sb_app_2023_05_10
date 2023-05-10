package com.sbs.exam.sb_app_2022_10_13.article.controller;

import com.sbs.exam.sb_app_2022_10_13.article.vo.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserArticleController {

  int articleLastId;

  private List<Article> articles;

  public UserArticleController() {
    articles = new ArrayList<>();
    articleLastId = 0;

    makeTestData();
  }

  private void makeTestData() {
    for(int i=1; i<=10; i++) {
      int id = articleLastId + 1;
      String title = "제목" + i;
      String body = "내용" + i;
      Article article = new Article(id, title, body);

      articles.add(article);
      articleLastId = id;
    }
  }

  @RequestMapping("/user/article/doAdd")
  @ResponseBody
  public Article doAdd(String title, String body) {
    int id = articleLastId + 1;
    Article article = new Article(id, title, body);

    articles.add(article);
    articleLastId = id;

    return article;
  }

  @RequestMapping("/user/article/getArticles")
  @ResponseBody
  public List<Article> getArticles() {
    return articles;
  }

}
