import java.util.ArrayList;

public class ZespolProjektowy {
    private String nazwaProjektu;
    private ArrayList<Pracownik> pracownicy; // lista typu nadrzędnego

    public ZespolProjektowy(String nazwaProjektu) {
        this.nazwaProjektu = nazwaProjektu;
        this.pracownicy = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
        System.out.println("Dodano: " + pracownik.getImie() + " " + pracownik.getNazwisko()
                + " do projektu \"" + nazwaProjektu + "\"");
    }

    public void wypiszSkladZespolu() {
        System.out.println("\n========================================");
        System.out.println("  SKŁAD ZESPOŁU: " + nazwaProjektu.toUpperCase());
        System.out.println("========================================");
        for (int i = 0; i < pracownicy.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + pracownicy.get(i).przedstawSie());
        }
        System.out.println("========================================\n");
    }

    public double policzLacznyKoszt() {
        double suma = 0;
        for (Pracownik p : pracownicy) {
            suma += p.obliczKosztMiesieczny();
        }
        return suma;
    }

    public Pracownik znajdzPoId(String idPracownika) {
        for (Pracownik p : pracownicy) {
            if (p.pobierzIdPracownika().equals(idPracownika)) { // metoda final
                return p;
            }
        }
        return null;
    }

    public void wypiszTesterowAutomatyzujacych() {
        System.out.println("\n--- Testerzy automatyzujący w projekcie \"" + nazwaProjektu + "\" ---");
        boolean znaleziono = false;
        for (Pracownik p : pracownicy) {
            if (p instanceof Tester) {
                Tester t = (Tester) p; // bezpieczne rzutowanie
                if (t.isCzyAutomatyzujacy()) {
                    System.out.println("  " + t.przedstawSie());
                    znaleziono = true;
                }
            }
        }
        if (!znaleziono) System.out.println("  Brak testerów automatyzujących.");
        System.out.println();
    }
}