-- 在 SQL 中，开窗函数是一种强大的查询工具，它允许我们在查询中进行对分组数据进行计算、 同时保留原始行的详细信息 。
--
-- 开窗函数可以与聚合函数（如 SUM、AVG、COUNT 等）结合使用，但与普通聚合函数不同，开窗函数不会导致结果集的行数减少。
--
-- 打个比方，可以将开窗函数想象成一种 "透视镜"，它能够将我们聚焦在某个特定的分组，同时还能看到整体的全景。
--
-- 本节我们先讲第一个开窗函数：sum over。
--
-- 该函数用法为：
--
-- SUM(计算字段名) OVER (PARTITION BY 分组字段名)
-- 示例
-- 假设我们有订单表 orders，表格数据如下：
--
-- order_id	customer_id	order_date	total_amount
-- 1	101	2023-01-01	200
-- 2	102	2023-01-05	350
-- 3	101	2023-01-10	120
-- 4	103	2023-01-15	500
-- 现在，我们希望计算每个客户的订单总金额，并显示每个订单的详细信息。
--
-- 示例 SQL 如下：
--
-- SELECT
--     order_id,
--     customer_id,
--     order_date,
--     total_amount,
--     SUM(total_amount) OVER (PARTITION BY customer_id) AS customer_total_amount
-- FROM
--     orders;
-- 查询结果：
--
-- order_id	customer_id	order_date	total_amount	customer_total_amount
-- 1	101	2023-01-01	200	320
-- 3	101	2023-01-10	120	320
-- 2	102	2023-01-05	350	350
-- 4	103	2023-01-15	500	500
-- 在上面的示例中，我们使用开窗函数 SUM 来计算每个客户的订单总金额（customer_total_amount），并使用 PARTITION BY 子句按照customer_id 进行分组。从前两行可以看到，开窗函数保留了原始订单的详细信息，同时计算了每个客户的订单总金额。
--
-- 题目
-- 假设有一个学生表 student，包含以下字段：id（学号）、name（姓名）、age（年龄）、score（分数）、class_id（班级编号）。
--
-- 请你编写一个 SQL 查询，返回每个学生的详细信息（字段顺序和原始表的字段顺序一致），并计算每个班级的学生平均分（class_avg_score）。
--
SELECT id,
       name,
       age,
       class_id,
       score,
       AVG(score) OVER (PARTITION BY class_id) AS class_avg_score
FROM student;




















