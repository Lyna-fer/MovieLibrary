package movielibrary;
import java.util.*;
public class MovieLibraryView {
	public void afficherMenuPrincipal() {
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║    MY MOVIE LIBRARY - Ma Collection       ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.println("\n📺 MA COLLECTION");
        System.out.println("  1. Voir toute ma collection");
        System.out.println("  2. Ajouter un film (populaire)");
        System.out.println("  3. Ajouter un film (manuel)");
        System.out.println("  4. Supprimer un film");
        System.out.println("  5. Chercher un film");
        
        System.out.println("\n🎬 GESTION");
        System.out.println("  6. Changer le statut d'un film");
        System.out.println("  7. Noter un film");
        System.out.println("  8. Enregistrer un visionnage");
        System.out.println("  9. Voir détails d'un film");
        
        System.out.println("\n🔍 FILTRES (Stratégie)");
        System.out.println("  10. Filtrer par statut");
        System.out.println("  11. Filtrer par genre");
        System.out.println("  12. Filtrer par note");
        System.out.println("  13. Filtrer par année");
        
        System.out.println("\n📊 STATISTIQUES");
        System.out.println("  14. Voir mes statistiques");
        
        System.out.println("\n🔔 NOTIFICATIONS");
        System.out.println("  15. Historique des notifications");
        
        System.out.println("\n  0. Quitter");
        System.out.print("\nChoix: ");
    }
    
    public void afficherFilms(List<Film> films, String titre) {
        System.out.println("\n" + titre);
        System.out.println("═══════════════════════════════════════════");
        if (films.isEmpty()) {
            System.out.println("  (Aucun film)");
        } else {
            for (Film f : films) {
                System.out.println(f);
                System.out.println("───────────────────────────────────────────");
            }
        }
        System.out.println("Total: " + films.size() + " film(s)");
    }
    
    public void afficherDetailsFilm(Film film) {
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║         DÉTAILS DU FILM                   ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.println("\n🎬 " + film.getTitre() + " (" + film.getAnnee() + ")");
        System.out.println("   ID: " + film.getId());
        System.out.println("   Réalisateur: " + film.getRealisateur());
        System.out.println("   Genre: " + film.getGenre());
        System.out.println("   Statut: " + film.getStatut());
        
        if (film.getSynopsis() != null && !film.getSynopsis().isEmpty()) {
            System.out.println("\n📖 Synopsis:");
            System.out.println("   " + film.getSynopsis());
        }
        
        if (film.getInfosTech() != null) {
            System.out.println("\n⚙️ Infos techniques:");
            System.out.println("   " + film.getInfosTech());
        }
        
        if (!film.getActeurs().isEmpty()) {
            System.out.println("\n👥 Casting:");
            for (Acteur a : film.getActeurs()) {
                System.out.println("   • " + a);
            }
        }
        
        if (film.getAvis() != null) {
            System.out.println("\n⭐ Mon avis:");
            System.out.println("   " + film.getAvis().toString().replace("\n", "\n   "));
        }
        
        if (!film.getSessions().isEmpty()) {
            System.out.println("\n📺 Historique de visionnage:");
            for (SessionVisionnage s : film.getSessions()) {
                System.out.println("   • " + s);
            }
        }
    }
    
    public void afficherStatistiques(MovieLibraryManager manager) {
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║         MES STATISTIQUES                  ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        
        int total = manager.getNombreFilms();
        int vus = manager.getNombreFilmsVus();
        int aVoir = 0, enCours = 0, abandonnes = 0;
        
        for (Film f : manager.getCollection()) {
            switch(f.getStatut()) {
                case A_VOIR: aVoir++; break;
                case EN_COURS: enCours++; break;
                case ABANDONNE: abandonnes++; break;
                case VU: 
            }
        }
        
        System.out.println("\n📊 COLLECTION");
        System.out.println("   Total de films: " + total);
        System.out.println("   Films vus: " + vus + " (" + (total > 0 ? (vus*100/total) : 0) + "%)");
        System.out.println("   À voir: " + aVoir);
        System.out.println("   En cours: " + enCours);
        System.out.println("   Abandonnés: " + abandonnes);
        
        int duree = manager.getDureeTotal();
        System.out.println("\n⏱️ TEMPS DE VISIONNAGE");
        System.out.println("   Total: " + duree + " minutes (" + (duree/60) + "h" + (duree%60) + ")");
        if (vus > 0) {
            System.out.println("   Moyenne par film: " + (duree/vus) + " min");
        }
        
        double noteMoyenne = manager.getNoteMoyenne();
        if (noteMoyenne > 0) {
            System.out.println("\n⭐ NOTES");
            System.out.println("   Note moyenne: " + String.format("%.1f", noteMoyenne) + "/5");
        }
        
        Map<Genre, Integer> genres = manager.getRepartitionGenres();
        if (!genres.isEmpty()) {
            System.out.println("\n🎭 GENRES");
            for (Map.Entry<Genre, Integer> entry : genres.entrySet()) {
                int pct = (entry.getValue() * 100) / total;
                System.out.println("   " + entry.getKey() + ": " + entry.getValue() + 
                                 " (" + pct + "%)");
            }
        }
    }
    
    public void afficherMessage(String message) {
        System.out.println("\n✓ " + message);
    }
    
    public void afficherErreur(String erreur) {
        System.out.println("\n✗ ERREUR: " + erreur);
    }
}
