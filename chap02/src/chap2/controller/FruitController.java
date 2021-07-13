package chap2.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap02.model.Apple;

/**
 * Servlet implementation class FruitController
 */
@WebServlet("/fruit/controller")
public class FruitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fruit = req.getParameter("fruit");
		// 해당 과일 이름의 파일의 내용을 읽어서 sysout으로 출력해보세요
		File file = new File(String
				.format("C:\\Users\\xoghk\\OneDrive\\바탕 화면\\공부\\국비\\git\\JSPStudy\\chap02\\files\\%s.txt", fruit));
		BufferedReader bin = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = bin.readLine()) != null) {
			sb.append(line);
		}
		req.setAttribute("fruitName", fruit);
		req.setAttribute("fruitDetail", sb);

		req.setAttribute("apple1", new Apple());
		req.setAttribute("apple2", new Apple());
		req.setAttribute("apple3", new Apple());
		req.setAttribute("appleArray", new Apple[] { new Apple(), new Apple(), new Apple(), new Apple() });
		req.getRequestDispatcher("/attribute/view/fruitDetail.jsp").forward(req, resp);
//		resp.sendRedirect("/chap02/attribute/fruitSelector.jsp");
	}
}
