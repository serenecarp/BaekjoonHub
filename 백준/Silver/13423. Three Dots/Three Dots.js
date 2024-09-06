let fs = require('fs');
//let input = fs.readFileSync('example.txt').toString();
let input = fs.readFileSync('/dev/stdin').toString();
let [T, ...chunk] = input.split('\n');
let cases = Number(T);
let nums = [];
let arrs = [];
for (let i = 0; i < 2 * cases; i++) {
  if (i % 2 === 1) {
    arrs.push(
      chunk[i]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b)
    );
  } else {
    nums.push(Number(chunk[i]));
  }
}

let answer;

for (let i = 0; i < cases; i++) {
  answer = 0;
  let arr = arrs[i];
  let num = nums[i];
  for (let j = 0; j < num - 1; j++) {
    for (let k = j + 1; k < num; k++) {
      if (search(arr, j, k)) {
        answer++;
      }
    }
  }
  console.log(answer);
}

function search(arr, idx1, idx2) {
  let [a, b] = [arr[idx1], arr[idx2]];
  if ((a + b) % 2 === 1 || (a + b) % 2 === -1) return false;
  let c = (a + b) / 2;
  while (idx1 <= idx2) {
    let mid = Math.floor((idx1 + idx2) / 2);

    if (arr[mid] === c) {
      return true;
    } else if (arr[mid] > c) {
      idx2 = mid - 1;
    } else {
      idx1 = mid + 1;
    }
  }
}
