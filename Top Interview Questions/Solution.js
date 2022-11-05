/**
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    if(n==0){
        return 0;
    }
    let res=1
    for(let i=n;i>=1;i--){
        res*=i
    }
    res
};