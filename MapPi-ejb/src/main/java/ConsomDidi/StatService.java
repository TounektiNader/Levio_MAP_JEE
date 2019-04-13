package ConsomDidi;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import Entity.Project;

@LocalBean
@Stateful
public class StatService implements StatRemote,StatLocal{
	
	  @PersistenceContext(unitName="MapPi-ejb")
			EntityManager em;
	  
		@Override
		public List<Object[]> getAllCostumer() {
			/*
			 List<Object[]> results = entityManager
        .createQuery("SELECT m.name AS name, COUNT(m) AS total FROM Man AS m GROUP BY m.name ORDER BY m.name ASC");
        .getResultList();
for (Object[] result : results) {
    String name = (String) result[0];
    int count = ((Number) result[1]).intValue();
}
			 */
		//return em.createQuery("Select e from Project e ",Project.class).getResultList();
			List<Object[]> results  = em.createQuery("select COUNT(p) ,p.state from Project p GROUP BY p.state").getResultList();
			
		return results;
//			Query query =em.createQuery("select * from user ",User.class);
//			List<User>results=query.getResultList();
//			return results;
//			
			
			
//			Query query= em.createQuery("Select firstname from User u "
//					+" where u.role=:role ");
//			query.setParameter("role","Customer");
//			
//
//			System.out.println(query.getResultList().size());
//				return query.getResultList();
	}
	
	@Override
	public Integer NbrProjectClients(int id2) {
		
	TypedQuery<Project> query = em.createQuery("select p from Project p JOIN p.userId u where u.userId=:id" , Project.class);
	query.setParameter("id",id2);
	List<Project> l=query.getResultList();
	return l.size();
	}
	
	
	
	public List<Object[]> getAllProj() {
		List<Object[]> result  = em.createQuery("select SUM(p.numberResource),p.description from Project p GROUP BY p.description").getResultList();
		
		return result;
		
		
		
	}


}
