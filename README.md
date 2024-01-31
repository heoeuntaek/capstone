


**기간**
2022.03~2022.06 <br><br>

**담당**
허은택(본인)<br><br>

1. **REST API** 개발

   그룹 생성 및 참가 API 구현<br>
  스케줄 작성, 공유, 매칭 API 구현

2. 서버 세팅 및 담당

RDS(Mysql) 사용해 jar 파일 AWS EC2 에 배포


**문제1**
 - JPA 다대다 매핑 무한 호출 에러

→ 중간 테이블을 연관관계로 매핑하여 해결<br>


**문제2**
- JPA에서 양방향으로 연결된 Entity 조회 시 양방향 순환 참조 문제

→ @JsonIgnore 사용  

( Json 데이터에 해당하는 data는 null로 들어감)

→ DTO 사용 

( Entity 자체를 return 하지 않고 DTO 객체를 만들어 필요한 데이터만 옮겨담아 return) <br><br>

**배운것**
1. Spring boot MVC, REST API
2. JPA 이용한 DB 연관관계 매핑
3. Retrofit API 학습 및 적용
4. Git을 활용한 협업 방법
<br><br>

**느낀점**
1. 앱을 개발하는 과정에서 생각한 아이디어가 실제로 구현되는 순간에 큰 흥미와 함께 성취감을 느낄 수 있었다. 이 경험이 어렵다고 생각했던 개발에 대한 흥미를 본격적으로 갖게 된 계기가 되었다.
<br>


![슬라이드3](https://github.com/heoeuntaek/capstone-spring/assets/80875005/73d43676-2657-4ca4-814b-7e4d4e9a3a62)
회사, 동아리, 스터디, 대외활동 등 각자가 속한 그룹은 다양하다. 그래서 팀원들과 미팅 시간과 요일을 정하기가 쉽지만은 않다. 팀원의 스케줄을 매칭해 최적의 미팅 시간을 제시해주는 서비스가 있었으면 좋겠다고 생각해서 이 앱을 개발하고자 했다.


<br/> <br/><br>


![슬라이드4](https://github.com/heoeuntaek/capstone-spring/assets/80875005/20047a95-acf5-4711-8b8a-64b23b4cbd6f)
![슬라이드5](https://github.com/heoeuntaek/capstone-spring/assets/80875005/03e7158c-e6cb-4d96-8f4a-27621781c44e)
스케줄 작성: 사용자는 자신의 일정을 앱에 작성할 수 있다.
그룹 참가: 그룹장이 공유한 그룹 코드로 그룹에 참가할 수 있다.
스케줄 공유: 사용자는 자신의 스케줄을 그룹과 공유할 수 있다.
스케줄 매칭: 그룹원들과의 스케줄을 매칭하여 최적의 미팅 시간을 추천 받을 수 있다.

<br/><br/>
![슬라이드6](https://github.com/heoeuntaek/capstone-spring/assets/80875005/95a576be-170b-41be-9202-e3c51ddd9938)


<br/>


<br/><br/>

![image38](https://user-images.githubusercontent.com/80875005/227517134-22e6d198-2c79-431a-a560-d56cb1a10c5c.png)
<br/>

메인페이지
<br/><br/>
![image39](https://user-images.githubusercontent.com/80875005/227517142-d6f5369b-bfd2-4e3e-b1a0-4b0341f57a60.png)

스케줄 작성
<br/><br/>

![image40](https://user-images.githubusercontent.com/80875005/227517144-b64ee465-b54f-4c72-854e-6aedcefeb996.png)

그룹 메뉴
<br/><br/>


![image41](https://user-images.githubusercontent.com/80875005/227517151-ec294179-3e6f-48cb-bbbf-ca34dd472c02.png)

스케줄 매칭


<br/><br/>
![캡스톤](https://user-images.githubusercontent.com/80875005/227667478-32a4c00f-e60a-4f20-b8e2-6e20d7dc7f70.gif)

구현영상
