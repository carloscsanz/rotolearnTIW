package es.rotolearn.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		String ruta;
		
		String nick = request.getParameter("nick");
		String pass = request.getParameter("pass");
		
		/*HAGO LA CONSULTA A LA BBDD*/
		// 1 Create the factory of Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("administracion");//ESTO ES CLAVE

		// 2 Create the Entity Manager
		EntityManager em = factory.createEntityManager();

		// 3 Get one EntityTransaction
		EntityTransaction tx = em.getTransaction();

		//Creamos el usuario a buscar en la BBDD
		es.rotolearn.entities.Admin aux = new es.rotolearn.entities.Admin();
		aux.setNickname(nick);
		aux.setPassword(pass);
		
		//PARA BUSCAR EL USUARIO QUE HEMOS RECIBIDO POR PARAMETROS, si devuelve null no existe si devuelve algo es que existe
		tx.begin();//Comenzamos la transaccion
		es.rotolearn.entities.Admin resultado = em.find(aux.getClass(), aux.getNickname());
		
		// 5 Close the manager
		em.close();
		
		if(resultado == null){
			request.setAttribute("error", "true");
			ruta = "admin_login.jsp";
		}else{
			
			if(resultado.getNickname().equals(nick)){
				//System.out.println("Usuario administrador, puede entrar");
				
				if(resultado.getPassword().equals(pass)){
					//System.out.println("Pass correcta, puede entrar");
					
					session = ((HttpServletRequest) request).getSession();
					session.setAttribute("logueado", "true");
					session.setAttribute("usuario",nick);
					ruta = "admin_index.jsp";
					
				}else{
					//System.out.println("Pass incorrecta, no puede entrar");
					request.setAttribute("error", "pass");
					ruta = "admin_login.jsp";
				}
				
			}else{
				//System.out.println("Login incorrecto usuario no valido");
				request.setAttribute("error", "user");
				ruta = "admin_login.jsp";
			}
		}
		return ruta;
	}

}
