package boj0311_jungang;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int[] a = new int[k];

            for (int j = 0; j < k; j++) {
                a[j] = sc.nextInt();
            }

            boolean isPossible = false;
            int count = 0;

            while (true) {
                boolean allZero = true;

                for (int j = 0; j < k; j++) {
                    if (a[j] != 0) {
                        allZero = false;
                        break;
                    }
                }

                if (allZero) {
                    isPossible = true;
                    break;
                }

                int firstNonZeroIndex = -1;
                for (int j = 0; j < k; j++) {
                    if (a[j] != 0) {
                        firstNonZeroIndex = j;
                        break;
                    }
                }

                if (firstNonZeroIndex == -1) {
                    break;
                }

                int current = a[firstNonZeroIndex];
                a[firstNonZeroIndex] = 0;

                for (int j = firstNonZeroIndex + 1; j < k; j++) {
                    if (a[j] != 0) {
                        int next = a[j];
                        a[j] = current;
                        current = next;
                    }
                }

                for (int j = 0; j < k; j++) {
                    if (a[j] != 0) {
                        a[j] -= current;
                        if (a[j] < 0) {
                            a[j] = -a[j];
                        }
                    }
                }

                count++;
            }

            if (isPossible) {
                System.out.println(count);
            } else {
                System.out.println("impossible");
            }
        }

        sc.close();
    }
}
