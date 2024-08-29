let fs = require('fs');
// let input = fs.readFileSync('example.txt').toString();
let input = fs.readFileSync('/dev/stdin').toString();
let [n, nums] = input.split('\n');
let arr = nums
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);
// console.log(n);
// console.log(arr);

let anna = 0;
let elsa = 0;
let diff = Infinity;
let [ni, nj] = [0, 0];
outer: for (let i = 0; i < arr.length - 1; i++) {
  for (let j = i + 1; j < arr.length; j++) {
    elsa = arr[i] + arr[j];
    ni = 0;
    nj = arr.length - 1;
    while (ni < nj) {
      if (ni === i || ni === j) {
        ni++;
        continue;
      }
      if (nj === i || nj === j) {
        nj--;
        continue;
      }
      anna = arr[ni] + arr[nj];
      diff = Math.min(difference(elsa, anna), diff);
      if (elsa > anna) ni++;
      if (anna > elsa) nj--;
      if (elsa === anna) {
        diff = 0;
        break outer;
      }
    }
  }
}

console.log(diff);

function difference(a, b) {
  return Math.abs(a - b);
}
