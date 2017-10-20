package br.com.ads.servlet;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BemVindo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<haed>");
		out.println("<title>Primeira Servlet </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Oi mundo Servlet!</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}