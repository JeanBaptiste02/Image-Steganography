package principal;

import java.io.File;

/**
 * 
 * @author Jean-Baptiste / Elumalai Sriguru
 *
 */
public class ExploRep {
 
	private String cheminInitial = "";
   

    public ExploRep(String cheminInitial) {
        this.cheminInitial = cheminInitial;
    }
    
    public Boolean estVide(File[] f) {
    	if(f==null)
    		return true;
    	return false;
    }
 
    public void maList() {
        this.listerReper(this.cheminInitial);
    }
 
    public void listerReper(String mon_reper) {
        File fichier = new File(mon_reper);
        File[] fichiers = fichier.listFiles();
        if (!estVide(fichiers)) {
            for (int i = 0; i < fichiers.length; i++) {
            	if (fichiers[i].isDirectory() == true) {
            		listerReper(fichiers[i].getAbsolutePath());
                }else if(fichiers[i].getName().endsWith(".png") || fichiers[i].getName().endsWith(".png")) {
                	System.out.println(fichiers[i].getName());
                }
                
            }
        }
    }    
}