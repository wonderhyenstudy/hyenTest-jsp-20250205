package com.busanit501.jsp_server_project_260205.dao;

import com.busanit501.jsp_server_project_260205.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// DB 연동 작업. sql 작성 등
// 각 기능들 모음
public class TodoDAO {
    // 1. 등록하기 insert
    public void insert(){
        // 준비물 : 한개만, DB연결 sql,
        // 1. sql 작성
        // 2. DB서버에 연결 + 담아두기


    }

    // 2. 목록 selectAll
    // 여러개 이니깐 클래스 배열로 받아야 한다. 어떤형태로?????? TodoVo 형태로.
    public List<TodoVO> selectAll() throws Exception {
        // 준비물 : 여러개, 배열. DB연결 sql
        // 1. sql 작성 : 조회하는 sql 문
        String sql = "select * from tbl_menu order by tno desc";
        // 2. DB서버에 연결 + 담아두기
        // DB 서버에 연결하는 도구 설정
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        // sql 문장을 담아 두는 기능
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // sql 문장을 디비 서버에 전달. and 결과 테이블을 받아와서, 담아두기. 읽기 executeQuery
        // 자바가 DB에서 데이터를 한 줄씩 꺼내온 임시 바구니
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        // 3. 데이터베이스 받아온 내용을 리스트로 변환
        // 임시로 담아둘 리스트 선언
        // 완성된 vo 그릇들을 차곡차곡 쌓아놓은 배달 박스
        List<TodoVO> list = new ArrayList<>();
        // 받아온 list 를 반복문으로 돌려~
        while(resultSet.next()) { //한줄씩 넣어
            // 1. 조립대(builder)를 불러서 데이터를 하나씩 끼워 맞춤
            // 자바가 이해할 수 있는 '객체' 형태의 그릇
            TodoVO vo = TodoVO.builder()
                    // DB에서 꺼내 온 값을 vo 에다 넣을꺼야~
                    .tno(resultSet.getLong("tno")) //DB 창고에서 tno라는 숫자를 하나 꺼내와!
                    .title(resultSet.getString("title"))
                    // toLocalDate : 방금 꺼낸 옛날 날짜를 현대적인 LocalDate 타입으로 변신
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build(); // 2. 조립 완료! (진짜 객체가 생성됨)
            // 3. 완성된 vo를 바구니에 담음
            list.add(vo); //Array의 문법. 꺼내온 한줄 vo를 배열객체 list에 넣어
        }


        return list;


    }

    // 3. 한개만 조회 selectOne
    public void selectOne(){
        // 준비물 : 한개만

    }

    // 4. 수정 updateOne
    public void updateOne(){
        // 준비물 : 한개만

    }

    // 5. 삭제 deleteOne
    public void deleteOne(){
        // 준비물 : 한개만

    }


}
