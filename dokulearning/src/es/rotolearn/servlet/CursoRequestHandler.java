package es.rotolearn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import es.rotolearn.javaBean.RegistroBean;

public class CursoRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = "profes_crearcurso.jsp";
		HttpSession session;
		session = ((HttpServletRequest) request).getSession();
		//RegistroBean reg = (RegistroBean) session.getAttribute("perfil");
		
		//es.rotolearn.entities.Curso crear_curso = new es.rotolearn.entities.Curso();
		//crear_curso.setTitulo(request.getParameter("titulo"));
		//es.rotolearn.entities.Usuario user = new es.rotolearn.entities.Usuario();
		//user.setNickname(reg.getNickName());
		/*crear_curso.setUsuario(user);
		crear_curso.setDescripcion(request.getParameter("descripcion"));
		crear_curso.setDificultad(request.getParameter("dificultad"));
		crear_curso.setHoras(Integer.parseInt(request.getParameter("horas")));
		crear_curso.setPrecio(Integer.parseInt(request.getParameter("precio")));
		crear_curso.setImagen("RUTA IMAGEN");//ESTO HAY QUE CAMBIARLO
		crear_curso.setEmail_paypal(request.getParameter("paypal"));
		crear_curso.setCategoria(request.getParameter("categoria"));
		crear_curso.setDestacado("NO");
		crear_curso.setValidado("NO");*/
		
		/*Data source*/
		System.out.println("Vamos a probar a hacer la insercion por DATASOURCE");
		InitialContext miInitialContext;
		DataSource miDS;
		try{
			miInitialContext = new InitialContext();

			miDS = (DataSource) miInitialContext.lookup("RotolearnJNDI");

			Connection conexion = miDS.getConnection();

			Statement myStatement = conexion.createStatement();

			myStatement.executeUpdate("INSERT INTO CURSO VALUES ('"+request.getParameter("titulo")+"','"+"profe"+"','"+request.getParameter("precio")+"','"+request.getParameter("horas")+"','"+request.getParameter("paypal")+"','"+request.getParameter("dificultad")+"','"+request.getParameter("descripcion")+"','"+"NO"+"','"+"NO"+"','"+request.getParameter("categoria")+"', '"+request.getParameter("imagen")+"')");

			myStatement.close();
			conexion.close();
			
		}catch (NamingException e) {
			// TODO Bloque catch generado automaticamente
			e.printStackTrace();

		} catch (SQLWarning sqlWarning) {
			while (sqlWarning != null) {
				System.out.println("Error: " + sqlWarning.getErrorCode());
				System.out.println("Descripcion: " + sqlWarning.getMessage());
				System.out.println("SQLstate: " + sqlWarning.getSQLState());
				sqlWarning = sqlWarning.getNextWarning();
			}
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());
				sqlException = sqlException.getNextException();
			}
		}
		
		
		/*JPA*/
		// 1 Create the factory of Entity Manager
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("dokulearning");
	
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
		em.close();*/
		
	    
	    //request.setAttribute("curso", "si");
		
		return ruta;
	}

}
