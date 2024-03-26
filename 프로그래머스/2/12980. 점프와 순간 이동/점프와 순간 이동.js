function solution(n)
{
    let loc = n;
    let energy = 0;
    while(loc) {
        if(loc % 2 === 0) {
            loc /= 2;
        } else {
            loc -= 1;
            energy++;
        }
    }
    return energy;
}