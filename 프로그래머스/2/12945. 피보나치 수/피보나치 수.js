function solution(n) {
    let x1 = 0;
    let x2 = 1;
    for(let i = 2; i <= n; i++) {
        let val = (x1 + x2) % 1234567;
        x1 = x2;
        x2 = val;
    }
    return x2;
}