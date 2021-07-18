package chap03.bean;

import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GradeQuiz
 */
@WebServlet("/student_servlet")
public class GradeQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TreeSet<Student> rankList;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setCharacterEncoding("EUC-KR");

		HttpSession session = req.getSession();

		if (session.getAttribute("id") == null) {
			session.setAttribute("id", 1);
		} else {
			session.setAttribute("id", ((int) session.getAttribute("id")) + 1);
		}	

		if (session.getAttribute("rankList") == null) {
			rankList = new TreeSet<Student>();
		} else {
			rankList = (TreeSet<Student>) session.getAttribute("rankList");
		}
		
		Student st = new Student();
		st.setId((int) session.getAttribute("id"));
		st.setName(req.getParameter("name"));
		st.setKor(Integer.parseInt(req.getParameter("kor")));
		st.setEng(Integer.parseInt(req.getParameter("eng")));
		st.setMath(Integer.parseInt(req.getParameter("math")));
		st.setAvg(Math.round(st.getKor() + st.getEng() + st.getMath()) / 3.0);
		rankList.add(st);

		rankList = Rank(rankList);// 순위를 조정

		session.setAttribute("rankList", rankList);

		resp.sendRedirect("./javabean/grade.jsp");
	}
	public TreeSet<Student> Rank(TreeSet<Student> rankList) {
		TreeSet<Student> rankListReset = new TreeSet<Student>();
		int rank = 1;
		for (Student st : rankList) {
			st.setRank(rank);
			rankListReset.add(st);
			rank++;
		}
		return rankListReset;
	}
//	treeSet를 ArrayList로 변환한뒤 indexof로 해보자
}
