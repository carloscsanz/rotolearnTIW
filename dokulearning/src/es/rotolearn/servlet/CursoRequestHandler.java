package es.rotolearn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CursoRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = "profes_crearcurso.jsp";
		
		es.rotolearn.entities.Curso crear_curso = new es.rotolearn.entities.Curso();
		//HAY QUE MIRAR COMO METER LA PK
		es.rotolearn.entities.CursoPK curso_PK = new es.rotolearn.entities.CursoPK();
		curso_PK.setTitulo(request.getParameter("titulo"));
		curso_PK.setProfesor("Prueba");//HAY QUE METER EL BEAN DEL USUARIO LOGUEADO
		
		crear_curso.setId(curso_PK);
		crear_curso.setDescripcion(request.getParameter("descripcion"));
		crear_curso.setDificultad(request.getParameter("dificultad"));
		crear_curso.setHoras(Integer.parseInt(request.getParameter("horas")));
		crear_curso.setPrecio(Integer.parseInt(request.getParameter("precio")));
		crear_curso.setImagen("RUTA IMAGEN");//ESTO HAY QUE CAMBIARLO
		crear_curso.setEmail_paypal(request.getParameter("paypal"));
		crear_curso.setCategoria(request.getParameter("categoria"));
		crear_curso.setDestacado("NO");
		crear_curso.setValidado("NO");
		
	    
	    //request.setAttribute("curso", "si");
		
		return ruta;
	}

}
