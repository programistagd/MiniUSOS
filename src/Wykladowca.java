/**
 * Created by rw386491 on 05.04.17.
 */
public class Wykladowca extends UczestnikZajec {
    public Wykladowca(String imie, String nazwisko, Plec plec){
        super(imie,nazwisko,plec);
    }

    @Override
    public String toString(){
        String s = super.toString();
        if(!dajZajecia().isEmpty()){
            s += "\nUczestniczy w:";
            for(ZapisyNaZajecia z : dajZajecia())
            {
                s += "\n" + z;
            }
        }
        return s;
    }
}
