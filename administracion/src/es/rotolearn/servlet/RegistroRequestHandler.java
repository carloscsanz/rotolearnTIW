package es.rotolearn.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistroRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta= "admin_reg.jsp";
		
		System.out.println("Creando persona");
		String NickName = request.getParameter("nick");
		
		
		System.out.println("Creamos el usuario");
		
		//Obtenemos cada uno de los campos del formulario de registro
		String Tipo = request.getParameter("optradio");
	    String Nombre = request.getParameter("nombre");
	    String Apellido1 = request.getParameter("apellido1");
	    String Apellido2 = request.getParameter("apellido2");
	    String Email = request.getParameter("email");
	    String Pass = request.getParameter("pass");
	    String Nacimiento = request.getParameter("date");
	    String Direccion = request.getParameter("direccion");
	    String Descripcion = request.getParameter("descripcion");
	    String Intereses = request.getParameter("intereses");
	    String Telefono = request.getParameter("tlf");
	    
	    //HACER LO DE LA BBDD
	    request.setAttribute("error","ok");
	    
		
		return ruta;
	}

}
