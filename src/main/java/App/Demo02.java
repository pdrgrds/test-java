package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.EUsuario;

public class Demo02 {
	public static void main(String[] args) {
		System.out.println("hola");
		//obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mySql");
		//crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		EUsuario user = new EUsuario();
		user.setCodigo(6);
		user.setNombre("user");
		user.setApellido("user");
		user.setUsuario("user");
		user.setClave("1234");
		user.setFnacim("2021/07/07");
		user.setTipo(1);
		user.setEstado(1);
		
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		
		em.close();
	}
}
