function solution(numbers) {
    var answer = '';
    newNumbers = numbers.map((number) => number.toString());
    newNumbers.sort(function compare(a, b) {
        return (b+a) - (a+b);
    })
    return newNumbers[0] === '0' ? '0' : newNumbers.join('');
}