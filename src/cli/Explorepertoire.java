package traitement;

import java.io.File;

/**
 * 
 * @author Jean-Baptiste 
 *
 */

public class Explorepertoire {
	private String monChemin = ""; //mon chemin d'acces aux dossiers / fichiers
	/*
	 * si ces 2 attributs etaient private, il faudrait faire des accesseurs des accesseurs en ecriture et lecture
	 */
	
	
	/**
	 * Constructeur
	 * @param monChemin permet faire l'initialisation de l'attribut monChemin
	 */
	public Explorepertoire(String monChemin) {
		this.monChemin = monChemin;
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
	
	
	public void maListe() {
		
		 this.lister(this.monChemin);
	}
	
	

	public void lister(String cheminRep) {
		File rep = new File(cheminRep);
		File[] mes_fichiers = rep.listFiles(); //retourne un tableau de fichiers (a verifier)
		if(!(estVideF(mes_fichiers))) {
			for (File f : mes_fichiers) {
                if (f.isDirectory()) { //.isDirectory verifie si le fichier est un repertoire, si oui -> vrai, si non -> faux
                    lister(f.getAbsolutePath());
			    } else if (f.getName().endsWith(".png") || (f.getName().endsWith(".jpg"))) {
			    	       System.out.println(f.getName());
			    }
		    }	    
		}
	}	
	
}
