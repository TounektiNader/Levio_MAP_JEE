package GestionInternational;

import javax.ejb.Local;

import Entity.AttachmentImmigrant;

@Local
public interface ServiceAttachmentsLocal {
	
	public void ajoutAttachment(AttachmentImmigrant attachment);

	public AttachmentImmigrant getAttachment(int id);
	
	public void DeleteAttachment(int id);

}
