-- 6. 查询在 SC 表存在成绩的学生信息
-- 方法一 通过联表查询然后where条件判断!
SELECT
    S,
    Sname,
    Sage,
    Ssex
FROM
    sc
        RIGHT JOIN student USING ( S )
GROUP BY
    S,
    Sname,
    Sage,
    Ssex
HAVING
    sum( score ) IS NOT NULL

-- 方法二 通过先子查询在链表的来生成最总表
SELECT
    Student.*
FROM
    (
        SELECT S -- 这里可以查询出该有的学生id列表
        FROM SC
        GROUP BY S
        HAVING COUNT( score ) > 0 -- count(score)可以计算出有多少个score的字段每一个group里面, 字段等于null的不计入个数
        ) AS S1
        INNER JOIN Student USING ( S );

-- 7. 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )
-- 方法一
SELECT
    S,
    Sname,
    SUM( score ) fenshu,
    COUNT( score ) amount
FROM
    student
        LEFT JOIN sc USING ( S )
GROUP BY
    S,
    Sname,
    Sage,
    Ssex
-- 方法二
SELECT
    Student.Sname,
    Student.S,
    S1.amount,
    S1.total
FROM
    ( SELECT S, COUNT( C ) AS amount, SUM( score ) AS total FROM SC GROUP BY S ) AS S1
        RIGHT JOIN Student USING ( S );


-- 8. 查询「李」姓老师的数量

SELECT
    COUNT( T )
FROM
    Teacher
WHERE
        Tname LIKE '李%';



-- 9. 查询学过「张三」老师授课的同学的信息


SELECT
    Student.*
FROM
    (
        SELECT DISTINCT
            S
        FROM
            SC
                INNER JOIN ( SELECT C FROM ( SELECT T FROM Teacher WHERE Tname = '张三' ) AS T1 INNER JOIN Course USING ( T ) ) AS C1 USING ( C )
    ) AS S1
        INNER JOIN Student USING ( S );






-- 10. 查询没有学全所有课程的同学的信息

SELECT
    Student.*
FROM
    SC
        RIGHT JOIN Student USING(S)
GROUP BY
    S,
    Sname,
    Sage,
    Ssex
HAVING
        COUNT( C ) < ( SELECT COUNT(*) FROM Course );
