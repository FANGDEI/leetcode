/* 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:

如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 */
/**
 * @param {string} s
 * @return {number[]}
 */
 var diStringMatch = function (s) {
    let end = s.length, front = 0, res = [],p=s.length
    if (s[0] == 'D') {
        i = end--
    }
    else if (s[0] == "I") {
        i = front++
    }
    res.push(i)
    for (let x = 1; x < s.length; x++) {
        if (s[x] == "D") {
            res.push(end--)
        }
        else {
            res.push(front++)
        }
    }
        if (s[p-1] == 'D') {
        i = end--
    }
    else if (s[p-1] == "I") {
        i = front++
    }
    res.push(i)
    return res
};