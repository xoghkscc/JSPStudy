package chap06.admin.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hikariCP.HikariCP;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		int win_id =Integer.parseInt(request.getParameter("win_id"));
		setWinLost(win_id);
		response.sendRedirect(request.getContextPath()+"/home");
	}
	
	public void setWinLost(int win_id) {
		int wid=0;
		try (Connection conn = new HikariCP().getHikariDataSource().getConnection()){
			String sql1 = String.format("UPDATE worldcup_item set win = win +1 WHERE id = %d", win_id);
			try(PreparedStatement pstmt = conn.prepareStatement(sql1)){
				pstmt.executeUpdate();
			}
			
			String sql2 = String.format("SELECT wid FROM worldcup_item WHERE id = %d", win_id);
			try(PreparedStatement pstmt = conn.prepareStatement(sql2)){
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					wid = rs.getInt(1);
				}
			}
			
			String sql3 = String.format("UPDATE worldcup_item set lose = lose +1 WHERE wid = %d and id != %d", wid, win_id);
			try(PreparedStatement pstmt = conn.prepareStatement(sql3)){
				pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
