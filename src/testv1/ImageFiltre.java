package testv1;

import java.io.File;
import java.util.ArrayList;


public class ImageFiltre {
    private ArrayList<String> fichiers;
	
	public ImageFiltre() {
		fichiers = new ArrayList<String>();
	}
	
	public void ajouterFichier(String nomfichier) {
			fichiers.add(nomfichier);		
	}
	
	public void regroupeFichiers(File rep) {
	    for (File fichiercourant : rep.listFiles()) {
	        if (fichiercourant.isDirectory()) {
	            regroupeFichiers(fichiercourant);
	        } else{
	            ajouterFichier(fichiercourant.getName());
	        }
	    }
	}
	
	public String afficherImages() {
		String res ="";
		for(String fich : fichiers) {
			if ((fich.endsWith(".png") || fich.endsWith(".jpeg"))) {
				res += fich + "\n";
			}
		}
		return res;
		
	}
	
	

}
