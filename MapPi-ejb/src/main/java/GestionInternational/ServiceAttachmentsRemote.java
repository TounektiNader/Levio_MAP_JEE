package GestionInternational;

import javax.ejb.Remote;

import Entity.AttachmentImmigrant;

@Remote
public interface ServiceAttachmentsRemote {

	public void ajoutAttachment(AttachmentImmigrant attachment);

	public AttachmentImmigrant getAttachment(int id);

	public void DeleteAttachment(int id);
}
