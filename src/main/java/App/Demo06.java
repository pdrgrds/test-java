package App;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.EUsuario;

public class Demo06 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mySql");
		//crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		String sql = "select u from EUsuario u "; //JPA
		String sql2 = "select u from EUsuario u where u.tipo = :xtipo"; //JPA
		
		TypedQuery<EUsuario> query = em.createQuery(sql2, EUsuario.class);
		query.setParameter("xtipo", 1);
		
		//query.getResultList();adsñas
		
		List<EUsuario> lstUsuario = em.createQuery(sql2, EUsuario.class).setParameter("xtipo", 1).getResultList();
		
		System.out.println("cant:" + lstUsuario.size());
		
		em.close();
	}
}
