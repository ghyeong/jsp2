package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("두포스트 호출했네요." + request.getParameterMap());
		PrintWriter out = resp.getWriter();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> m = request.getParameterMap();
		Iterator<String> it = m.keySet().iterator();
		String result = "두겟 호출했네요.";
		while (it.hasNext()) {
			String key = it.next();
			result += key + ":" + request.getParameter(key);

		}
		doProcess(resp, result);
	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
	}
}
