package es.rotolearn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import es.rotolearn.tablas.Curso;

public class busquedaAvanzadaRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HE ENTRADO AL HANDLER SHUR");
		String palabra = request.getParameter("palabra");
		String categoria1 = request.getParameter("cat1");
		String categoria2 = request.getParameter("cat2");
		String categoria3 = request.getParameter("cat3");
		String categoria4 = request.getParameter("cat4");
		String categoria5 = request.getParameter("cat5");
		String categoria6 = request.getParameter("cat6");
		String categoria7 = request.getParameter("cat7");
		String categoria8 = request.getParameter("cat8");
		String categoria9 = request.getParameter("cat9");

		String query = "SELECT * from CURSO";
		
		if((palabra != null && !palabra.equals(""))|| categoria1 != null || categoria2 != null || 
	       categoria3 != null || categoria4 != null || categoria5 != null || 
	       categoria6 != null || categoria7 != null || categoria8 != null || 
	       categoria9 != null){
			query = query+" WHERE ";
			if(palabra != null && !palabra.equals("")){ //buscamos la palabra
				System.out.println("PARALABRA: "+palabra);
				String delimitadores= "[ .,;?!¡¿\'\"\\[\\]]+";
				String[] palabrasSeparadas = palabra.split(delimitadores);
				query = query+" (Titulo LIKE '%"+palabrasSeparadas[0]+"%'";
				for(int i = 1; i < palabrasSeparadas.length; i++){
					query = query+" OR Titulo LIKE '%"+palabrasSeparadas[i]+"%'";
				}
				query = query+")";
			}
			if(categoria1 != null || categoria2 != null || 
		       categoria3 != null || categoria4 != null || categoria5 != null || 
		       categoria6 != null || categoria7 != null || categoria8 != null || 
		       categoria9 != null){
				int categorias = 0;
				if(palabra != null && !palabra.equals(""))
					query = query + " AND ";
				query = query + " (";
				if(categoria1 != null){
					query = query+" Categoria LIKE '%"+categoria1+"%'";
					categorias++;
				}
				if(categoria2 != null){
					if(categorias>0)
						query = query+" OR";
					query = query+" Categoria LIKE '%"+categoria2+"%'";
					categorias++;
				}
				if(categoria3 != null){
					if(categorias>0)
						query = query+" OR";
					query = query+" Categoria LIKE '%"+categoria3+"%'";
					categorias++;
				}
				if(categoria4 != null){
					if(categorias>0)
						query = query+" OR";
					query = query+" Categoria LIKE '%"+categoria4+"%'";
					categorias++;
				}
				if(categoria5 != null){
					if(categorias>0)
						query = query+" OR";
					query = query+" Categoria LIKE '%"+categoria5+"%'";
					categorias++;
				}
				if(categoria6 != null){
					if(categorias>0)
						query = query+" OR";
					query = query+" Categoria LIKE '%"+categoria6+"%'";
					categorias++;
				}
				if(categoria7 != null){
					if(categorias>0)
						query = query+" OR";
					query = query+" Categoria LIKE '%"+categoria7+"%'";
					categorias++;
				}
				if(categoria8 != null){
					if(categorias>0)
						query = query+" OR";
					query = query+" Categoria LIKE '%"+categoria8+"%'";
					categorias++;
				}
				if(categoria9 != null){
					if(categorias>0)
						query = query+" OR";
					query = query+" Categoria LIKE '%"+categoria9+"%'";
					categorias++;
				}
				query = query+")";
			}
		}	
		System.out.println("Palabra: "+palabra+" Macho: "+categoria2);
		String ruta="busquedaAvanzada.jsp";
		
		/*Consulta a la BBDD con DataSource*/
		
		InitialContext miInitialContext;
		DataSource miDS;
		ArrayList<Curso> bus = new ArrayList<Curso>();
		
		try{
			miInitialContext = new InitialContext();

			miDS = (DataSource) miInitialContext.lookup("RotolearnJNDI");

			Connection conexion = miDS.getConnection();

			Statement myStatement = conexion.createStatement();
			System.out.println("LA QUERY: "+query);
			ResultSet buscados = myStatement.executeQuery(query+" LIMIT 10");//Hay que cambiar la query

			if(buscados!=null){
				while(buscados.next()){
					Curso aux = new Curso();
					aux.setTitulo(buscados.getString("Titulo"));
					aux.setUsuario((buscados.getString("Profesor")));
					aux.setPrecio(buscados.getString("Precio"));
					aux.setHoras(buscados.getString("Horas"));
					aux.setEmail_paypal(buscados.getString("Email_paypal"));
					aux.setDificultad(buscados.getString("Dificultad"));
					aux.setDescripcion(buscados.getString("Descripcion"));
					aux.setValidado(buscados.getString("Validado"));
					aux.setDestacado(buscados.getString("Destacado"));
					aux.setCategoria(buscados.getString("Categoria"));
					aux.setImagen(buscados.getString("Imagen"));
					bus.add(aux);
				}
			}
			
			buscados.close();
			myStatement.close();
			conexion.close();
			System.out.println("Salgo del HANDLER SHUR");
		}catch (NamingException e) {
			System.out.println("SALTA EXCEPCION NAMING");
			e.printStackTrace();

		} catch (SQLWarning sqlWarning) {
			while (sqlWarning != null) {
				System.out.println("SALTA EXCEPCION SQLWARNING");
				System.out.println("Error: " + sqlWarning.getErrorCode());
				System.out.println("Descripcion: " + sqlWarning.getMessage());
				System.out.println("SQLstate: " + sqlWarning.getSQLState());
				sqlWarning = sqlWarning.getNextWarning();
			}
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("SALTA EXCEPCION SQLEXCEPTION");
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());
				sqlException = sqlException.getNextException();
			}
		}
		request.setAttribute("buscados", bus);

		return ruta;
	}

}
