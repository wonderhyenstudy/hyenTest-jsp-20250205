package com.busanit501.jsp_server_project_260205.controller;

import com.busanit501.jsp_server_project_260205.domain.TodoVO;
import com.busanit501.jsp_server_project_260205.dto.TodoDTO;
import com.busanit501.jsp_server_project_260205.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="TodoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    // 서비스의 기능을 가지고 있는 클래스 이용
    private TodoService todoService = TodoService.INSTANCE;

    // 어떻게 보여줄꺼야???
    //doGet / doPost

    // 화면 제공
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("리스트화면을 뿌려줘");
        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);





    }
}
