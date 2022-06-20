-- 1. 查询" 01 “课程比” 02 "课程成绩高的学生的信息及课程分数
-- 方法一
SELECT
    S,
    Sname,
    Sage,
    Ssex,-- 这里用sum,是因为group by 加起来合到一起咯
    SUM( CASE WHEN C = '01' THEN score ELSE NULL END ) AS Cscore1,
    SUM( CASE WHEN C = '02' THEN score ELSE NULL END ) AS Cscore2
FROM
    sc -- JOIN student  on sc.S = student.S
        JOIN student USING ( S ) -- 这里是使用USING关键字能剩一堆指代S的代码,和省略join后面的连接on条件

GROUP BY
    S,
    Sname,
    Sage,
    Ssex
HAVING
        Cscore1 > Cscore2;

-- 方法二

SELECT
    S,
    Sname,
    Sage,
    Ssex,
    Cscore1.score AS c1,
    Cscore2.score AS c2 -- 新建几个临时表来连接

FROM
    ( SELECT S, score FROM sc WHERE C = '01' ) AS Cscore1
        JOIN ( SELECT S, score FROM sc WHERE C = '02' ) AS Cscore2 USING ( S )
        JOIN student USING ( S )
WHERE
        Cscore1.score > Cscore2.score


-- 2. 查询同时存在" 01 “课程和” 02 "课程的情况

SELECT
    S,
    Sname,
    Sage,
    Ssex,
    Cscore1.score AS c1,
    Cscore2.score AS c2 -- 新建几个临时表来连接,一定不存在空的情况，子查询一样

FROM
    ( SELECT S, score FROM sc WHERE C = '01' ) AS Cscore1
        JOIN ( SELECT S, score FROM sc WHERE C = '02' ) AS Cscore2 USING ( S )
        JOIN student USING ( S )

-- 3. 查询存在" 01 “课程但可能不存在” 02 "课程的情况(不存在时显示为 null )
-- 主要注意left join和right join还有join之间有什么区别!

SELECT
    S,
    Sname,
    Sage,
    Ssex,
    Cscore1.score AS c1,
    Cscore2.score AS c2 -- 新建几个临时表来连接,一定不存在空的情况，子查询一样

FROM
    ( SELECT S, score FROM sc WHERE C = '01' ) AS Cscore1
        LEFT JOIN ( SELECT S, score FROM sc WHERE C = '02' ) AS Cscore2 USING ( S )
        JOIN student USING ( S )


-- 4. 查询不存在" 01 “课程但存在” 02 "课程的情况

SELECT
    S,
    Sname,
    Sage,
    Ssex,
    Cscore1.score AS c1,
    Cscore2.score AS c2 -- 新建几个临时表来连接,一定不存在空的情况，子查询一样

FROM
    ( SELECT S, score FROM sc WHERE C = '01' ) AS Cscore1
        RIGHT JOIN ( SELECT S, score FROM sc WHERE C = '02' ) AS Cscore2 USING ( S )
        JOIN student USING ( S )
WHERE
    Cscore1.score IS NULL;



-- 5. 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩


SELECT
    S,
    Sname,
    AVG( score ) scoreavg
FROM
    sc
        JOIN student USING ( S )
GROUP BY
    S,
    Sname
HAVING
        scoreavg > 60






