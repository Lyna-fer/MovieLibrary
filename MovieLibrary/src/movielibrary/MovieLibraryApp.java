package movielibrary;

public class MovieLibraryApp {
	 public static void main(String[] args) {
	        System.out.println("╔══════════════════════════════════════════════╗");
	        System.out.println("║    MY MOVIE LIBRARY - Système MVC            ║");
	        System.out.println("║                                              ║");
	        System.out.println("║  📺 Bibliothèque Personnelle de Films        ║");
	        System.out.println("║                                              ║");
	        System.out.println("║  ✓ Singleton (Manager unique)                ║");
	        System.out.println("║  ✓ Composition (Film avec Acteurs, Avis...)  ║");
	        System.out.println("║  ✓ Stratégie (Filtres multiples)             ║");
	        System.out.println("║  ✓ Observateur (Notifications)               ║");
	        System.out.println("╚══════════════════════════════════════════════╝\n");
	        
	        MovieLibraryController controller = new MovieLibraryController();
	        controller.demarrer();
	    }
}
