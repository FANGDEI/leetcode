-- Row_Number 开窗函数是 SQL 中的一种用于为查询结果集中的每一行 分配唯一连续排名 的开窗函数。
--
-- 它与之前讲到的 Rank 函数，Row_Number 函数为每一行都分配一个唯一的整数值，不管是否存在并列（相同排序值）的情况。每一行都有一个唯一的行号，从 1 开始连续递增。
-- 题目
-- 假设有一个学生表 student，包含以下字段：id（学号）、name（姓名）、age（年龄）、score（分数）、class_id（班级编号）。
--
-- 请你编写一个 SQL 查询，返回每个学生的详细信息（字段顺序和原始表的字段顺序一致），并且按照分数降序的方式给每个班级内的学生分配一个编号（row_number）。

SELECT id,
       name,
       age,
       score,
       class_id,
       ROW_NUMBER() OVER (PARTITION BY class_id order by score desc) AS row_number
FROM student;
