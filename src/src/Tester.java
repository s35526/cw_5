public class Tester extends Pracownik {
    private boolean czyAutomatyzujacy;
    private int liczbaScenariuszy;

    public Tester(String idPracownika, String imie, String nazwisko,
                  double stawkaBazowa, boolean czyAutomatyzujacy, int liczbaScenariuszy) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.czyAutomatyzujacy = czyAutomatyzujacy;
        this.liczbaScenariuszy = liczbaScenariuszy;
    }

    public boolean isCzyAutomatyzujacy() { return czyAutomatyzujacy; }
    public int getLiczbaScenariuszy()    { return liczbaScenariuszy; }


    @Override
    public double obliczKosztMiesieczny() {
        return czyAutomatyzujacy ? getStawkaBazowa() * 1.15 : getStawkaBazowa();
    }

    @Override
    public String przedstawSie() {
        String typ = czyAutomatyzujacy ? "Automatyzujący" : "Manualny";
        return "Tester (" + typ + "): " + getImie() + " " + getNazwisko()
                + " | Scenariusze: " + liczbaScenariuszy
                + " | Koszt: " + String.format("%.2f", obliczKosztMiesieczny()) + " PLN";
    }

    public void uruchomRaportTestow() {
        System.out.println(">>> Raport testów - " + getImie() + " " + getNazwisko() + ":");
        System.out.println("    Typ testowania: " + (czyAutomatyzujacy ? "Automatyzacja" : "Manualne"));
        System.out.println("    Liczba scenariuszy testowych: " + liczbaScenariuszy);
        System.out.println("    Status: Gotowy do wdrożenia");
    }

    @Override
    public String toString() {
        return "Tester{id='" + pobierzIdPracownika() + "', imie='" + getImie()
                + "', nazwisko='" + getNazwisko()
                + "', automatyzujacy=" + czyAutomatyzujacy
                + ", scenariusze=" + liczbaScenariuszy
                + ", kosztMiesieczny=" + String.format("%.2f", obliczKosztMiesieczny()) + " PLN}";
    }
}