package principal;

@SuppressWarnings("serial")
public class ImageExtensionException extends Exception{
	
	public ImageExtensionException() {
		super("Erreur : vous devez choisir un fichier png pour cacher un message secret");
	}

}
