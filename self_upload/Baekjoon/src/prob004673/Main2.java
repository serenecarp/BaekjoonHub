package prob004673;

public class Main2 {
	public static int[] selfNum = new int[10000]; // 조건: 10000보다 작거나 같은 셀프 넘버-> 인덱스: 0~9999


	public static void main(String[] args) {
		int idx = 0;
		selfNumber(idx);

		for (int i = 0; i < selfNum.length; i++)
			if (selfNum[i] == 0) System.out.println(i + 1);
	}

	public static void selfNumber(int idx) {
		int sn = idx + 1;
		for (int j = 0; j < 5; j++) {
			sn += ((idx + 1) % Math.pow(10, j + 1)) / Math.pow(10, j);
		}
		System.out.printf("*** %d \n", sn);
		selfNum[sn - 1] = 1;
		while (idx > 9999) {
			if (selfNum[idx] == 0)
				selfNumber(idx);
		}
	}
}
