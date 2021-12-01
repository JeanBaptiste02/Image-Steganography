
import java.io.File;
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
<<<<<<< HEAD
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
				String lechemin = "/mnt/c/Users/vikne/eclipse-workspace/LEPROJETDEJAVAJBSRI/images";
				System.out.println("Liste des images sous : " + lechemin);
			    System.out.println("------------------------------------");
				ExploRep explorer = new ExploRep(lechemin);
				explorer.maListe();
				System.out.println(explorer.toString());
			}else {
				File rep = new File(args[1]);
				String lechemin = rep.getAbsolutePath(); // sa marche mais il faut mettre le repertoire en question dans src
				System.out.println("Liste des images sous : " + lechemin);
			    System.out.println("------------------------------------");
			    ExploRep explorer = new ExploRep(lechemin);
				explorer.maListe();
				System.out.println(explorer.toString());

			} // ajouter une erreur (a voir)
			}catch(IllegalArgumentException error1) {
				System.err.println(error1.getMessage());
			}catch(DossierNexistePas error2) {
				System.err.println(error2.getMessage());
			}
		    break;
			

	}

}
}
=======
				System.out.println("  -s                 permet de dissimuler un texte dans un certain fichier \n");
				System.out.println("  -e                 permet  d'extraire un texte dissimule dans un certain fichier \n");	
			}
			break;
		case 2:
		    if(args[0].equals("-d") && args[1].equals(".")) {
				String lechemin = "/mnt/c/Users/srigu/OneDrive/Bureau/ProjetS3/PROJET_de_Jean_Sri";
				System.out.println("Liste des images sous : " + lechemin);
			    System.out.println("------------------------------------");
				Explorepertoire explorer = new Explorepertoire(lechemin);
				explorer.maListe();
			}else {
				File rep = new File(args[1]);
				String lechemin = rep.getAbsolutePath(); // sa marche mais il faut mettre le repertoire en question dans src
				System.out.println("Liste des images sous : " + lechemin);
			    System.out.println("------------------------------------");
				Explorepertoire explorer = new Explorepertoire(lechemin);
				explorer.maListe();
			} // ajouter une erreur (a voir)
		    break;	
		}
	}

}
>>>>>>> 6d89297cd15a64e26359055b1515374d4c00c5e7
