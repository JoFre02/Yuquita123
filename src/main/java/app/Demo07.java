package app;

import model.Producto;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo07 {
	//listado de productos mostrando proveedor - categoria
	
	public static void main(String[] args) {
		//obtener conexion --> llamar al persistence-unit
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		//crear manejador entidades
		EntityManager em = fabrica.createEntityManager();
		
		//select * from tb_productos --> List
		String jpql = " select p from Producto p ";
		
		List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
		
		//imprimir listado
		for (Producto p : lstProductos) {
			System.out.println("Codigo........: " + p.getId_prod());
			System.out.println("Descripcion...: " + p.getDes_prod());
			System.out.println("Categoria.....: " + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor.....: " + p.getObjProveedor().getNombre_rs());
			System.out.println("--------------------------");
		}
		em.close();
	}
}
