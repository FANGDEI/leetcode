-- 题目
-- 假设有一个学生表 student，包含以下字段：id（学号）、name（姓名）、age（年龄）、score（分数）、class_id（班级编号）。
--
-- 请你编写一个 SQL 查询，返回每个学生的详细信息（字段顺序和原始表的字段顺序一致），并且按照分数升序的方式累加计算每个班级的学生总分（class_sum_score）。
SELECT id,
       name,
       age,
       score,
       class_id,
       SUM(score) OVER (PARTITION BY class_id order by score) AS class_sum_score
FROM student;


