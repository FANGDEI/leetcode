package com.feng.newline.array;

/**
 * @author: ladidol
 * @date: 2022/10/6 10:54
 * @description: 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 * arr[0], arr[1], ..., arr[i] 为第一部分；
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，
 * 而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 * 示例 1：
 * <p>
 * 输入：arr = [1,0,1,0,1]
 * 输出：[0,3]
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,0,1,1]
 * 输出：[-1,-1]
 * 示例 3:
 * <p>
 * 输入：arr = [1,1,0,0,1]
 * [1,1,0,1,1,1,1]
 * 输出：[0,2]
 */
public class L927三等分 {


    /**
     * 参数：
     * 返回值：
     * 作者： ladidol
     * 描述：通过分成三份，从首位非零为开始来对比是不是逐个相等。
     */
    class Solution {
        public int[] threeEqualParts(int[] arr) {

            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) count++;
            }

            if (count % 3 != 0) return new int[]{-1, -1};//整除符号弄成“/”了。
            if (count == 0) return new int[]{0, arr.length - 1};
            int[] res = new int[]{0, 2};

            // 将数组划分为每部分有count/3个1。三指针，分别指向第一个出现的1
            int firstIndex = count / 3;
            int i = findOne(arr, 1), j = findOne(arr, firstIndex + 1), k = findOne(arr, firstIndex * 2 + 1);


            // 开始向后遍历，逐个判断对应指针位置上的数字是否相等，如果发现不相等，返回[-1,-1]，否则继续往下走
            for (; k < arr.length && arr[i] == arr[j] && arr[i] == arr[k]; ) {
                i++;
                j++;
                k++;
            }

            return k == arr.length ? new int[]{i - 1, j} : new int[]{-1, -1};

        }

        //找第k个1的位置。
        int findOne(int[] arr, int key) {

            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    count++;
                }
                if (count == key) return i;
            }
            return -1;
        }
    }

}