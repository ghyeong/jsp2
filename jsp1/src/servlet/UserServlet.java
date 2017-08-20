package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBConnector;

public class UserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String[] hobbies = request.getParameterValues("hobby");
		String hobby = "";
		for (String h : hobbies) {
			hobby += h + ",";
		}
		hobby = hobby.substring(0, hobby.length() - 1);
		
		String result = name+"님 회원가입에 실패했습니다.";
		Connection con;
		try {
			con = DBConnector.getCon();
			String sql = "insert into user(id,password,name,hobby)";
			sql += "values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
			ps.setString(4, hobby);
			int row = ps.executeUpdate(); 
			if(row ==1) {
				result =name + "님 회원가입에 성공하셨습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		doProcess(resp, result);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
	}
}
