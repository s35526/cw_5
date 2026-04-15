public class Pracownik {
    private String idPracownika;
    private String imie;
    private String nazwisko;
    private double stawkaBazowa;

    public Pracownik(String idPracownika, String imie, String nazwisko, double stawkaBazowa) {

        this.idPracownika = idPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stawkaBazowa = stawkaBazowa;
    }

    public final String pobierzIdPracownika() {
    return idPracownika;
    }
    public String getImie() {
    return imie;
    }
    public String getNazwisko() {
    return nazwisko;
    }
    public double getStawkaBazowa() {
    return stawkaBazowa;
    }

    public double obliczKosztMiesieczny() {
        return stawkaBazowa;
    }

    public String przedstawSie() {
        return "Pracownik: " + imie + " " + nazwisko + "ID: " + idPracownika + ")";
    }

    @Override
    public String toString() {
        return "Pracownik{id=" + idPracownika + ", imie=" + imie
                + ", nazwisko=" + nazwisko
                + ", stawkaBazowa=" + stawkaBazowa + " PLN}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Pracownik)) return false;
        Pracownik other = (Pracownik) obj;
        return this.idPracownika.equals(other.idPracownika);
    }

    @Override
    public int hashCode() {
        return this.idPracownika.hashCode();
    }
}
