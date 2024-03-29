let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// let input = fs.readFileSync("./example.txt").toString().trim().split("\r\n");

let [mn, ...list] = input;

let [m, n] = mn.split(" ");
let targetSite = list.splice(m);
let passwordData = {};

for (let i = 0; i < list.length; i++) {
  let data = list[i].split(" ");
  passwordData[data[0]] = data[1];
}

let answer = "";
for (let i = 0; i < n; i++) {
  answer += passwordData[targetSite[i]];
  answer += "\n";
}
console.log(answer);
