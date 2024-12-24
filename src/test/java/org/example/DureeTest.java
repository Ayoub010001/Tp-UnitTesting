package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DureeTest {

    @Test
    void getHeures() {
        Duree duree = new Duree(1,20,39);
        assertEquals(1, duree.getHeures());
        //fail("Not yet implemented");
    }

    @Test
    void setHeures() {
        Duree duree = new Duree();
        // Cas 1 : Heure valide
        duree.setHeures(5);
        assertEquals(5, duree.getHeures());
        // Cas 2 : Heure valide (limite basse)
        duree.setHeures(0);
        assertEquals(0, duree.getHeures());
        // Cas 3 : Heure invalide
        assertThrows(IllegalArgumentException.class, () ->
                duree.setHeures(-1));
        //fail("Not yet implemented");
    }

    @Test
    void getMinutes() {
        Duree duree = new Duree(1,20,39);
        assertEquals(20, duree.getMinutes());
        //fail("Not yet implemented");
    }

    @Test
    void setMinutes() {
        Duree duree = new Duree();
        duree.setMinutes(5);
        assertEquals(5, duree.getMinutes());
        //fail("Not yet implemented");
    }

    @Test
    void getSecondes() {
        Duree duree = new Duree(1,20,39);
        assertEquals(39, duree.getSecondes());
    }

    @Test
    void setSecondes() {
        Duree duree = new Duree();
        // Cas 1 : Second valide
        duree.setSecondes(1);
        assertEquals(1, duree.getSecondes());
        // Cas 2 : Second valide (limite basse)
        duree.setHeures(0);
        assertEquals(0, duree.getHeures());
        // Cas 3 : Second invalide
        assertThrows(IllegalArgumentException.class, () ->
                duree.setHeures(-1));
        //fail("Not yet implemented");
    }

    @Test
    void formatDuree() {
        Duree duree1 = new Duree(1, 2, 3);
        assertEquals("01:02:03", duree1.formatDuree());
        Duree duree2 = new Duree(0, 0, 0);
        assertEquals("00:00:00", duree2.formatDuree());
        Duree duree3 = new Duree(23, 59, 59);
        assertEquals("23:59:59", duree3.formatDuree());
        //fail("Not yet implemented");
    }

    @Test
    void afficherDuree() {
        Duree duree1 = new Duree(1, 2, 3);
        duree1.afficherDuree();
        //fail("Not yet implemented");
    }

    @Test
    void comparer() {
        Duree d1 = new Duree(1, 0, 0);
        Duree d2 = new Duree(2, 0, 0);
        Duree d3 = new Duree(1, 30, 0);
        Duree d4 = new Duree(1, 30, 30);
        assertEquals(0, d1.comparer(new Duree(1, 0, 0)));
        assertEquals(-1, d1.comparer(d2));
        assertEquals(1, d2.comparer(d1));
        assertEquals(-1, d3.comparer(new Duree(1, 40, 0)));
        assertEquals(-1, d4.comparer(new Duree(1, 30, 31)));
        //fail("Not yet implemented");
    }

    @Test
    void nextSeconde() {
        Duree d1 = new Duree(0, 0, 59);
        d1.nextSeconde();
        assertEquals(0, d1.getSecondes());

        Duree d2 = new Duree(0, 59, 59);
        d2.nextSeconde();
        assertEquals(0, d2.getMinutes());
        //fail("Not yet implemented");
    }

    @Test
    void nextMinute() {
        Duree d1 = new Duree(0, 59, 0);
        d1.nextMinute();
        assertEquals(0, d1.getMinutes());
        //fail("Not yet implemented");
    }

    @Test
    void isEquals() {
        Duree d1 = new Duree(0, 20, 15);
        Duree d2 = new Duree(0, 20, 15);
        Duree d3 = new Duree(0, 21, 50);

        assertTrue(d1.isEquals(d2));
        assertFalse(d1.isEquals(d3));
        //fail("Not yet implemented");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,5,6})
    void testSetHeures(int heures) {
        Duree duree = new Duree();
        duree.setHeures(heures);
        assertEquals(heures, duree.getHeures());
    }
}