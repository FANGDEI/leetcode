// 编写一个函数来查找字符串数组中的最长公共前缀。
// 如果不存在公共前缀，返回空字符串 ""。
function longestCommonPrefix(strs) {
    if(strs.length===1)
    return strs[0]
    let minl=201;
    for(x of strs){
        x.length<minl?minl=x.length:1
    }
    let olds = "1", s = strs[0][0]
    let tag = 1
    while (1) {
        for (let t = 0; t < strs.length; t++) {
            if (s !== strs[t].slice(0, tag))
                return olds
        }
        if(s.length===minl){
            return s
        }
        tag++
        olds = s
        s = strs[0].slice(0, tag)

    }
};
console.log(longestCommonPrefix(['dfdsf','dfdsf','dfdsf']));