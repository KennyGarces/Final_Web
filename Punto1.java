// Kenny Alejandro Garces Cabrera
// Programa en Java que lea un número positivo en base 8 e imprima su correspondiente numero binario 


import java.util.Scanner;

public class Punto1 { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "si";

        do {
            System.out.print("Ingrese un número en base 8: ");
            int NumeroOctal = scanner.nextInt();

            if (NumeroOctal < 0 || NumeroOctal > 7777 || tieneDigitosMayoresA7(NumeroOctal)) {
                System.out.println("El numero debe ser positivo 0 - 7");
                System.out.print("¿Desea ingresar otro número? (si/no): ");
                continuar = scanner.next();
                continue;
            }

            System.out.print("Correspondiente en binario: ");
            convertOctalToBinary(NumeroOctal);

            System.out.print("¿Desea ingresar otro número? (si/no): ");
            continuar = scanner.next();
        } while (!continuar.equalsIgnoreCase("no"));
    }

    public static void convertOctalToBinary(int octalNumber) {
        int[] octalToBinary = { 0, 1, 10, 11, 100, 101, 110, 111 };

        StringBuilder binaryString = new StringBuilder();

        if (octalNumber == 0) {
            binaryString.append("000");
        } else {
            while (octalNumber != 0) {
                int digit = octalNumber % 10;
                binaryString.insert(0, String.format("%03d ", octalToBinary[digit]));
                octalNumber /= 10;
            }
        }

        System.out.println(binaryString.toString().trim());
    }

    public static boolean tieneDigitosMayoresA7(int octalNumber) {
        while (octalNumber != 0) {
            int digit = octalNumber % 10;
            if (digit > 7) {
                return true;
            }
            octalNumber /= 10;
        }
        return false;
    }
}




