//package com.example.capstone.JpaMain;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@AllArgsConstructor  //생성자
//@NoArgsConstructor  //default생성자 추가
//@Entity  //DB가 해당 객체 인식 가능   (해당 클래스로 테이블을 만듬)
//@ToString
//@Getter
//@Setter
//@Table (name = "user")
//public class User2 {
//   @Id //PK
//   @GeneratedValue(strategy = GenerationType.AUTO) // db가 알아서 생성
//   private Long id;
//
//   @Column (unique = true)
//   private String user_id;
//
//   @Column
//   private String user_pass;
//
//   @Column
//   private String user_name;
//
//   @OneToMany(mappedBy = "user")
//   private List<Schedule2> schedules = new ArrayList<>();
//
//   @OneToMany(mappedBy = "user")
//   private List<User_group2> user_groups;
//
//   public void patch(User2 user) {
//
//      if (user.user_id != null) {
//         this.user_id = user.user_id;
//      }
//      if (user.user_name != null) {
//         this.user_name = user.user_name;
//      }
//      if (user.user_pass != null) {
//         this.user_pass = user.user_pass;
//      }
////      if (user.user_groups != null) {
////         this.user_groups = user.user_groups;
////      }
//   }
//
////           = new ArrayList<>();
//
////   @OneToMany
////   private User_Group user_group;
//
////   public User(int id, String user_id, String user_pass, String user_name) {
////      this.id = id;
////      this.user_id = user_id;
////      this.user_pass = user_pass;
////      this.user_name = user_name;
////   }
////
////   @Override
////   public String toString() {
////      return "User{" +
////              "id=" + id +
////              ", user_id='" + user_id + '\'' +
////              ", user_pass='" + user_pass + '\'' +
////              ", user_name='" + user_name + '\'' +
////              '}';
////   }
//
//}