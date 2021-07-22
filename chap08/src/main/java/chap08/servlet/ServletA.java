package chap08.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletA
 */
public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String name;
	String tel;
	String user;
	public void init() throws ServletException {
		ServletContext application = getServletContext();//context-param은 이걸로 가지고 와야함
		
		ServletConfig config = getServletConfig();
		
		this.name = config.getInitParameter("name");
		this.tel = config.getInitParameter("tel");
		this.user = application.getInitParameter("user");
		System.out.println("name: " + config.getInitParameter("name"));
		System.out.println("tel: " + config.getInitParameter("tel"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("잘 되고 있나?");
	}
}
