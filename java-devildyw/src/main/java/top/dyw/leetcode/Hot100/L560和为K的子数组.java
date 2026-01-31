class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        //初始化：前缀和为0出现过1次（处理子数组从索引0开始的情况）
        map.put(0,1);

        // preSum[i] - preSum[j] = k
        // preSum[i] - k = preSum[j]
        // 代表存在索引区间 (j, i] 的子数组和为 k
        for(int i = 0; i<nums.length; i++) {
            preSum += nums[i];

            if (map.containsKey(preSum - k)) {
                count += map.get(preSum-k);
            }

            // 同一个终点i 可能对应多个起点j 如果 p[i] - p[j] = k 如果 p[j] 的值>0 则代表 存在多个起点
            // 中间可能存在和为0的子数组导致起点存在多个
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}