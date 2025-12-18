package movielibrary;

public class MovieLibraryApp {
	 public static void main(String[] args) {
	        System.out.println("╔══════════════════════════════════════════════╗");
	        System.out.println("║             MY MOVIE LIBRARY                 ║");
	        System.out.println("║                                              ║");
	        System.out.println("║   Bibliothèque Personnelle de Films          ║");
	        System.out.println("╚══════════════════════════════════════════════╝\n");
	        
	        MovieLibraryController controller = new MovieLibraryController();
	        controller.demarrer();
	    }
}
