package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {

  public Scanner keyboard;
  MemberList memberList = new MemberList();

  public MemberHandler(Scanner mk) {
    keyboard = mk;
  }

  public void listMember() {
    Member[] members = memberList.toArray();
    for (Member member : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", member.getNo(), member.getName(),
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
  }

  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("이름? ");
    member.setName(this.keyboard.nextLine());

    System.out.print("이메일? ");
    member.setEmail(this.keyboard.nextLine());

    System.out.print("암호? ");
    member.setPassword(this.keyboard.nextLine());

    System.out.print("사진? ");
    member.setPhoto(this.keyboard.nextLine());

    System.out.print("전화? ");
    member.setTel(this.keyboard.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);

    System.out.println("저장하였습니다.");
  }

}
