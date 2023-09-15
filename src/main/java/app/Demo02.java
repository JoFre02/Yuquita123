//package app;
//import model.Usuario;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class Demo02 {
//	//actualizar Usuario
//	public static void main(String[] args) {
//		//obtener conexion --> llamar al persistence-unit
//		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
//		
//		//crear manejador entidades
//		EntityManager em = fabrica.createEntityManager();
//		
//		//proceso
//		Usuario u = new Usuario(6,"Miguel","Ruiz","mars@gmail.com","familia","2000/05/10",1,1);
//		
//		//update tb_xxx set campo=?,... where
//		// !! si el proceso es reg/ act/ eli --> Transaccion
//		try {
//			em.getTransaction().begin();
//			em.merge(u);
//			em.getTransaction().commit();
//			System.out.println("Actualizacion Ok!!!");
//		} catch (Exception e) {
//			System.out.println("Error:" + e.getCause().getMessage());
//		}
//		
//		em.close();
//	}
//}
