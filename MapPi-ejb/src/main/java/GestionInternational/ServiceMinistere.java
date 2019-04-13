package GestionInternational;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import Entity.Ministere;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * Session Bean implementation class ServiceMinistere
 */
@Stateless
@LocalBean
public class ServiceMinistere implements ServiceMinistereRemote, ServiceMinistereLocal {

	@PersistenceContext(unitName = "MapPi-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ServiceMinistere() {

	}

	public void CreateQrCode(String email, String pays, int id) {

		String qrCodeData = email + id + pays;
		String filePath = "C:\\Users\\Nader\\workspace\\MapPi\\MapPi-web\\src\\main\\webapp\\QRCODE\\" + pays + id
				+ ".png";

		String charset = "UTF-8"; // or "ISO-8859-1"
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		BitMatrix matrix;
		try {
			matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, 200, 200, hintMap);
			MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1),
					new File(filePath));
			System.out.println("QR Code image created successfully!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public void CreateQrCode(String email,String pays,int id) {
	//
	// String qrCodeData = "www.chillyfacts.com";
	// String filePath = "C:\\QRCODE\\chillyfacts.png";
	// String charset = "UTF-8"; // or "ISO-8859-1"
	// Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new
	// HashMap<EncodeHintType, ErrorCorrectionLevel>();
	// hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	// BitMatrix matrix;
	// try {
	// matrix = new MultiFormatWriter().encode(new
	// String(qrCodeData.getBytes(charset), charset),
	// BarcodeFormat.QR_CODE, 200, 200, hintMap);
	// MatrixToImageWriter.writeToFile(matrix,
	// filePath.substring(filePath.lastIndexOf('.') + 1),
	// new File(filePath));
	// System.out.println("QR Code image created successfully!");
	//
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (WriterException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	public static String readQRCode(String filePath, String charset, Map hintMap) {
		BinaryBitmap binaryBitmap;
		String tex = "";
		try {
			binaryBitmap = new BinaryBitmap(
					new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));
			Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);

			tex = qrCodeResult.getText();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tex;

	}

	public Boolean ReadQrCode(String filename, String filenameUpload) {
		boolean test = false;
		String filePath = "C:\\Users\\Nader\\workspace\\MapPi\\MapPi-web\\src\\main\\webapp\\QRCODE\\" + filename;
		String filePathUpload = "C:\\Users\\Nader\\workspace\\MapPi\\MapPi-web\\src\\main\\webapp\\ImagesVerif\\"+ filenameUpload;

		String charset = "UTF-8";
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		System.out.println("Data read from QR Code: " + readQRCode(filePath, charset, hintMap));
		System.out.println("Data read from QR Code: " + readQRCode(filePathUpload, charset, hintMap));

		if (readQRCode(filePath, charset, hintMap).equals(readQRCode(filePathUpload, charset, hintMap))) {
			test = true;
		}
		return test;
	}

	public Boolean RegisterMinistere(Ministere ministere) {

		try {
			em.persist(ministere);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Ministere getMinistereByEmail(String email, String pays) {

		TypedQuery<Ministere> query = em.createQuery("Select e from Ministere e where e.email=:email and e.pays=:pays",
				Ministere.class);
		query.setParameter("email", email);
		query.setParameter("pays", pays);
		Ministere employe = null;
		try {
			employe = query.getSingleResult();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return employe;
	}

	public Ministere getMinistereByEmailVerif(String email) {

		TypedQuery<Ministere> query = em.createQuery("Select e from Ministere e where e.email=:email", Ministere.class);
		query.setParameter("email", email);

		Ministere employe = null;
		try {
			employe = query.getSingleResult();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return employe;
	}

	public void updateMinisterQrCode(String email, String pays) {
		Ministere mn = getMinistereByEmail(email, pays);
		CreateQrCode(mn.getEmail(), mn.getPays(), mn.getId());
		mn.setQrCode(mn.getPays() + mn.getId() + ".png");
		em.merge(mn);
	}
}
