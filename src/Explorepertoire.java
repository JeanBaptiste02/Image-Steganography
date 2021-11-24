import java.io.File;

/**
 * 
 * @author Jean-Baptiste 
 *
 */

public class Explorepertoire {
	private String monChemin = ""; //mon chemin d'acc�s aux dossiers / fichiers
	/*
	 * si ces 2 attributs �taient private, il faudrait faire des accesseurs des accesseurs en �criture et lecture
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
	 * @param f est une r�f�rence
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

	public void lister(String monRep) {
		File f = new File(monRep);
		File[] mes_fichiers = f.listFiles(); //retourne un tableau de fichiers (� v�rifier)
		if(!(estVideF(mes_fichiers))) {
			int i = 0;
			while(i<mes_fichiers.length) {
				if(mes_fichiers[i].isDirectory()){	//.isDirectory v�rifie si le fichier est un r�pertoire, si oui -> vrai, si non -> faux 
					System.out.println("Dossier : " + mes_fichiers[i].getName());
					
				}else if(mes_fichiers[i].isFile()) {
					System.out.println("Fichier : " + mes_fichiers[i].getName());
					
				}
				i++;
			}
		}
	}
	
	
}
