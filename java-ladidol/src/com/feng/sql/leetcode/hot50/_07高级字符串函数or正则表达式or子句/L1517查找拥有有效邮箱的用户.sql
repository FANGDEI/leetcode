-- 用户表： Users
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | user_id       | int     |
-- | name          | varchar |
-- | mail          | varchar |
-- +---------------+---------+
-- 在 SQL 中，user_id （用户 ID）是该表的主键。
-- 这个表包含用户在某网站上注册的信息。有些邮箱是无效的。
--
--
-- 查询拥有有效邮箱的用户。
--
-- 有效的邮箱包含符合下列条件的前缀名和域名：
--
-- 前缀名是包含字母（大写或小写）、数字、下划线 '_'、句点 '.' 和/或横杠 '-' 的字符串。前缀名必须以字母开头。
-- 域名是 '@leetcode.com' 。
-- 按任意顺序返回结果表。
--
-- 查询格式如下所示。
--
--
--
-- 示例 1：
--
-- 输入：
-- Users:
-- +---------+-----------+-------------------------+
-- | user_id | name      | mail                    |
-- +---------+-----------+-------------------------+
-- | 1       | Winston   | winston@leetcode.com    |
-- | 2       | Jonathan  | jonathanisgreat         |
-- | 3       | Annabelle | bella-@leetcode.com     |
-- | 4       | Sally     | sally.come@leetcode.com |
-- | 5       | Marwan    | quarz#2020@leetcode.com |
-- | 6       | David     | david69@gmail.com       |
-- | 7       | Shapiro   | .shapo@leetcode.com     |
-- +---------+-----------+-------------------------+
--
-- 输出：
-- +---------+-----------+-------------------------+
-- | user_id | name      | mail                    |
-- +---------+-----------+-------------------------+
-- | 1       | Winston   | winston@leetcode.com    |
-- | 3       | Annabelle | bella-@leetcode.com     |
-- | 4       | Sally     | sally.come@leetcode.com |
-- +---------+-----------+-------------------------+
-- 解释：
-- 2 号用户的邮箱没有域名。
-- 5 号用户的邮箱包含非法字符 #。
-- 6 号用户的邮箱的域名不是 leetcode。
-- 7 号用户的邮箱以句点（.）开头。
-- 解：用正则匹配
SELECT user_id, name, mail
FROM Users
WHERE mail regexp '^[a-zA-Z][a-zA-Z0-9_\\.\\-\\/]*@leetcode\\.com$'







