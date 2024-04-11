let fs = require("fs");
// let input = fs.readFileSync("example.txt").toString().split(" ");
let input = fs.readFileSync("/dev/stdin").toString().split(" ");
let [a, b] = input.map((e) => Number(e));
let k = recursive(a, b, 1);

console.log(k);

function recursive(a, b, cnt) {
  // console.log(a);
  // console.log(b);
  // console.log(cnt);
  // console.log("---");
  if (a === b) return cnt;
  if (a > b) return -1;
  if (b % 10 !== 1 && b % 2 !== 0) return -1;

  if (b % 2 === 0) return recursive(a, b / 2, cnt + 1);
  if (b % 10 === 1) return recursive(a, Math.floor(b / 10), cnt + 1);
}
