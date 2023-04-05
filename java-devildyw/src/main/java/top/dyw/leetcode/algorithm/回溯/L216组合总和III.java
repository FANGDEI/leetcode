package top.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字 1 到 9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * @author Devil
 * @since 2022-10-09-13:04
 */
@SuppressWarnings("all")
public class L216组合总和III {

    public static void main(String[] args) {
        System.out.println(new L216组合总和III().combinationSum3(3, 9));
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Integer sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3Helper(k, n, 1);
        return result;
    }


    /**
     * 回溯
     *
     * @param k
     * @param n
     * @param i
     */
    private void combinationSum3Helper(int k, int n, int startIndex) {

        //终止条件
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        /**
         * 剪枝操作 优化 即判断后续元素是否还能支撑是的组合的元素个数到达k
         */
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            combinationSum3Helper(k, n, i + 1);
            path.removeLast();
            sum -= i;
        }

//        for (int i = startIndex; i<=9; i++){
//            path.add(i);
//            sum+=i;
//            combinationSum3Helper(k,n,i+1);
//            path.removeLast();
//            sum-=i;
//        }

        //
    }
}
