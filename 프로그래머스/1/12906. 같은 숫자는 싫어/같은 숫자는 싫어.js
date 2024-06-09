function solution(arr)
{
    let queue = [];
    queue.push(arr[0]);
    for(let i=1; i<arr.length; i++) {
        if(arr[i] === queue[queue.length-1]) continue;
        queue.push(arr[i]);
    }
    return (queue);
}