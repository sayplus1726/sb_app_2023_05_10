package com.sbs.exam.sb_app_2022_10_13.member.controller;

import com.sbs.exam.sb_app_2022_10_13.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserMemberController {

  public UserMemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  private MemberService memberService;
  @RequestMapping("/user/member/doJoin")
  @ResponseBody
  public String doJoin(String loginId, String loginPw, String name, String nickname,
                       String cellphoneNo, String email) {
    memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
    return "성공";
  }

}
