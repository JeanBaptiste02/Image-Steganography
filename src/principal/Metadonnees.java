package principal;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class Metadonnees{
	
	private String monChemin = ""; //mon chemin d'acces a l'image
	
	public Metadonnees(String chemin) {
		this.monChemin = chemin;
	}
	
	public String lectureMeta() throws ImageProcessingException, IOException {
		 File file = new File(this.monChemin);
		 Metadata meta = ImageMetadataReader.readMetadata(file);
         return this.print(meta);

	}
	
	public String print(Metadata meta) {
		String res = "";
        //
        // A Metadata object contains multiple Directory objects
        //
        for (Directory reper : meta.getDirectories()) {
            //
            // Each Directory stores values in Tag objects
            //
            for (Tag tag : reper.getTags()) {
                res += "["+reper.getName()+"]"+ "-" +tag.getTagName()+ "=" +tag.getDescription()+ "\n";
            }
        }
        return res;
	}
	
	/*public Boolean imageVerifJpg(File image) {
		if(image.getName().endsWith(".jpg")) {
			return true;
		} else {
			return false;
		}
	}
	*/
	
	

	
}