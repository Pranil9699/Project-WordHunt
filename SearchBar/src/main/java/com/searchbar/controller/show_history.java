package com.searchbar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.searchbar.service.*;
import com.searchbar.model.*;
import com.searchbar.repository.*;

/**
 * Servlet implementation class show_history
 */

public class show_history extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession sessions = request.getSession();
		if (sessions.getAttribute("user") != null) {
			sessions.setAttribute("contents",(List<Content>) service.getContents((User)sessions.getAttribute("user")));
			RequestDispatcher rs = request.getRequestDispatcher("History.jsp");
			rs.forward(request, response);
		}else {
			sessions.setAttribute("msg", "An error occurred during processing. Please try again.");
			RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
			rs.forward(request, response);
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
