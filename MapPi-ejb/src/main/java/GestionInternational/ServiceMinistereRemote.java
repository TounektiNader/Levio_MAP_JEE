package GestionInternational;

import javax.ejb.Remote;

import Entity.Ministere;

@Remote
public interface ServiceMinistereRemote {
	public void CreateQrCode(String email, String pays, int id);

	public Boolean ReadQrCode(String filename, String filenameUpload);

	public Boolean RegisterMinistere(Ministere ministere);

	public void updateMinisterQrCode(String email, String pays);

	public Ministere getMinistereByEmail(String email, String pays);

	public Ministere getMinistereByEmailVerif(String email);

}
