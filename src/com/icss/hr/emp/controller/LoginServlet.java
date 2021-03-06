package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.emp.service.EmpService;

/**
 * 验证登录数据访问接口 用户名不存在，响应1 登录错误，响应2 登录失败，响应3
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 输出流
		PrintWriter out = response.getWriter();

		// 获得登录名密码
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");

		// 调用业务功能
		EmpService service = new EmpService();

		try {

			int loginFlag = service.checkLogin(empLoginName, empPwd);

			// 如果登录成功，在session范围存储数据
			if (loginFlag == 3) {
				HttpSession session = request.getSession();
				session.setAttribute("empLoginName", empLoginName);
			}

			out.print(loginFlag);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
