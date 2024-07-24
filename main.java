import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Willkommen beim Textanalyse-Programm!---");

        // Eingabe des Textes
        String text;
        while (true) {
            System.out.print("Bitte geben Sie Ihren Text ein, der gespeichert werden soll: ");
            text = scanner.nextLine();
            if (text.isEmpty()) {
                System.out.println("Fehler: Die Eingabe darf nicht leer sein.");
            } else {
                System.out.println("Die Eingabe wurde gespeichert.");
                break;
            }
        }

        // Textanalyse durchführen
        textAnalyse(text);

        scanner.close();
    }

    public static void textAnalyse(String text) {
        int satzzeichenCount = 0;
        int vokalCount = 0;
        int leerzeichenCount = 0;
        int konsonantenCount = 0;

        // Zählen der verschiedenen Zeichen im Text
        for (char ch : text.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                leerzeichenCount++;
            } else if (isVowel(ch)) {
                vokalCount++;
            } else if (isPunctuation(ch)) {
                satzzeichenCount++;
            } else if (Character.isLetter(ch)) {
                konsonantenCount++;
            }
        }

        // Ausgabe der Ergebnisse
        System.out.printf("Anzahl der Satzzeichen: %d%n", satzzeichenCount);
        System.out.printf("Anzahl der Vokale: %d%n", vokalCount);
        System.out.printf("Anzahl der Leerzeichen: %d%n", leerzeichenCount);
        System.out.printf("Anzahl der Konsonanten: %d%n", konsonantenCount);
    }

    // Hilfsfunktion zur Überprüfung, ob ein Zeichen ein Vokal ist
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // Hilfsfunktion zur Überprüfung, ob ein Zeichen ein Satzzeichen ist
    public static boolean isPunctuation(char ch) {
        return ch == '.' || ch == ',' || ch == '!' || ch == '?' || ch == ';' || ch == ':';
    }
}
