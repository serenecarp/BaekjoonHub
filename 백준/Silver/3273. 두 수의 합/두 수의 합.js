let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();
let [n, nums, xString] = input.split('\n');
// let input = fs.readFileSync('/dev/stdin').toString();
// let [n, nums, xString] = input.split('\r\n');
let arr = nums
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);
const x = Number(xString);
let answer = 0;
outer: for (let i = 0; i < arr.length - 1; i++) {
  for (let j = i + 1; j < arr.length; j++) {
    if (arr[i] + arr[j] === x) {
      answer++;
      continue outer;
    }
  }
}
console.log(answer);
