package principal;

/**
 * la classe ImageExtensionException permet de lancer une exception si le fichier choisi est un type different de png
 * @author D.JEAN BAPTISTE & E.SRIGURU
 *
 */
@SuppressWarnings("serial")
public class ImageExtensionException extends Exception{
	
	/**
	 * Construit une nouvelle exception en affichant un message d'erreur
	 */
	public ImageExtensionException() {
		super("Erreur : vous devez choisir un fichier png pour cacher un message secret");
	}

}	