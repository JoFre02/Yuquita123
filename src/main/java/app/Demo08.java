package app;

import model.Usuario;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo08 {

	// listado de usuarios segun tipo usuario
	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		// select * from tb_usuarios where usr_usua = ?
		String jpql = " select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla ";

		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).
				setParameter("xusr", "admin@ciberfarma.com").
				setParameter("xcla","super").
				getResultList();

		// imprimir listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo...: " + u.getCod_usua());
			System.out.println("Nombre...: " + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("--------------------------");
		}
		em.close();
	}
}
