function solution(num_list, n) {
    const arr = [];
    for(let i = 1; i <= n; i++) {
        arr.push(num_list[i-1]);
    }
    return arr;
}