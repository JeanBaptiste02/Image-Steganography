<<<<<<< HEAD
package principal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * la classe EncoderImage permet de cacher un message secret dans un fichier image de type png
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class EncoderImage extends TabColor {
	
	private BufferedImage img;
	private String msg;
	
	/**
	 * Construit et initialise le message secret et l'image
	 * @param message indique le message qui sera cache
	 * @param img indique l'image
	 */
	public EncoderImage(String message, BufferedImage img) {
		this.msg = message;
		this.img = img;
	}

	
	/**
	 * la methode monString permet de convertir message initial en message binaire
	 * @param message
	 * @return
	 */
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
		

	/**
	 * la methode encodeImage permet de cacher le message binaire dans une image
	 * @param bit indique de bit
	 * @param image indique l'image est question qui sera encode
	 * @return
	 */
	public  BufferedImage encodeImage (String bit, BufferedImage image) {
		int ind = bit.length()-1; //valeur char de chaque charactere de 0 à length()-1
		
		for (int x = image.getWidth()-1; x >= 0; x--) { //pour chacun des pixels
			for (int y = image.getHeight()-1; y >= 0; y--) { //pour chacun des pixels
							
				Color c = new Color(image.getRGB(x,y)); //la couleur du pixel
				//definitions des valeurs de r,g,b
				byte[]tabCOL = getPixelImg(c); //methode est presente dans la classe TabColor
				
				byte[] tabCOL2 = new byte[3];
				
				for (int i = 2; i >= 0; i--) { //Pour chacun des valeurs du tabCOL, on affecte une nouvelle valeure
					if (ind >= 0) { //if we still have bits to encode, change to 1 or 0
						
						int bpf;
						//pour définir les dernieres valeurs des binaires
						if ((tabCOL[i] & 1) == 1) {
							bpf = 1;
						} else {
							bpf = 0;
						}
						
						//permet de donner la valeur numerique des caracteres
						char c1 = bit.charAt(ind); //retourne la valeur char de l'index specifie : derniere valeure ?
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
				image.setRGB(x,y,newColor.getRGB());
			}
		}
		return image;
	}
	
	/**
	 * la methode verifPng permet de verifier si l'extension du fichier image est png, si oui, elle retourne vrai, si non faux
	 * @param f indique le fichier image
	 * @return
	 * @throws ImageExtensionException
	 */
	public Boolean verifPng(File f) throws ImageExtensionException{
		if(f.getName().endsWith(".png")) {
			return true;
		} else {
			throw new ImageExtensionException();
		}
		
	}
=======
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
>>>>>>> 3f58618ecc103d0efeac5ad7b4c870f0710a1154
}