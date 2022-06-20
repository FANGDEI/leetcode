

[ SQL 经典 50 题_执笔苦行僧的博客-CSDN博客_sql经典50题](https://blog.csdn.net/qq_43580193/article/details/110727554?utm_source=app&app_version=5.3.1&code=app_1562916241&uLinkId=usr1mkqgl919blen)


## 建库建表sql
```sql
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course`  (
  `C` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Cname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `T` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Course
-- ----------------------------
INSERT INTO `Course` VALUES ('01', '语文', '02');
INSERT INTO `Course` VALUES ('02', '数学', '01');
INSERT INTO `Course` VALUES ('03', '英语', '03');

-- ----------------------------
-- Table structure for SC
-- ----------------------------
DROP TABLE IF EXISTS `SC`;
CREATE TABLE `SC`  (
  `S` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `C` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` decimal(18, 1) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of SC
-- ----------------------------
INSERT INTO `SC` VALUES ('01', '01', 80.0);
INSERT INTO `SC` VALUES ('01', '02', 90.0);
INSERT INTO `SC` VALUES ('01', '03', 99.0);
INSERT INTO `SC` VALUES ('02', '01', 70.0);
INSERT INTO `SC` VALUES ('02', '02', 60.0);
INSERT INTO `SC` VALUES ('02', '03', 80.0);
INSERT INTO `SC` VALUES ('03', '01', 80.0);
INSERT INTO `SC` VALUES ('03', '02', 80.0);
INSERT INTO `SC` VALUES ('03', '03', 80.0);
INSERT INTO `SC` VALUES ('04', '01', 50.0);
INSERT INTO `SC` VALUES ('04', '02', 30.0);
INSERT INTO `SC` VALUES ('04', '03', 20.0);
INSERT INTO `SC` VALUES ('05', '01', 76.0);
INSERT INTO `SC` VALUES ('05', '02', 87.0);
INSERT INTO `SC` VALUES ('06', '01', 31.0);
INSERT INTO `SC` VALUES ('06', '03', 34.0);
INSERT INTO `SC` VALUES ('07', '02', 89.0);
INSERT INTO `SC` VALUES ('07', '03', 98.0);
INSERT INTO `SC` VALUES ('07', '04', 94.0);

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student`  (
  `S` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Sname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Sage` datetime(0) NULL DEFAULT NULL,
  `Ssex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Student
-- ----------------------------
INSERT INTO `Student` VALUES ('01', '赵雷', '1990-01-01 00:00:00', '男');
INSERT INTO `Student` VALUES ('02', '钱电', '1990-12-21 00:00:00', '男');
INSERT INTO `Student` VALUES ('03', '孙风', '1990-05-20 00:00:00', '男');
INSERT INTO `Student` VALUES ('04', '李云', '1990-08-06 00:00:00', '男');
INSERT INTO `Student` VALUES ('05', '周梅', '1991-12-01 00:00:00', '女');
INSERT INTO `Student` VALUES ('06', '吴兰', '1992-03-01 00:00:00', '女');
INSERT INTO `Student` VALUES ('07', '郑竹', '1989-07-01 00:00:00', '女');
INSERT INTO `Student` VALUES ('08', '王菊', '1990-01-20 00:00:00', '女');

-- ----------------------------
-- Table structure for Teacher
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher`  (
  `T` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Tname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
INSERT INTO `Teacher` VALUES ('01', '张三');
INSERT INTO `Teacher` VALUES ('02', '李四');
INSERT INTO `Teacher` VALUES ('03', '王五');

SET FOREIGN_KEY_CHECKS = 1;

```

## 题目
五十个问题:
1. 查询" 01 “课程比” 02 "课程成绩高的学生的信息及课程分数
2. 查询同时存在" 01 “课程和” 02 "课程的情况
3. 查询存在" 01 “课程但可能不存在” 02 "课程的情况(不存在时显示为 null )
4. 查询不存在" 01 “课程但存在” 02 "课程的情况
5. 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩
6. 查询在 SC 表存在成绩的学生信息
7. 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )
8. 查询「李」姓老师的数量
9. 查询学过「张三」老师授课的同学的信息
10. 查询没有学全所有课程的同学的信息
11. 查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息
12. 查询和" 01 "号的同学学习的课程完全相同的其他同学的信息
13. 查询没学过"张三"老师讲授的任一门课程的学生姓名
14. 查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
15. 检索" 01 "课程分数小于 60，按分数降序排列的学生信息
16. 按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
17. 查询各科成绩最高分、最低分和平均分：以如下形式显示：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
    及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
    要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
18. 按各科成绩进行排序，并显示排名， Score 重复时保留名次空缺
19. 按各科成绩进行排序，并显示排名， Score 重复时合并名次
20. 查询学生的总成绩，并进行排名，总分重复时保留名次空缺
21. 查询学生的总成绩，并进行排名，总分重复时不保留名次空缺
22. 统计各科成绩各分数段人数：课程编号，课程名称，[100-85]，[85-70]，[70-60]，[60-0] 及所占百分比
23. 查询各科成绩前三名的记录
24. 查询每门课程被选修的学生数
25. 查询出只选修两门课程的学生学号和姓名
26. 查询男生、女生人数
27. 查询名字中含有「风」字的学生信息
28. 查询同名同性学生名单，并统计同名人数
29. 查询 1990 年出生的学生名单
30. 查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列
31. 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩
32. 查询课程名称为「数学」，且分数低于 60 的学生姓名和分数
33. 查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）
34. 查询任何一门课程成绩在 70 分以上的姓名、课程名称和分数
35. 查询不及格的课程
36. 查询课程编号为 01 且课程成绩在 80 分以上的学生的学号和姓名
37. 求每门课程的学生人数
38. 成绩不重复，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩
39. 成绩有重复的情况下，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩
40. 查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩
41. 查询每门功成绩最好的前两名
42. 统计每门课程的学生选修人数（超过 5 人的课程才统计）。
43. 检索至少选修两门课程的学生学号
44. 查询选修了全部课程的学生信息
45. 查询各学生的年龄，只按年份来算
46. 按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一
47. 查询本周过生日的学生
48. 查询下周过生日的学生
49. 查询本月过生日的学生
50. 查询下月过生日的学生



## 一些小链接:

[SQL之CASE WHEN用法详解_涛声依旧叭的博客-CSDN博客_case when](https://blog.csdn.net/rongtaoup/article/details/82183743)
[SQL使用using关键字详解_shadow_zed的博客-CSDN博客_sql using](https://blog.csdn.net/shadow_zed/article/details/89083383)
