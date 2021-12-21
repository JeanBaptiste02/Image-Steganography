package principal;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
/**
 * la classe MainCli permet faire l'instanciation de toutes les classes et de les executer
 * @author DAMODARANE Jean-Baptiste & ELUMALAI Sriguru
 *
 */
public class MainCli {
	
	/**
	 * Les instanciations et les appels des methodes et des classes sont faits dans cette methode
	 * @param args est un tableau de String
	 * 
	 */
	
	public static void main(String[] args) throws IOException{
		
		
		System.out.println("#####################################\n");
		System.out.println("#######  Image Steganographie  ######\n");
		System.out.println("#####################################\n");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		
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
				String lechemin = ".";
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
					Metadonnees var = new Metadonnees(lechemin);
					var.print(metadata);
				}
			}catch(ImageProcessingException e1) {
				System.err.println("Il y a ERREUR");
			}catch(IOException e2) {
				System.err.println(e2.getMessage());
			}
			break;
			
			
		case 3:
			
			if(args[0].equals("-f") && args[2].equals("-e")) {
				File imageEncode = new File(args[1]);
				
				String filePath = imageEncode.getAbsolutePath();

				File outFile = new File(filePath);
				BufferedImage image = null;

				image = ImageIO.read(outFile);

				DecoderImage var = new DecoderImage(null, image);
				
				String bitMessage = var.decodeLeMessage(image);
				
				System.out.println("le message secret est : \n"+var.retournMess(bitMessage));
			}
			
			break;
		
			
		
		 case 4:
			 try {
                 if(args[0].equals("-f") && args[2].equals("-s")) {

                         String nomImage = args[1];
                         File inFile = new File(nomImage);
                         BufferedImage initImage = null;
                         initImage = ImageIO.read(inFile);

                         String message = args[3];

                         EncoderImage var = new EncoderImage(message,initImage); 
                         String bitMsg = var.monstring(message);
                         if (var.verifPng(inFile)) {
                             BufferedImage newImage = var.encodeLimage(bitMsg,initImage);
                             System.out.println("Veuillez saisir le nom du fichier sous lequel vous souhaitez enregistrer l'image :");
                             String nomImageEncoder = input.nextLine();
                             File finalImage = new File(nomImageEncoder);
                             ImageIO.write(newImage,"png",finalImage);
                             String lechemin = finalImage.getAbsolutePath();
                             System.out.println("Votre image a bien ete encoder sous : " + lechemin);
                         }
                     }
             } catch (ImageExtensionException e) {
                 System.err.println(e.getMessage());
             } catch (IOException e) {
                  System.err.println("Impossible d'ouvrir l'image");
             }
		 

			 break;
	}
}
}