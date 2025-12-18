package movielibrary;

import java.util.ArrayList;
import java.util.List;

public class FiltreParAnnee implements StrategieFiltre{
	private int anneeMin;
    private int anneeMax;
    
    public FiltreParAnnee(int anneeMin, int anneeMax) {
        this.anneeMin = anneeMin;
        this.anneeMax = anneeMax;
    }
    
    public List<Film> filtrer(List<Film> films) {
        List<Film> resultat = new ArrayList<>();
        for (Film f : films) {
            if (f.getAnnee() >= anneeMin && f.getAnnee() <= anneeMax) {
                resultat.add(f);
            }
        }
        return resultat;
    }
    
    public String getNom() {
        return "Filtre par année: " + anneeMin + "-" + anneeMax;
    }
}
