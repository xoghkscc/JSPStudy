package chap06.admin.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

@WebServlet("/addInfo")
public class AddInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<WorldCup> wcList;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addWorldCupDb(request);
		wcList = getWorldCupDb();
		request.setAttribute("wcList", wcList);
		request.setAttribute("q_count", wcList.size());
		request.getRequestDispatcher("WEB-INF/index/index.jsp").forward(request, response);
	}

	public void addWorldCupDb(HttpServletRequest request) {
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();

		String sql1 = String.format("INSERT INTO WORLDCUP(WID, NAME) VALUES(WORLDCUP_WID_SEQ.nextval, '%s')",
				request.getParameter("title"));
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql1)) {
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		int worldcup_item_seq = 0;

		String sql2 = "SELECT MAX(WID) FROM worldcup";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				worldcup_item_seq = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		String[] names = request.getParameterValues("name");
		for (int i = 0; i < names.length; i++) {
			String sql3 = String.format(
					"INSERT INTO WORLDCUP_ITEM(ID, NAME, WID) VALUES(WORLDCUP_ITEM_SEQ.nextval, '%s', %d)", names[i],
					worldcup_item_seq);
			try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql3)) {
				pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public ArrayList<WorldCup> getWorldCupDb() {
		ArrayList<WorldCup> wcList = new ArrayList<WorldCup>();
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		
		String sql = "SELECT * FROM worldcup";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				wcList.add(new WorldCup(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return wcList;
	}
}
