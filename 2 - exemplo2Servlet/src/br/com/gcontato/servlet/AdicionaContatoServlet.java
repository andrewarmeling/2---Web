package br.com.gcontato.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AdicionaContatoServlet() {
		super();
	}

	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		String nome = request.getParameter("nome");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Home</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1 style='text-align:right; position:absolute; right:5%;'>");
//		out.print("Bem-vindo, ");
//		out.print(nome);
//		out.println(".");
//		out.println("</h1>");
//		out.println("</body>");
//		out.println("</html>");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Home</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 style='text-align:right; position:absolute; right:5%;'>");
		out.print("Bem-vindo, ");
		out.print(nome);
		out.println(".");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Home</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 style='text-align:right; position:absolute; right:5%;'>");
		out.print("Bem-vindo, ");
		out.print(nome);
		out.println(".");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
