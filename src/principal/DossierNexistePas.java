package principal;

@SuppressWarnings("serial")
/**
 * la classe DossierNexistePas permet de lancer une exception si un dossier n'existe pas
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
public class DossierNexistePas extends Exception{

	/**
	 * Construit une nouvelle exception en affichant un message d'erreur
	 */
	public DossierNexistePas() {
		super("Votre dossier n'existe pas, veuillez saisir un nom de repertoire valide");
	}

}