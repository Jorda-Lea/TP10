package fr.umontpellier.iut;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {
    Entreprise entreprise;
    Employe e1;
    Employe e2;

    @Before
    void setUp(){
        entreprise = new Entreprise();
        e1 = new EmployeBuilder()
                .setNom("Smith")
                .setPrenom("John")
                .setNss("123456789")
                .createEmploye();
        e2 = new EmployeBuilder()
                .setNom("Threepwood")
                .setPrenom("Guybrush")
                .setNss("234567890")
                .createEmploye();

    }

    @Test
    void getMoisAnciennete() {
        entreprise.embaucher(e1, LocalDate.of(2019,1,1));
        entreprise.embaucher(e2, LocalDate.of(2019, 1, 5));
        assertEquals(e1.getMoisAnciennete(), e2.getMoisAnciennete());
    }
    @Test
    void getIndemniteTransport(){
        e1.setBase(1);
        e1.setAdresse("Montpellier");
        assertEquals(0, e1.getIndemniteTransport());
    }

}