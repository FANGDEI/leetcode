package top.dyw.leetcode.medium.priority_queue;

import java.util.*;

/**
 * @author Devil
 * @since 2022-08-21-11:03
 * <p>
 * 给定一个数组 points，其中points[i] = [xi, yi]表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 * <p>
 * 这里，平面上两点之间的距离是欧几里德距离（√(x1- x2)2+ (y1- y2)2）。
 * <p>
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 */
@SuppressWarnings("all")
public class L973最接近原点的K个点 {
    public static void main(String[] args) {
        int[][] ints = new L973最接近原点的K个点().kClosest(new int[][]{{3, 3}, {5, -1},{-2,4}}, 2);
        for (int[] anInt : ints) {
            System.out.println(anInt[0]+" "+ anInt[1]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        HashMap<int[], Double> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point,Math.sqrt(Math.pow(point[0]-0,2)+Math.pow(point[1]-0,2)));
        }
        int[][] ints = new int[points.length][2];
        int index = 0;
        Iterator<Map.Entry<int[], Double>> iterator = map.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(entry -> entry.getValue()))
                .limit(k).iterator();
        while (iterator.hasNext()) {
            Map.Entry<int[], Double> next = iterator.next();
            ints[index++] = next.getKey();
//            System.out.println(next.getKey()[0]+","+next.getKey()[1]+" "+next.getValue());
        }

        return Arrays.copyOfRange(ints,0,index);
    }
}
