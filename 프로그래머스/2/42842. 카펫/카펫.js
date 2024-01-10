function solution(brown, yellow) {
    const total = brown + yellow;
    for(let i = 3; i <= Math.sqrt(total); i++) {
        if(total % i === 0) {
            let garo = i;
            let sero = total / i;
            let yel = (garo - 2) * (sero - 2);
            if(yel === yellow) {
                return [sero, garo];
            }
        } 
    }
}