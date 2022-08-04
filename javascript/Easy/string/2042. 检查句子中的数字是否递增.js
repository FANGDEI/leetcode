
/* 句子是由若干 token 组成的一个列表，token 间用 单个 空格分隔，句子没有前导或尾随空格。每个 token 要么是一个由数字 0-9 组成的不含前导零的 正整数 ，要么是一个由小写英文字母组成的 单词 。
示例，"a puppy has 2 eyes 4 legs" 是一个由 7 个 token 组成的句子："2" 和 "4" 是数字，其他像 "puppy" 这样的 tokens 属于单词。
给你一个表示句子的字符串 s ，你需要检查 s 中的 全部 数字是否从左到右严格递增（即，除了最后一个数字，s 中的 每个 数字都严格小于它 右侧 的数字）。
 */
/**
 * @param {string} s
 * @return {boolean}
 */
var areNumbersAscending = function (s) {
    let res = []
    s=s.split(" ")
    for (let x of s) {
        if (x < 100 && x > 0) {
            res.push(x)
        }
    }
    for (let i = 0; i < res.length-1; i++) {
        if (res[i]-0 >= res[i + 1]-0)
            return false
    }
    return true
};
// console.log(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));