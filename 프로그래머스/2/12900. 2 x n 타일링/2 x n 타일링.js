function solution(n) {
    let dp = [];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    if(n === 1 || n === 2) return dp[n];
    for(let i = 3; i <= n; i++) {
        dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
    }
    console.log(dp);
    return dp[n];
}