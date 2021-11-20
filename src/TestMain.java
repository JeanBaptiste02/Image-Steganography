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
	
	public static void main(String[] args) {
		System.out.println("#####################################\n");
		System.out.println("#######  Image Steganographie  ######\n");
		System.out.println("#####################################\n");
		//String val1 = args[0];
		//String val2 = args[1];
		if(args.length == 0) { // there is no argument only if the array is empty
			System.out.println("Il manque des parametres\n" + 
		                      "Afin d'avoir plus d'informations "
		                       + "veuillez taper -h ou --help apres la commande d'execution \n");
		}
		else if(args.length!=0) {
			if(args[0].equals("-h") || args[0].equals("--help")) {
				System.out.println("[options]            [fonctions]");
				System.out.println("  -h, --help         permet d'obtenir de l'aide \n");
				System.out.println("  -d                 affiche la liste et analyse tous "
						                                 + "les images � partir d'un certain dossier \n");
				System.out.println("  -s                 permet de dissimuler un texte dans un certain fichier \n");
				System.out.println("  -e                 permet  d'extraire un texte dissimul� dans un certain fichier \n");

			}
		}

		
		/*switch works only with integers,etc.
		 it never works with boolean type! 
		*/
		/*
		switch(args.length) 
		{
		case 0: 
			System.out.println("pas d'arguments"); 
			break;
		case 1:
			System.out.println("namaste India");
			break;
			
		}
		*/
	}

}