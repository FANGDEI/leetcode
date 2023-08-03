-- Customer 表：
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | customer_id | int     |
-- | product_key | int     |
-- +-------------+---------+
-- product_key 是 Customer 表的外键。
-- Product 表：
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | product_key | int     |
-- +-------------+---------+
-- product_key 是这张表的主键。
--
--
-- 写一条 SQL 查询语句，从 Customer 表中查询购买了 Product 表中所有产品的客户的 id。
--
-- 示例：
--
-- Customer 表：
-- +-------------+-------------+
-- | customer_id | product_key |
-- +-------------+-------------+
-- | 1           | 5           |
-- | 2           | 6           |
-- | 3           | 5           |
-- | 3           | 6           |
-- | 1           | 6           |
-- +-------------+-------------+
--
-- Product 表：
-- +-------------+
-- | product_key |
-- +-------------+
-- | 5           |
-- | 6           |
-- +-------------+
--
-- Result 表：
-- +-------------+
-- | customer_id |
-- +-------------+
-- | 1           |
-- | 3           |
-- +-------------+
-- 购买了所有产品（5 和 6）的客户的 id 是 1 和 3 。

SELECT customer_id
FROM Customer a
group by customer_id
having count(distinct product_key) = (SELECT count(*)
                                      FROM Product)

-- 窗口函数，但是没必要
select
    customer_id
from
    (select row_number() over(partition by customer_id) as counts,customer_id
     from Customer group by customer_id, product_key) t
where counts = (select count(1) from Product)










