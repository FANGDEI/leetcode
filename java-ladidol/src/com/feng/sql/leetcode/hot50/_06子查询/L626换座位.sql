-- 表: Seat
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | name        | varchar |
-- +-------------+---------+
-- id 是该表的主键（唯一值）列。
-- 该表的每一行都表示学生的姓名和 ID。
-- id 是一个连续的增量。
--
--
-- 编写解决方案来交换每两个连续的学生的座位号。如果学生的数量是奇数，则最后一个学生的id不交换。
-- 按 id 升序 返回结果表。
-- 查询结果格式如下所示。
--
--
--
-- 示例 1:
-- 输入:
-- Seat 表:
-- +----+---------+
-- | id | student |
-- +----+---------+
-- | 1  | Abbot   |
-- | 2  | Doris   |
-- | 3  | Emerson |
-- | 4  | Green   |
-- | 5  | Jeames  |
-- +----+---------+
-- 输出:
-- +----+---------+
-- | id | student |
-- +----+---------+
-- | 1  | Doris   |
-- | 2  | Abbot   |
-- | 3  | Green   |
-- | 4  | Emerson |
-- | 5  | Jeames  |
-- +----+---------+
-- 解释:
-- 请注意，如果学生人数为奇数，则不需要更换最后一名学生的座位。
-- 解：逆向思维：交换id，奇数就是id+1，偶数id-1，最后一个id不变
select (case
            when mod(id, 2) = 1 and id = (select count(*) from Seat) then id -- 最后一个数
            when mod(id, 2) = 1 then id + 1 -- 奇数
            else id - 1 -- 偶数
    end) id,
       student
from Seat
order by id










