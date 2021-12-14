package principal;

/**
 * author : D.JEAN_BAPTISTE & E.SRIGURU
 */

import java.awt.Color;
import java.awt.image.BufferedImage;

public final class EncoderImage {
	/**
	 * 
	 * @param message
	 * @return messBinaire
	 */
	
	//mermet de convertir le message en binaire
	public static String monstring (String message) {
		//creation du tableau de bytes[]
		byte[] convMess = message.getBytes(); //converti les lettres du message en binaire et les stocke dans un tableau
		String messBinaire = "";
		
		int i = 0;
		while(i<convMess.length) {
			String strBin = Integer.toBinaryString(convMess[i]); //retourne un string de numeros ex : 10101010...
			while(strBin.length() < 8) {
				strBin = "0" + strBin; //permet d'avoir des string de numero ayant des 0 au début
			}
			messBinaire += strBin; //converti lettre par lettre en binaire
			i++;
		}
		return messBinaire;
	}
		
		
	public static BufferedImage encodeImage (String bit, BufferedImage image) {
		int ind = bit.length()-1; //valeur char de chaque charactere de 0 à length()-1
		
		for (int x = image.getWidth()-1; x >= 0; x--) {
			for (int y = image.getHeight()-1; y >= 0; y--) { //for each pixel
							
				Color c = new Color(image.getRGB(x,y)); //color of pixel
				//definitions des valeurs de r,g,b
			    byte r = (byte) c.getRed(); 
		        byte g = (byte) c.getGreen(); 
		        byte b = (byte) c.getBlue();
				byte[] tabCOL = {r,g,b}; //tableau de bits contenant les valeurs binaires des r,g,b
				byte[] tabCOL2 = new byte[3];
				
				for (int i = 2; i >= 0; i--) { //for each RGB value/set new RGB value
					if (ind >= 0) { //if we still have bits to encode, change to 1 or 0
						
						int bpf;
						//pour définir les dernieres valeurs des binaires
						if ((tabCOL[i] & 1) == 1) {
							bpf = 1;
						} else {
							bpf = 0;
						}
						
						
						char c1 = bit.charAt(ind); //retourne la valeur char de l'index specifie : derniere valeure ?
						int i1 = Character.getNumericValue(c1); //valeur numerique de bit.charAt(pointer)
				
						if (i1 != bpf) { //si le lsb != bit du message, 
							if (bpf == 1) { 
								tabCOL2[i] = (byte) (tabCOL[i] & ~(1)); //0
							} else {
								tabCOL2[i] = (byte) (tabCOL[i] | 1); //1
							}
						} else {								
							tabCOL2[i] = tabCOL[i];
						}
					} else {  

						tabCOL2[i] = (byte) (tabCOL[i] & ~(1));
					}
					
					ind--;
				}
			
				Color newColor = new Color(Byte.toUnsignedInt(tabCOL2[0]), Byte.toUnsignedInt(tabCOL2[1]), Byte.toUnsignedInt(tabCOL2[2]));
				image.setRGB(x,y,newColor.getRGB());
			}
		}
		return image;
	}	
}