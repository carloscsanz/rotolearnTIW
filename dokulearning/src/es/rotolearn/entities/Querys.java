package es.rotolearn.entities;

import java.io.Serializable;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="findDeseos", query="SELECT c FROM CursoAlumno c WHERE c.estado LIKE :estado AND c.usuario.nickname LIKE :usuario")
})
public class Querys implements Serializable {
	
}
