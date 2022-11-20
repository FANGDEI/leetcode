function countPrimes(n: number): number {
    const isPrime = new Array(n).fill(1);
    let ans = 0;
    for (let i = 2; i < n; ++i) {
        if (isPrime[i]) {
            ans += 1;
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = 0;
            }
        }
    }
    return ans;
};

// 进一步优化
// function countPrimes(n: number): number {
//     const isPrime = new Array(n).fill(1);
//     if(n<=2){
//         return 0
//     }
//     let ans = 1;

//     for (let i = 3; i < n; i+=2) {
//         if (isPrime[i]) {
//             ans += 1;
//             for (let j = i * i; j < n; j += i) {
//                 isPrime[j] = 0;
//             }
//         }
//     }
//     return ans;
// };

