package principal;
public class TestExploRep {

	public static void main(String[] args) {
		String chemin = "/mnt/c/Users/vikne/eclipse-workspace/PROJETJAVA";
		ExploRep explore = new ExploRep(chemin);
		explore.maList();
		System.out.println("\n");
		System.out.println("Exploration du chemin : " + chemin);
		System.out.println("\n");
		
		System.out.println("\n");
	}

}
