package com.example.capstone.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor  //생성자
@NoArgsConstructor  //default생성자 추가
@Entity  //DB가 해당 객체 인식 가능   (해당 클래스로 테이블을 만듬)
@ToString
@Getter
@Setter
@Table(name = "user")
public class User {

    @Column(name = "user_id")
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO) // db가 알아서 생성
    private Long id;

    @Column(unique = true)
    private String user_login_id;
    @Column
    private String user_pass;

    @Column
    private String user_name;

//   @OneToMany(mappedBy = "user")
//   private List<User_group> user_groups = new ArrayList<>();

//   @OneToMany(mappedBy = "user")
//   private List<Schedule> schedules = new ArrayList<>();

    public void patch(User user) {

        if (user.user_login_id != null) {
            this.user_login_id = user.user_login_id;
        }
        if (user.user_name != null) {
            this.user_name = user.user_name;
        }
        if (user.user_pass != null) {
            this.user_pass = user.user_pass;
        }
    }

}