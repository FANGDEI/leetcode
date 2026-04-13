package top.dyw.write_exam.bytedance;

import java.util.Arrays;

/**
 * 题意：
 * 给定一个数字数组 nums，数组中的每个元素都可以被重复使用。
 * 再给定一个正整数 N。
 *
 * 目标：
 * 1. 用 nums 中的数字拼接出一个整数
 * 2. 这个整数必须严格小于 N
 * 3. 在满足小于 N 的前提下，结果尽可能大
 * 4. 如果无法构造，返回 -1
 *
 * 实现思路分成两步：
 *
 * 第一部分：优先尝试构造“和 N 位数相同”的答案
 * 因为同位数的整数一定比更短位数的整数更有机会更大，
 * 所以只要能构造出一个与 N 同位数、且严格小于 N 的数字，
 * 它一定优于所有更短位数的候选值。
 *
 * 第二部分：如果同位数完全构造不出来，再退而求其次，
 * 构造一个“位数比 N 少 1”的最大值。
 * 这个值的构造就很直接：
 * - 第一位放“最大的非 0 数字”，避免前导 0
 * - 后面每一位都放“整个集合中的最大数字”
 *
 * 例如：
 * nums = [2,4,9], N = 23121
 * 先尝试同位数：
 * - 第 1 位最多放 2，可以放 2，继续比较下一位
 * - 第 2 位 N 是 3，可选里没有 3，但有 2 小于 3
 *   那么答案前缀确定为 22，后面全部补最大数字 9
 * - 得到 22999
 */
public class B02构造小于N的最大值 {

    public static void main(String[] args) {
        System.out.println(maxNums(new int[]{2, 4, 9}, 23121));
        System.out.println(maxNums(new int[]{1, 2, 4, 9}, 2533));
        System.out.println(maxNums(new int[]{0}, 1));
        System.out.println(maxNums(new int[]{7}, 7));
    }

    /**
     * 对外主入口。
     *
     * 整体流程：
     * 1. 先做输入合法性判断
     * 2. 把 nums 规范化成 [0..9] 范围内、去重后、升序排列的数字集合
     * 3. 先尝试构造“和 N 同位数”的最优解
     * 4. 如果同位数无解，再构造“位数更短”的最优解
     *
     * 为什么先做同位数？
     * 因为在十进制下，只要能构造出一个合法的同位数结果，
     * 它一定比任何更短位数的正整数都大。
     *
     * @param nums 可重复使用的数字集合，理论上应为 0~9
     * @param n    上界，结果必须严格小于它
     * @return 小于 n 的最大可构造整数；如果完全无法构造，返回 -1
     */
    public static int maxNums(int[] nums, int n) {
        if (nums == null || nums.length == 0 || n <= 0) {
            return -1;
        }

        // 过滤非法数字、去重，并保证结果升序。
        // 后续很多逻辑都依赖“digits 已经有序”这一前提。
        Arrays.sort(nums);
        int[] digits = nums;

        // 把 N 转成字符数组，便于按“每一位”逐位比较。
        char[] target = String.valueOf(n).toCharArray();

        // 优先尝试构造与 N 等长的答案。
        // 如果返回非 null，说明已经找到一个严格小于 N 的最优解。
        String sameLengthAnswer = buildSameLengthAnswer(digits, target, 0);
        if (sameLengthAnswer != null) {
            return Integer.parseInt(sameLengthAnswer);
        }

        // 同长度无解时，只能退化到更短位数。
        return buildShorterLengthAnswer(digits, target.length);
    }

    /**
     * 将原始 nums 处理成“可直接参与构造”的数字数组。
     *
     * 这里做了三件事：
     * 1. 忽略不在 0~9 范围内的非法值
     * 2. 去重，因为某个数字是否能用，和它在 nums 中出现几次无关
     * 3. 按从小到大输出，方便后续：
     *    - 需要最大数字时，直接取最后一个
     *    - 需要从大到小试探时，倒序遍历即可
     *
     * @param nums 原始输入
     * @return 升序且去重后的可用数字
     */
    private static int[] buildSortedUniqueDigits(int[] nums) {
        boolean[] visited = new boolean[10];
        int count = 0;

        for (int num : nums) {
            if (num < 0 || num > 9 || visited[num]) {
                continue;
            }
            visited[num] = true;
            count++;
        }

        int[] digits = new int[count];
        int index = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                digits[index++] = i;
            }
        }

        return digits;
    }

    /**
     * 递归构造一个“与 target 等长、并且严格小于 target”的最大字符串。
     *
     * 这个方法是整题的核心。
     *
     * 含义：
     * - index 表示当前正在处理第几位
     * - 返回值：
     *   1. 返回非 null：表示从 index 开始可以构造出合法答案
     *   2. 返回 null：表示当前前缀走不通，需要回退并尝试更小的数字
     *
     * 关键策略：
     * - 当前位优先尝试更大的数字，因为我们要整体结果尽可能大
     * - 但当前位不能超过 target 对应位
     * - 如果当前位放了一个“严格小于 target 当前位”的数字，
     *   那么后面的所有位都已经不再受上界约束，
     *   直接全部补成最大数字即可，这是当前前缀下的最优选择
     * - 如果当前位刚好等于 target 当前位，
     *   那么后面仍然必须继续受约束，递归处理下一位
     *
     * 为什么最后一位等于 target 的时候要 continue？
     * 因为题目要求“严格小于 N”，不是“小于等于 N”。
     * 如果一路都完全相等，到了最后一位也相等，
     * 那么构造出来的数就是 N 本身，这是不合法的。
     *
     * @param digits 可用数字，升序
     * @param target N 的字符数组表示
     * @param index  当前处理到的位下标
     * @return 从当前位开始构造出的最优后缀；若无解则返回 null
     */
    private static String buildSameLengthAnswer(int[] digits, char[] target, int index) {
        if (index == target.length) {
            return "";
        }

        int limit = target[index] - '0';
        //倒序遍历，保证优先尝试更大的数字
        for (int i=digits.length-1; i>=0; i--) {
            int current = digits[i];

            if (index==0 && target.length>1 && current==0) {
                continue;
            }

            if (current > limit) {
                continue;
            }

            if (current < limit) {
                return current + buildMaxSuffix(digits, target.length-index-1);
            }

            String suffix = buildSameLengthAnswer(digits, target, index+1);
            if (suffix!=null) {
                if (index == target.length-1) {
                    continue;
                }

                return current + suffix;
            }
        }

        // 当前位所有候选数字都试过了，仍然无法构造出合法解。
        // 返回 null，让上层回退。
        return null;
    }

    /**
     * 构造一个长度为 length 的“最大后缀”。
     *
     * 使用场景：
     * 当某一位已经确定“严格小于 target 对应位”后，
     * 后面的位就不再受约束，为了让结果尽可能大，
     * 直接把剩余每一位都填成可用集合中的最大数字。
     *
     * @param digits  升序数字集合
     * @param length  需要补出的后缀长度
     * @return 最大后缀字符串
     */
    private static String buildMaxSuffix(int[] digits, int length) {
        if (length <= 0) {
            return "";
        }

        int maxDigit = digits[digits.length - 1];
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(maxDigit);
        }
        return builder.toString();
    }

    /**
     * 当“与 N 同位数”的结果完全构造不出来时，
     * 退而求其次，构造一个“位数更短”的最大值。
     *
     * 为什么一定是 nLength - 1？
     * 因为比 N 少 1 位的数，一定小于 N；
     * 并且在所有更短位数中，位数越长数值越大，
     * 所以只需要考虑“少 1 位”这一种情况即可。
     *
     * 构造规则：
     * - 第一位必须是最大的非 0 数字，避免前导 0
     * - 后续位全部填最大数字
     *
     * 边界：
     * - 如果 N 本身只有 1 位，那么不存在“更短的正整数位数方案”
     *   此时只有当可用数字里包含 0 时，才能返回 0
     * - 如果所有可用数字都是 0，那么无论 N 有多少位，
     *   唯一能构造出来的整数都只有 0
     *
     * @param digits  升序数字集合
     * @param nLength N 的位数
     * @return 更短位数下的最大可行值
     */
    private static int buildShorterLengthAnswer(int[] digits, int nLength) {
        // N 是一位数时，更短位数只可能是 0 位，不成立。
        // 这时唯一可能的合法结果只有 0。
        if (nLength == 1) {
            return digits[0] == 0 ? 0 : -1;
        }

        int maxDigit = digits[digits.length - 1];
        int maxNonZeroDigit = -1;

        // 从大到小找最大的非 0 数字，作为最高位。
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 0) {
                maxNonZeroDigit = digits[i];
                break;
            }
        }

        // 说明整个集合里只有 0，那么唯一能拼出来的整数就是 0。
        if (maxNonZeroDigit == -1) {
            return 0;
        }

        StringBuilder builder = new StringBuilder(nLength - 1);
        builder.append(maxNonZeroDigit);

        // 剩余每一位都补成最大数字，使整体数值最大。
        for (int i = 1; i < nLength - 1; i++) {
            builder.append(maxDigit);
        }

        return Integer.parseInt(builder.toString());
    }
}
