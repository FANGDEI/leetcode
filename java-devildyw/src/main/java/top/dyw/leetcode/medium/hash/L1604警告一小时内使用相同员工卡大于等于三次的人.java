package top.dyw.leetcode.medium.hash;

import java.util.*;

/**
 * @author Devil
 * @since 2023-02-07-13:03
 */
@SuppressWarnings("all")
public class L1604警告一小时内使用相同员工卡大于等于三次的人 {

    public static void main(String[] args) {

    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {

        int n = keyName.length;

        ArrayList<String> result = new ArrayList<>();

        HashMap<String, List<Integer>> timeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];

            timeMap.putIfAbsent(name,new ArrayList<Integer>());
            int hour = (time.charAt(0)-'0')*10+(time.charAt(1)-'0');
            int minute = (time.charAt(3)-'0')*10+(time.charAt(4)-'0');
            timeMap.get(name).add(hour*60+minute);
        }

        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                //如果发现列表中存在三个连续元素中的最大元素与最小元素之差不超过60
                int time1 = list.get(i-2),time2 = list.get(i);
                int difference = time2-time1;
                if (difference<=60){
                    result.add(name);
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
