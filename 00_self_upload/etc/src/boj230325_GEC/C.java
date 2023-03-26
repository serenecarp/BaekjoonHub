package boj230325_GEC;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String encrypted = sc.next();
        String[] schools = {"NLCS", "BHA", "KIS", "SJA"};
        String decrypted;

        for (int i = 0; i < schools.length; i++) {
            decrypted = decryptName(schools[i]);
            for (int j = 0; j <= 25; j++) {
                String shifted = shiftName(decrypted, j);
                if (shifted.equals(encrypted)) {
                    System.out.println(schools[i]);
                    return;
                }
            }
        }
        System.out.println("Unknown");
    }

    private static String decryptName(String name) {
        String trimmed = name.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return trimmed.substring(0, Math.min(trimmed.length(), 10));
    }

    private static String shiftName(String name, int n) {
        StringBuilder shifted = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int ascii = (int) c;
            if (ascii >= 97 && ascii <= 122) {
                ascii = ((ascii - 97 - n) % 26 + 26) % 26 + 97;
            }
            shifted.append((char) ascii);
        }
        return shifted.toString();
    }
}
