package movielibrary;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
public class Avis {
	 private double note;          
	    private String commentaire;
	    private Date dateAvis;
	    private List<String> pointsForts;
	    private List<String> pointsFaibles;
	    
	    public Avis(double note, String commentaire) {
	        this.note = note;
	        this.commentaire = commentaire;
	        this.dateAvis = new Date();
	        this.pointsForts = new ArrayList<>();
	        this.pointsFaibles = new ArrayList<>();
	    }
	    
	    public void ajouterPointFort(String point) {
	        pointsForts.add(point);
	    }
	    
	    public void ajouterPointFaible(String point) {
	        pointsFaibles.add(point);
	    }
	    
	    public double getNote() { return note; }
	    public String getCommentaire() { return commentaire; }
	    public Date getDateAvis() { return dateAvis; }
	    public List<String> getPointsForts() { return pointsForts; }
	    public List<String> getPointsFaibles() { return pointsFaibles; }
	    
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Note: ").append(note).append("/5 ");
	        for (int i = 0; i < (int)note; i++) sb.append("⭐");
	        sb.append("\n");
	        if (!commentaire.isEmpty()) {
	            sb.append("Commentaire: ").append(commentaire).append("\n");
	        }
	        if (!pointsForts.isEmpty()) {
	            sb.append("Points forts: ").append(String.join(", ", pointsForts)).append("\n");
	        }
	        if (!pointsFaibles.isEmpty()) {
	            sb.append("Points faibles: ").append(String.join(", ", pointsFaibles));
	        }
	        return sb.toString();
	    }
}

