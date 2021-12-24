package principal;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * la classe Metadonnees permet d'afficher les metadonnees d'une image de type png ou de type jpeg
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class Metadonnees extends FileExtension{

	/**
	 * Construit et initialise un chemin
	 * @param chemin indique le chemin d'une image
	 */
	public Metadonnees(String chemin) {
		super(chemin);
	}
	
	/**
	 * la methode lectureMeta permet de lire les metadonnees d'une image si le fichier est de type png ou jpeg, si non une exception est lancee
	 * @return retourne les metadonnees si le fichier est de bon type, si non elle lance une exception
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
	 * la methode print permet d'afficher les metadonnes d'un fichier image 
	 * @param meta indique les metadonnees
	 * @return retourne les metadonnees a afficher
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
	
	
}