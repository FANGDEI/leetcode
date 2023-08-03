-- Table: Transactions
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | id            | int     |
-- | country       | varchar |
-- | state         | enum    |
-- | amount        | int     |
-- | trans_date    | date    |
-- +---------------+---------+
-- id 是这个表的主键。
-- 该表包含有关传入事务的信息。
-- state 列类型为 “[”批准“，”拒绝“] 之一。
--
--
-- 编写一个 sql 查询来查找每个月和每个国家/地区的事务数及其总金额、已批准的事务数及其总金额。
--
-- 以 任意顺序 返回结果表。
--
-- 查询结果格式如下所示。
--
--
--
-- 示例 1:
--
-- 输入：
-- Transactions table:
-- +------+---------+----------+--------+------------+
-- | id   | country | state    | amount | trans_date |
-- +------+---------+----------+--------+------------+
-- | 121  | US      | approved | 1000   | 2018-12-18 |
-- | 122  | US      | declined | 2000   | 2018-12-19 |
-- | 123  | US      | approved | 2000   | 2019-01-01 |
-- | 124  | DE      | approved | 2000   | 2019-01-07 |
-- +------+---------+----------+--------+------------+
-- 输出：
-- +----------+---------+-------------+----------------+--------------------+-----------------------+
-- | month    | country | trans_count | approved_count | trans_total_amount | approved_total_amount |
-- +----------+---------+-------------+----------------+--------------------+-----------------------+
-- | 2018-12  | US      | 2           | 1              | 3000               | 1000                  |
-- | 2019-01  | US      | 1           | 1              | 2000               | 2000                  |
-- | 2019-01  | DE      | 1           | 1              | 2000               | 2000                  |
-- +----------+---------+-------------+----------------+--------------------+-----------------------+


-- 解：一个对count和if理解到位的题，同时对日期格式化有了解
select DATE_FORMAT(trans_date, '%Y-%m') month, -- 也可以使用left函数截取前面七个字符left(trans_date,7) month,
       country,
       count(state)                           trans_count,
       count(if(state = 'approved', 1, null)) approved_count,
       sum(amount)                            trans_total_amount,
       sum(if(state = 'approved', amount, 0)) approved_total_amount
from Transactions
group by month, country


