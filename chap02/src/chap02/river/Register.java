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
		System.out.println("������ ó�� �ʱ�ȭ �� �� �ѹ��� �����");
		System.out.println("�ʱ�ȭ ���Դϴ�..");
		System.out.println("�ʱ�ȭ �������ϴ�..");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��û ��İ� ������� service()�� ȣ��");
		//service�� �⺻ ������ ��û�� method�� ���� ��û�� �˸��� doMethod()�� �й��ϴ� ���̴�
		super.service(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get ��� ��û�� �����ϸ� doGet()�� ȣ��");
		// HttpServletRequest�� ������� ��û�� ���� ��� ������ ��� �ִ�.
		// �� �߿��� form�� ���� �Ƿ��� �����ʹ� ��û ��ü�� parameter�� ����ִ�
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		System.out.printf("����ڰ� ���� �̸�: %s %s\n", firstName, lastName);
		response.getWriter().append("Username : "+firstName).append(" " + lastName);
		
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getContextPath());
		System.out.println(request.getLocalAddr());
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post ��� ��û�� �����ϸ� doPost()�� ȣ��");
		doGet(request, response);
	}

}
