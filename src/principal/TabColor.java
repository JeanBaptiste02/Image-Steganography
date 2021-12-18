package principal;

import java.awt.Color;

/**
 * la classe TabColor permet de retourner un tableau de contenant les valeurs binaires des couleurs r,g,b
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class TabColor {

	public static byte[] getPixelImg(Color c) {
		//1 pixel est compose de rouge, vert et bleu
	    byte r = (byte) c.getRed(); 
        byte g = (byte) c.getGreen(); 
        byte b = (byte) c.getBlue();
		byte[] tab = {r,g,b}; 
		return tab;
	}
}