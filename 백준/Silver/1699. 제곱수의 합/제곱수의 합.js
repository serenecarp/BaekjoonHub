let fs = require('fs');
// let input = fs.readFileSync('example.txt').toString().trim();
let input = fs.readFileSync('/dev/stdin').toString().trim();

let N = Number(input);
const dp = [];
for (let i = 0; i <= N; i++) dp[i] = i;
for (let i = 1; i <= N; i++) {
  for (let j = 1; j <= Math.sqrt(i); j++) {
    dp[i] = Math.min(dp[i], dp[i - j ** 2] + 1);
  }
}

console.log(dp[N]);
