function solution(s) {
    let answer = 0;
    answer = test(s);
    function test(string) {
        let tmpString = string;
        let cnt = 0;
        let len = string.length
        if(len % 2 === 1) return 0;
        

        for(let i = 0; i < len; i++ ) {
            const stack = [];
            
            tmpString = rotate(tmpString, len);
            stack.push(tmpString[0]);
            if(tmpString[0] === ']' || tmpString[0] === '}' || tmpString[0] === ')') continue;
            for(let i = 1; i < len; i++) {
                if(yn(stack[stack.length - 1], tmpString[i])){
                    stack.pop();
                } else {
                    stack.push(tmpString[i]);
                }
            }
            
            if(!stack.length) {
                cnt++;
            }
        }
        return cnt;
    }
    
    function yn(a, b) {
        if(a==='[' && b===']') return true;
        if(a==='{' && b==='}') return true;
        if(a==='(' && b===')') return true;
        return false;
    }
    
    function rotate(string, len) {
        const arr = [...string]
        let letter = arr.shift();
        arr.push(letter);
        const newString = arr.join('');
        return newString;
    }
    
    return answer;
}