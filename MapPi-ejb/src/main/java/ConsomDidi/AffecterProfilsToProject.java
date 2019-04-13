package ConsomDidi;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entity.Profil;
import Entity.Project;


@LocalBean
@Stateful
public class AffecterProfilsToProject implements AffecterProfilsToProjectLocal,AffecterProfilsToProjectRemote{

	@PersistenceContext(unitName="MapPi-ejb")
	EntityManager em;
	
	
	@Override
	public void AffecterProfAProj(int profilId, int projectId) {
		
		Project ProjectManagedEntity = em.find(Project.class,projectId );
		Profil  ProfilManagedEntity =em.find(Profil.class, profilId);
		
		ProfilManagedEntity.setProject(ProjectManagedEntity);		
		
	}

	@Override
	public void ajouterProfil(Profil prof) {
		em.persist(prof);
	}

	@Override
	public Project findbyId(int id) {
		Project project =em.find(Project.class, id);
		return project;
	}
	
	public  List<Profil> listP(int id)
	{ List <Profil> l = new ArrayList<Profil>();
		TypedQuery<Profil> query = em.createQuery("select p from Profil p",Profil.class );
		List<Profil> list=query.getResultList();
		
		for (Profil p : list)
		{
			if(p.getProject().getProjectId()==id)
				
			{
				l.add(p);
			}
		}
		return l;
		
		
	}
	
	public void SupprimerProfile(int id)
	{
		em.remove(em.find(Profil.class, id));
	}
	
	

}
