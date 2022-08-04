package com.dyw.leetcode.simple.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Devil
 * @date 2022-05-21-14:36
 * <p>
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，
 * 每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。
 * 你可以假设答案总是存在。
 */
@SuppressWarnings("all")
public class L599两个列表的最小索引总和 {
    public static void main(String[] args) {
        new L599两个列表的最小索引总和().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"});
    }

    /**
     * 笨方法
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                map1.put(list2[i], i + map.get(list2[i]));
            }
        }
        int min = Integer.MAX_VALUE;
        for (String string : map1.keySet()) {
            Integer index = map1.get(string);
            if (index < min) {
                min = index;
            }
        }
        String[] strings = new String[list1.length];
        int k = 0;
        for (String string : map1.keySet()) {
            Integer index = map1.get(string);
            if (index == min) {
                strings[k++] = string;
            }
        }

        return Arrays.copyOfRange(strings, 0, k);
    }

    public String[] findRestaurant01(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        //结果集
        ArrayList<String> result = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            //遍历list2 判断map中是否有list2[i]
            if (map.containsKey(list2[i])) {
                //若有获取对应的索引
                int j = map.get(list2[i]);
                //判断所以是否小于现在的indexSum
                if (i + j < indexSum) {
                    //小于则刷新result 并将新的索引最小值的元素add进去
                    result.clear();
                    result.add(list2[i]);
                    //更新indexSum
                    indexSum = i + j;
                }//如果i+j与index相等 那么在原来的结果集中继续添加
                else if (i + j == indexSum) {
                    result.add(list2[i]);
                }//如果当前索引i都大于了index 那么直接跳出循环
                else if (i > indexSum) {
                    break;
                }
            }
        }
        //result==>String[]
        return result.toArray(new String[result.size()]);

    }
}
