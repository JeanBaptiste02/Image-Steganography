package testv1;

import java.io.File;

public class TestFiltre {

	public static void main(String[] args) {
		System.out.println("#####################################\n");
		System.out.println("#######  Image Steganographie  ######\n");
		System.out.println("#####################################\n");
		
		int nbrArg = args.length;
		switch(nbrArg) {
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
						                                 + "les images à  partir d'un certain dossier \n");
				System.out.println("  -s                 permet de dissimuler un texte dans un certain fichier \n");
				System.out.println("  -e                 permet  d'extraire un texte dissimulé dans un certain fichier \n");
			} else if(args[0].equals("-d")) {
				       String lechemin = "C:\\Users\\srigu\\OneDrive\\Bureau\\projetS3\\PROJET_de_Jean_Sri";
				       File dossier = new File(lechemin);
				       ImageFiltre img = new ImageFiltre();
				       img.regroupeFichiers(dossier);
				       img.afficherImages();
			}
		}
		

	}

}
