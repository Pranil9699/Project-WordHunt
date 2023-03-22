package com.searchbar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			int srno = Integer.parseInt(request.getParameter("srno"));
			if (((User) sessions.getAttribute("user")).getId() == id) {

				System.out.println(id + contentid);
				int result = com.searchbar.service.service.deletecontent(new Contentid(contentid, id, srno));
				System.out.println(result);
				if (result == 1) {
					@SuppressWarnings("unchecked")
					List<Content> content = (List<Content>) request.getSession().getAttribute("content");
					List<Content> content1 = new ArrayList<Content>();
					for (Content obj : content) {
						if (obj.getContentid().getSrno() == srno) {
							continue;
						} else
							content1.add(obj);
					}
					request.getSession().removeAttribute("content");
					request.getSession().setAttribute("content", (List<Content>) content1);
					System.out.println("settint new Object");
					sessions.setAttribute("msg", "Deleted The Row...");
					RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
					rs.forward(request, response);
				} else {
					request.getSession().setAttribute("msg", "Deleting Row Failded...");
					RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
					rs.forward(request, response);
				}
			} else {
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
			int id = Integer.parseInt(request.getParameter("id"));
			int contentid = Integer.parseInt(request.getParameter("contentid"));
			int srno = Integer.parseInt(request.getParameter("srno"));
			System.out.println(id + " : " + contentid);
			boolean flag = com.searchbar.service.service.updatecontent(information, new Contentid(contentid, id, srno));
			if (flag) {
				// Content content = (Content) repository.getContent(new Contentid(contentid,
				// id,srno));
				@SuppressWarnings("unchecked")
				List<Content> content = (List<Content>) request.getSession().getAttribute("content");
				List<Content> content1 = new ArrayList<Content>();
				for (Content obj : content) {
					if (obj.getContentid().getSrno() == srno) {
						obj.setInfomation(information);
						content1.add(obj);
					} else
						content1.add(obj);
				}
				request.getSession().removeAttribute("content");
				System.out.println(request.getSession().getId());
				request.getSession().setAttribute("content", (List<Content>) content1);
				request.getSession().setAttribute("msg", "Update The Row...");
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
			RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
			rs.forward(request, response);

		}
	}

}
