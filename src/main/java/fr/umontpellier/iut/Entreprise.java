package fr.umontpellier.iut;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Entreprise {
    private Collection<Employe> lePersonnel;
    private double bonusTotal;

    public Entreprise() {
        this.lePersonnel = new ArrayList<>();
    }

    public void setBonusTotal(double bonusTotal) {
        this.bonusTotal = bonusTotal;
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

    public void distribuerBonus(){
        PriorityQueue<Employe> personnelTrie = new PriorityQueue<>(lePersonnel.size(), new ComparateurDate());
        personnelTrie.addAll(lePersonnel);
        for (Employe e: personnelTrie){
            int bonus = e.getMoisAnciennete() * 3;
            if(bonusTotal > bonus){
                e.setBonus(bonus);
                bonusTotal -= bonus;
            } else {
                e.setBonus(bonusTotal);
                bonusTotal = 0;
                break;
            }

        }
    }

    public void remercier(int n){
        PriorityQueue<Employe> personnelTrie = new PriorityQueue<>(lePersonnel.size(), new ComparateurDateDecroissant());
        personnelTrie.addAll(lePersonnel);
        for (int i = 0; i < n; i++) {
            licencier(personnelTrie.poll());
        }
    }


}
