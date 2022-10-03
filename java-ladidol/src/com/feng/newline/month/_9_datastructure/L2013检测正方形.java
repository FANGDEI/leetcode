package com.feng.newline.month._9_datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L2013检测正方形
 * @author: Ladidol
 * @description: 给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：
 * 添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
 * 给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
 * 轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。
 * 实现 DetectSquares 类：
 * DetectSquares() 使用空数据结构初始化对象
 * void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
 * int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。
 * 示例：
 * 输入：
 * ["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
 * [[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
 * 输出：
 * [null, null, null, null, 1, 0, null, 2]
 * <p>
 * 解释：
 * DetectSquares detectSquares = new DetectSquares();
 * detectSquares.add([3, 10]);
 * detectSquares.add([11, 2]);
 * detectSquares.add([3, 2]);
 * detectSquares.count([11, 10]); // 返回 1 。你可以选择：
 * //   - 第一个，第二个，和第三个点
 * detectSquares.count([14, 8]);  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
 * detectSquares.add([11, 2]);    // 允许添加重复的点。
 * detectSquares.count([11, 10]); // 返回 2 。你可以选择：
 * //   - 第一个，第二个，和第三个点
 * //   - 第一个，第三个，和第四个点
 * @date: 2022/9/2 16:15
 * @version: 1.0 做吐了！
 */
public class L2013检测正方形 {
    // 对于 add 操作，我们可以使用「哈希表 套 哈希表」的方式，以 {x, {y : 点 (x,y) 数量}} 的形式对传入点进行存储。
    // 对于 count 查询而言，假定传入的点为 (x, y)，我们可以先查询 x 行都有哪些列，枚举这些列（ 即枚举点 (x, ny) ），由 y 和 n 可得正方形边长 len，
    // 此时再检查唯一确定的两点 (x±len,y) 和 (x±len,ny) 的出现次数，应用乘法原理，即可知道该正方形的方案数，统计所有合法方案数即是该询问的答案。

    // 可以重复添加点。
    class DetectSquares {// 哈希表套哈希表。
        Map<Integer, Map<Integer, Integer>> rowToCol = new HashMap<>();


        public void add(int[] point) {//我们通过一个x对应多个y来写,一个y对应点(x,y)数量
            int x = point[0], y = point[1];
            Map<Integer, Integer> colToCount = rowToCol.getOrDefault(x, new HashMap<>());// 有对应点就直接得到map没有就新建map
            //更新内层map
            colToCount.put(y, colToCount.getOrDefault(y, 0) + 1);
            //更新外层map
            rowToCol.put(x, colToCount);
        }

        public int count(int[] point) {
            int x = point[0], y = point[1];
            int res = 0;
            //先对同一行进行遍历分析
            Map<Integer, Integer> colToCount = rowToCol.getOrDefault(x, new HashMap<>());
            for (int ny : colToCount.keySet()) {//（直线x上寻找ny）
                //排除点本身
                if (ny == y) continue;
                //判断该点有多少可以形成正方形的
                int c1 = colToCount.get(ny);//第一个点的个数（直线x与ny的交点）
                int len = y - ny;
                int[] nums = {x + len, x - len};//另两个点在上面还是下面的情况。
                for (int nx : nums) {
                    Map<Integer,Integer> tempColToCount = rowToCol.getOrDefault(nx,new HashMap<>());//nx这条水平线
                    int c2 = tempColToCount.getOrDefault(ny,0);//第二个点的个数（直线nx与ny的交点）
                    int c3 = tempColToCount.getOrDefault(y,0);//第三个点的个数（直线nx与y的交点）
                    res += c1*c2*c3;//乘法大法计数有多少个正方形
                }
            }
            return res;
        }
    }

}
