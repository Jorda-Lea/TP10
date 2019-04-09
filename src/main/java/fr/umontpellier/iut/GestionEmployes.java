package fr.umontpellier.iut;

import java.time.LocalDate;

public class GestionEmployes {

    public static void main(String[] args) {
        Entreprise entreprise = new Entreprise();
        Employe e1 = new EmployeBuilder()
                .setNom("Dorjas")
                .setPrenom("Gabriel")
                .setNss("174071458123601")
                .createEmploye();
        Employe e2 = new EmployeBuilder()
                .setNom("fcghd")
                .setPrenom("Harry")
                .setNss("174072641515405")
                .createEmploye();
        Employe e3 = new EmployeBuilder()
                .setNom("Jpour")
                .setPrenom("Severus")
                .setNss("145015623415215")
                .createEmploye();
        Employe e4 = new EmployeBuilder()
                .setNom("Dorjas")
                .setPrenom("Gabriel")
                .setNss("174071458116415")
                .createEmploye();
        System.out.println(entreprise);
        entreprise.embaucher(e1, LocalDate.now());
        System.out.println(entreprise);
        entreprise.embaucher(e2, LocalDate.now());
        entreprise.embaucher(e3, LocalDate.now());
        entreprise.embaucher(e4, LocalDate.now());
        System.out.println(entreprise);
        entreprise.licencier(e1);
        System.out.println(entreprise);
    }



}
