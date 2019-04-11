package fr.umontpellier.iut;

import java.util.Comparator;

public class ComparateurDate implements Comparator<Employe> {

    public int compare(Employe o1, Employe o2){
        return  o1.getDateEmbauche().compareTo(o2.getDateEmbauche());
    }
}
