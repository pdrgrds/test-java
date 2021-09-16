package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.EUsuario;

public class Demo05 {
	public static void main(String[] args) {
		System.out.println("hola");
		//obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mySql");
		//crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		EUsuario user = em.find(EUsuario.class, 7);
		
		if(user != null) {
			em.getTransaction().begin();
			em.remove(user);
			System.out.println("Eliminaod usuario v:");
			em.getTransaction().commit();
			em.close();
		};
	}
}
