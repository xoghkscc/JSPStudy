package chap05.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[info]: " + req.getRequestURI()+"��"+req.getMethod()+"��� ��û �߻�");
		req.getRequestDispatcher("/WEB-INF/blog/home.jsp").forward(req, resp);
	}
}
