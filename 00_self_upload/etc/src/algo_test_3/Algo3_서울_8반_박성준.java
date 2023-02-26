

import java.util.Scanner;

public class Algo3_서울_8반_박성준 {
	public static void main(String[] args) {
		
		// *****************************
		
		// 1) 이진검색의 프로그래밍 코드 작성
		// 2) 이진 검색에 대한 설명: 코드 가장 아랫단에 서술
		
		// *****************************

		Scanner sc = new Scanner(System.in);
		System.out.print("찾으려는 값을 입력하세요: ");
		int searchNum = sc.nextInt();
		int[] arr = { 1, 5, 23, 45, 67, 72, 88, 91, 105};
		int start = 0;
		int end = arr.length - 1;
		
		int idx = -1;
		while (start <= end) {
			// 찾고자 하는 범위의 중간 지점 설정
			// 범위를 절반씩 줄여 나가며 계속 재설정될 mid값
			int mid = (start + end) / 2;

			// 값을 찾으면 idx에 저장하고 탈출
			if (arr[mid] == searchNum) {
				idx = mid;
				break;
			// 찾으려는 값보다 mid가 크면 mid보다 왼쪽편에 있을 것이다
			} else if (arr[mid] > searchNum) {
				end = mid - 1;
			// 찾으려는 값보다 mid가 작으면 mid보다 오른편에 있을 것이다
			} else if (arr[mid] < searchNum) {
				start = mid + 1;
			}
		}
		if (idx == -1)
		System.out.println("값이 없어요");
		else System.out.printf("찾고자 하는 값은 [%d]에 있어요", idx);
	}
}

// 2) 이진 검색에 대한 설명
// 개념: 탐색할 배열의 범위를 계속 1/2씩 줄여 나가며 원하는 value를 찾는 방법이다.
// 배열이 정렬되어 있을 때에만 사용 가능하다.
// 찾고자 하는 값이 중간값보다 크다면, 중간값 바로 다음 index 범위부터 탐색한다.
// 찾고자 하는 값이 중간값보다 작다면, 중간값 바로 이전 index 범위까지 탐색한다.
// 찾고자 하는 값과 중간값이 일치할 때 검색을 종료하며 해당 index를 출력한다.
// 탐색 시작 index와 탐색 끝 index가 교차할 때까지 일치값이 없다면 검색에 실패한 것이다.
// 시간복잡도는 O(logn)이다.
