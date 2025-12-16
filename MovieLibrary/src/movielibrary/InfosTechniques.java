package movielibrary;

public class InfosTechniques {
	private int duree;             // en minutes
	   private String langue;
	   private String sousTitres;
	   private String qualite;        // HD, 4K, etc.
	   
	   public InfosTechniques(int duree, String langue) {
	       this.duree = duree;
	       this.langue = langue;
	       this.sousTitres = "Aucun";
	       this.qualite = "HD";
	   }
	   
	   public void setSousTitres(String sousTitres) { this.sousTitres = sousTitres; }
	   public void setQualite(String qualite) { this.qualite = qualite; }
	   
	   public int getDuree() { return duree; }
	   public String getLangue() { return langue; }
	   public String getSousTitres() { return sousTitres; }
	   public String getQualite() { return qualite; }
	   
	   public String toString() {
	       return duree + " min | " + langue + " | ST: " + sousTitres + " | " + qualite;
	   }
}
