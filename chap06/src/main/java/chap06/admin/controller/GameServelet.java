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

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class GameServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<WorldCup_Item> itemList;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wid = Integer.parseInt(request.getParameter("wid"));
		itemList = getItemList(wid);
		request.setAttribute("itemList", itemList);
		
		request.getRequestDispatcher("/WEB-INF/gamePage.jsp").forward(request, response);
	}
	
	public ArrayList<WorldCup_Item> getItemList(int wid) {
		ArrayList<WorldCup_Item> itemList = new ArrayList<WorldCup_Item>();
		
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		String sql = String.format("SELECT * FROM worldcup_item WHERE wid = %d", wid);
		
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				itemList.add(new WorldCup_Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return itemList;
	}


}
