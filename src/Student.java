/**
 * Created by rw386491 on 05.04.17.
 */
public class Student extends UczestnikZajec {
    public final int numer_indeksu;
    private String nazwaStudiow;
    private Integer rokStudiow;

    public Student(String imie, String nazwisko, Plec plec, int nrIndeksu, String nazwaStudiow, Integer rokStudiow){
        super(imie, nazwisko, plec);
        this.numer_indeksu = nrIndeksu;
        this.nazwaStudiow = nazwaStudiow;
        this.rokStudiow = rokStudiow;
    }

    public Student(String imie, String nazwisko, Plec plec, int nrIndeksu){
        this(imie, nazwisko, plec, nrIndeksu, null, null);
    }

    public String dajStudia(){
        return nazwaStudiow;
    }

    public void zapiszNaStudia(String nazwa){
        this.nazwaStudiow = nazwa;
        this.rokStudiow = 1;
    }

    public int rokStudiow(){
        return rokStudiow;
    }

    public void przeniesNaNastepnyRok(){
        if(rokStudiow == 3){
            return;//nie można awansować na rok dalszy niż 3 bo to studia licencjackie
        }
        rokStudiow += 1;
    }

    public String toString(){
        String s = this.imie + " " + this.nazwisko;
        s += ", numer indeksu: " + numer_indeksu;
        if(nazwaStudiow != null){
            s += ", studia: " + nazwaStudiow;
            s += ", rok: " + rokStudiow;
        }
        for(ZapisyNaZajecia zapis : dajZajecia()){
            s += "\n" + zapis;
        }
        return s;
    }
}
