package fr.umontpellier.iut;

import java.time.LocalDate;
import java.util.Objects;

public class Employe implements Comparable<Employe>{

    private String nss; // numéro de sécurité social
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;
    private LocalDate dateEmbauche;


    public Employe(String nss, String nom, String prenom, int echelon, double base, double nbHeures) {
        this.nss = nss;
        this.nom = nom;
        this.prenom = prenom;
        this.echelon = echelon;
        this.base = base;
        this.nbHeures = nbHeures;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return nss.equals(employe.nss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nss);
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public double calculeSalaireBrut(){
       return base * nbHeures + 100;
    }

    public double calculeSalaireNet(){
        return calculeSalaireBrut()*.8;
    }

    public int getEchelon() {
        return echelon;
    }

    public double getBase() {
        return base;
    }

    public double getNbHeures() {
        return nbHeures;
    }

    public int compareTo(Employe o){
        int x = this.nom.compareTo(o.nom);
        if(x==0){
            return -this.nss.compareTo(o.nss);
        }else {
            return x;
        }

    }

    @Override
    public String toString() {
        return "Employe{" +
                "nss='" + nss + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", echelon=" + echelon +
                ", salaireBrut=" + calculeSalaireBrut() +
                ", salaireNet=" + calculeSalaireNet() +
                '}';
    }
}
