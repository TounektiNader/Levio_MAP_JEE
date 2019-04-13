package GestionInternational;

import java.util.List;

import javax.ejb.Remote;

import Entity.Folder;
import Entity.JobRequest;
import Entity.OfferJob;

@Remote
public interface ServiceJobRequestRemote {

	public List<JobRequest> getJobRequestByOffer(int id);

	public List<OfferJob> getOffers();

	public Folder getFolder(int id);


	public void updateFolderToAssign(int idFolder);
	
	public List<JobRequest> getJobRequetAssign(int idOffer);

}
