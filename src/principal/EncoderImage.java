/**
 * @author : D.JEAN_BAPTISTE & E.SRIGURU
 */

package principal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EncoderImage extends JustAbs {
	
	private BufferedImage img;
	private String msg;
	
	public EncoderImage(String message, BufferedImage img) {
		this.msg = message;
		this.img = img;
	}

	/* Conversion du message initial en message binaire */
	public  String monstring (String message) {
		byte[] convMess = message.getBytes(); // chaque caractère du message sera converti en "décimal" qui sera stocker dans un tableau
		String messBinaire = "";
		
		int i = 0;
		while(i<convMess.length) {
			String strBin = Integer.toBinaryString(convMess[i]); // chaque décimal du tableau sera représenter en binaire
			while(strBin.length() < 8) {
				strBin = "0" + strBin; // Les 0 du début étant supprimés lors de la conversion, on les rajoute
			}
		    messBinaire += strBin; 
			i++;
		}
		return messBinaire;
	}
		
    /*cache le message binaire dans l'image */
	public  BufferedImage encodeImage (String bit, BufferedImage image) {
int ind = bit.length()-1; //valeur char de chaque charactere de 0 à length()-1
		
		for (int x = image.getWidth()-1; x >= 0; x--) {
			for (int y = image.getHeight()-1; y >= 0; y--) { //for each pixel
							
				Color c = new Color(image.getRGB(x,y)); //color of pixel
				//definitions des valeurs de r,g,b

				byte[]tabCOL = getPixelImg(c);
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
	

	

	
	
	public void createImg(BufferedImage image) throws IOException{
		File imgFinal = new File("ImgEncoder.png");
		ImageIO.write(image, "png", imgFinal);
	}
	
	public Boolean verifPng(File f) throws ImageExtensionException{
		if(f.getName().endsWith(".png")) {
			return true;
		} else {
			throw new ImageExtensionException();
		}
		
	}
}