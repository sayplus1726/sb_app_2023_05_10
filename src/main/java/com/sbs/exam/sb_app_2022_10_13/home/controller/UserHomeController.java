package com.sbs.exam.sb_app_2022_10_13.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHomeController {
  private int count;

  public UserHomeController() {
    count = -1;
  }
  @RequestMapping("/user/home/main")
  @ResponseBody
  public String showMain() {
    return "안녕";
  }

  @RequestMapping("/user/home/main2")
  @ResponseBody
  public String showMain2() {
    return "반갑습니다";
  }

  @RequestMapping("/user/home/main3")
  @ResponseBody
  public String showMain3() {
    return "또 만나요";
  }

  @RequestMapping("/user/home/main4")
  @ResponseBody
  public int showMain4() {
    count++;
    return count;
  }

}
