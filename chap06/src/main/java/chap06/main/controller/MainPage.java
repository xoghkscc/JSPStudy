package chap06.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.admin.controller.AddInfo;
import chap06.admin.controller.WorldCup;

@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<WorldCup> wcList = new AddInfo().getWorldCupDb();
		request.setAttribute("q_count", wcList.size());
		request.setAttribute("wcList", wcList);
		request.getRequestDispatcher("WEB-INF/index/index.jsp").forward(request, response);
	}

}
