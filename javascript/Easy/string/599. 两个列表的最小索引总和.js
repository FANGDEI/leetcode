/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-25 09:58:35
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-25 10:02:53
 * @FilePath: \leetcode\javascript\Easy\string\599. 两个列表的最小索引总和.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 */
/**
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
 var findRestaurant = function(list1, list2) {
    let map = {};
    let keysArr = [];
    list1.forEach((item, index)=>{
        const index2 = list2.indexOf(item);
        if(index2 > -1){
            const total = index + index2;
            if(map[total]){
                map[total].push(item)
            }else{
                map[total] = [item];
            }
        }
    })
    keysArr = Object.keys(map);
    keysArr.sort((a,b)=>a-b);
    return map[keysArr[0]]
};