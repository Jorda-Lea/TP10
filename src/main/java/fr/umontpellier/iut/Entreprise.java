package fr.umontpellier.iut;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

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

    public Collection<Employe> getEmploye() {
        return new TreeSet<>(lePersonnel);
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "lePersonnel=" + lePersonnel + "\n" +
                '}';
    }
}
