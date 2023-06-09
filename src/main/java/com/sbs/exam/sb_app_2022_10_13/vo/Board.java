package com.sbs.exam.sb_app_2022_10_13.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
  private int id;
  private String regDate;
  private String updateDate;
  private String code;
  private String name;

  private String extra__writerName;
  private boolean extra__actorCanModify;
  private boolean extra__actorCanDelete;
  private boolean delStatus;
  private String delDate;

}
