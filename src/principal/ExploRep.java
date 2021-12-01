package principal;

import java.io.File;
import java.util.ArrayList;
/**
 * 
 * @author Jean-Baptiste and Sriguru
 *
 */

public class ExploRep{
	private String monChemin = ""; //mon chemin d'acces aux dossiers / fichiers
	private ArrayList<String> images = new ArrayList<String>();
	
	
	/**
	 * Constructeur
	 * @param monChemin permet faire l'initialisation de l'attribut monChemin
	 */
	public ExploRep(String monChemin) {
		this.monChemin=monChemin;
		
	}
	
	/**
	 * 
	 * @param f est une reference
	 * @return 
	 */
	public Boolean estVideF(File[] f) {
		if(f==null) //si le tableau de fichiers est vide ...
			return true;
		return false;
	}
	
	
	public void maListe() throws DossierNexistePas{
		File rep = new File(this.monChemin);
		if(rep.exists()) {
			 this.lister(this.monChemin);
		}else {
			throw new DossierNexistePas(); //lance une exception si le Dossier n'existe pas
		}
	}
	
	
	public void lister(String cheminRep) {
		File rep = new File(cheminRep);
		File[] mes_fichiers = rep.listFiles(); //retourne un tableau de fichiers (a verifier)
		if(!(estVideF(mes_fichiers))) {
			for (File f : mes_fichiers) {
                if (f.isDirectory()) { //.isDirectory verifie si le fichier est un repertoire, si oui -> vrai, si non -> faux
                    lister(f.getAbsolutePath());
			    } else if (f.getName().endsWith(".png") || (f.getName().endsWith(".jpg"))) {
			    	       images.add(f.getName());
			    }
		    }	    
		}
	}
	
	public String toString() throws IllegalArgumentException{
		String res = "";
		if(images.size()==0) { //si le ArrayList est vide, une exception est lancee
			throw new IllegalArgumentException("votre dossier ne contient aucunes images de type .png ou .joeg");
		}else {
			for(int i=0; i<images.size();i++) {
				res += images.get(i) + "\n";
			}
		}
		return res;
	}
	
}