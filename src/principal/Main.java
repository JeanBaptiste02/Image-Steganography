package principal;
import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
/**
 * 
 * @author DAMODARANE Jean-Baptiste / ELUMALAI Sriguru
 *
 */
public class Main {
	/**
	 * 
	 * @param args is an array of strings
	 */
	
	public static void main(String[] args){
		System.out.println("#####################################\n");
		System.out.println("#######  Image Steganographie  ######\n");
		System.out.println("#####################################\n");
		
		
		int nombre_args = args.length;
		switch(nombre_args) {
		case 0:
			System.out.println("Il manque des parametres\n" + 
                    "Afin d'avoir plus d'informations "
                     + "veuillez taper -h ou --help apres la commande d'execution \n");
			break;
		case 1:
			if(args[0].equals("-h") || args[0].equals("--help")) {
				System.out.println("[options]            [fonctions]");
				System.out.println("  -h, --help         permet d'obtenir de l'aide \n");
				System.out.println("  -d                 affiche la liste et analyse tous "
						                                 + "les images a partir d'un certain dossier \n");
				System.out.println("  -f                  affiche les metadonnees d'un fichier donnee en parametre \n");
				System.out.println("  -s                 permet de dissimuler un texte dans un certain fichier \n");
				System.out.println("  -e                 permet  d'extraire un texte dissimule dans un certain fichier \n");	
			}else {
				if(args[0].equals("-d")) {
					System.out.println("Il manque des arguments, veuillez taper -h ou --help apres la commande d'execution \n ");
				}
			}
			break;
		case 2:
			try {
		    if(args[0].equals("-d") && args[1].equals(".")) {
				String lechemin = "/mnt/c/Users/vikne/eclipse-workspace/PROJ/images";
				System.out.println("Liste des images sous  : " + lechemin);
			    System.out.println("------------------------------------");
				ExploRep explorer = new ExploRep(lechemin);
				explorer.maListe();
				System.out.println(explorer.toString());
			}else if(args[0].equals("-d")) {
				File rep = new File(args[1]);
				String lechemin = rep.getAbsolutePath(); 
				System.out.println("Liste des images sous : " + lechemin);
			    System.out.println("------------------------------------");
			    ExploRep explorer = new ExploRep(lechemin);
				explorer.maListe();
				System.out.println(explorer.toString());
			} 
			}catch(IllegalArgumentException error1) {
				System.err.println(error1.getMessage());
			}catch(DossierNexistePas error2) {
				System.err.println(error2.getMessage());
			}
			
			/*pour afficher les metadonnees d'une image*/
			try {
				if(args[0].equals("-f")) {
					File monImage = new File(args[1]);
					String lechemin = monImage.getAbsolutePath();
					Metadata metadata = ImageMetadataReader.readMetadata(monImage);
					Metadonnees var = new Metadonnees(metadata, lechemin);
					var.print(metadata);
				}
			}catch(ImageProcessingException e1) {
				System.err.println("Il y a ERREUR");
			}catch(IOException e2) {
				System.err.println(e2.getMessage());
			}

	}
}
}