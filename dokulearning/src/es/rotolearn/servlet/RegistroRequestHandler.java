
package es.rotolearn.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.rotolearn.entities.Usuario;
import es.rotolearn.javaBean.RegistroBean;

public class RegistroRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = "login.jsp";
		System.out.println("Creamos el usuario");
		
		/*HAGO  LA CONSULTA A LA BBDD*/
		// 1 Create the factory of Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dokulearning");//ESTO ES CLAVE

		// 2 Create the Entity Manager
		EntityManager em = factory.createEntityManager();

		// 3 Get one EntityTransaction
		em.getTransaction().begin();

		//Creamos el usuario a buscar en la BBDD
		Usuario newUsuario = new Usuario();
		
		newUsuario.setNickname(request.getParameter("nick"));
		Usuario resultado = em.find(newUsuario.getClass(), newUsuario.getNickname());
		if(resultado == null){ // si no existe el usuario, puedo crearlo
		//
		// Modificar el html para quitar lo de la segunda contraseña y cambiar lo de la imagen por  un textbox
		//
		System.out.println("El getparameter " +  request.getParameter("nick") + "fin nombre");
		System.out.println("voy a meter a este usuario " + newUsuario.getNickname());
		newUsuario.setNombre(request.getParameter("nombre"));
		newUsuario.setTipo(request.getParameter("optradio"));
		newUsuario.setApellido1(request.getParameter("apellido1"));
		newUsuario.setApellido2(request.getParameter("apellido2"));
		newUsuario.setEmail(request.getParameter("email"));
		newUsuario.setPass(request.getParameter("pass"));
		//newUsuario.setFecha_Nac(request.getParameter("date")); es un string y espera un date
		newUsuario.setDireccion(request.getParameter("direccion"));
		newUsuario.setDescripcion(request.getParameter("descripcion"));
		newUsuario.setIntereses(request.getParameter("intereses"));
		newUsuario.setTelefono(request.getParameter("tlf"));
		newUsuario.setImagen(request.getParameter("exampleInputFile"));
		try {
			em.persist(newUsuario);
			
		} catch (Exception e) {
			System.out.println("Descripcion: " + e.getMessage());
		}
		
		}	else{ 		System.out.println("Existe el usuario pues NO lo creo");
					request.setAttribute("error","reg");
						ruta = "formulario_registro.jsp";
				}
		

		
		em.getTransaction().commit();
		em.close();

		return ruta;
	}

}