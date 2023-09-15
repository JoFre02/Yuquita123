package app;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class Demo09 {

	// listado de usuarios segun tipo usuario
	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog("Ingrese usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese clave: ");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		// select * from tb_usuarios where usr_usua = ?
		String jpql = " select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla ";

		try {
			Usuario u = em.createQuery(jpql, Usuario.class).
					setParameter("xusr", usuario).
					setParameter("xcla", clave).
					getSingleResult();
		// Abrir la ventana
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto");
		}
		em.close();
	}
}