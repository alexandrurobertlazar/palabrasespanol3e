import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File palabrasTotales = new File("listado-general.txt");
            File palabras3E = new File("resultado.txt");
            PrintStream printStream = new PrintStream(palabras3E);
            Scanner scanner = new Scanner(palabrasTotales);
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                if (s.length() < 3) continue;
                int cnt = 0;
                for (int i = 0; i < s.length(); i++){
                    if (s.charAt(i) == 'e') cnt++;
                }
                if (cnt == 3){
                    printStream.println(s);
                }
            }
            // Comprobamos errores.
            scanner = new Scanner(palabras3E);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.length() < 3) {
                    System.out.println("ERROR: '" + s + "' tiene menos de tres letras.");
                    break;
                }
                int cnt = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == 'e') cnt++;
                }
                if (cnt == 3) {
                    continue;
                }
                System.out.println("ERROR: '" + s + "' no tiene 3 e.");
                break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
