package cli;

/**
 * 
 * @author DAMODARANE Jean-Baptiste / ELUMALAI Sriguru
 *
 */
public class TestMain {
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
				System.out.println("  -s                 permet de dissimuler un texte dans un certain fichier \n");
				System.out.println("  -e                 permet  d'extraire un texte dissimule dans un certain fichier \n");	
			}
			break;		
		}
	}

}
