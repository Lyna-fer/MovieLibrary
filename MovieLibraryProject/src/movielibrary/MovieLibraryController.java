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
	        
	        System.out.println("\n Merci d'avoir utilisé My Movie Library!");
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
	    	
	    	Film avengers = creerAvengersEndgame();
	        Film joker = creerJoker();
	        Film coco = creerCoco();
	        
	        manager.ajouterFilm(avengers);
	        manager.ajouterFilm(joker);
	        manager.ajouterFilm(coco);
	        System.out.println("\n Bibliothèque initialisée avec 3 films de démonstration");
	    }
	    
	    
	    private Film creerAvengersEndgame() {
	        Film film = new Film("Avengers: Endgame", "Anthony et Joe Russo", 2019, Genre.ACTION);
	        film.setSynopsis("Après les événements dévastateurs d'Infinity War, les Avengers s'unissent une dernière fois pour inverser les actions de Thanos.");
	        film.setInfosTech(new InfosTechniques(181, "Anglais"));
	        film.ajouterActeur(new Acteur("Robert Downey Jr.", "Tony Stark / Iron Man"));
	        film.ajouterActeur(new Acteur("Chris Evans", "Steve Rogers / Captain America"));
	        film.ajouterActeur(new Acteur("Scarlett Johansson", "Natasha Romanoff / Black Widow"));
	        return film;
	    }
	   
	    
	    private Film creerJoker() {
	        Film film = new Film("Joker", "Todd Phillips", 2019, Genre.DRAME);
	        film.setSynopsis("Dans les années 1980, à Gotham City, Arthur Fleck, un humoriste de stand-up raté, bascule dans la folie et devient le Joker.");
	        film.setInfosTech(new InfosTechniques(122, "Anglais"));
	        film.ajouterActeur(new Acteur("Joaquin Phoenix", "Arthur Fleck / Joker"));
	        film.ajouterActeur(new Acteur("Robert De Niro", "Murray Franklin"));
	        return film;
	    }
	    
	    
	    private Film creerCoco() {
	        Film film = new Film("Coco", "Lee Unkrich", 2017, Genre.ANIMATION);
	        film.setSynopsis("Miguel, jeune garçon passionné de musique, voyage au Pays des Morts pour découvrir le secret de sa famille.");
	        film.setInfosTech(new InfosTechniques(105, "Anglais"));
	        film.getInfosTech().setSousTitres("Français");
	        film.ajouterActeur(new Acteur("Anthony Gonzalez", "Miguel (voix)"));
	        return film;
	    }
	    private void voirCollection() {
	        view.afficherFilms(manager.getCollection(), " MA COLLECTION COMPLÈTE");
	    }
	    
	    private void ajouterFilmPopulaire() {
	        System.out.println("\n FILMS POPULAIRES");
	        System.out.println("1. Parasite (2019) - Thriller/Drame");
	        System.out.println("2. Spider-Man: No Way Home (2021) - Action/Aventure");
	        System.out.println("3. Star Wars: Episode IV (1977) - Sci-Fi/Aventure");
	        System.out.println("4. Ratatouille (2007) - Animation");
	        System.out.println("5. Barbie (2023) - Comédie/Fantastique");
	        System.out.print("\nChoix (0 pour annuler): ");
	        
	        int choix = lireEntier();
	        Film film = null;
	        
	        switch(choix) {
	            case 1:
	            	film = new Film("Parasite", "Bong Joon-ho", 2019, Genre.THRILLER);
	                film.setSynopsis("Toute la famille de Ki-taek est au chômage. Un jour, leur fils réussit à se faire recommander pour donner des cours chez les Park, une famille richissime.");
	                film.setInfosTech(new InfosTechniques(132, "Coréen"));
	                film.getInfosTech().setSousTitres("Français");
	                film.ajouterActeur(new Acteur("Song Kang-ho", "Kim Ki-taek"));
	                film.ajouterActeur(new Acteur("Lee Sun-kyun", "Park Dong-ik"));
	                film.ajouterActeur(new Acteur("Cho Yeo-jeong", "Choi Yeon-gyo"));
	                break;
	            case 2:
	            	film = new Film("Spider-Man: Into the Spider-Verse", "Bob Persichetti, Peter Ramsey", 2018, Genre.ANIMATION);
	                film.setSynopsis("Miles Morales devient Spider-Man et rencontre d'autres Spider-personnes venues de dimensions parallèles du multivers.");
	                film.setInfosTech(new InfosTechniques(117, "Anglais"));
	                film.getInfosTech().setSousTitres("Français");
	                film.ajouterActeur(new Acteur("Shameik Moore", "Miles Morales (voix)"));
	                film.ajouterActeur(new Acteur("Jake Johnson", "Peter B. Parker (voix)"));
	                film.ajouterActeur(new Acteur("Hailee Steinfeld", "Gwen Stacy (voix)"));
	                break;
	            case 3:
	            	 film = new Film("Star Wars: Un nouvel espoir", "George Lucas", 1977, Genre.SCIENCE_FICTION);
	                 film.setSynopsis("Luke Skywalker rejoint les forces rebelles pour sauver la princesse Leia des griffes de l'Empire galactique.");
	                 film.setInfosTech(new InfosTechniques(121, "Anglais"));
	                 film.ajouterActeur(new Acteur("Mark Hamill", "Luke Skywalker"));
	                 film.ajouterActeur(new Acteur("Harrison Ford", "Han Solo"));
	                 film.ajouterActeur(new Acteur("Carrie Fisher", "Princesse Leia"));
	                 break;
	            case 4:
	                film = new Film("Ratatouille", "Brad Bird", 2007, Genre.ANIMATION);
	                film.setSynopsis("Rémy, un rat passionné de cuisine, s'allie avec Linguini pour devenir chef dans un grand restaurant parisien.");
	                film.setInfosTech(new InfosTechniques(111, "Anglais"));
	                film.ajouterActeur(new Acteur("Patton Oswalt", "Rémy (voix)"));
	                break;
	            case 5:
	            	film = new Film("Barbie", "Greta Gerwig", 2023, Genre.COMEDIE);
	                film.setSynopsis("Barbie vit à Barbie Land, un endroit parfait. Un jour, elle décide de partir dans le monde réel pour trouver le bonheur véritable.");
	                film.setInfosTech(new InfosTechniques(114, "Anglais"));
	                film.ajouterActeur(new Acteur("Margot Robbie", "Barbie"));
	                film.ajouterActeur(new Acteur("Ryan Gosling", "Ken"));
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
	        
	        System.out.print("\n Titre: ");
	        String titre = scanner.nextLine();
	        
	        System.out.print(" Réalisateur: ");
	        String realisateur = scanner.nextLine();
	        
	        System.out.print(" Année: ");
	        int annee = lireEntier();
	        
	        System.out.println("\n Genres:");
	        Genre[] genres = Genre.values();
	        for (int i = 0; i < genres.length; i++) {
	            System.out.println((i+1) + ". " + genres[i]);
	        }
	        System.out.print("Choix: ");
	        int choixGenre = lireEntier() - 1;
	        Genre genre = genres[choixGenre];
	        
	        Film film = new Film(titre, realisateur, annee, genre);
	        
	        System.out.print("\n Synopsis (Entrée pour passer): ");
	        String synopsis = scanner.nextLine();
	        if (!synopsis.isEmpty()) {
	            film.setSynopsis(synopsis);
	        }
	        
	        System.out.print("\n Durée (minutes): ");
	        int duree = lireEntier();
	        
	        System.out.print(" Langue: ");
	        String langue = scanner.nextLine();
	        
	        film.setInfosTech(new InfosTechniques(duree, langue));
	        
	        System.out.print("\n Nombre d'acteurs à ajouter: ");
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
	        
	        view.afficherFilms(resultats, " RÉSULTATS DE RECHERCHE");
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
	            manager.notifierObservateurs(" Statut de " + film.getTitre() + 
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
	        manager.notifierObservateurs("Tu as noté " + film.getTitre() + " : " + note + "/5");
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
	        
	        System.out.println("\n Lieu de visionnage:");
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
	        
	        System.out.print("\n Notes (optionnel): ");
	        String notes = scanner.nextLine();
	        if (!notes.isEmpty()) {
	            session.setNotes(notes);
	        }
	        
	        film.ajouterSession(session);
	        manager.notifierObservateurs("Visionnage enregistré pour " + film.getTitre());
	        
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
	        System.out.println("\n Filtrer par statut:");
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
	            view.afficherFilms(resultat, strategie.getNom());
	        }
	    }
	    
	    private void filtrerParGenre() {
	        System.out.println("\n Filtrer par genre:");
	        Genre[] genres = Genre.values();
	        for (int i = 0; i < genres.length; i++) {
	            System.out.println((i+1) + ". " + genres[i]);
	        }
	        System.out.print("Choix: ");
	        
	        int choix = lireEntier() - 1;
	        if (choix >= 0 && choix < genres.length) {
	            StrategieFiltre strategie = new FiltreParGenre(genres[choix]);
	            List<Film> resultat = manager.filtrer(strategie);
	            view.afficherFilms(resultat, strategie.getNom());
	        }
	    }
	    
	    private void filtrerParNote() {
	        System.out.print("\nNote minimale (/5): ");
	        double note = scanner.nextDouble();
	        scanner.nextLine();
	        
	        StrategieFiltre strategie = new FiltreParNote(note);
	        List<Film> resultat = manager.filtrer(strategie);
	        view.afficherFilms(resultat, strategie.getNom());
	    }
	    
	    private void filtrerParAnnee() {
	        System.out.print("\nAnnée minimale: ");
	        int min = lireEntier();
	        System.out.print("Année maximale: ");
	        int max = lireEntier();
	        
	        StrategieFiltre strategie = new FiltreParAnnee(min, max);
	        List<Film> resultat = manager.filtrer(strategie);
	        view.afficherFilms(resultat, strategie.getNom());
	    }
	    
	    private void voirStatistiques() {
	        view.afficherStatistiques(manager);
	    }
}
