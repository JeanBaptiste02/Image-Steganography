package principal;
public class TestExploRep {

	public static void main(String[] args) {
		String lechemin = "/mnt/c/Users/vikne/eclipse-workspace/LEPROJETDEJAVAJBSRI/images";
		System.out.println("Le chemin a explorer est :  " + lechemin);
	    System.out.println("------------------------------------");
		ExploRep explorer = new ExploRep(lechemin); // appel du constructeur
		explorer.maListe();
	}

}
