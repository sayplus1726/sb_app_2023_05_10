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
  public Object doJoin(String loginId, String loginPw, String name, String nickname,
                       String cellphoneNo, String email) {
    int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

    if ( loginId == null) {
      return "loginId를 입력해주세요.";
    }

    if ( loginPw == null) {
      return "loginPw를 입력해주세요.";
    }

    if ( name == null) {
      return "name을 입력해주세요.";
    }

    if ( nickname == null) {
      return "nickname을 입력해주세요.";
    }

    if ( cellphoneNo == null) {
      return "cellphoneNo을 입력해주세요.";
    }

    if ( email == null) {
      return "email을 입력해주세요.";
    }

    if ( id == -1 ) {
      return "해당 로그인 아이디는 이미 사용중입니다.";
    }

    Member member = memberService.getMemberById(id);

    return member;
  }

}
