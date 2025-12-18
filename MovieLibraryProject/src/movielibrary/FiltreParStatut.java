package movielibrary;
import java.util.List;
import java.util.ArrayList;
public class FiltreParStatut implements StrategieFiltre{
private StatutVisionnage statut;
    
    public FiltreParStatut(StatutVisionnage statut) {
        this.statut = statut;
    }
    
    public List<Film> filtrer(List<Film> films) {
        List<Film> resultat = new ArrayList<>();
        for (Film f : films) {
            if (f.getStatut() == statut) {
                resultat.add(f);
            }
        }
        return resultat;
    }
    
    public String getNom() {
        return "Filtre par statut: " + statut;
    }
}
