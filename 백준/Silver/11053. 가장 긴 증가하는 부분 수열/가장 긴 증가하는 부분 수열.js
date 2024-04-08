let fs = require("fs");

// let input = fs.readFileSync("example.txt").toString().split("\r\n");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let [n, rawSeries] = input;
let series = rawSeries.split(" ");

s = series.map((element) => Number(element));
// console.log(s);
let dp = [];
for (let i = 0; i < n; i++) {
  let max = 0;
  for (let j = 0; j < i; j++) {
    if (s[i] > s[j] && dp[j] > max) {
      max = dp[j];
    }
  }
  dp[i] = max + 1;
}
console.log(Math.max(...dp));
