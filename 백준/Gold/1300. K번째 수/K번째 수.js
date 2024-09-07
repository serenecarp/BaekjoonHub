let fs = require('fs');
// let input = fs.readFileSync('example.txt').toString().trim();
let input = fs.readFileSync('/dev/stdin').toString();
let [N, k] = input.split('\n').map(Number);

answer = search(N, k);
console.log(answer);

function search(N, k) {
  let start = 1;
  let end = N * N;
  while (start <= end) {
    let mid = Math.floor((start + end) / 2);
    let count = 0;
    // count: N / 2 이하 숫자의 개수
    for (let i = 1; i <= N; i++) {
      count += Math.min(Math.floor(mid / i), N);
    }
    // k번째 숫자 이분탐색으로 찾기
    if (count < k) start = mid + 1;
    if (count >= k) end = mid - 1;
  }
  return start;
}
