package movielibrary;

public class Acteur {
	 private String nom;
	    private String role;
	    
	    public Acteur(String nom, String role) {
	        this.nom = nom;
	        this.role = role;
	    }
	    
	    public String getNom() { return nom; }
	    public String getRole() { return role; }
	    
	    public String toString() {
	        return nom + " (" + role + ")";
	    }
}
