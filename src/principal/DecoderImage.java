package principal;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * la classe DecoderImage permet de decoder et montrer le message qui a ete cache dans une image donnee
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class DecoderImage implements TabColor {
	
	private String encode;
	private BufferedImage image;
	
	/**
	 * Construit et initialise le message encode et l'image
	 * @param encode indique le message encode
	 * @param image indique l'image en question
	 */
	public DecoderImage(String encode, BufferedImage image) {
		this.encode = encode;
		this.image = image;
	}

	
	/**
	 * la methode decodeLeMessage permet de convertir le message binaire en un message de charactere
	 * @param image indique l'image en question
	 * @return retourne des bits
	 */
	public String decodeLeMessage(BufferedImage image) {
		StringBuilder constructBits = new StringBuilder();

		int a = image.getWidth();
		int b = image.getHeight();
		
		for (int x = 0; x < a; x++) {
			for (int y = 0; y < b; y++) {
				Color c = new Color(image.getRGB(x,y));
	
				String str1 = "1";
				String str2 = "0";
				
				byte[] RGB = getPixelImg(c);
				
				for (int i = 0; i < 3; i++) {
					if ((RGB[i] & 1) == 1) { 
						constructBits.append(str1);
					} else {
						constructBits.append(str2);
					}
				}
			}
		}
		
		return constructBits.toString();
	}
	
	/**
	 * la methode retournMess permet de retourner le message secret apres avoir decode
	 * @param encode indique le message encode
	 * @return retourne le message finale qui sera decode
	 */
	public String retournMess (String encode) {
		int compteur = encode.length()-1;
		StringBuilder monMess = new StringBuilder();
		int mesVal = encode.length()/8;
		byte[] tabByt = new byte[mesVal];
		int comptTab = mesVal-1;
		while (comptTab > 0) {
			StringBuilder contsruc = new StringBuilder();
			for (int i = 0; i < 8; i++) {
				contsruc.insert(0,encode.charAt(compteur-i));
			}
			byte b = (byte) Integer.parseInt(contsruc.toString(), 2);
			int x = Byte.toUnsignedInt(b);
			tabByt[comptTab] = (byte) x;
			char c = (char) x;
			monMess.insert(0,c);
			
				compteur = compteur - 8;
				comptTab--;
			
		}
		String messFinale = new String(tabByt);
		
		return messFinale;
	} 
	/**
	 * la methode getPixelImg permet de retourner un tableau de contenant les valeurs binaires des couleurs r,g,b
	 * @param c la couleur du pixel de l'image
	 * @return retourne un tableau de valeurs binaires
	 */
	public byte[] getPixelImg(Color c) {
		//1 pixel est compose de rouge, vert et bleu
	    byte r = (byte) c.getRed(); 
        byte g = (byte) c.getGreen(); 
        byte b = (byte) c.getBlue();
		byte[] tab = {r,g,b}; 
		return tab;
	}
}