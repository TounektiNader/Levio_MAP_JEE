package Entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DossierImmigrant
 *
 */

@Entity

public class DossierImmigrant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private EtapeDossier etape;
	private EtatDossier etat;
	private String pays;
	private int idUser;

	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String lettreEmbauche;
	private String motivation;
	private String statut;
	private String address;
	private String image;
	private int age;

	@OneToMany(mappedBy = "dossierAttachment", fetch = FetchType.EAGER)
	private List<AttachmentImmigrant> attachments;
	private static final long serialVersionUID = 1L;

	public DossierImmigrant() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EtapeDossier getEtape() {
		return etape;
	}

	public void setEtape(EtapeDossier etape) {
		this.etape = etape;
	}

	public EtatDossier getEtat() {
		return etat;
	}

	public void setEtat(EtatDossier etat) {
		this.etat = etat;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public List<AttachmentImmigrant> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<AttachmentImmigrant> attachments) {
		this.attachments = attachments;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLettreEmbauche() {
		return lettreEmbauche;
	}

	public void setLettreEmbauche(String lettreEmbauche) {
		this.lettreEmbauche = lettreEmbauche;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
