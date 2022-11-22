/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
 var reverseBits = function (n) {
    let s=''+n
    let res=''
    for (let i = 0; i < 32; i++) {
        if (n != 0) {
            let s = Math.floor(n / 2)
            let t = n % 2
            res+=t
            n = s
        }else{
            res+=0
        }
    }
    s=res
    res=0
    for(let i=31;i>=0;i--){
        res+=(parseInt(s.charAt(i))*Math.pow(2,31-i))
    }
    return res
};