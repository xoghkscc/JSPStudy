package chap02.quiz;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import chap02.quiz.Quizmodel;
import hikariCP.HikariCP;

/**
 * Servlet implementation class quiz
 */
@WebServlet("/quiz_servlet")
public class QuizServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//서블릿에서 DB와 연동을 하려면 Class.forName이 필수이다!!
		} catch (Exception e) {
		}

		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		String user_id = req.getParameter("id");
		String user_pw = req.getParameter("pw");
		HttpSession session = req.getSession();
		Quizmodel ud = new Quizmodel("0", "0", "0");//초기값 설정

		String sql = String.format("SELECT * FROM login WHERE user_id='%s'", user_id);

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ud = new Quizmodel(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (loginJudgment(user_id, user_pw, ud)) {//유저가 입력한 정보와 db에 저장된 정보가 일치하는지 판단하는 메서드
			session.setAttribute("login", ud);//아이디와 비밀번호가 일치한다면 login이라는 attribute에 ud를 실어나름
		} else {
			session.setAttribute("loginfalse", "false");//아이디와 비밀번호가 일치하지 않다면 loginfalse에 아무거나 실어 나름
		}

		resp.sendRedirect("/chap02/quiz/quiz.jsp");
	}

	public boolean loginJudgment(String user_id, String user_pw, Quizmodel ud) {
		String user_pw_secret = getSha256(user_pw);//유저가 입력한 pw를 SHA-256 암호화로 바꿔주는 메서드
		if (user_id.equals(ud.id)) {
			if (user_pw_secret.equals(ud.pw.trim())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public String getSha256(String text) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes());
			byte[] byteData = md.digest();
			for (int i = 0; i< byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString().trim();
	}
}

