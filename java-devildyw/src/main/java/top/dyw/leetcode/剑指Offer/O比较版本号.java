package top.dyw.leetcode.剑指Offer;

/**
 * 项目发布项目版本时会有版本号，比如1.02.11，2.14.4等等
 * <p>
 * 现在给你2个版本号version1和version2，请你比较他们的大小
 * <p>
 * 版本号是由修订号组成，修订号与修订号之间由一个"."连接。1个修订号可能有多位数字组成，修订号可能包含前导0，且是合法的。例如，1.02.11，0.1，0.2都是合法的版本号
 * <p>
 * 每个版本号至少包含1个修订号。
 * <p>
 * 修订号从左到右编号，下标从0开始，最左边的修订号下标为0，下一个修订号下标为1，以此类推。
 * <p>
 * **比较规则：**
 * <p>
 * 一. 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较忽略任何前导零后的整数值。比如"0.1"和"0.01"的版本号是相等的
 * <p>
 * 二. 如果版本号没有指定某个下标处的修订号，则该修订号视为0。例如，"1.1"的版本号小于"1.1.1"。因为"1.1"的版本号相当于"1.1.0"，第3位修订号的下标为0，小于1
 * <p>
 * 三. version1 > version2 返回1，如果 version1 < version2 返回-1，不然返回0.
 * <p>
 * **数据范围：**
 * <p>
 * 1<=`version1.length` , `version2.length` <=1000
 * <p>
 * version1 和 version2 的修订号不会超过int的表达范围，即不超过 **32 位整数** 的范围
 * <p>
 * 进阶： 空间复杂度 O(1)， 时间复杂度 O(n)
 *
 * @author Devil
 * @since 2022-10-18-11:09
 */
@SuppressWarnings("all")
public class O比较版本号 {

    public static void main(String[] args) {
        String version1 = "2.0.1";
        String version2 = "2";
        O比较版本号 solution = new O比较版本号();
        System.out.println(solution.compare(version1, version2));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * O比较版本号
     *
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        for (int i = 0;i<nums1.length||i<nums2.length;i++){
            int x=0,y=0;
            if (i< nums1.length){
                x = Integer.parseInt(nums1[i]);
            }
            if (i< nums2.length){
                x = Integer.parseInt(nums2[i]);
            }

            if (x>y){
                return 1;
            }
            if (y<x){
                return -1;
            }
        }
        return 0;
    }

}
