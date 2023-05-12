package com.sbs.exam.sb_app_2022_10_13.controller;

import com.sbs.exam.sb_app_2022_10_13.service.MemberService;
import com.sbs.exam.sb_app_2022_10_13.vo.Member;
import com.sbs.exam.sb_app_2022_10_13.util.Ut;
import com.sbs.exam.sb_app_2022_10_13.vo.ResultData;
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
  public ResultData doJoin(String loginId, String loginPw, String name, String nickname,
                           String cellphoneNo, String email) {

    if ( Ut.empty(loginId) ) {
      return ResultData.from("F-1", "loginId(을)를 입력해주세요.");
    }

    if ( Ut.empty(loginPw) ) {
      return ResultData.from("F-2", "loginPw(을)를 입력해주세요.");
    }

    if ( Ut.empty(name) ) {
      return ResultData.from("F-3", "name(을)를 입력해주세요.");
    }

    if ( Ut.empty(nickname) ) {
      return ResultData.from("F-4", "nickname(을)를 입력해주세요.");
    }

    if ( Ut.empty(cellphoneNo) ) {
      return ResultData.from("F-5", "cellphoneNo(을)를 입력해주세요.");
    }

    if ( Ut.empty(email) ) {
      return ResultData.from("F-6", "email(을)를 입력해주세요.");
    }

    ResultData<Integer> joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);


    if ( joinRd.isFail() ) {
      return joinRd;
    }

    Member member = memberService.getMemberById(joinRd.getData1());

    return ResultData.newData(joinRd, member);
  }

}
