function solution(progresses, speeds) {
    let pointer = 0;
    let queue = [...progresses];
    let flag = true;
    let cum = 0;
    let answer = [];
    while(flag) {
        queue = queue.map((e, i) => e+speeds[i])
        if(queue[pointer] >= 100) {
            while(queue[pointer] >= 100) {
                pointer++;
            }
            if(answer.length === 0) {
                answer.push(pointer);
                cum += pointer;
            } else {
                answer.push(pointer - cum);
                cum += answer[answer.length -1];
            }

            if(pointer >= queue.length) break;
        }
    }
    
    return answer;
}