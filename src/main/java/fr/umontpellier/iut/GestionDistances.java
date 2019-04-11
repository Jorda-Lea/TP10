package fr.umontpellier.iut;

import java.util.HashMap;
import java.util.Map;

public class GestionDistances {

    static private Map<String, Integer> distances;

    static{
        distances = new HashMap<>();
        distances.put("Montpellier", 0);
        distances.put("Sète", 36);
        distances.put("Sommière", 30);
        distances.put("Nîmes", 58);
        distances.put("Lunel", 30);
        distances.put("Béziers", 80);

    }

    static public int getDistance(String ville){
        return distances.get(ville);
    }

}
