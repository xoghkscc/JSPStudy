package chap08.servlet;

import javax.servlet.http.HttpServletRequest;

public class Music extends Base{

	public Music() {
		super.url = "music";
	}

	@Override
	public void function(String text, HttpServletRequest req) {
		System.out.println("À½¾Ç ¸®½ºÆ®¸¦ ²¨³»´Â °÷");
	}
}
