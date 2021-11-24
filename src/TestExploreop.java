/**
 * @author vikne
 *
 */
public class TestExploreop {

	/**
	 * @param args est un tableau de string
	 */
	public static void main(String[] args) {
		String lechemin = "C:\\Users\\vikne\\eclipse-workspace\\LEPROJETDEJAVAJBSRI\\src";
		Explorepertoire explorer = new Explorepertoire(lechemin);
		
		explorer.maListe();
		
		System.out.println("\n");
		System.out.println("le chemin à explorer est : " + lechemin);
		System.out.println("\n");
		System.out.println("");
	}

}
