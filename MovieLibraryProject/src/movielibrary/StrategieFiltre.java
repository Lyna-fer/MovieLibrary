package movielibrary;

import java.util.List;

public interface StrategieFiltre {
	 List<Film> filtrer(List<Film> films);
	    String getNom();
}
