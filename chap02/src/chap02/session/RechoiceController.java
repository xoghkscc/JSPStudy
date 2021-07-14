package chap02.session;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RechoiceController
 */
@WebServlet("/fruit/re")
public class RechoiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ServletContext : ���� ������ ����Ǿ� �ִ� ��ü
		ServletContext application = req.getServletContext();
		//HttpSession : ���� ������ ����Ǿ� �ִ� ��ü
		HttpSession session = req.getSession();
		
		session.removeAttribute("choice");
		resp.sendRedirect("/chap02/scope/scope.jsp");
	}
}
