void main() {
    
}public class Main {
    public static void main(String[] args) {

        // 1. Tworzenie zespołu
        ZespolProjektowy zespol = new ZespolProjektowy("Campus App");

        // Referencje typu Pracownik wskazują na obiekty Programista i Tester
        Pracownik p1 = new Programista("E-101", "Anna",  "Maj",    12000.0, "Java",   4);
        Pracownik p2 = new Tester     ("E-201", "Piotr", "Lis",     9800.0, true,    25);
        Pracownik p3 = new Programista("E-102", "Karol", "Wójcik", 11500.0, "Kotlin", 3);
        Pracownik p4 = new Tester     ("E-202", "Marta", "Kowal",   8500.0, false,   18);

        zespol.dodajPracownika(p1);
        zespol.dodajPracownika(p2);
        zespol.dodajPracownika(p3);
        zespol.dodajPracownika(p4);
        zespol.wypiszSkladZespolu();

        System.out.printf("Łączny miesięczny koszt zespołu: %.2f PLN%n%n",
                zespol.policzLacznyKoszt());

        System.out.println("--- Prezentacje pracowników (polimorfizm) ---");
        System.out.println(p1.przedstawSie());
        System.out.println(p2.przedstawSie());
        System.out.println();

        System.out.println("--- instanceof i rzutowanie ---");
        if (p1 instanceof Programista) {
            Programista programista = (Programista) p1;
            programista.wypiszTechnologie();
        }
        System.out.println();
        if (p2 instanceof Tester) {
            Tester tester = (Tester) p2;
            tester.uruchomRaportTestow();
        }
        System.out.println();

        System.out.println("--- Metoda final pobierzIdPracownika() ---");
        System.out.println("ID p1: " + p1.pobierzIdPracownika());
        System.out.println("ID p2: " + p2.pobierzIdPracownika());
        System.out.println();

        System.out.println("--- equals() ---");
        Pracownik duplikat = new Tester("E-201", "Inne", "Dane", 9000.0, false, 10);
        System.out.println("p2.equals(duplikat 'E-201'): " + p2.equals(duplikat)); // true
        System.out.println("p1.equals(p3):               " + p1.equals(p3));       // false
        System.out.println();

        System.out.println("--- toString() ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println();

        System.out.println("--- Wyszukiwanie po ID ---");
        Pracownik znaleziony = zespol.znajdzPoId("E-102");
        System.out.println("Znaleziony 'E-102': "
                + (znaleziony != null ? znaleziony.przedstawSie() : "Nie znaleziono:("));

        zespol.wypiszTesterowAutomatyzujacych();
    }
}