function solution(s)
{
    const stack = [];
    stack.push(s[0]);
    for(let i = 1; i < s.length; i++){
        let letter = s[i];
        // console.log(stack[stack.length - 1]);
        // console.log(letter);
        if(stack[stack.length - 1] === letter) stack.pop();
        else stack.push(letter);
    }
    if(stack.length === 0) return 1;
    return 0;
}