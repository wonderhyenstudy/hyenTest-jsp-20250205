package com.busanit501.jsp_server_project_260205.ConnectionUtil;

import lombok.*;

import java.time.LocalDate;

//@Data : vo는 데이터에 보관할 수정하면 안되는 원본이다.
//        그래서 @Setter 를 쓰면 안된다. @Data에는 Getter, Setter, toString 모든게 포함되어 있어서 안됨
//        그래서 각각 @Getter, @ToString 사용한다
@Getter //
@ToString   // ToString 직접 생성안하고, 어노테이션 이용하면, 메모리상에 다 만들어져 있다.
@Builder    // 객체생성자 편하게
            // 내가 넣고 싶은 값만, 이름을 보면서, 순서 상관없이 점(.) 찍어서 편리하게 객체를 만들겠다!
@NoArgsConstructor  // 기본생성자 생성
@AllArgsConstructor // 모든 매개변수가 있는 전체 생성자 생성

//VO : 금고에 보관할 원본 데이터
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
