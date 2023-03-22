package com.searchbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.searchbar.service.*;
import com.searchbar.model.*;
import com.searchbar.repository.repository;

public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			System.out.println(request.getSession().getId());
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			boolean flag = service.check(user);
			if (!flag) {
//				System.out.println("not mathching ");
				if((Boolean)service.checkpassword(user)) {
					session.setAttribute("msg", "Create your account today and unlock a world of possibilities.");
					RequestDispatcher rs = request.getRequestDispatcher("Register.jsp");
					rs.forward(request, response);
				}
				else {
					session.setAttribute("msg", "The email matches, but the password entered is incorrect. Please try again.");
					RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
					rs.forward(request, response);
				}
				

			} else {
//				System.out.println("yes mathching ");
				session.setAttribute("user", (User) repository.getuser(user));
				RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
				rs.forward(request, response);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.setAttribute("msg", "An error occurred during processing. Please try again.");
			RequestDispatcher rs = request.getRequestDispatcher("Register.jsp");
			rs.forward(request, response);
		}

	}

}
