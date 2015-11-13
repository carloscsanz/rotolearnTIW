package es.rotolearn.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CursoRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = "profes_crearcurso.jsp";
		
		es.rotolearn.entities.Curso crear_curso = new es.rotolearn.entities.Curso();
		crear_curso.setTitulo(request.getParameter("titulo"));
		es.rotolearn.entities.Usuario user = new es.rotolearn.entities.Usuario();
		user.setNickname("profe");
		crear_curso.setUsuario(user);
		crear_curso.setDescripcion(request.getParameter("descripcion"));
		crear_curso.setDificultad(request.getParameter("dificultad"));
		crear_curso.setHoras(Integer.parseInt(request.getParameter("horas")));
		crear_curso.setPrecio(Integer.parseInt(request.getParameter("precio")));
		crear_curso.setImagen("RUTA IMAGEN");//ESTO HAY QUE CAMBIARLO
		crear_curso.setEmail_paypal(request.getParameter("paypal"));
		crear_curso.setCategoria(request.getParameter("categoria"));
		crear_curso.setDestacado("NO");
		crear_curso.setValidado("NO");
		
		// 1 Create the factory of Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dokulearning");

		// 2 Create the Entity Manager
		EntityManager em = factory.createEntityManager();

		// 3 Get one EntityTransaction and start it
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Create one entity user, set its attributes and make it persist
		
		em.persist(crear_curso);

		// 4 Commmit the transaction
		tx.commit();

		// 5 Close the manager
		em.close();
		
	    
	    //request.setAttribute("curso", "si");
		
		return ruta;
	}

}
