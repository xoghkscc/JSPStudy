package chap08.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// /chap08//aaa로 들어오면 a.jsp
		// /chap08/bbb로 들어오면 b.jsp

		String uri = req.getRequestURI();
		Pattern regex = Pattern.compile("/");
		String[] uilArraty = regex.split(uri);
		String forwardUri = uilArraty[2];

		ArrayList<Base> list = new ArrayList<Base>();
		list.add(new Blog());
		list.add(new Music());

		for (Base base : list) {
			if (forwardUri.equals(base.getUrl())) {
				base.function(forwardUri, req);
			}
		}

		req.getRequestDispatcher("/WEB-INF/page/" + forwardUri + ".jsp").forward(req, resp);
	}

}
