package com.busanit501.jsp_server_project_260205.todo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
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
