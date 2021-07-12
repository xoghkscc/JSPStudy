package chap02.river;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/river/register")
public final class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿을 처음 초기화 할 때 한번만 실행됨");
		System.out.println("초기화 중입니다..");
		System.out.println("초기화 끝났습니다..");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 방식과 상관없이 service()가 호춤");
		//service의 기본 동작은 요청의 method에 따라 요청을 알맞은 doMethod()로 분배하는 것이다
		super.service(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get 방식 요청이 도착하면 doGet()이 호출");
		// HttpServletRequest는 사용자의 요청에 대한 모든 정보가 담겨 있다.
		// 그 중에서 form을 통해 실려온 데이터는 요청 객체의 parameter에 담겨있다
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		System.out.printf("사용자가 보낸 이름: %s %s\n", firstName, lastName);
		response.getWriter().append("Username : "+firstName).append(" " + lastName);
		
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getContextPath());
		System.out.println(request.getLocalAddr());
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 방식 요청이 도착하면 doPost()가 호출");
		doGet(request, response);
	}

}
