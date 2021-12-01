package principal;

@SuppressWarnings("serial")
public class DossierNexistePas extends Exception{

	public DossierNexistePas() {
		super("Votre dossier n'existe pas, veuillez saisir un nom de repertoire valide");
	}

}
