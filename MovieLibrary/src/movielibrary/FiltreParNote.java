package movielibrary;
import java.util.List;
import java.util.ArrayList;
public class FiltreParNote  implements StrategieFiltre {
	 private double noteMin;
	    
	    public FiltreParNote(double noteMin) {
	        this.noteMin = noteMin;
	    }
	    
	    public List<Film> filtrer(List<Film> films) {
	        List<Film> resultat = new ArrayList<>();
	        for (Film f : films) {
	            if (f.getAvis() != null && f.getAvis().getNote() >= noteMin) {
	                resultat.add(f);
	            }
	        }
	        return resultat;
	    }
	    
	    public String getNom() {
	        return "Filtre par note >= " + noteMin;
	    }
}
