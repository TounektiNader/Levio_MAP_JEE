package GestionInternational;

import java.util.List;

import javax.ejb.Local;

import Entity.Folder;
import Entity.JobRequest;
import Entity.OfferJob;

@Local
public interface ServiceJobRequestLocal {

	public List<JobRequest> getJobRequestByOffer(int id);

	public List<OfferJob> getOffers();

	public Folder getFolder(int id);
	
	public void updateFolderToAssign(int idFolder) ;
	
	public List<JobRequest> getJobRequetAssign(int idOffer);

}
