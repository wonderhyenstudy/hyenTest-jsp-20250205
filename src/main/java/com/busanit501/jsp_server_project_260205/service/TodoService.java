package com.busanit501.jsp_server_project_260205.service;

import com.busanit501.jsp_server_project_260205.dao.TodoDAO;
import com.busanit501.jsp_server_project_260205.domain.TodoVO;
import com.busanit501.jsp_server_project_260205.dto.TodoDTO;
import com.busanit501.jsp_server_project_260205.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;

@Log4j2
public enum TodoService {
    // 클래스가 메모리에 딱 한번만 생성되도록 함
    INSTANCE;
    // DB 서버에 작업을 시키는 클래스를 가져오기
    private TodoDAO dao;

    // DTO <- VO 클래스를 변환 해주는 기능 클래스
    // MapperUtil 사용
    // 서로 다른 클래스(예: Domain/VO와 DTO) 사이에 필드 이름이 같으면,
    // 일일이 get/set을 호출하지 않아도 데이터를 자동으로 복사해서 새로운 객체로 만들어주는 아주 편리한 라이브러리
    private ModelMapper modelMapper;
    
    // 생성자
    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 1. 등록하기 register


    // 2. 목록 listAll
    public List<TodoDTO> listAll() throws Exception {
        // 1. 넣어둘 배열공간 생성
        List<TodoVO> voList = dao.selectAll();

    }


    // 3. 한개만 조회 get


    // 4. 수정 modify


    // 5. 삭제 remove



}
