package principal;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * la classe Metadonnees permet d'afficher les metadonnees d'une image de png ou de type jpeg
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class Metadonnees{

	private String monChemin = ""; //le chemin d'acces a l'image
	
	/**
	 * Construit et initialise un chemin
	 * @param chemin indique le chemin d'une image
	 */
	public Metadonnees(String chemin) {
		this.monChemin = chemin;
	}
	
	/**
	 * la methode lectureMeta permet de lire les metadonnees d'une image si le fichier est de type png ou jpeg, si non une exception est lancee
	 * @return
	 * @throws ImageProcessingException
	 * @throws IOException
	 */
	public String lectureMeta() throws ImageProcessingException, IOException {
		 File file = new File(this.monChemin);
		 if(imageVerifExt(file)) {
	         Metadata meta = ImageMetadataReader.readMetadata(file);
	         return this.print(meta);
		 }else {
			 throw new IOException("impossible de lire les métadonnée de l'image, veuillez choisir une image jpg ou png");
		 }
	}
	
	/**
	 * la methode print permet d'afficher les metadonnes d'un fichier image donne et 
	 * @param meta indique les metadonnees
	 * @return
	 */
	public String print(Metadata meta) {
		String res = "";
       
        for (Directory reper : meta.getDirectories()) {
          
            for (Tag tag : reper.getTags()) {
            	System.out.format("[%s] - %s = %s \n", reper.getName(), tag.getTagName(), tag.getDescription());
                res += "["+reper.getName()+"]"+ "-" +tag.getTagName()+ "=" +tag.getDescription()+ "\n";
            }
        }
        return res;
	}
	
	/**
	 * la methode imageVerifExt permet de verifier les extensions des fichiers images, si les extensions sont jpg et png, elle retourne vraie, si non, faux
	 * @param image indique l'image dont on verifiera l'extension
	 * @return
	 */
	public Boolean imageVerifExt(File image) {
		if(image.getName().endsWith(".jpg") || image.getName().endsWith(".png")) {
			return true;
		} else {
			return false;
		}
	}
	
	

	
}