package es.rotolearn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CursoRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = "profes_crearcurso.jsp";
		
		
		request.getParameter("descripcion");
	    request.getParameter("dificultad");
	    request.getParameter("horas");
	    request.getParameter("precio");
	    request.getParameter("dificultad");
	    request.getParameter("correo descripcion");
	    
	    request.setAttribute("curso", "si");
		
		return ruta;
	}

}
