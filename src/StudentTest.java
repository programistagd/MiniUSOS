import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StudentTest {
    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void test_czlowiek() {
        Czlowiek c = new Czlowiek("Jan", "Kowalski", Plec.M);
        assertEquals(c.imie, "Jan");
        assertEquals(c.nazwisko, "Kowalski");
        assertTrue(c.plec==Plec.M);

        //moje:
        assertEquals("Jan Kowalski", c.toString());
    }

    @Test
    public void test_student() {
        Student s = new Student("Jan", "Kowalski", Plec.M, 123456);
        assertEquals(s.imie, "Jan");
        assertEquals(s.nazwisko, "Kowalski");
        assertTrue(s.plec==Plec.M);
        assertEquals(s.numer_indeksu, 123456);
        assertEquals(s.toString(), "Jan Kowalski, numer indeksu: 123456");
        assertEquals(s.dajStudia(), null);
        s.zapiszNaStudia("Matematyka");
        assertEquals(s.dajStudia(), "Matematyka");
        assertEquals(s.rokStudiow(), 1);
        assertEquals(s.toString(), "Jan Kowalski, numer indeksu: 123456, studia: Matematyka, rok: 1");
        s.przeniesNaNastepnyRok();
        assertEquals(s.rokStudiow(), 2);
        s.przeniesNaNastepnyRok();
        assertEquals(s.rokStudiow(), 3);
        s.przeniesNaNastepnyRok(); // zakĹadamy, Ĺźe to studia licencjackie wiÄc rokStudiow=1..3
        assertEquals(s.rokStudiow(), 3);

        Student s2 = new Student("Jan", "Kowalski", Plec.M, 222333, "Informatyka", 2);
        assertEquals(s2.numer_indeksu, 222333);
        assertEquals(s2.dajStudia(), "Informatyka");
        assertEquals(s2.rokStudiow(), 2);
    }

    @Test
    public void test_wykladowca() {
        Wykladowca c = new Wykladowca("Ewa", "Kowalska", Plec.K);
        assertEquals(c.imie, "Ewa");
        assertEquals(c.nazwisko, "Kowalska");
        assertTrue(c.plec==Plec.K);
        assertEquals("Ewa Kowalska",c.toString());
        UczestnikZajec u = c;
        u.zapiszNaPrzedmiot(dajPrzedmiotP1());
        assertEquals("Ewa Kowalska\nUczestniczy w:\nMatematyka dyskretna",c.toString());
    }

    @Test
    public void test_przedmiot() {
        Przedmiot c = dajPrzedmiotP1();
        assertEquals(c.nazwa, "Matematyka dyskretna");
        assertEquals(c.toString(), "Matematyka dyskretna (W1I W1N)");
    }

    @Test
    public void test_zapisy_na_zajecia() {
        Przedmiot p = dajPrzedmiotP1();
        ZapisyNaZajecia z = new ZapisyNaZajecia(p);
        assertEquals(z.dajOcene(), null);
        assertEquals(z.toString(), "Matematyka dyskretna");
        z.ustawOcene(5);
        assertTrue(z.dajOcene() == 5);
        assertEquals(z.dajZaliczenie(), true);
        assertEquals(z.toString(), "Matematyka dyskretna, ocena: 5, zaliczenie: TAK");

        z.ustawOcene(2);
        assertTrue(z.dajOcene() == 2);
        assertEquals(z.dajZaliczenie(), false);
        assertEquals(z.toString(), "Matematyka dyskretna, ocena: 2, zaliczenie: NIE");

        UczestnikZajec s = dajStudenta();
        assertEquals(s.dajZajecia().size(), 0);
        s.zapiszNaPrzedmiot(p);
        assertEquals(s.dajZajecia().size(), 1);
        assertEquals(s.toString(), "Jan Kowalski, numer indeksu: 123123, studia: Informatyka, rok: 2\nMatematyka dyskretna");
        s.zapiszNaPrzedmiot(dajPrzedmiotP2());
        assertEquals(s.dajZajecia().size(), 2);
        assertEquals(s.toString(), "Jan Kowalski, numer indeksu: 123123, studia: Informatyka, rok: 2\nMatematyka dyskretna\nAnaliza Matematyczna");
    }

    public Przedmiot dajPrzedmiotP1() {
        return new Przedmiot("Matematyka dyskretna", new Wykladowca("W1I", "W1N", Plec.M));
    }

    public Przedmiot dajPrzedmiotP2() {
        return new Przedmiot("Analiza Matematyczna", new Wykladowca("W2I", "W2N", Plec.K));
    }

    public Student dajStudenta() {
        // 2-gi rok Informatyki, numer indeksu 123123
        return new Student("Jan", "Kowalski", Plec.M, 123123, "Informatyka", 2);
    }

    @Test
    public void test_uczestnik_zajec(){
        UczestnikZajec u = new UczestnikZajec("Jan","Kowalski",Plec.M);

        assertTrue(u.dajZajecia().isEmpty());

        Przedmiot p1 = dajPrzedmiotP1();

        u.zapiszNaPrzedmiot(p1);

        assertEquals(1, u.dajZajecia().size());
        assertEquals(p1.nazwa, u.dajZajecia().get(0).toString());
    }



}