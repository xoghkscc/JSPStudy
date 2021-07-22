package chap08.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Base {

	String url = "Base";

	public Base() {
	}

	public void function(String text, HttpServletRequest req) {
		
	}

	public String getUrl() {
		return this.url;
	}
}
