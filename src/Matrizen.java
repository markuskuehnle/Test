import java.util.Scanner;

public class Matrizen {

    public static float[][] matrizenMultiplikation(float[][] a, float[][] b) throws MultiplicationErrorException {
        float[][] e = new float[a.length][b[0].length]; // Ergebnis-Matrix

        if (a.length == b[0].length) { // nur möglich wenn (Spaltenzahl a == Zeilenzahl b) -> Exception
            // Schleife zur Berechnung der Ergebnismatrix
            for (int i = 0; i < e.length; i++) { // Zeilen
                for (int j = 0; j < e[0].length; j++) { // Spalten
                    e[i][j] = multiplikationZahl(a, b, i, j);
                }
            }
            return e; // Return Ergebnis-Matrix
        } else {
            throw new MultiplicationErrorException();
        }
    }

    // Berechnung einzelner Zahlen in der Ergebnismatrix
    private static float multiplikationZahl(float[][] a, float[][] b, int i, int j) {
        // Multiplikation für eine Zahl der Ergebnismatrix
        float zahl = 0;
        for (int k = 0; k < b.length; k++) {
            zahl += (a[i][k] * b[k][j]);
        }
        return zahl;
    }

    // Ausgabe einer Matrix in der Konsole
    public static void ausgabe(float[][] e) {
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e[0].length; j++) {
                System.out.print(e[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Manuelle Eingabe von Matrizen beliebiger Größe
    private static float[][] initialisiereMatrix() {
        Scanner scan = new Scanner(System.in);

        // Matrix initialisieren
        System.out.print("Anzahl Zeilen der Matrix: ");
        int zeilen = scan.nextInt();
        System.out.print("Anzahl Spalten der Matrix: ");
        int spalten = scan.nextInt();
        float[][] matrix = new float[zeilen][spalten];
        // Werte eingeben
        for (int i = 0; i < zeilen; i++) {
            System.out.println("Reihe " + (i + 1));
            for (int j = 0; j < spalten; j++) {
                System.out.print("Zahl " + (j + 1) + ": ");
                matrix[i][j] = scan.nextFloat();
            }
        }
        // Ausgabe der eingegebenen Matrix
        System.out.println("Ihre Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        return matrix;
    }

    public static void main(String[] args) throws MultiplicationErrorException {
        // Manuelle Eingabe der Matrizen
//		System.out.println("Ihre erste Matrix:");
//		float[][] a = initialisiereMatrix();
//		System.out.println("Ihre zweite Matrix:");
//		float[][] b = initialisiereMatrix();

        // Test-Matrizen aus Übungsblatt
        float[][] a = {
                {0, 0, 1, 2},
                {0, 1, 0, 4},
                {-1, 0, 0, 3},
                {0, 0, 0, 1},
        };

        float[][] b = {
                {0, 0, -1, 3},
                {0, 1, 0, 1},
                {1, 0, 0, 5},
                {0, 0, 0, 1},
        };

        // Berechnung und Ausgabe der Matrizenmultiplikation
        ausgabe(matrizenMultiplikation(a, b));
    }
}
