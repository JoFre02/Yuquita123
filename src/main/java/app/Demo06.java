package app;

import model.Usuario;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo06 {
	//listado de usuarios mostrando tipoUsuario
	
	public static void main(String[] args) {
		//obtener conexion --> llamar al persistence-unit
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		//crear manejador entidades
		EntityManager em = fabrica.createEntityManager();
		
		//select * from tb_usuarios --> List
		String jpql = " select u from Usuario u ";
		
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
		
		//imprimir listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo...: " + u.getCod_usua());
			System.out.println("Nombre...: " + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo.....: " + u.getObjTipo().getDescripcion());
			System.out.println("--------------------------");
		}
		em.close();
	}
}
