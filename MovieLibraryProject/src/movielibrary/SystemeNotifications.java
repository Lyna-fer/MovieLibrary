package movielibrary;

import java.text.SimpleDateFormat;
import java.util.*;

public class SystemeNotifications implements Observateur {
private List<String> historique;
    
    public SystemeNotifications() {
        this.historique = new ArrayList<>();
    }
    
    public void update(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM HH:mm");
        String notification = "[" + sdf.format(new Date()) + "] " + message;
        historique.add(notification);
        System.out.println("\n" + message);
    }
    
    public void afficherHistorique() {
        System.out.println("\n HISTORIQUE DES NOTIFICATIONS");
        System.out.println("═══════════════════════════════════════════");
        if (historique.isEmpty()) {
            System.out.println("  (Aucune notification)");
        } else {
            for (String notif : historique) {
                System.out.println("  " + notif);
            }
        }
    }
}
