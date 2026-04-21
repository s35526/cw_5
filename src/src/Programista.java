public class Programista extends Pracownik {
    private String glownyJezyk;
    private int liczbaRepozytoriow;

    public Programista(String idPracownika, String imie, String nazwisko,
                       double stawkaBazowa, String glownyJezyk, int liczbaRepozytoriow) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.glownyJezyk = glownyJezyk;
        this.liczbaRepozytoriow = liczbaRepozytoriow;
    }

    public String getGlownyJezyk()       { return glownyJezyk; }
    public int getLiczbaRepozytoriow()   { return liczbaRepozytoriow; }

    @Override
    public double obliczKosztMiesieczny() {
        return getStawkaBazowa() * 1.20;
    }

    @Override
    public String przedstawSie() {
        return "Programista: " + getImie() + " " + getNazwisko()
                + " | Język: " + glownyJezyk
                + " | Repozytoria: " + liczbaRepozytoriow
                + " | Koszt: " + String.format("%.2f", obliczKosztMiesieczny()) + " PLN";
    }

    public void wypiszTechnologie() {
        System.out.println(">>> Technologie programisty " + getImie() + " " + getNazwisko() + ":");
        System.out.println("    Główny język: " + glownyJezyk);
        System.out.println("    Liczba repozytoriów GitHub: " + liczbaRepozytoriow);
    }

    @Override
    public String toString() {
        return "Programista{id='" + pobierzIdPracownika() + "', imie='" + getImie()
                + "', nazwisko='" + getNazwisko() + "', jezyk='" + glownyJezyk
                + "', repozytoria=" + liczbaRepozytoriow
                + ", kosztMiesieczny=" + String.format("%.2f", obliczKosztMiesieczny()) + " PLN}";
    }
}
