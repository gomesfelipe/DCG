package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.Dao;

@WebServlet("/delete")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Excluir() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Dao d = new Dao();
		Comentario comment = d.findCommentary(id);
		d.delete(comment);
		List<Comentario> all = d.findAll();
		Collections.reverse(all);
		HttpSession session = request.getSession();
		session.setAttribute("all", all);		
		response.sendRedirect("index.jsp");
	}

}
