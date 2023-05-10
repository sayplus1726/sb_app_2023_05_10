package com.sbs.exam.sb_app_2022_10_13.home.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserHomeController {
  private int count;

  public UserHomeController() {
    count = -1;
  }

  @RequestMapping("/user/home/getCount")
  @ResponseBody
  public int getCount() {
    return count;
  }

  @RequestMapping("/user/home/getString")
  @ResponseBody
  public String getString() {
    return "HI";
  }

  @RequestMapping("/user/home/getInt")
  @ResponseBody
  public int getInt() {
    return 10;
  }

  @RequestMapping("/user/home/getFloat")
  @ResponseBody
  public float getFloat() {
    return 10.5f;
  }

  @RequestMapping("/user/home/getDouble")
  @ResponseBody
  public double getDouble() {
    return 10.5;
  }

  @RequestMapping("/user/home/getBoolean")
  @ResponseBody
  public boolean getBoolean() {
    return true;
  }

  @RequestMapping("/user/home/getCharacter")
  @ResponseBody
  public char getCharacter() {
    return 'a';
  }

  @RequestMapping("/user/home/getList")
  @ResponseBody
  public List<String> getList() {
    List<String> list = new ArrayList<>();
    list.add("철수");
    list.add("영희");

    return list;
  }

  @RequestMapping("/user/home/getMap")
  @ResponseBody
  public Map<String, Object> getMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("철수나이", 22);
    map.put("영희나이", 21);
    return map;
  }

  @RequestMapping("/user/home/getArticle")
  @ResponseBody
  public Article getArticle() {
    Article article = new Article(1, "제목1");

    return article;
  }

  @RequestMapping("/user/home/getArticles")
  @ResponseBody
  public List<Article> getArticles() {
    Article article1 = new Article(1, "제목1");
    Article article2 = new Article(2, "제목2");

    List<Article> list = new ArrayList<>();
    list.add(article1);
    list.add(article2);

    return list;
  }

  @RequestMapping("/user/home/doSetCount")
  @ResponseBody
  public String doSetCount(int count) {
    this.count = count;
    return "count의 값이" + this.count + "으로 초기화 되었습니다.";
  }

@Data
@NoArgsConstructor
@AllArgsConstructor
class Article {
    public int id;
    public String title;
  }

}
