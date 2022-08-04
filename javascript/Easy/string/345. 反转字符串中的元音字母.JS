/* 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 */
/**
 * @param {string} s
 * @return {string}
 */
 var reverseVowels = function(s) {
    let a=["a","e","i","o","u","A","E","I","O","U"]
    let b=[]
    let res=[]
    for(let x of s){
        if(a.indexOf(x)!=-1){
            b.push(x)
        }
    }
    b=b.reverse()
    console.log(b)
    let p=0
    for(let i=0;i<s.length;i++){
        if(a.indexOf(s[i])!=-1){
            res[i]=b[p]
            console.log(b[p]);
            p++
        }
        else
        res[i]=s[i]
    }
    return res.join("")
};
console.log(reverseVowels("hello"));