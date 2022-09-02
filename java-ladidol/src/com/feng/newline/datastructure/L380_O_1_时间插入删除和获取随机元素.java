package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L380_O_1_时间插入删除和获取随机元素
 * @author: Ladidol
 * @description: 实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * 示例：
 * <p>
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 *105 次
 * 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
 * @date: 2022/9/2 14:47
 * @version: 1.0
 */
public class L380_O_1_时间插入删除和获取随机元素 {
    // insert 操作：使用哈希表判断 val 是否存在，存在的话返回 false，否则将其添加到 nums，更新 idx，同时更新哈希表；
    //remove 操作：使用哈希表判断 val 是否存在，不存在的话返回 false，否则从哈希表中将 val 删除，同时取出其所在 nums 的下标 loc，然后将 nums[idx] 赋值到 loc 位置，并更新 idx（含义为将原本处于 loc 位置的元素删除），同时更新原本位于 idx 位置的数在哈希表中的值为 loc（若 loc 与 idx 相等，说明删除的是最后一个元素，这一步可跳过）；
    //getRandom 操作：由于我们人为确保了 [0, idx][0,idx] 均为存活值，因此直接在 [0, idx + 1)[0,idx+1) 范围内进行随机即可。
    class RandomizedSet {

        // 主要操作是 哈希表和数组的0（1）查询操作。对数组中元素的删除操作。index表示最后一个有效元素的角标同时表示数组的有效长度
        int[] array;
        Map<Integer, Integer> map;
        int index = -1;
        Random random = new Random();

        public RandomizedSet() {
            array = new int[200005];
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, ++index);
            array[index] = val;
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int i = map.remove(val); // map的remove可以返回当前删除key的value值
            if (i!=index) map.put(array[index], i);// 末位不等于刚刚删除的元素，更新末尾元素的角标
            array[i] = array[index];//把末尾的给放过来。
            index--;
            return true;
        }

        public int getRandom() {
            int ranInt = random.nextInt(index + 1);// 数组大小的随机数
            return array[ranInt];
        }
    }
}
