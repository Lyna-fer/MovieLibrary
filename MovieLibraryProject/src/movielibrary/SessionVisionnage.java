package movielibrary;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SessionVisionnage {
	private Date dateVisionnage;
    private String lieu;          
    private String notes;
    
    public SessionVisionnage(Date date, String lieu) {
        this.dateVisionnage = date;
        this.lieu = lieu;
        this.notes = "";
    }
    
    public void setNotes(String notes) { this.notes = notes; }
    
    public Date getDateVisionnage() { return dateVisionnage; }
    public String getLieu() { return lieu; }
    public String getNotes() { return notes; }
    
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dateVisionnage) + " - " + lieu + 
               (notes.isEmpty() ? "" : " (" + notes + ")");
    }
}
