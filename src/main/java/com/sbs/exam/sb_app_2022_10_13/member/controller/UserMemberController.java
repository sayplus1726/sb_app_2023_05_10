package com.sbs.exam.sb_app_2022_10_13.member.controller;

import com.sbs.exam.sb_app_2022_10_13.member.service.MemberService;
import com.sbs.exam.sb_app_2022_10_13.member.vo.Member;
import com.sbs.exam.sb_app_2022_10_13.util.Ut;
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

    if ( Ut.empty(loginId) ) {
      return "loginId를 입력해주세요.";
    }

    if ( Ut.empty(loginPw) ) {
      return "loginPw를 입력해주세요.";
    }

    if ( Ut.empty(name) ) {
      return "name을 입력해주세요.";
    }

    if ( Ut.empty(nickname) ) {
      return "nickname을 입력해주세요.";
    }

    if ( Ut.empty(cellphoneNo) ) {
      return "cellphoneNo을 입력해주세요.";
    }

    if ( Ut.empty(email) ) {
      return "email을 입력해주세요.";
    }

    if ( id == -1 ) {
      return Ut.f("해당 로그인 아이디(%s)는 이미 사용중입니다.", loginId);
    }

    if ( id == -2 ) {
      return Ut.f("해당 이름(%s)과 이메일(%s)은 이미 사용중입니다.", name, email);
    }

    Member member = memberService.getMemberById(id);

    return member;
  }

}
