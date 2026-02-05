package com.busanit501.jsp_server_project_260205.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // Getter, Setter, toString 한번에 생성
@Builder // 객체 생성을 편하게 하기 위해
@NoArgsConstructor // 기본생성자를 생성
@AllArgsConstructor // 모든 멤버를 매개변수로 가지는 전체 생성자 생성

//DTO : 손님에게 전달할 배달 박스
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
