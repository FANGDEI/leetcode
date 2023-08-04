-- 表：Logs
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | num         | varchar |
-- +-------------+---------+
-- id 是这个表的主键。
--
--
-- 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
--
-- 返回的结果表中的数据可以按 任意顺序 排列。
--
-- 查询结果格式如下面的例子所示：
--
--
--
-- 示例 1:
--
-- 输入：
-- Logs 表：
-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  | 1   |
-- | 2  | 1   |
-- | 3  | 1   |
-- | 4  | 2   |
-- | 5  | 1   |
-- | 6  | 2   |
-- | 7  | 2   |
-- +----+-----+
-- 输出：
-- Result 表：
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
-- 解释：1 是唯一连续出现至少三次的数字。

-- 解：通过窗口函数，lag和lead-- 注意配合order by，如果不是分组里面的前后关系，这里就不用partition by关键字
select distinct num ConsecutiveNums
from (select num,
             lag(num, 1, null) over(order by id) preNum, lead(num, 1, null) over(order by id) afterNum
      from Logs) a -- 临时表必须要有别名
where preNum is not null and afterNum is not null and preNum = afterNum and preNum = num -- 三个都相等才行



