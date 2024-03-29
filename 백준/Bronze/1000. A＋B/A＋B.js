let fs = require("fs");
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

let [a, b] = [...input];
console.log(Number(a) + Number(b));
