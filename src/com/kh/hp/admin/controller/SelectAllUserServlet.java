package com.kh.hp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.UserService;
import com.kh.hp.admin.model.vo.User;






@WebServlet("/selectAllUser.ad")
public class SelectAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectAllUserServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("들어왔나욤?");
		
	ArrayList<User> list = new UserService().selectAll();
	
	System.out.println( list);
	
		String page = "";

		if(list != null) {
			request.setAttribute("list", list);
			page = "views/admin/UserManagement.jsp";
			
		} else {
			request.setAttribute("msg", "목록조회실패");
			page = "views/main/main.jsp";

		}
		request.getRequestDispatcher(page).forward(request, response);

	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
