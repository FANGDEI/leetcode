package top.dyw.leetcode.剑指Offer;

import java.util.HashMap;

/**
 * @author Devildyw
 * @date 2023/06/01 19:40
 **/
@SuppressWarnings("all")
public class OII011_0和1个数相同的子数组 {

    public static void main(String[] args) {
        System.out.println(new OII011_0和1个数相同的子数组().findMaxLength(new int[]{0, 1, 0, 1, 0, 1}));
    }

    /**
     * 将0换为-1 这样就把题转变为求数组和为0的最长连续子数组了
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLenght = 0;
        int counter = 0;
        map.put(counter,-1); //初始化时存储的值为 (0,-1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num==1){ //为一则counter++
                counter++;
            }else{
                counter--;//为零则counter-- 模拟将0换为-1
            }
            //例如： 表示当前counter为-1 map中存在counter为-1的key时 说明map key为-1 的value(下标)到当前下表i之间的子数组满足0和1数目相同
            //因为出现了相同counter 只有可能是中间数组的0 1 个数相同才行
            if (map.containsKey(counter)){ //
                int prevIndex = map.get(counter);
                maxLenght = Math.max(maxLenght,i-prevIndex);
            }else{ //如果匹配不上值就加入 最差的情况会出现三种值已经对应的下标位置 [-1,0,1]
                map.put(counter,i);
            }
        }
        return maxLenght;
    }
}
