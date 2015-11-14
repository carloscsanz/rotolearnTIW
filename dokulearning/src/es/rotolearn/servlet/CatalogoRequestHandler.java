package es.rotolearn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CatalogoRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String ruta="catalogo.jsp";
		
		/*HAGO LA CONSULTA A LA BBDD*/
		// 1 Create the factory of Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dokulearning");//ESTO ES CLAVE

		// 2 Create the Entity Manager
		EntityManager em = factory.createEntityManager();

		// 3 Get one EntityTransaction
		EntityTransaction tx = em.getTransaction();

		//generamos la query de cursos
		Query query = em.createQuery("SELECT e FROM Curso e");
		
		//PARA BUSCAR EL USUARIO QUE HEMOS RECIBIDO POR PARAMETROS, si devuelve null no existe si devuelve algo es que existe
		tx.begin();//Comenzamos la transaccion
		query.setMaxResults(5);
		List<es.rotolearn.entities.Curso> results =(List<es.rotolearn.entities.Curso>) query.getResultList();
		em.close();
		Iterator it = results.iterator();
		
		es.rotolearn.entities.Curso aux = new es.rotolearn.entities.Curso();
		ArrayList<es.rotolearn.entities.Curso> array = new ArrayList<es.rotolearn.entities.Curso>();
		
		while(it.hasNext()){
			aux = (es.rotolearn.entities.Curso)it.next();
			array.add(aux);
			
		}
		
		
		

		//ArrayList<es.rotolearn.entities.Curso> cursos = new ArrayList<es.rotolearn.entities.Curso>();
		/*for(int i = 0; i < array.length; i++){
			cursos.add(results.get(i));
		}*/
		request.setAttribute("listaCursos", array);
		// 5 Close the manager
		return ruta;
	}

}