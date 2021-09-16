package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.EProducto;

public class ProductoDelete {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mySql");
		EntityManager em = fabrica.createEntityManager();
		
		EProducto producto = em.find(EProducto.class, "12345");
		
		if(producto != null) {
			em.getTransaction().begin();
			em.remove(producto);
			System.out.println("Eliminado producto v:");
			em.getTransaction().commit();
			em.close();
		}
	}
}
