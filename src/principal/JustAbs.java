package principal;

import java.awt.Color;

public class JustAbs {

	public static byte[] getPixelImg(Color c) {
		//1 pixel est composer de rouge, vert et bleu
	    byte r = (byte) c.getRed(); 
        byte g = (byte) c.getGreen(); 
        byte b = (byte) c.getBlue();
		byte[] tab = {r,g,b}; //tableau de bits contenant les valeurs binaires des r,g,b
		return tab;
	}
}
