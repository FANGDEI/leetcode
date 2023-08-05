-- RANK() OVER (
--   PARTITION BY 列名1, 列名2, ... -- 可选，用于指定分组列
--   ORDER BY 列名3 [ASC|DESC], 列名4 [ASC|DESC], ... -- 用于指定排序列及排序方式
-- ) AS rank_column
--     题目
-- 假设有一个学生表 student，包含以下字段：id（学号）、name（姓名）、age（年龄）、score（分数）、class_id（班级编号）。
--
-- 请你编写一个 SQL 查询，返回每个学生的详细信息（字段顺序和原始表的字段顺序一致），并且按照分数降序的方式计算每个班级内的学生的分数排名（ranking）。
--
-- http://sqlmother.yupi.icu/#/learn/level28

SELECT id,
       name,
       age,
       score,
       class_id,
       rank() OVER (PARTITION BY class_id order by score desc) AS ranking -- 有并列第一、并列第二的情况；会出现不连续排名的情况
FROM student;
-- 紧密排序还可以用dense_rank()


