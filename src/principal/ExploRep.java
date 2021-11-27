package principal;

import java.io.File;
 
public class ExploRep {
 
	private String cheminInitial = "";
   

    public ExploRep(String cheminInitial) {
        this.cheminInitial = cheminInitial;
    }
 
    public void maList() {
        this.listDirectory(this.cheminInitial);
    }
 
    private void listDirectory(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
                    System.out.println("Dossier: " + files[i].getAbsolutePath());
                } else {
                    System.out.println("  Fichier: " + files[i].getName());
                }
                
            }
        }
    }    
}