package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Employe implements Comparable<Employe>{

    private String nss; // numéro de sécurité social
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;
    private LocalDate dateEmbauche;
    private double bonus;
    private String adresse;



    public Employe(String nss, String nom, String prenom, int echelon, double base, double nbHeures) {
        this.nss = nss;
        this.nom = nom;
        this.prenom = prenom;
        this.echelon = echelon;
        this.base = base;
        this.nbHeures = nbHeures;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
        if (this.equals(o)){
            return 0;
        }
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
                ", base=" + base +
                ", nbHeures=" + nbHeures +
                ", dateEmbauche=" + dateEmbauche +
                ", bonus=" + bonus +
                '}';
    }

    public int getMoisAnciennete(){
        return (int) ChronoUnit.MONTHS.between(getDateEmbauche(), LocalDate.now());
    }

    public double getIndemniteTransport(){
        return GestionDistances.getDistance(adresse) * base;
    }
}
