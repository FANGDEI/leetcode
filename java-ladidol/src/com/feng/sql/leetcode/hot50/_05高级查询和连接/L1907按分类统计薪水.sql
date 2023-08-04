-- 表: Accounts
--
-- +-------------+------+
-- | 列名        | 类型  |
-- +-------------+------+
-- | account_id  | int  |
-- | income      | int  |
-- +-------------+------+
-- 在 SQL 中，account_id 是这个表的主键。
-- 每一行都包含一个银行帐户的月收入的信息。
--
--
-- 查询每个工资类别的银行账户数量。 工资类别如下：
--
-- "Low Salary"：所有工资 严格低于 20000 美元。
-- "Average Salary"： 包含 范围内的所有工资 [$20000, $50000] 。
-- "High Salary"：所有工资 严格大于 50000 美元。
--
-- 结果表 必须 包含所有三个类别。 如果某个类别中没有帐户，则报告 0 。
--
-- 按 任意顺序 返回结果表。
--
-- 查询结果格式如下示例。
--
--
--
-- 示例 1：
--
-- 输入：
-- Accounts 表:
-- +------------+--------+
-- | account_id | income |
-- +------------+--------+
-- | 3          | 108939 |
-- | 2          | 12747  |
-- | 8          | 87709  |
-- | 6          | 91796  |
-- +------------+--------+
-- 输出：
-- +----------------+----------------+
-- | category       | accounts_count |
-- +----------------+----------------+
-- | Low Salary     | 1              |
-- | Average Salary | 0              |
-- | High Salary    | 3              |
-- +----------------+----------------+
-- 解释：
-- 低薪: 数量为 2.
-- 中等薪水: 没有.
-- 高薪: 有三个账户，他们是 3, 6和 8.

-- 解：用union（用group by + case when then，会有出现分类不为三个的情况）
select 'Low Salary' category, count(*) accounts_count from Accounts where income<20000
union
select 'Average Salary' category,count(*) accounts_count from Accounts where income between 20000 and 50000
union
select 'High Salary' category,count(*) accounts_count from Accounts where income>50000


--group by 1的解释:  GROUP BY子句中的列可以通过它们的位置索引来引用。在这种情况下，GROUP BY 1表示使用结果集中的第一个列进行分组。类似地，GROUP BY 2表示使用结果集中的第二个列进行分组，以此类推。以下是一个示例，说明GROUP BY 1的使用：
-- 一个大佬的答案，嘤嘤嘤真屌
    with t as(
    select 'Low Salary' category
    union
    select 'Average Salary'
    union
    select 'High Salary'
)
select
    t.category, ifnull(a.cnt,0) accounts_count
from
    t
        left join
    (
        select
            case when income  < 20000 then 'Low Salary'
                 when income  > 50000 then 'High Salary'
                 else 'Average Salary' end as category,
            count(1) as cnt
        from
            Accounts
        group by 1
    ) a
    on
            t.category = a.category

