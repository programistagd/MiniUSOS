/**
 * Created by rw386491 on 05.04.17.
 */
public class Przedmiot {
    private Wykladowca prowadzacy;
    public final String nazwa;

    public Przedmiot(String nazwa, Wykladowca prowadzacy){
        this.nazwa = nazwa;
        this.prowadzacy = prowadzacy;
    }

    public String toString(){
        return nazwa + " (" + prowadzacy.toString() + ")";
    }
}
