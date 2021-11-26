package traitement;

public class TestExploreop{

	public static void main(String[] args) {
		String lechemin = "C:\\Users\\srigu\\OneDrive\\Bureau\\projetS3\\PROJET_de_Jean_Sri\\images";
		System.out.println("Liste des images sous : " + lechemin);
	    System.out.println("------------------------------------");
		Explorepertoire explorer = new Explorepertoire(lechemin);
		explorer.maListe();
	}
}
