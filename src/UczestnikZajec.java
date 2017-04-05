import java.util.ArrayList;
import java.util.List;

/**
 * Created by rw386491 on 05.04.17.
 */
public class UczestnikZajec extends Czlowiek {
    private List<ZapisyNaZajecia> zapisy;

    public UczestnikZajec(String imie, String nazwisko, Plec plec){
        super(imie,nazwisko,plec);
        zapisy = new ArrayList<>();
    }

    public void zapiszNaPrzedmiot(Przedmiot przedmiot){
        zapisy.add(new ZapisyNaZajecia(przedmiot));
    }

    public List<ZapisyNaZajecia> dajZajecia(){
        return  zapisy;
    }
}
