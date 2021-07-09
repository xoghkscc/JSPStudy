package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
// /chap01/gugudan������ ����ڿ��� ���ִ� ������ ���̺��� �����ϴ� ������ ����� ������
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("<table border='1'>");
		for (int dan = 2; dan <= 9; dan++) {
			out.print("<tr>");
			for (int gop = 1; gop <= 9; gop++) {
				out.printf("<td>%d X %d = %d</td>", dan, gop, dan*gop);
			}
			out.print("</tr>");
		}
		out.print("</table>");
	}
}
