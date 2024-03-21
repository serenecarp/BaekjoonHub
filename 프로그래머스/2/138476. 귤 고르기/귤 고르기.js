function solution(k, tangerine) {
    let arr = tangerine.sort();
    let dict = {};
    let cnt = k;
    let answer = 0;
    arr.forEach((e) => dict[e] = (dict[e] || 0) + 1);
    const sizeArr = Object.values(dict).sort((a,b) => b - a);
    for (const i of sizeArr) {
        cnt -= i;
        answer++;
        if(cnt <= 0) break; 
    }
    if(cnt > 0) return 0;
    return answer;
}