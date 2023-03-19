package com.searchbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.searchbar.model.Content;
import com.searchbar.model.Contentid;
import com.searchbar.model.User;
import com.searchbar.repository.repository;

public class updatecontent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession sessions = request.getSession();
			int id = Integer.parseInt(request.getParameter("id"));
			int contentid = Integer.parseInt(request.getParameter("contentid"));
			if(((User)sessions.getAttribute("user")).getId()==id) {

			System.out.println(id+contentid);
			int result = com.searchbar.service.service
					.deletecontent(new Contentid(contentid,id));
			if (result == 1) {

				request.getSession().removeAttribute("content");
				request.getSession().setAttribute("msg", "Deleted The Row...");
				RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
				rs.forward(request, response);
			} else {
				request.getSession().setAttribute("msg", "Deleting Row Failded...");
				RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
				rs.forward(request, response);
			}
			}else {
				request.getSession().setAttribute("msg", "Your Are Not Valid User ...");
				RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
				rs.forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.getSession().setAttribute("msg", "An error occurred while deleting user data. Please try again.");
			RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
			rs.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String information = request.getParameter("information");
			int id=Integer.parseInt(request.getParameter("id"));
			int contentid=Integer.parseInt(request.getParameter("contentid"));
			System.out.println(id+" : "+contentid);
			boolean flag = com.searchbar.service.service.updatecontent(information,
					new Contentid(contentid, id));
			if (flag) {
				Content content = (Content) repository.getContent(new Contentid(contentid, id));
				request.getSession().removeAttribute("content");
				request.getSession().setAttribute("content", content);
				request.getSession().setAttribute("msg","Update The Row...");
				RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
				rs.forward(request, response);
			} else {
				request.getSession().setAttribute("msg", "Updating Row Failed ...");
				RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
				rs.forward(request, response);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			request.getSession().setAttribute("msg", "An error occurred while saving user data. Please try again.");
			RequestDispatcher rs = request.getRequestDispatcher("Register.jsp");
			rs.forward(request, response);

		}
	}

}
