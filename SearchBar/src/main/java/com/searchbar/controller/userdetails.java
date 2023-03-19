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
import com.searchbar.service.*;
/**
 * Servlet implementation class userdetails
 */
public class userdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		try {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user = new User(name,email,password);
		
		boolean flag=service.saveuser(user);
		System.out.println(flag);
		if(flag) {
			session.setAttribute("user",(User) repository.getuser(user));
			RequestDispatcher rs= request.getRequestDispatcher("DashBoard.jsp");
			rs.forward(request, response);
		}
		else {
			session.setAttribute("msg","This email address is already registered. Please log in.");
			RequestDispatcher rs= request.getRequestDispatcher("Login.jsp");
			rs.forward(request, response);
		}
	}catch(Exception ex) {
		ex.printStackTrace();
		session.setAttribute("msg","An error occurred while saving user data. Please try again.");
		RequestDispatcher rs= request.getRequestDispatcher("Register.jsp");
		rs.forward(request, response);
	}
	}

}
