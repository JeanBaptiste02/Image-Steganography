public class TestExploreop{

	public static void main(String[] args) {
		String lechemin = "C:\\Users\\vikne\\eclipse-workspace\\LEPROJETDEJAVAJBSRI";
		Explorepertoire explorer = new Explorepertoire(lechemin);
		
		explorer.maListe();
		
		System.out.println("\n");
		System.out.println("le chemin a explorer est : " + lechemin);
		System.out.println("\n");
		System.out.println("");
	}
}
