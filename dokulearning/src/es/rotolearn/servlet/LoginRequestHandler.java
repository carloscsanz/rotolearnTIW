package es.rotolearn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		System.out.println("Handler login received the request");
		//HAY QUE AÑADIR/MODIFICAR PARA METERLE LA BBDD
		String ruta;
		String nick = request.getParameter("Nickname");
		String pass = request.getParameter("Password");
		System.out.println("Nick introducido: "+nick);
		System.out.println("Pass introducida: "+pass);
		
		if(nick == null){
			request.setAttribute("error", "true");
			ruta = "login.jsp";
		}else{
			
			if(nick.equals("admin")){
				System.out.println("Usuario administrador, puede entrar");
				
				if(pass.equals("admin")){
					System.out.println("Pass correcta, puede entrar");
					//Hay que guardar los datos del user en un BEAN para poder utilizarlos en otras paginas
					session = ((HttpServletRequest) request).getSession();
					session.setAttribute("logueado", "true");
					session.setAttribute("usuario",nick);
					ruta = "index.jsp";
					
				}else{
					System.out.println("Pass incorrecta, no puede entrar");
					request.setAttribute("error", "pass");
					ruta = "login.jsp";
				}
				
			}else{
				System.out.println("Login incorrecto usuario no valido");
				request.setAttribute("error", "user");
				ruta = "login.jsp";
			}
		}
		return ruta;
	}

}
