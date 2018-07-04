package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Dao;


@WebServlet("/comment")
public class DCGfilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DCGfilter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String comentario = request.getParameter("comment");
			
			Comentario c = new Comentario();
			c.setTexto(comentario);
			c.setRegistrationDate(new Date());

			Dao d = new Dao();
			d.save(c);			
	}

}
