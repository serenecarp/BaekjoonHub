package prob011279;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N + 1];
        int last = 0;
        for (int i = 0; i < N; i++) {

            int command = sc.nextInt();

            if (command == 0) {
                System.out.println(arr[1]);
                if (last == 0) {
                    continue;
                }
                arr[1] = arr[last];
                arr[last] = 0;

                int idx = 1;
                while (idx * 2 < last && (arr[idx] < arr[idx * 2] || arr[idx] < arr[idx * 2 + 1])) {
                    if (arr[idx * 2] > arr[idx * 2 + 1]) {
                        swap(idx, idx * 2);
                        idx = idx * 2;
                    } else {
                        swap(idx, idx * 2 + 1);
                        idx = idx * 2 + 1;
                    }
                }

                last--;

            } else {

                arr[++last] = command;
                int idx = last;
                while (idx > 1 && arr[idx / 2] < arr[idx]) {
                    swap(idx / 2, idx);
                    idx = idx / 2;
                }
            }
        }
    }

    public static void swap(int idx, int jdx) {
        int tmp = arr[idx];
        arr[idx] = arr[jdx];
        arr[jdx] = tmp;
    }
}
