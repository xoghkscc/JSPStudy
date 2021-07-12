package chap02.river;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class movie_register
 */
@WebServlet("/movie_register")
public class movie_register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setCharacterEncoding("EUC-KR");

		String time1 = req.getParameter("time1");
		String time2 = req.getParameter("time2");
		String time3 = req.getParameter("time3");
		String time4 = req.getParameter("time4");
		String big = req.getParameter("����");
		String small = req.getParameter("û�ҳ�");
		String sinior = req.getParameter("�ôϾ�");
		String sick = req.getParameter("�����");

		int priceBig = movieCostBig(time1, big);
		int priceSmall = movieCostSmall(time2, small);
		int priceSinior = movieCostSinior(time3, sinior);
		int priceSick = movieCostSick(time4, sick);
		

		int big_price = Integer.parseInt(big) * priceBig;
		int small_price = Integer.parseInt(small) * priceSmall;
		int siniorl_price = Integer.parseInt(sinior) * priceSinior;
		int sick_price = Integer.parseInt(sick) * priceSick;

		String textBig = String.format("�ð��� : %s, ��� : ����, �ο��� : %s, ���� : %d �Ѱ��� : %d\n", time1, big, priceBig, big_price);
		String textSmall = String.format("�ð��� : %s, ��� : û�ҳ�, �ο��� : %s, ���� : %d �Ѱ��� : %d\n", time2, small, priceSmall, small_price);
		String textSinior = String.format("�ð��� : %s, ��� : �ôϾ�, �ο��� : %s, ���� : %d �Ѱ��� : %d\n", time3, sinior, priceSinior, siniorl_price);
		String textSick = String.format("�ð��� : %s, ��� : �����, �ο��� : %s, ���� : %d �Ѱ��� : %d\n", time4, sick, priceSick, sick_price);

		resp.getWriter().append(textBig).append(textSmall).append(textSinior).append(textSick);
	}

	public int movieCostBig(String time, String person) {
		String[] times= {"����", "�Ϲ�", "������", "�ɾ�"};
		int price=0;
		int[] cost= {6000,7000, 9000, 7000};
		for (int i = 0; i < times.length; i++) {
					price = cost[i];
		}
		return price;
	}
	public int movieCostSmall(String time, String person) {
		String[] times= {"����", "�Ϲ�", "������", "�ɾ�"};
		int price=0;
		int[] cost= {6000,7000, 8000, 7000};
		for (int i = 0; i < times.length; i++) {
			price = cost[i];
		}
		return price;
	}
	public int movieCostSinior(String time, String person) {
		String[] times= {"����", "�Ϲ�", "������", "�ɾ�"};
		int price=0;
		int[] cost= {5000,5000, 5000, 5000};
		for (int i = 0; i < times.length; i++) {
			price = cost[i];
		}
		return price;
	}
	public int movieCostSick(String time, String person) {
		String[] times= {"����", "�Ϲ�", "������", "�ɾ�"};
		int price=0;
		int[] cost= {5000,5000, 5000, 5000};
		for (int i = 0; i < times.length; i++) {
			price = cost[i];
		}
		return price;
	}
}
