/*表：Logs

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id 是这个表的主键。
 

编写一个 SQL 查询，查找所有至少连续出现三次的数字。

返回的结果表中的数据可以按 任意顺序 排列。

查询结果格式如下面的例子所示：

 

示例 1:

输入：
Logs 表：
+----+-----+
| Id | Num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
输出：
Result 表：
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
解释：1 是唯一连续出现至少三次的数字。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/consecutive-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
SELECT DISTINCT
    t1.num "ConsecutiveNums"
FROM
    LOGS t1
        JOIN LOGS t2 ON ( t2.id - t1.id )= 1
        JOIN LOGS t3 ON ( t3.id - t2.id )= 1
WHERE
        t1.num = t2.num
  AND t2.num = t3.num



