/**
 * Created by rw386491 on 05.04.17.
 */

public class Czlowiek {
    public final String imie;
    public final String nazwisko;
    public final Plec plec;

    public Czlowiek(String imie, String nazwisko, Plec plec){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
    }

    @Override
    public String toString(){
        return imie + " " + nazwisko;
    }
}
