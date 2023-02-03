package com.feng.draft.垃;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author Ladidol
 * @Date: 2022/3/25 15:00
 * @Version 1.0
 */
public class L70爬楼梯 {
    public static void main(String[] args) {
        System.out.println("爬十阶楼梯有 " + new 爬楼梯().climbStairs(10));
    }
}
class 爬楼梯 {
    public Map<Integer, Integer> note = new HashMap<> ();
    public int climbStairs(int n) {
        if( n <= 2){
            return n;
        }
        //按这种,代表每一次分叉都会开启一次递归,有重复的递归
//        return climbStairs( n - 1) + climbStairs( n - 2);

        //按这种,代表每一个台阶都只开启一次递归
        if (note.containsKey(n)){
            return note.get(n);
        }else {
            note.put(n,climbStairs(n-1)+climbStairs(n-2));
            return note.get(n);
        }
    }
}