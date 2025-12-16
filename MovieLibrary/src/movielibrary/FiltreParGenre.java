package movielibrary;
import java.util.List;
import java.util.ArrayList;
public class FiltreParGenre implements StrategieFiltre {
	 private Genre genre;
	    
	    public FiltreParGenre(Genre genre) {
	        this.genre = genre;
	    }
	    
	    public List<Film> filtrer(List<Film> films) {
	        List<Film> resultat = new ArrayList<>();
	        for (Film f : films) {
	            if (f.getGenre() == genre) {
	                resultat.add(f);
	            }
	        }
	        return resultat;
	    }
	    
	    public String getNom() {
	        return "Filtre par genre: " + genre;
	    }
}
