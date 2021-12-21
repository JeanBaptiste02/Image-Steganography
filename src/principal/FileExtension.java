package principal;

import java.io.File; 
import java.awt.image.BufferedImage;

/**
 * la classe FileExtension permet de verifier les extensions des fichiers images
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class FileExtension {
	
	protected File file;
	protected BufferedImage image; 
	protected String monChemin = ""; //le chemin d'acces a l'image ou au fichier ou au dossier
	
	/**
	 * construit et initialise le fichier
	 * @param f indique le fichier
	 */
	public FileExtension(File f) {
		this.file=f;
	}
    
	/**
	 * construit et initialise une image
	 * @param img indique l'image
	 */
	public FileExtension(BufferedImage img) {
		this.image=img;
	}
	
	/**
	 * construit et initialise un chemin
	 * @param chemin indique le chemin
	 */
	public FileExtension(String chemin) {
		this.monChemin=chemin;
		
	}
	
	/**
	 * la methode verifPng permet de verifier si le fichier est bien un png, si oui vrai, si non faux
	 * @param f indique le fichier image
	 * @return retourne un booleen ou lance une exception
	 * @throws ImageExtensionException
	 */
	public Boolean verifPng(File f) throws ImageExtensionException{
		if(f.getName().endsWith(".png")) {
			return true;
		} else {
			throw new ImageExtensionException();
		}
		
	}
	
	/**
	 * la methode imageVerifExt permet de verifier les extensions des fichiers images, si les extensions sont de type jpg ou png, elle retourne vraie, si non, faux
	 * @param image indique l'image dont on verifiera l'extension
	 * @return retourne un booleen
	 */
	public Boolean imageVerifExt(File image) {
		if(image.getName().endsWith(".jpg") || image.getName().endsWith(".png")) {
			return true;
		} else {
			return false;
		}
	}
}
