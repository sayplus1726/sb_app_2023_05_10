package com.sbs.exam.sb_app_2022_10_13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserHomeController {
  @RequestMapping("/user/home/main")
  public String main() {
    return "user/home/main";
  }

  @RequestMapping
  public String showRoot() {
    return "redirect:/user/home/main";
  }

}
