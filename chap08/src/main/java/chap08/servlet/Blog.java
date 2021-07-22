package chap08.servlet;

import javax.servlet.http.HttpServletRequest;

public class Blog extends Base{

	public Blog() {
		super.url = "blog";
	}
	
	@Override
	public void function(String text, HttpServletRequest req) {
		System.out.println("블로그 이웃 목록 처리하는 곳");
	}

}
