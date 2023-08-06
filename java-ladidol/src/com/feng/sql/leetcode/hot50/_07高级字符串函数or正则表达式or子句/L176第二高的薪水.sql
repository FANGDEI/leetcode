-- Employee 表：
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | id          | int  |
-- | salary      | int  |
-- +-------------+------+
-- 在 SQL 中，id 是这个表的主键。
-- 表的每一行包含员工的工资信息。
--
--
-- 查询并返回 Employee 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null(Pandas 则返回 None) 。
--
-- 查询结果如下例所示。
--
--
--
-- 示例 1：
--
-- 输入：
-- Employee 表：
-- +----+--------+
-- | id | salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 输出：
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+
-- 示例 2：
--
-- 输入：
-- Employee 表：
-- +----+--------+
-- | id | salary |
-- +----+--------+
-- | 1  | 100    |
-- +----+--------+
-- 输出：
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | null                |
-- +---------------------+
-- 解：用窗口函数：为了避免出现输不出null的情况，这里通过构建临时表来做 注意！！！！！这里要用desc，不然又做错了。
select ifnull(
               (select distinct salary
                from (select dense_rank() over(order by salary desc) ranking ,salary
                      from Employee) a
                where ranking = 2),
               null
           ) as SecondHighestSalary -- 用as来查询




