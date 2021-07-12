package chap2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageNumController
 */
@WebServlet("/page/controller")
public class PageNumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
		request.setCharacterEncoding("EUC-KR");
		String page = request.getParameter("page");

		RequestDispatcher dispatcher = request.getRequestDispatcher(String.format("/forward/view/page%s.jsp", page));
//		dispatcher.forward(request, response);// 다른 페이지로 request를 그대로 전달하고 이동
		dispatcher.include(request, response);
		response.getWriter().append("서블릿에 추가됨");
	}
}
