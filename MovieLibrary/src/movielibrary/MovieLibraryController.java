package movielibrary;
import java.util.*;

public class MovieLibraryController {
	 private MovieLibraryManager manager;
	    private MovieLibraryView view;
	    private Scanner scanner;
	    private SystemeNotifications notifications;
	    
	    public MovieLibraryController() {
	        this.manager = MovieLibraryManager.getInstance();
	        this.view = new MovieLibraryView();
	        this.scanner = new Scanner(System.in);
	        this.notifications = new SystemeNotifications();
	        manager.ajouterObservateur(notifications);
	    }
	    
	    public void demarrer() {
	        initialiserFilmsPopulaires();
	        
	        boolean continuer = true;
	        while (continuer) {
	            view.afficherMenuPrincipal();
	            int choix = lireEntier();
	            
	            switch (choix) {
	                case 1: voirCollection(); break;
	                case 2: ajouterFilmPopulaire(); break;
	                case 3: ajouterFilmManuel(); break;
	                case 4: supprimerFilm(); break;
	                case 5: chercherFilm(); break;
	                case 6: changerStatut(); break;
	                case 7: noterFilm(); break;
	                case 8: enregistrerVisionnage(); break;
	                case 9: voirDetails(); break;
	                case 10: filtrerParStatut(); break;
	                case 11: filtrerParGenre(); break;
	                case 12: filtrerParNote(); break;
	                case 13: filtrerParAnnee(); break;
	                case 14: voirStatistiques(); break;
	                case 15: notifications.afficherHistorique(); break;
	                case 0: continuer = false; break;
	                default: view.afficherErreur("Choix invalide");
	            }
	        }
	        
	        System.out.println("\n🎬 Merci d'avoir utilisé My Movie Library!");
	        scanner.close();
	    }
	    
	    private int lireEntier() {
	        while (!scanner.hasNextInt()) {
	            scanner.next();
	            System.out.print("Nombre invalide, réessayez: ");
	        }
	        int resultat = scanner.nextInt();
	        scanner.nextLine();
	        return resultat;
	    }
	    
	    private void initialiserFilmsPopulaires() {
	        // Créer quelques films de démonstration
	        Film inception = creerInception();
	        Film interstellar = creerInterstellar();
	        Film darkKnight = creerDarkKnight();
	        
	        manager.ajouterFilm(inception);
	        manager.ajouterFilm(interstellar);
	        manager.ajouterFilm(darkKnight);
	        
	        System.out.println("\n✓ Bibliothèque initialisée avec 3 films de démonstration");
	    }
	    
	    private Film creerInception() {
	        Film film = new Film("Inception", "Christopher Nolan", 2010, Genre.SCIENCE_FICTION);
	        film.setSynopsis("Un voleur qui s'infiltre dans les rêves se voit offrir une chance de retrouver sa vie passée.");
	        film.setInfosTech(new InfosTechniques(148, "Anglais"));
	        film.ajouterActeur(new Acteur("Leonardo DiCaprio", "Dom Cobb"));
	        film.ajouterActeur(new Acteur("Marion Cotillard", "Mal"));
	        film.ajouterActeur(new Acteur("Tom Hardy", "Eames"));
	        return film;
	    }
	    
	    private Film creerInterstellar() {
	        Film film = new Film("Interstellar", "Christopher Nolan", 2014, Genre.SCIENCE_FICTION);
	        film.setSynopsis("Une équipe d'explorateurs voyage à travers un trou de ver dans l'espace.");
	        film.setInfosTech(new InfosTechniques(169, "Anglais"));
	        film.ajouterActeur(new Acteur("Matthew McConaughey", "Cooper"));
	        film.ajouterActeur(new Acteur("Anne Hathaway", "Brand"));
	        return film;
	    }
	    
	    private Film creerDarkKnight() {
	        Film film = new Film("The Dark Knight", "Christopher Nolan", 2008, Genre.ACTION);
	        film.setSynopsis("Batman affronte le Joker, un criminel anarchiste.");
	        film.setInfosTech(new InfosTechniques(152, "Anglais"));
	        film.ajouterActeur(new Acteur("Christian Bale", "Batman"));
	        film.ajouterActeur(new Acteur("Heath Ledger", "Joker"));
	        return film;
	    }
	    
	    private void voirCollection() {
	        view.afficherFilms(manager.getCollection(), "📚 MA COLLECTION COMPLÈTE");
	    }
	    
	    private void ajouterFilmPopulaire() {
	        System.out.println("\n🎬 FILMS POPULAIRES");
	        System.out.println("1. The Shawshank Redemption (1994) - Drame");
	        System.out.println("2. Pulp Fiction (1994) - Crime/Drame");
	        System.out.println("3. Forrest Gump (1994) - Drame/Romance");
	        System.out.println("4. The Matrix (1999) - Sci-Fi/Action");
	        System.out.println("5. Fight Club (1999) - Drame/Thriller");
	        System.out.print("\nChoix (0 pour annuler): ");
	        
	        int choix = lireEntier();
	        Film film = null;
	        
	        switch(choix) {
	            case 1:
	                film = new Film("The Shawshank Redemption", "Frank Darabont", 1994, Genre.DRAME);
	                film.setSynopsis("Deux hommes emprisonnés se lient d'amitié sur plusieurs années.");
	                film.setInfosTech(new InfosTechniques(142, "Anglais"));
	                film.ajouterActeur(new Acteur("Tim Robbins", "Andy Dufresne"));
	                film.ajouterActeur(new Acteur("Morgan Freeman", "Red"));
	                break;
	            case 2:
	                film = new Film("Pulp Fiction", "Quentin Tarantino", 1994, Genre.THRILLER);
	                film.setSynopsis("Les vies de deux tueurs à gages, un boxeur et un couple de braqueurs s'entrecroisent.");
	                film.setInfosTech(new InfosTechniques(154, "Anglais"));
	                film.ajouterActeur(new Acteur("John Travolta", "Vincent Vega"));
	                film.ajouterActeur(new Acteur("Samuel L. Jackson", "Jules Winnfield"));
	                break;
	            case 3:
	                film = new Film("Forrest Gump", "Robert Zemeckis", 1994, Genre.DRAME);
	                film.setSynopsis("L'histoire d'un homme simple qui accomplit l'extraordinaire.");
	                film.setInfosTech(new InfosTechniques(142, "Anglais"));
	                film.ajouterActeur(new Acteur("Tom Hanks", "Forrest Gump"));
	                break;
	            case 4:
	                film = new Film("The Matrix", "The Wachowskis", 1999, Genre.SCIENCE_FICTION);
	                film.setSynopsis("Un hacker découvre la vraie nature de la réalité.");
	                film.setInfosTech(new InfosTechniques(136, "Anglais"));
	                film.ajouterActeur(new Acteur("Keanu Reeves", "Neo"));
	                break;
	            case 5:
	                film = new Film("Fight Club", "David Fincher", 1999, Genre.DRAME);
	                film.setSynopsis("Un employé de bureau insomniaque forme un club de combat clandestin.");
	                film.setInfosTech(new InfosTechniques(139, "Anglais"));
	                film.ajouterActeur(new Acteur("Brad Pitt", "Tyler Durden"));
	                film.ajouterActeur(new Acteur("Edward Norton", "Le Narrateur"));
	                break;
	            case 0:
	                return;
	            default:
	                view.afficherErreur("Choix invalide");
	                return;
	        }
	        
	        if (film != null) {
	            manager.ajouterFilm(film);
	            view.afficherMessage(film.getTitre() + " ajouté à ta collection!");
	        }
	    }
	    
	    private void ajouterFilmManuel() {
	        System.out.println("\n╔═══════════════════════════════════════╗");
	        System.out.println("║       AJOUTER UN FILM                 ║");
	        System.out.println("╚═══════════════════════════════════════╝");
	        
	        System.out.print("\n📝 Titre: ");
	        String titre = scanner.nextLine();
	        
	        System.out.print("📝 Réalisateur: ");
	        String realisateur = scanner.nextLine();
	        
	        System.out.print("📝 Année: ");
	        int annee = lireEntier();
	        
	        System.out.println("\n🎭 Genres:");
	        Genre[] genres = Genre.values();
	        for (int i = 0; i < genres.length; i++) {
	            System.out.println((i+1) + ". " + genres[i]);
	        }
	        System.out.print("Choix: ");
	        int choixGenre = lireEntier() - 1;
	        Genre genre = genres[choixGenre];
	        
	        Film film = new Film(titre, realisateur, annee, genre);
	        
	        System.out.print("\n📖 Synopsis (Entrée pour passer): ");
	        String synopsis = scanner.nextLine();
	        if (!synopsis.isEmpty()) {
	            film.setSynopsis(synopsis);
	        }
	        
	        System.out.print("\n⚙️ Durée (minutes): ");
	        int duree = lireEntier();
	        
	        System.out.print("⚙️ Langue: ");
	        String langue = scanner.nextLine();
	        
	        film.setInfosTech(new InfosTechniques(duree, langue));
	        
	        System.out.print("\n👥 Nombre d'acteurs à ajouter: ");
	        int nbActeurs = lireEntier();
	        
	        for (int i = 0; i < nbActeurs; i++) {
	            System.out.print("Nom acteur " + (i+1) + ": ");
	            String nom = scanner.nextLine();
	            System.out.print("Rôle: ");
	            String role = scanner.nextLine();
	            film.ajouterActeur(new Acteur(nom, role));
	        }
	        
	        manager.ajouterFilm(film);
	        view.afficherMessage("Film ajouté avec succès!");
	    }
	    
	    private void supprimerFilm() {
	        voirCollection();
	        System.out.print("\nID du film à supprimer: ");
	        int id = lireEntier();
	        
	        if (manager.supprimerFilm(id)) {
	            view.afficherMessage("Film supprimé");
	        } else {
	            view.afficherErreur("Film introuvable");
	        }
	    }
	    
	    private void chercherFilm() {
	        System.out.print("\nTitre à chercher: ");
	        String recherche = scanner.nextLine().toLowerCase();
	        
	        List<Film> resultats = new ArrayList<>();
	        for (Film f : manager.getCollection()) {
	            if (f.getTitre().toLowerCase().contains(recherche)) {
	                resultats.add(f);
	            }
	        }
	        
	        view.afficherFilms(resultats, "🔍 RÉSULTATS DE RECHERCHE");
	    }
	    
	    private void changerStatut() {
	        voirCollection();
	        System.out.print("\nID du film: ");
	        int id = lireEntier();
	        
	        Film film = manager.trouverFilm(id);
	        if (film == null) {
	            view.afficherErreur("Film introuvable");
	            return;
	        }
	        
	        System.out.println("\nStatut actuel: " + film.getStatut());
	        System.out.println("\nNouveaux statuts:");
	        System.out.println("1. À VOIR");
	        System.out.println("2. EN COURS");
	        System.out.println("3. VU");
	        System.out.println("4. ABANDONNÉ");
	        System.out.print("Choix: ");
	        
	        int choix = lireEntier();
	        StatutVisionnage[] statuts = StatutVisionnage.values();
	        if (choix >= 1 && choix <= statuts.length) {
	            film.setStatut(statuts[choix-1]);
	            manager.notifierObservateurs("📝 Statut de " + film.getTitre() + 
	                                       " changé en " + statuts[choix-1]);
	        }
	    }
	    
	    private void noterFilm() {
	        voirCollection();
	        System.out.print("\nID du film: ");
	        int id = lireEntier();
	        
	        Film film = manager.trouverFilm(id);
	        if (film == null) {
	            view.afficherErreur("Film introuvable");
	            return;
	        }
	        
	        System.out.print("\nNote (/5): ");
	        double note = scanner.nextDouble();
	        scanner.nextLine();
	        
	        System.out.print("Commentaire: ");
	        String commentaire = scanner.nextLine();
	        
	        Avis avis = new Avis(note, commentaire);
	        
	        System.out.print("\nAjouter points forts ? (o/n): ");
	        if (scanner.nextLine().equalsIgnoreCase("o")) {
	            System.out.print("Nombre de points forts: ");
	            int nb = lireEntier();
	            for (int i = 0; i < nb; i++) {
	                System.out.print("Point fort " + (i+1) + ": ");
	                avis.ajouterPointFort(scanner.nextLine());
	            }
	        }
	        
	        System.out.print("Ajouter points faibles ? (o/n): ");
	        if (scanner.nextLine().equalsIgnoreCase("o")) {
	            System.out.print("Nombre de points faibles: ");
	            int nb = lireEntier();
	            for (int i = 0; i < nb; i++) {
	                System.out.print("Point faible " + (i+1) + ": ");
	                avis.ajouterPointFaible(scanner.nextLine());
	            }
	        }
	        
	        film.setAvis(avis);
	        manager.notifierObservateurs("⭐ Tu as noté " + film.getTitre() + " : " + note + "/5");
	    }
	    
	    private void enregistrerVisionnage() {
	        voirCollection();
	        System.out.print("\nID du film: ");
	        int id = lireEntier();
	        
	        Film film = manager.trouverFilm(id);
	        if (film == null) {
	            view.afficherErreur("Film introuvable");
	            return;
	        }
	        
	        System.out.println("\n📍 Lieu de visionnage:");
	        System.out.println("1. Cinéma");
	        System.out.println("2. Maison");
	        System.out.println("3. Chez un ami");
	        System.out.println("4. Autre");
	        System.out.print("Choix: ");
	        
	        int choix = lireEntier();
	        String lieu = "";
	        switch(choix) {
	            case 1: lieu = "Cinéma"; break;
	            case 2: lieu = "Maison"; break;
	            case 3: lieu = "Chez un ami"; break;
	            case 4:
	                System.out.print("Préciser: ");
	                lieu = scanner.nextLine();
	                break;
	        }
	        
	        SessionVisionnage session = new SessionVisionnage(new Date(), lieu);
	        
	        System.out.print("\n📝 Notes (optionnel): ");
	        String notes = scanner.nextLine();
	        if (!notes.isEmpty()) {
	            session.setNotes(notes);
	        }
	        
	        film.ajouterSession(session);
	        manager.notifierObservateurs("📺 Visionnage enregistré pour " + film.getTitre());
	        
	        if (film.getStatut() != StatutVisionnage.VU) {
	            film.setStatut(StatutVisionnage.VU);
	            view.afficherMessage("Statut changé en VU");
	        }
	    }
	    
	    private void voirDetails() {
	        voirCollection();
	        System.out.print("\nID du film: ");
	        int id = lireEntier();
	        
	        Film film = manager.trouverFilm(id);
	        if (film == null) {
	            view.afficherErreur("Film introuvable");
	        } else {
	            view.afficherDetailsFilm(film);
	        }
	    }
	    
	    private void filtrerParStatut() {
	        System.out.println("\n📊 Filtrer par statut:");
	        System.out.println("1. À VOIR");
	        System.out.println("2. EN COURS");
	        System.out.println("3. VU");
	        System.out.println("4. ABANDONNÉ");
	        System.out.print("Choix: ");
	        
	        int choix = lireEntier();
	        StatutVisionnage[] statuts = StatutVisionnage.values();
	        if (choix >= 1 && choix <= statuts.length) {
	            StrategieFiltre strategie = new FiltreParStatut(statuts[choix-1]);
	            List<Film> resultat = manager.filtrer(strategie);
	            view.afficherFilms(resultat, "🔍 " + strategie.getNom());
	        }
	    }
	    
	    private void filtrerParGenre() {
	        System.out.println("\n🎭 Filtrer par genre:");
	        Genre[] genres = Genre.values();
	        for (int i = 0; i < genres.length; i++) {
	            System.out.println((i+1) + ". " + genres[i]);
	        }
	        System.out.print("Choix: ");
	        
	        int choix = lireEntier() - 1;
	        if (choix >= 0 && choix < genres.length) {
	            StrategieFiltre strategie = new FiltreParGenre(genres[choix]);
	            List<Film> resultat = manager.filtrer(strategie);
	            view.afficherFilms(resultat, "🔍 " + strategie.getNom());
	        }
	    }
	    
	    private void filtrerParNote() {
	        System.out.print("\nNote minimale (/5): ");
	        double note = scanner.nextDouble();
	        scanner.nextLine();
	        
	        StrategieFiltre strategie = new FiltreParNote(note);
	        List<Film> resultat = manager.filtrer(strategie);
	        view.afficherFilms(resultat, "🔍 " + strategie.getNom());
	    }
	    
	    private void filtrerParAnnee() {
	        System.out.print("\nAnnée minimale: ");
	        int min = lireEntier();
	        System.out.print("Année maximale: ");
	        int max = lireEntier();
	        
	        StrategieFiltre strategie = new FiltreParAnnee(min, max);
	        List<Film> resultat = manager.filtrer(strategie);
	        view.afficherFilms(resultat, "🔍 " + strategie.getNom());
	    }
	    
	    private void voirStatistiques() {
	        view.afficherStatistiques(manager);
	    }
}
