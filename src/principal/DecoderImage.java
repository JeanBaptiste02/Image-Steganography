package principal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * @author D.JEAN_BAPTISTE & E.SRIGURU
 *
 */
public final class DecoderImage extends JustAbs {
	
	private String encode;
	private BufferedImage image;
	
	
	public DecoderImage(String encode, BufferedImage image) {
		this.encode = encode;
		this.image = image;
	}

	public String getMessage (String encode) {
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

	public String decodeMessage(BufferedImage image) {
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
}