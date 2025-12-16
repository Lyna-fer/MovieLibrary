package movielibrary;
import java.util.*;
public class MovieLibraryManager implements Sujet{
	private static MovieLibraryManager instance;
    private List<Film> maCollection;
    private List<Observateur> observateurs;
    
    private MovieLibraryManager() {
        this.maCollection = new ArrayList<>();
        this.observateurs = new ArrayList<>();
    }
    
    public static MovieLibraryManager getInstance() {
        if (instance == null) {
            instance = new MovieLibraryManager();
        }
        return instance;
    }
    
    // OBSERVATEUR
    public void ajouterObservateur(Observateur obs) {
        observateurs.add(obs);
    }
    
    public void retirerObservateur(Observateur obs) {
        observateurs.remove(obs);
    }
    
    public void notifierObservateurs(String message) {
        for (Observateur obs : observateurs) {
            obs.update(message);
        }
    }
    
    // Gestion des films
    public void ajouterFilm(Film film) {
        maCollection.add(film);
        notifierObservateurs("✅ " + film.getTitre() + " ajouté à ta collection");
    }
    
    public boolean supprimerFilm(int id) {
        for (Film f : maCollection) {
            if (f.getId() == id) {
                String titre = f.getTitre();
                maCollection.remove(f);
                notifierObservateurs("🗑️ " + titre + " supprimé de ta collection");
                return true;
            }
        }
        return false;
    }
    
    public Film trouverFilm(int id) {
        for (Film f : maCollection) {
            if (f.getId() == id) return f;
        }
        return null;
    }
    
    public List<Film> getCollection() {
        return maCollection;
    }
    
    public List<Film> filtrer(StrategieFiltre strategie) {
        return strategie.filtrer(maCollection);
    }
    
    // Statistiques
    public int getNombreFilms() {
        return maCollection.size();
    }
    
    public int getNombreFilmsVus() {
        int count = 0;
        for (Film f : maCollection) {
            if (f.getStatut() == StatutVisionnage.VU) count++;
        }
        return count;
    }
    
    public int getDureeTotal() {
        int total = 0;
        for (Film f : maCollection) {
            if (f.getInfosTech() != null && f.getStatut() == StatutVisionnage.VU) {
                total += f.getInfosTech().getDuree();
            }
        }
        return total;
    }
    
    public double getNoteMoyenne() {
        double somme = 0;
        int count = 0;
        for (Film f : maCollection) {
            if (f.getAvis() != null) {
                somme += f.getAvis().getNote();
                count++;
            }
        }
        return count > 0 ? somme / count : 0;
    }
    
    public Map<Genre, Integer> getRepartitionGenres() {
        Map<Genre, Integer> repartition = new HashMap<>();
        for (Film f : maCollection) {
            repartition.put(f.getGenre(), repartition.getOrDefault(f.getGenre(), 0) + 1);
        }
        return repartition;
    }
}
