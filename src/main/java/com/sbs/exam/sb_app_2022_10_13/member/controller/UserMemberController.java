package com.sbs.exam.sb_app_2022_10_13.member.controller;

import com.sbs.exam.sb_app_2022_10_13.member.service.MemberService;
import com.sbs.exam.sb_app_2022_10_13.member.vo.Member;
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
  public Member doJoin(String loginId, String loginPw, String name, String nickname,
                       String cellphoneNo, String email) {
    int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
    Member member = memberService.getMemberById(id);

    return member;
  }

}
