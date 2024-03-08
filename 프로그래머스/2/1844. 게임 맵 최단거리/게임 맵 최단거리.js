function solution(maps) {
    let n = maps.length;
    let m = maps[0].length;
    return dfs(n, m, maps);
}

function dfs(n, m, maps) {
    let visited = new Array(n).fill().map((val) => new Array(m).fill(0));
    let queue = [];
    let dx = [1, 0, -1, 0];
    let dy = [0, 1, 0, -1];
    queue.push([0, 0]);
    // 영역밖이거나 벽이거나 방문했으면 가지 않음
    while (queue.length) {
        let [x, y] = queue.shift();
        for (let i = 0; i < 4; i++) {
            let nx = x + dx[i];
            let ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n || maps[ny][nx] === 0 || visited[ny][nx] !== 0) continue;
            queue.push([nx, ny]);
            visited[ny][nx] = visited[y][x] + 1;
        }
    }
    return visited[n - 1][m - 1] ? visited[n - 1][m - 1] + 1 : -1;
}