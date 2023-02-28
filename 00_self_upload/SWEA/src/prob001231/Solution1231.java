// 구현이 막혀 구글링해 참고했습니다..

package prob001231;

import java.util.Scanner;

// 트리 구현
class Tree {
	// 트리 node 개수, root node
	int N;
	Node root;

	// 트리 생성
	public Tree(int N) {
		this.N = N;
		this.root = null;
	}

	// 트리를 구성하는 노드 구현
	class Node {
		// 노드의 index, 가지고 있는 글자, left child, right child
		int index;
		char value;
		Node left;
		Node right;

		// 노드 생성(index와 value를 모두 <- 당사자 노드를 생성할 때)
		public Node(int index, char value) {
			this.index = index;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		// 노드 생성(index만 <- 노드의 자식을 미리 생성해둘 때)
		public Node(int index) {
			this.index = index;
			this.value = '\u0000';
			this.left = null;
			this.right = null;
		}
	}

	// 노드를 생성 및 연결함
	public void setNode(int index, char value, int leftIdx, int rightIdx) {
		Node temp;
		// 아직 root node가 없다면 처음 들어온 node를 root로 함
		if (root == null) {
			Node node = new Node(index, value);
			this.root = node;
			temp = node;

		// root가 이미 있다면,
		// 앞에서 부모가 이미 생성했을
		// index만 들어 있는 노드를 찾아서,
		// 그 노드에 value, left, right를 부여하고자 함
		} else {
			Node node = findNode(root, index);
			node.value = value;
			temp = node;
		}
		// 받을 때 leftIdx나 rightIdx 입력값이 없으면 0으로 입력되도록 했음.
		if (leftIdx != 0) {
			temp.left = new Node(leftIdx);
		}
		if (rightIdx != 0) {
			temp.right = new Node(rightIdx);
		}

	}

	// 부모가 이미 생성한 내 노드를 찾아주는 메소드
	// index값만 들어 있어서, index로 그 노드를 찾고자 함
	public Node findNode(Node temp, int index) {
		// temp가 null이면 내가 찾으려는 노드가 아니므로 null 리턴
		if (temp == null) {
			return null;
		}

		// index가 일치하면 그 노드를 리턴
		if (temp.index == index) {
			return temp;
		}
		
		// 일단 왼쪽을 탐색
		Node foundNode = findNode(temp.left, index);
		// 왼쪽에 내가 원하는 노드가 없어 null값이 돌아왔다면
		// 오른쪽을 탐색
		if(foundNode == null) {
			foundNode = findNode(temp.right, index);
		}
		// 찾은 결과물을 리턴
		return foundNode;
	}

	// in-order traversal (중위 순회) 출력
	public void inOrder(Node temp) {
		// 끝까지 왔으면 돌아오기
	    if (temp == null) {
	        return;
	    }
	    // L V R
	    inOrder(temp.left);
	    System.out.print(temp.value);
	    inOrder(temp.right);
	}

}

public class Solution1231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// nextInt에 남은 개행문자를 처리
			sc.nextLine();
			// 트리 생성
			Tree tree = new Tree(N);

			// 줄 단위로 입력받고자 함(크기 4인 건 의미 없음)
			String[] inputLine = new String[4];
			for (int i = 0; i < N; i++) {
				// 받은 줄단위 입력값을 공백 단위로 분리
				inputLine = sc.nextLine().split(" ");
				// 분리한 값들을 index, value, leftIdx, rightIdx로 전달해줄 예정
				// leftIdx나 rightIdx값이 없는 경우에는 그 값을 0으로 해서 메소드에 전달해 준다.
				int index = 0;
				char value = '\u0000';
				int leftIdx = 0;
				int rightIdx = 0;
				
				// 입력값이 4글자면 leftIdx, rightIdx 둘다 있음
				if (inputLine.length == 4) {
					index = Integer.parseInt(inputLine[0]);
					value = inputLine[1].charAt(0);
					leftIdx = Integer.parseInt(inputLine[2]);
					rightIdx = Integer.parseInt(inputLine[3]);

				// 입력값이 3글자면 leftIdx만 있음
				} else if (inputLine.length == 3) {
					index = Integer.parseInt(inputLine[0]);
					value = inputLine[1].charAt(0);
					leftIdx = Integer.parseInt(inputLine[2]);

				// 입력값이 2글자면 index랑 value만 있음
				} else {
					index = Integer.parseInt(inputLine[0]);
					value = inputLine[1].charAt(0);

				}

				// 받은 입력값으로 노드를 생성 및 연결
				tree.setNode(index, value, leftIdx, rightIdx);
				
			}
			// 트리를 in-order로 출력
			System.out.printf("#%d ", test_case);
			tree.inOrder(tree.root);
			System.out.println();
		}
	}
}
