package App;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import model.EUsuario;

public class Demo08 {
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mySql");
		//crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		//String sql2 = "select u from EUsuario u where u.usuario = :xusr and u.clave = :xcla";
		//String sql2 = "{call usp_validaAcceso(:xusr, :xcla)}";	
		String sql2 = "{call usp_validaAcceso(?, ?)}";	
		
		//esto es para JPA
		//TypedQuery<EUsuario> query = em.createQuery(sql2, EUsuario.class);
		Query query = em.createNativeQuery(sql2, EUsuario.class);
		//query.setParameter("xusr", "U002@gmail.com");
		//query.setParameter("xcla", "10002");
		query.setParameter(1, "U002@gmail.com");
		query.setParameter(2, "10002");
		
		EUsuario u = (EUsuario) query.getSingleResult();
		
		if(u == null) {
			System.out.println("codigo no existe");
		} else {
			System.out.println("Bienvenido: " + u.getNombre());
		}
		
		em.close();
		
		
		/*EUsuario user = em.find(EUsuario.class, 7);
		
		if(user != null) {
			em.getTransaction().begin();
			em.remove(user);
			System.out.println("Eliminaod usuario v:");
			em.getTransaction().commit();
			em.close();
		};*/
	}
}
