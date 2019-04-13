package GestionInternational;

import javax.ejb.Local;

import Entity.Ministere;

@Local
public interface ServiceMinistereLocal {
	public void CreateQrCode(String email, String pays, int id);

	public Boolean ReadQrCode(String filename, String filenameUpload);

	public Boolean RegisterMinistere(Ministere ministere);

	public void updateMinisterQrCode(String email, String pays);

	public Ministere getMinistereByEmail(String email, String pays);

	public Ministere getMinistereByEmailVerif(String email);

}
