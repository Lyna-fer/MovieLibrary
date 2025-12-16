package movielibrary;
import java.util.*;
public class Film {
	private static int compteur = 1;
    private int id;
    private String titre;
    private String realisateur;
    private int annee;
    private Genre genre;
    private String synopsis;
    private StatutVisionnage statut;
    
    // COMPOSITION
    private List<Acteur> acteurs;
    private InfosTechniques infosTech;
    private Avis avis;
    private List<SessionVisionnage> sessions;
    
    public Film(String titre, String realisateur, int annee, Genre genre) {
        this.id = compteur++;
        this.titre = titre;
        this.realisateur = realisateur;
        this.annee = annee;
        this.genre = genre;
        this.statut = StatutVisionnage.A_VOIR;
        this.acteurs = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }
    
    // Getters/Setters
    public int getId() { return id; }
    public String getTitre() { return titre; }
    public String getRealisateur() { return realisateur; }
    public int getAnnee() { return annee; }
    public Genre getGenre() { return genre; }
    public String getSynopsis() { return synopsis; }
    public StatutVisionnage getStatut() { return statut; }
    public List<Acteur> getActeurs() { return acteurs; }
    public InfosTechniques getInfosTech() { return infosTech; }
    public Avis getAvis() { return avis; }
    public List<SessionVisionnage> getSessions() { return sessions; }
    
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }
    public void setStatut(StatutVisionnage statut) { this.statut = statut; }
    public void setInfosTech(InfosTechniques infos) { this.infosTech = infos; }
    public void setAvis(Avis avis) { this.avis = avis; }
    
    public void ajouterActeur(Acteur acteur) {
        acteurs.add(acteur);
    }
    
    public void ajouterSession(SessionVisionnage session) {
        sessions.add(session);
        if (statut == StatutVisionnage.A_VOIR) {
            statut = StatutVisionnage.VU;
        }
    }
    
    public int getNombreVisionnages() {
        return sessions.size();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🎬 ").append(titre).append(" (").append(annee).append(")\n");
        sb.append("   Réalisateur: ").append(realisateur).append("\n");
        sb.append("   Genre: ").append(genre).append(" | Statut: ").append(statut).append("\n");
        if (infosTech != null) {
            sb.append("   ").append(infosTech).append("\n");
        }
        if (avis != null) {
            sb.append("   Note: ").append(avis.getNote()).append("/5 ⭐\n");
        }
        sb.append("   Visionnages: ").append(getNombreVisionnages());
        return sb.toString();
    }
}
