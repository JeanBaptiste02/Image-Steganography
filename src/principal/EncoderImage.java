package principal;

import java.awt.Color;
import java.awt.image.BufferedImage;


/**
 * la classe EncoderImage permet de cacher un message secret dans un fichier image de type png
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class EncoderImage extends FileExtension implements TabColor {
	
	
	private String msg;
	
	/**
	 * Construit et initialise le message secret et l'image
	 * @param message indique le message qui sera cache
	 * @param img indique l'image
	 */
	public EncoderImage(String message, BufferedImage img) {
	    super(img);
		this.msg = message;
	}

	
	/**
	 * la methode monString permet de convertir message initial en message binaire
	 * @param message indique le message
	 * @return retourne le message binaire
	 */
	public String monstring (String message) {
		byte[] convMess = message.getBytes(); // chaque caractere du message sera converti en "decimal" qui sera stocker dans un tableau
		String messBinaire = "";
		
		int i = 0;
		while(i<convMess.length) {
			String strBin = Integer.toBinaryString(convMess[i]); // chaque decimal du tableau sera representer en binaire
			while(strBin.length() < 8) {
				strBin = "0" + strBin; // Les 0 du debut etant supprimes lors de la conversion, on les rajoute
			}
		    messBinaire += strBin; 
			i++;
		}
		return messBinaire;
	}
		

	/**
	 * la methode encodeLimage permet de cacher le message binaire dans une image
	 * @param monBit indique le bit
	 * @param monImage indique l'image est question qui sera encode
	 * @return retourne l'image
	 */
	public BufferedImage encodeLimage (String monBit, BufferedImage monImage) {
		int ind = monBit.length()-1; //valeur char de chaque charactere de 0 à length()-1
		
		for (int x = monImage.getWidth()-1; x >= 0; x--) { //pour chacun des pixels
			for (int y = monImage.getHeight()-1; y >= 0; y--) { //pour chacun des pixels
							
				Color c = new Color(monImage.getRGB(x,y)); //la couleur du pixel
				//definitions des valeurs de r,g,b
				byte[]tabCOL = getPixelImg(c); //methode presente dans la classe TabColor
				
				byte[] tabCOL2 = new byte[3];
				
				for (int i = 2; i >= 0; i--) { //Pour chacun des valeurs du tabCOL, on affecte une nouvelle valeure
					if (ind >= 0) {
						
						int bpf;
						//pour definir les dernieres valeurs des binaires
						if ((tabCOL[i] & 1) == 1) {
							bpf = 1;
						} else {
							bpf = 0;
						}
						
						//permet de donner la valeur numerique des caracteres
						char c1 = monBit.charAt(ind); //retourne la valeur char de l'index specifie : derniere valeure ?
						int i1 = Character.getNumericValue(c1); //valeur numerique de bit.charAt(pointer)
				
						if (i1 != bpf) {  
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
				monImage.setRGB(x,y,newColor.getRGB());
			}
		}
		return monImage;
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