/* 给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
 */
/**
 * @param {string} s
 * @return {boolean}
 */
var areOccurrencesEqual = function (s) {
    let map = new Map()
    for (let x of s) {
        if (map.has(x)) {
            map.set(x, map.get(x) + 1)
        }
        else {
            map.set(x, 1)
        }
    }
    let p=map.get(s[0])
    for(let x of map.values()){
        if(x!=p){
            return false
        }
    }
    return true
};