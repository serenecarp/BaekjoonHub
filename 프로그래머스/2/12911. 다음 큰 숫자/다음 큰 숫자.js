function solution(n) {
    let binary = DecimalToBinary(n);
    
    let point = 0;
    let ones = -1;
    for(let i=binary.length-1; i>0; i--) {
        if(binary[i] === 1 && binary[i-1] ===0) {
            point = i;
            for(let j=point; j<binary.length; j++) {
                if(binary[j] === 1) ones++;
            }
            break;
        }
    }
    binary[point - 1] = 1;
    binary[point] = 0;
    for(let i=binary.length-1; i>point; i--) {
        binary[i] = 0;
    }
    let curr = binary.length-1;
    while(ones > 0) {
        binary[curr--] = 1;
        ones--;
    }
    
    let answer = 0;
    let digit = 0;
    for(let i=binary.length-1; i>=0; i--) {
        answer += binary[i] * (2**digit++);
    }
    
    return answer;
}

function DecimalToBinary(n) {
    let d = n;
    let b = [];
    while(d > 0) {
        b.unshift(d % 2);
        d = Math.floor(d/2);
    }
    b.unshift(0);
    return b;
}