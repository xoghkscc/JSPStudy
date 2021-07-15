package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	String text;
	public SHA256(String text) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes());
			byte[] byteData = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.text = sb.toString();
	}
	
	public String getTextSha256() {
		return text;
	}
	
}
