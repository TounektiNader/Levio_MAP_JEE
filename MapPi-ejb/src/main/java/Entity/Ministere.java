package Entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ministere
 *
 */
@Entity

public class Ministere implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String pays;
	private String QrCode;
	private static final long serialVersionUID = 1L;

	public Ministere() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}   
	public String getQrCode() {
		return this.QrCode;
	}

	public void setQrCode(String QrCode) {
		this.QrCode = QrCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
   
}
