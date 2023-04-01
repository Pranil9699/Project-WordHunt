package com.searchbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.searchbar.model.User;
import com.searchbar.repository.repository;

public class formservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				HttpSession sessions = request.getSession();
		if (sessions.getAttribute("user") != null) {
			RequestDispatcher rs = request.getRequestDispatcher("form.jsp");
			rs.forward(request, response);

		} else {
			request.getSession().invalidate();
			RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
			rs.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				User user=(User)session.getAttribute("user");
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				boolean flag = com.searchbar.service.service.updateuser(user);
				if(flag) {
					session.setAttribute("msg","Update Successfully ...");
					session.setAttribute("user",(User) repository.getuser(user));
					RequestDispatcher rs= request.getRequestDispatcher("DashBoard.jsp");
					rs.forward(request, response);
				}else {
					
					session.setAttribute("msg","Update Failed ...");
					System.out.println("update failed");
					//session.setAttribute("user",(User) repository.getuser(user));
					RequestDispatcher rs= request.getRequestDispatcher("DashBoard.jsp");
					rs.forward(request, response);
				}
			} else {
				session.invalidate();
				RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
				rs.forward(request, response);
			}
		} catch (Exception ex) {
			request.getSession().invalidate();
			RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
			rs.forward(request, response);
		}
	}

}
