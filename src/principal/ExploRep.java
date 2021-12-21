package principal;

import java.io.File;
import java.util.ArrayList;

/**
 * la classe ExploRep permet d'explorer un repertoire, c'est a dire, de lister des fichiers images de type png et jpeg des dossiers et des sous dossiers
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class ExploRep extends FileExtension{
	private ArrayList<String> images = new ArrayList<String>(); //creation d'une arrayList
	
	
	/**
	 * Construit et initialise un chemin
	 * @param monChemin indique le chemin de l'image
	 */
	public ExploRep(String monChemin) {
		super(monChemin);
		
	}
	
	/**
	 * estVideF verifie si un tableau de fichier est vide, si oui, il retourne vraie, si non faux
	 * @param f est un tableau de File et permet
	 * @return retourne un booleen
	 */
	public Boolean estVideF(File[] f) {
		if(f==null) //si le tableau de fichiers est vide
			return true;
		return false; //si non
	}
	
	
	/**
	 * la methode maListe permet de faire une liste des fichiers dans un certain chemin si le repertoire existe, si non elle lance une exception
	 * @throws DossierNexistePas
	 */
	public void maListe() throws DossierNexistePas{
		File rep = new File(this.monChemin);
		if(rep.exists()) {
			 this.lister(this.monChemin); //appel la methode lister()
		}else {
			throw new DossierNexistePas(); //lance une exception si le Dossier n'existe pas
		}
	}
	
	/**
	 * lister permet d'explorer un repertoire recursivement
	 * @param cheminRep indique le chemin du repertoire
	 */
	public void lister(String cheminRep) {
		File rep = new File(cheminRep);
		File[] mes_fichiers = rep.listFiles(); //retourne un tableau de fichiers (a verifier)
		if(!(estVideF(mes_fichiers))) {
			for (File f : mes_fichiers) {
                if (f.isDirectory()) { //verifie si le fichier est un repertoire, si oui -> vrai, si non -> faux
                    lister(f.getAbsolutePath()); //recursive
			    } else if (imageVerifExt(f)) {
			    	       images.add(f.getName()); //ajout les noms des image qui finissent pas png et jpg dans l'arrayList
			    }
		    }	    
		}
	}
	
	/**
	 * la methode toString permet d'afficher la liste des images
	 * @return retourne le resultat a afficher
	 */
	public String toString() throws IllegalArgumentException{
		String res = "";
		if(images.size()==0) { //si le ArrayList est vide, une exception est lancee
			throw new IllegalArgumentException("votre dossier ne contient aucunes images de type .png ou .jpeg");
		}else {
			for(int i=0; i<images.size();i++) {
				res += images.get(i) + "\n";
			}
		}
		return res;
	}
	
}