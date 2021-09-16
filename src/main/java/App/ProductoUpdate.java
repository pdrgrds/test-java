package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.EProducto;

public class ProductoUpdate {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mySql");
		EntityManager em = fabrica.createEntityManager();
		
		EProducto producto = new EProducto();
		
		producto.setIdprod("12345");
		producto.setDescripcion("test Producto Edit");
		producto.setStock(300);
		producto.setPrecio(5);
		producto.setIdcategoria(1);
		producto.setEstado(true);
		
		em.getTransaction().begin();
		em.merge(producto);
		em.getTransaction().commit();
		
		em.close();
	}
}
