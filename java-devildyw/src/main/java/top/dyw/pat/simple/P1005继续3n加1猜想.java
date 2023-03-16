package top.dyw.pat.simple;

import java.util.*;

/**
 * @author Devil
 * @since 2022-10-08-12:18
 */
public class P1005继续3n加1猜想 {

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int[] array = new int[n];
        int[] hash = new int[5000];
        for (int i = 0; i < n; i++) {
            int num = input.nextInt();
            array[i] = num;
            //hash表中是否该数字对应为 1 为1表示该数已经被访问了 就不参加计算 如果没有则代表还没有
            if (hash[num]!=1){
                //P1001 计算
                while (num!=1){
                    if (num%2==0){
                        num = num/2;
                    }else{
                        num = (3*num+1)/2;
                    }
                    //如果计算结果在 hash表中出现那么跳出循环
                    if (hash[num]==1) break;
                    //如果没有 则将该位置的hash值设置为1
                    hash[num] = 1;
                }
            }
        }
        //最后将那些在数组中出现却在hash表中的值为 1 的值存储list中 因为这些值都是未被其他值所覆盖的值
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (hash[array[i]]==0){
                list.add(array[i]);
            }
        }

        //排序 翻转
        Collections.sort(list, ((o1, o2) -> {
            return o2-o1;
        }));
        for (int i = 0; i < list.size(); i++) {
            if (i!=0){
                System.out.print(" ");
            }
            System.out.print(list.get(i));
        }


    }


}
