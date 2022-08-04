/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-30 09:20:45
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-30 09:23:32
 * @FilePath: \leetcode\javascript\Easy\array\682. 棒球比赛.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。

比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：

整数 x - 表示本回合新获得分数 x
"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
请你返回记录中所有得分的总和。
 */
/**
 * @param {string[]} ops
 * @return {number}
 */
 var calPoints = function(ops) {
    let ret = 0;
    const points = [];
    for (const op of ops) {
        const n = points.length;
        switch (op[0]) {
            case '+':
                ret += points[n - 1] + points[n - 2];
                points.push(points[n - 1] + points[n - 2]);
                break;
            case 'D':
                ret += 2 * points[n - 1];
                points.push(2 * points[n - 1]);
                break;
            case 'C':
                ret -= points[n - 1];
                points.pop();
                break;
            default:
                ret += parseInt(op);
                points.push(parseInt(op));
                break;
        }
    }
    return ret;
};