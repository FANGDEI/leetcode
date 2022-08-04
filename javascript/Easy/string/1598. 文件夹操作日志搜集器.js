/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-23 19:50:51
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-23 19:55:46
 * @FilePath: \leetcode\javascript\Easy\string\1598. 文件夹操作日志搜集器.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。

下面给出对变更操作的说明：

"../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
"./" ：继续停留在当前文件夹。
"x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。

文件系统启动时位于主文件夹，然后执行 logs 中的操作。

执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 */
/**
 * @param {string[]} logs
 * @return {number}
 */
 var minOperations = function(logs) {
    let ans = 0;
    logs.forEach(item => {
        if(item === '../') ans = Math.max(0, ans - 1);
        else if(item !== './') ans++;
    });
    return ans;
};
