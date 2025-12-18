package movielibrary;

public interface Sujet {
	void ajouterObservateur(Observateur obs);
    void retirerObservateur(Observateur obs);
    void notifierObservateurs(String message);
}
