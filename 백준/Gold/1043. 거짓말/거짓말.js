let fs = require("fs");
// let input = fs.readFileSync("example.txt").toString().split("\r\n");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
let [n, m] = input[0].split(" ");
let [knowN, ...know] = input[1].split(" ");

// let graph = new Array(n + 1).map((a) => new Array(n + 1));
let graph = [];
for (let i = 0; i <= Number(n); i++) {
  graph.push(new Array(Number(n) + 1).fill(0));
}

for (let i = 0; i < m; i++) {
  let [p, ...people] = input[i + 2].split(" ");
  for (let j = 0; j < people.length - 1; j++) {
    for (let k = j + 1; k < people.length; k++) {
      let person1 = people[j];
      let person2 = people[k];
      graph[person1][person2] = 1;
      graph[person2][person1] = 1;
    }
  }
}

let visited = new Array(Number(n) + 1).fill(0);

let queue = [];
if (know.length !== 0) {
  for (let i = 0; i < know.length; i++) {
    queue.push(know[i]);
    visited[know[i]] = 1;
  }
}
while (queue.length !== 0) {
  let person = queue.shift();
  visited[person] = 1;
  for (let i = 1; i < graph[person].length; i++) {
    if (graph[person][i] === 1 && visited[i] === 0) {
      queue.push(i);
    }
  }
}

let answer = 0;
outer: for (let i = 0; i < m; i++) {
  let [p, ...checkList] = input[i + 2].split(" ");
  inner: for (check of checkList) {
    if (visited[check] === 1) continue outer;
  }
  answer++;
}
// console.log(visited);
console.log(answer);
