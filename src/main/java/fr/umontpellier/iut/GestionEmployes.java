package fr.umontpellier.iut;

import java.time.LocalDate;

public class GestionEmployes {

    public static void main(String[] args) {
        Entreprise entreprise = new Entreprise();
        Employe e1 = new EmployeBuilder().setNom("Dorjas").setPrenom("Gabriel").setNss("1546341458").createEmploye();
        Employe e2 = new EmployeBuilder().setNom("fcghd").setPrenom("Harry").setNss("24367264").createEmploye();
        System.out.println(entreprise);
        entreprise.embaucher(e1, LocalDate.now());
        System.out.println(entreprise);
        entreprise.embaucher(e2, LocalDate.now());
        System.out.println(entreprise);
        entreprise.licencier(e1);
        System.out.println(entreprise);
    }



}
