package principal;

/**
 * 
 * @author Jean-Baptiste / Elumalai Sriguru
 *
 */
public class Main  {

	public static void main(String[] args) {

		System.out.println("#######################");
		System.out.println("#### Steganography ####");
		System.out.println("####################### \n");

		
		if(args.length==0) {
			System.out.println("Il manque des parametres \n" + "Afin d'avoir plus "
					+ "d'informations veuillez taper -h ou --help apres la commande \n" );
		}
		else if(args.length!=0) {
			if(args[0].equals("-h") || args[0].equals("--help")) {
				System.out.println("[Options]           [Fonctions]");
				System.out.println(" -h, --help          permet d'obtenir de l'aide \n");
				System.out.println(" -d                  affiche la liste et analyse tout"
						+ "les images a partir d'un certain dossier \n");
				System.out.println(" -s                  permet de dissimuler un texte dans"
						+ " un certain fichier \n");
				System.out.println(" -e                  permet d'extraire un texte dissimule"
						+ "dans un certain fichier");
			}
			else if(args[0].equals("-d")) {
				String lechemin = "/mnt/c/Users/vikne/eclipse-workspace/LEPROJETDEJAVAJBSRI/images";
				System.out.println("Le chemin a explorer est :  " + lechemin);
			    System.out.println("\n");
			    System.out.println("les fichiers presents sont : \n");
				ExploRep explorer = new ExploRep(lechemin);
				explorer.maListe();
			}	
		}	
	}
}