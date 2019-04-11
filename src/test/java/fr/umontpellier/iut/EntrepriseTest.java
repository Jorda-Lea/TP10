package fr.umontpellier.iut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {
    Entreprise entreprise;
    Employe e1;
    Employe e2;
    Employe e3;
    Employe e4;

    @BeforeEach
    void setUp() {
        entreprise = new Entreprise();
        e1 = new EmployeBuilder()
                .setNom("Dorjas")
                .setPrenom("Gabriel")
                .setNss("174071458123601")
                .createEmploye();
        e2 = new EmployeBuilder()
                .setNom("Findus")
                .setPrenom("Harry")
                .setNss("174072641515405")
                .createEmploye();
        e3 = new EmployeBuilder()
                .setNom("Jpour")
                .setPrenom("Severus")
                .setNss("145015623415215")
                .createEmploye();
        e4 = new EmployeBuilder()
                .setNom("Dorjas")
                .setPrenom("Gabriel")
                .setNss("175071458116415")
                .createEmploye();
    }




    @Test
    void getEmployeUn() {
        entreprise.embaucher(e1, LocalDate.now());
        Collection<Employe> employes = entreprise.getEmploye();
        assertEquals(1, entreprise.getEmploye().size());
        assertTrue(employes.contains(e1));
    }


    @Test
    void getEmployeDeux(){
        entreprise.embaucher(e1, LocalDate.now());
        entreprise.embaucher(e2, LocalDate.now());
        Collection<Employe> employes = entreprise.getEmploye();
        assertEquals(2, entreprise.getEmploye().size());
        assertTrue(employes.contains(e1));
        assertTrue(employes.contains(e2));
    }


    @Test
    void getEmpleDoublon(){
        entreprise.embaucher(e1, LocalDate.now());
        entreprise.embaucher(e1, LocalDate.now());
        Collection<Employe> employes = entreprise.getEmploye();
        assertEquals(1, entreprise.getEmploye().size());
        assertTrue(employes.contains(e1));
    }

    @Test
    void getEmpleOrdre(){
        entreprise.embaucher(e2, LocalDate.now());
        entreprise.embaucher(e1, LocalDate.now());
        entreprise.embaucher(e3, LocalDate.now());
        entreprise.embaucher(e4, LocalDate.now());
        ArrayList<Employe> employes = new ArrayList<>(entreprise.getEmploye());
        assertEquals(e4, employes.get(0));
        assertEquals(e1, employes.get(1));
        assertEquals(e2, employes.get(2));
        assertEquals(e3, employes.get(3));
        assertEquals(4, employes.size());
    }


    @Test
    void distribuerBonusTest(){
        entreprise.embaucher(e1, LocalDate.of(2018, 4, 5));
        entreprise.embaucher(e2, LocalDate.of(2019, 3, 5));
        entreprise.embaucher(e3, LocalDate.of(2019, 3, 5));
        entreprise.embaucher(e4, LocalDate.of(2017, 4, 5));
        entreprise.setBonusTotal(100);
        entreprise.distribuerBonus();
        assertEquals(72, e4.getBonus());
        assertEquals(28, e1.getBonus());
        assertEquals(0, e3.getBonus());
        assertEquals(0, e2.getBonus());
    }

    @Test
    void remercier(){
        entreprise.embaucher(e1, LocalDate.of(2018, 4, 5));
        entreprise.embaucher(e2, LocalDate.of(2019, 3, 5));
        entreprise.embaucher(e3, LocalDate.of(2019, 3, 5));
        entreprise.embaucher(e4, LocalDate.of(2017, 4, 5));
        entreprise.remercier(3);
        assertEquals(1, entreprise);

    }
}