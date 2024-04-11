function solution(n) {
    let answer = '';
    let arr = ['4', '1', '2'];
    let number = n;
    while(number > 0) {
        answer = arr[number % 3] + answer;
        number = parseInt((number - 1) / 3)
    }
    return answer;
}