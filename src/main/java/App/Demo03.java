package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.EUsuario;

public class Demo03 {
	public static void main(String[] args) {
		System.out.println("hola");
		//obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mySql");
		//crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		EUsuario user = new EUsuario();
		user.setCodigo(7);
		
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		
		em.close();
	}
}
