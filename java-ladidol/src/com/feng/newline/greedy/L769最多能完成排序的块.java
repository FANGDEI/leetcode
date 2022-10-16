package com.feng.newline.greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/13 20:59
 * @description: 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * 返回数组能分成的最多块数量。
 * 示例 1:
 * <p>
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 * 示例 2:
 * <p>
 * 输入: arr = [1,0,2,3,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
 * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 *  
 * <p>
 * 提示:
 * <p>
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * arr 中每个元素都 不同
 */
public class L769最多能完成排序的块 {


    //模拟栈
    class Solution1 {
        /**
         * 参数：[arr]
         * 返回值：int
         * 作者： ladidol
         * 描述：我们定义每个块所处的区间为int[] interval = [min, max]，栈顶表示当前的区块大小值，如果包含在区块中就证明在同一个区块，
         * 定义在遍历遇到比min还小的，更新栈顶的min值；如果比max还要大的，压入新栈顶。
         *
         *
         * tips：尝试做但是没有做出来的
         */
//        public int maxChunksToSorted(int[] arr) {
//            Deque<int[]> stack = new ArrayDeque<>();
//            stack.push(new int[]{arr[0], arr[0]});//不能默认自己为最大最小值。
//            for (int num : arr) {
//                int[] top = stack.peek();
//                if (top[0] > num) top[0] = num;//更新min；
//                else if (top[1] < num) stack.push(new int[]{num, num});//更新栈顶
//            }
//            for (int[] ints : stack) {
//                System.out.println("ints = " + Arrays.toString(ints));
//            }
//
//            return stack.size();
//        }
    }

    class Solution京城打工仔的做法 {//这才是栈模拟的最终实现。

        public int maxChunksToSorted(int[] arr) {
            Deque<int[]> queue = new ArrayDeque<>();
            for (int num : arr) {
                int max = num;
                int min = num;
                //处理情况一和情况二，进行块的合并，不断合并之前的，用while循环实现，就一定能确定右边不会出现最小值。
                while (!queue.isEmpty() && (queue.peekLast()[1] > num || queue.peekLast()[0] > num)) {

//                    for (int[] ints : queue) {
//                        System.out.println("num = " + num + "：");
//                        System.out.println("ints = " + Arrays.toString(ints));
//                    }

                    int[] ints = queue.pollLast();
                    max = Math.max(max, ints[1]);
                    min = Math.min(min, ints[0]);
                }
                queue.addLast(new int[]{min, max});
            }
            return queue.size();
        }
    }


    //脑筋急转弯，找规律也。
    class Solution {
        /**
         * 参数：[arr]
         * 返回值：int
         * 作者： ladidol
         * 描述：由于arr中存放的是[0, n - 1]的数字，所以当前块的max值一定是和index对应的。每次遍历到一个max == index时，我们就可以记录一个新的块。
         */
        public int maxChunksToSorted(int[] arr) {
            int ans = 0;
            int max = arr[0];

            for (int i = 0; i < arr.length; i++) {
                max = Math.max(arr[i], max);
                if (max == i) ans++;
            }
            return ans;

        }
    }


}