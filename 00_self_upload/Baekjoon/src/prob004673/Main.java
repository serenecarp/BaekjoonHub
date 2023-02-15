package prob004673;

public class Main {
	public static void main(String[] args) {
		int[] selfNum = new int[10000]; // 조건: 10000보다 작거나 같은 셀프 넘버-> 인덱스: 0~9999

		for (int idx = 0; idx < selfNum.length; idx++) {

			int sn = idx + 1;
			for (int j = 0; j < 5; j++) {
				 // 자릿수 추출해서 더해주기
				sn += ((idx + 1) % Math.pow(10, j + 1)) / Math.pow(10, j);
			}
			if (sn > 9999)
				continue;
			// 셀프넘버가 아니면 1이라고 index자리에 표시해줌
			selfNum[sn] = 1;

		}
		for (int idx = 0; idx < selfNum.length - 1; idx++) {
			// 체크 안된 셀프넘버들을 출력
			if (selfNum[idx + 1] == 0)
				System.out.println(idx + 1);

		}
	}
}

