package com.example.demo.member;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
@SuppressWarnings("serial")
@WebServlet("/member/memberList")
public class MemberServlet extends HttpServlet {
    Logger logger = Logger.getLogger(MemberServlet.class);
    MemberDao memberDao = new MemberDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Map<String,Object>> mList = null;
       mList = memberDao.memberList();
       req.setAttribute("mList", mList);
       RequestDispatcher view = req.getRequestDispatcher("memberList.jsp");
       view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
    
}
