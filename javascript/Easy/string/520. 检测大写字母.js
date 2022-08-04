/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-21 21:37:06
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-21 21:56:13
 * @FilePath: \leetcode\javascript\Easy\string\520. 检测大写字母.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 我们定义，在以下情况时，单词的大写用法是正确的：
全部字母都是大写，比如 "USA" 。
单词中所有字母都不是大写，比如 "leetcode" 。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 */
/**
 * @param {string} word
 * @return {boolean}
 */
 var detectCapitalUse = function(word) {
    if(word.length==1||word.length==2){
        return true
    }
    let code=word[0].charCodeAt()
    if("a".charCodeAt()<=code&&code<="z".charCodeAt()){
        for(let x of word){
            if(x.charCodeAt()>"z".charCodeAt()||x.charCodeAt()<"a".charCodeAt())
            return false
        }
    }
    if("A".charCodeAt()<=code&&code<="Z".charCodeAt()){
        if("A".charCodeAt()<=word[1].charCodeAt()&&word[1].charCodeAt()<="Z".charCodeAt()){
            for(let x of word){
            
                if(x.charCodeAt()>"Z".charCodeAt()||x.charCodeAt()<"A".charCodeAt())
                return false
            }
        }
        if("a".charCodeAt()<=word[1].charCodeAt()&&word[1].charCodeAt()<="z".charCodeAt()){
            for(let i=2;i<word.length;i++){
                if(word[i].charCodeAt()>"z".charCodeAt()||word[i].charCodeAt()<"a".charCodeAt())
            return false
            }
        }
    }
    return true
};
/* var detectCapitalUse = function(word) {
    if(word.length === 0) return false;
    if(word.length === 1) return true;
    var uper = word.toUpperCase();
    var lower = word.toLowerCase();
    if(uper === word){
        return true;
    }else if(lower === word){
        return true;
    }
    if(word[0]<='Z'&&word[0]>='A'){
        var newWord = word.slice(1);
        if(newWord === newWord.toLowerCase()){
            return true;
        }
    }
    return false;
};


作者：ityou-o
链接：https://leetcode.cn/problems/detect-capital/solution/javascriptban-jie-ti-si-lu-by-ityou-o-egbw/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 */
console.log(detectCapitalUse("USA"));