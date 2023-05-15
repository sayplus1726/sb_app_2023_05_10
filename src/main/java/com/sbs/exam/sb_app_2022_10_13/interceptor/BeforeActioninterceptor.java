package com.sbs.exam.sb_app_2022_10_13.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeforeActioninterceptor implements HandlerInterceptor {

  public boolean preHandle(HttpServletRequest req, HttpServletResponse resq, Object handle) throws Exception {
    System.out.println("실핼되니?");

    return HandlerInterceptor.super.preHandle(req, resq, handle);
  }
}
