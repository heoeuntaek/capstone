//package com.example.capstone.JpaMain;
//
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class JpaMain {
//    public static void main(String[] args) {
//
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//
//        try {
////            em.clear(); // 영속성 컨텐츠(1차 캐시)를 모두 삭제
//
//            User2 user = new User2();
//            user.setUser_id("gjdmsxor3");
//            user.setUser_pass("dmsxor2");
//            user.setUser_name("허은택");
//            em.persist(user);
//            em.flush();
//
//            User2 user2 = new User2();
//            user2.setUser_id("gjdmsxor4");
//            user2.setUser_pass("dmsxor2");
//            user2.setUser_name("허은택");
//            em.persist(user2);
//            em.flush();
//
//            User2 user3 = new User2();
//            user3.setUser_id("gjdmsxor5");
//            user3.setUser_pass("dmsxor2");
//            user3.setUser_name("허은택");
//            em.persist(user3);
//            em.flush();
//
//
//            Group_tbl2 group = new Group_tbl2();
//            group.setGroup_id("11323");
//            group.setGroup_name("스케줄그룹");
//            group.setMatched_schedule("매칭 스케줄");
//            em.persist(group);
//            em.flush();
//
//
//            User_group2 user_group = new User_group2();
//            user_group.setUser(user);
//            user_group.setGroup_tbl(group);
//            em.persist(user_group);
//            em.flush();
//
//            Schedule2 schedule = new Schedule2();
//            schedule.setSchedule_data("{\"monday\":[1,1,1,1,1,1,1], \"tuesday\":[1,1,1,1,1,1,1], \"wednesday\":[1,1,1,1,1,1,1]}");
//            schedule.setSchedule_name("스케줄네임3");
//            schedule.setUser(user);
//            em.persist(schedule);
//            em.flush();
//
//            Schedule2 schedule2 = new Schedule2();
//            schedule2.setSchedule_data("스케줄데이타4");
//            schedule2.setSchedule_name("스케줄네임4");
//            schedule2.setUser(user);
//            em.persist(schedule2);
//            em.flush();
//
//            Schedule2 schedule_find = em.createQuery("select s from Schedule2 s where  s.schedule_name like '스케줄네임3'", Schedule2.class)
//                    .getSingleResult();
//            System.out.println("schedule_find = " + schedule_find);
//            System.out.println("schedule_find_data = "+schedule_find.getSchedule_data());
//
//            String json_string = schedule_find.getSchedule_data();
//
//            JSONParser jsonParser = new JSONParser();
//
//            //JSON데이터를 넣어 JSON Object 로 만들어 준다.
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(json_string);
//
////            //books의 배열을 추출
////            JSONArray bookInfoArray = (JSONArray) jsonObject.get("books");
//
//            System.out.println("jsonObject = " + jsonObject);
//            System.out.println("jsonObject.get(\"monday\")"+jsonObject.get("monday"));
//
//
////            em.createQuery("select m from User2 m where m.user_id like 'gjdmsxor3'").getResultList();
////            em.find(User2.class, 1);
//
////            Schedule2 singleResult = em.createQuery("select m from Schedule2 as m where m.schedul_data like'스케줄데이타'", Schedule2.class)
////                    .getSingleResult();
////
////            User2 findUser = em.createQuery("select m from User2 as m where m.user_id like 'gjdmsxor42'", User2.class)
////                    .getSingleResult();
//
////            Schedule2 schedule2 = new Schedule2();
////            schedule2.setSchedul_data("스케줄데이타");
//////            schedule2.setUser(findUser);
//////            em.persist(schedule2);
////            em.flush();
//
////            List<Schedule2> schedules = findUser.getSchedules();
////            for (Schedule2 sch : schedules) {
////                System.out.println("sch.toString()"+sch.getSchedul_data());
////            }
//
////            singleResult.setUser(findUser);
//
////            User2 findUser = em.createQuery("select m from User2 as m where m.user_id like 'gjdmsxor42'", User2.class)
////                    .getSingleResult();
////
////            User2 user21 = em.find(User2.class, 3L);
////
////
//
////            User2 result = em.createQuery("select m from User2 as m where m.user_id like 'gjdmsxor42'", User2.class)
////                    .getSingleResult();
////            System.out.println("result.getSchedules().toString();"+result.getSchedules().toString());
////
////
////            List<User2> resultList = em.createQuery("select m from User2 as m where m.user_name like '허은택'", User2.class)
////                    .getResultList();
////
////            for (User2 user2 : resultList) {
////                System.out.println("resultList.toString()"+user2.toString());
////            }
//
//
//
////            Team team = new Team();
////            team.setUsername("팀3번");
//
////            em.persist(team);
////            em.flush();
//
//
////            Member member = new Member();
////            member.setMember_name("박지수");
////            em.persist(member);
////            em.flush();
//
//
////            List<Member> members = foundteam.getMembers();
////            for (Member m : members) {
////                System.out.println("members_name"+m.getMember_name());
////            }
//
////            Member member = new Member();
////            member.setMember_name("양호진");
////            member.setTeam(foundteam);
////            em.persist(member);  // 1차 캐시에 저장
////            em.flush();  //commit 하기전에 바로 query문 조회 가능  / 쓰기 지연 SQL가 db에 반영되는 것
//
//
//
////            Member findmember = em.find(Member.class, 1L);
////            System.out.println("findmember = " + findmember.toString());
////            findmember.setName("허은택");
////
//////            em.clear(); // 영속성 컨텐츠(1차 캐시)를 모두 삭제
////
////            //jpql 쿼리  ( 하기 전엔 무조건 em.flush()해야함)
////            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
////                    .getResultList();
////            for (Member member : resultList) {
////                System.out.println("member.toString() = " + member.toString());
////            }
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        }
//        finally {
//            em.close();
//        }
//        emf.close();
//
//    }
//}