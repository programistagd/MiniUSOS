/**
 * Created by rw386491 on 05.04.17.
 */
public class ZapisyNaZajecia {
    private Przedmiot przedmiot;
    private Integer ocena;

    public ZapisyNaZajecia(Przedmiot przedmiot){
        this.przedmiot = przedmiot;
        ocena = null;
    }

    public Integer dajOcene(){
        return ocena;
    }

    public void ustawOcene(int ocena){
        this.ocena = ocena;
    }

    public boolean dajZaliczenie(){
        return (ocena != null && ocena > 2);
    }

    public String toString(){
        String s = przedmiot.nazwa;
        if(ocena != null){
            s += ", ocena: " + ocena;
            s += ", zaliczenie: " + (dajZaliczenie() ? "TAK" : "NIE");
        }
        return s;
    }
}
