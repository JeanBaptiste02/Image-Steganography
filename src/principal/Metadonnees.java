package principal;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class Metadonnees{
	@SuppressWarnings("unused")
	private String monChemin = "";
	@SuppressWarnings("unused")
	private Metadata meta;
	
	public Metadonnees(Metadata meta, String monChemin) {
		this.meta = meta;
		this.monChemin = monChemin;
	}
	
	public void print(Metadata meta) {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.print(' ');
        System.out.println();

        //
        // A Metadata object contains multiple Directory objects
        //
        for (Directory reper : meta.getDirectories()) {

            //
            // Each Directory stores values in Tag objects
            //
            for (Tag tag : reper.getTags()) {
                System.out.format("[%s] - %s = %s \n", reper.getName(), tag.getTagName(), tag.getDescription());
            }

            //
            // Each Directory may also contain error messages
            //
            for (String error : reper.getErrors()) {
                System.err.println("ERROR: " + error);
            }
        }
	}
	
	
	@SuppressWarnings("unused")
	private static void print(Exception exception) {
        System.err.println("EXCEPTION: " + exception);
 }

	
}