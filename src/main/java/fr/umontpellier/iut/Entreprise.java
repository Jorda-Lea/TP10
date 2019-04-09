package fr.umontpellier.iut;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Entreprise {
    private Collection<Employe> lePersonnel;

    public Entreprise() {
        this.lePersonnel = new ArrayList<>();
    }

    public void embaucher(Employe e, LocalDate dateEmbauche){
        e.setDateEmbauche(dateEmbauche);
        lePersonnel.add(e);
    }

    public void licencier(Employe e){
        lePersonnel.remove(e);
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "lePersonnel=" + lePersonnel +
                '}';
    }
}
