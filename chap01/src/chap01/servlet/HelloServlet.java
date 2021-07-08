package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")//이 서블릿으로 접속하려면 어떤 URL로 접속해야하는지 설정하는 어노테이션 (/chap01/hello)
public class HelloServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>안녕하세요</title></head><body>");
		out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css\">");
		
		out.println("<h1>Hello!</h1>");
		out.println(" <hr>\r\n" + 
				"    <!-- Standard button -->\r\n" + 
				"    <button type=\"button\" class=\"btn btn-default\">Default</button>\r\n" + 
				"\r\n" + 
				"    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->\r\n" + 
				"    <button type=\"button\" class=\"btn btn-primary\">Primary</button>\r\n" + 
				"\r\n" + 
				"    <!-- Indicates a successful or positive action -->\r\n" + 
				"    <button type=\"button\" class=\"btn btn-success\">Success</button>\r\n" + 
				"\r\n" + 
				"    <!-- Contextual button for informational alert messages -->\r\n" + 
				"    <button type=\"button\" class=\"btn btn-info\">Info</button>\r\n" + 
				"\r\n" + 
				"    <!-- Indicates caution should be taken with this action -->\r\n" + 
				"    <button type=\"button\" class=\"btn btn-warning\">Warning</button>\r\n" + 
				"\r\n" + 
				"    <!-- Indicates a dangerous or potentially negative action -->\r\n" + 
				"    <button type=\"button\" class=\"btn btn-danger\">Danger</button>\r\n" + 
				"\r\n" + 
				"    <!-- Deemphasize a button by making it look like a link while maintaining button behavior -->\r\n" + 
				"    <button type=\"button\" class=\"btn btn-link\">Link</button>\r\n" + 
				"\r\n" + 
				"    <!-- On rows -->\r\n" + 
				"    <table class=\"table table-hover\">\r\n" + 
				"        <tr class=\"active\">\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr class=\"success\">\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr class=\"warning\">\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr class=\"danger\">\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr class=\"info\">\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"            <td>content</td>\r\n" + 
				"        </tr>\r\n" + 
				"    </table>\r\n" + 
				"\r\n" + 
				"    <hr>\r\n" + 
				"\r\n" + 
				"    <div class=\"progress\">\r\n" + 
				"        <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"60\" aria-valuemin=\"0\" aria-valuemax=\"100\"\r\n" + 
				"            style=\"width: 60%;\">\r\n" + 
				"            <span>60%</span>\r\n" + 
				"        </div>\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <div class=\"row\">\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"        <div class=\"col-sm-1\">.col-md-1</div>\r\n" + 
				"      </div>\r\n" + 
				"      <div class=\"row\">\r\n" + 
				"        <div class=\"col-md-8\">.col-md-8</div>\r\n" + 
				"        <div class=\"col-md-4\">.col-md-4</div>\r\n" + 
				"      </div>\r\n" + 
				"      <div class=\"row\">\r\n" + 
				"        <div class=\"col-xs-4\">.col-md-4</div>\r\n" + 
				"        <div class=\"col-xs-4\">.col-md-4</div>\r\n" + 
				"        <div class=\"col-xs-4\">.col-md-4</div>\r\n" + 
				"      </div>\r\n" + 
				"      <div class=\"row\">\r\n" + 
				"        <div class=\"col-md-6\">.col-md-6</div>\r\n" + 
				"        <div class=\"col-md-6\">.col-md-6</div>\r\n" + 
				"      </div>");
		
		out.println("</body></html>");
	}
}
