package com.searchbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.searchbar.model.*;
import com.searchbar.service.*;

public class getdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession sessions = request.getSession();
			if (sessions.getAttribute("user") != null) {
              
				String CategoryType = request.getParameter("categoryName");
				if(CategoryType.toLowerCase().equals("other")) {
					CategoryType=request.getParameter("otherCategory");
				}
				String SearchName=request.getParameter("search");
				Content content= new Content();
				System.out.println("1)"+CategoryType+":2)"+SearchName);
				User user =(User)request.getSession().getAttribute("user");
				int count=service.getcount(user);
				content.setContentid(new Contentid(count,user.getId()));
				content.setCategory(CategoryType);
				content.setUser((User)user);
				content.setName(SearchName);
				content=(Content)service.getInfo(content);
				if(count==-1) {
					System.out.println("their is "+count);
					sessions.setAttribute("msg", "Error Is getting in here When the gettinng the Id from DB");
					RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
					rs.forward(request, response);
				} else {
					sessions.removeAttribute("content");
					sessions.setAttribute("content",(Content)content);
					System.out.println(content.getInfomation());
					RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
					rs.forward(request, response);
					System.out.println("their is "+count);
				}
			} else {
				System.out.println("bug here ");
				sessions.setAttribute("msg", "Your haven't The Session Soo Plesed Make Sure Your Are Login");
				RequestDispatcher rs = request.getRequestDispatcher("DashBoard.jsp");
				rs.forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
			rs.forward(request, response);
		}
	}

}
