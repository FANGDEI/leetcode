package top.dyw.leetcode.周赛.第322周;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-12-04-11:20
 */
@SuppressWarnings("all")
public class L6254划分技能点相等的团队 {

    public static void main(String[] args) {
        System.out.println(new L6254划分技能点相等的团队().dividePlayers(new int[]{10,14,16,15,9,4,4,4}));
    }

    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int sum = 0;
        int groupNum = n/2;
        for (int i : skill) {
            sum+=i;
        }

        System.out.println(sum);
        if(sum%groupNum!=0){
            return -1L;
        }
        int target = sum/groupNum;
        long result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < skill.length; i++) {
            if (target-skill[i]<=0){
                return -1L;
            }else{
                if (map.containsKey(target-skill[i])){
                    arrayList.add(new int[]{target-skill[i],skill[i]});
                    if (map.get(target-skill[i])-1==0){
                        map.remove(target-skill[i]);
                    }else{
                        map.put(target-skill[i],map.get(target-skill[i])-1);
                    }
                }else{
                    map.put(skill[i],map.getOrDefault(skill[i],0)+1);
                }
            }
        }

        if (arrayList.size()<groupNum){
            return -1L;
        }

        for (int[] ints : arrayList) {
            result += ints[0]*ints[1];
        }

        return result;
    }
}
