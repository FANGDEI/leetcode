package top.dyw.write_exam.meituan.meituan_2023_3_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/03/25 19:32
 **/

/**
 * 题目描述：
 * 小美明天要去春游了。她非常喜欢吃巧克力，希望能够带尽可能多的巧克力在春游的路上吃。
 * 她现在有n个巧克力，很巧的是她所有的巧克力都是厚度一样的正方形的巧克力板，这n个巧克力板的边长分别为a1,a2,...,an。因为都是厚度一致的正方形巧克力板，我们认为第 i 个巧克力的重量为。
 * 小美现在准备挑选一个合适大小的包来装尽可能多的巧克力板，她十分需要你的帮助来在明天之前准备完成，请你帮帮她。
 *
 *
 输入描述
 第一行两个整数n和m，表示小美的巧克力数量和小美的询问数量。

 第二行n个整数a1,a2,...,an，表示n块正方形巧克力板的边长。注意你不能将巧克力板进行拆分。

 第三行m个整数q1,q2,...,qm，第 i 个整数qi表示询问：如果小美选择一个能装qi重量的包，最多能装多少块巧克力板？（不考虑体积影响，我们认为只要质量满足要求，巧克力板总能塞进包里）

 1≤n,m≤50000,1≤ai≤104,1≤qi≤1018

 输出描述
 输出一行m个整数，分别表示每次询问的答案


 样例输入
 5 5
 1 2 2 4 5
 1 3 7 9 15
 样例输出
 1 1 2 3 3


 提示
 包最大重量为1，能装12

 包最大重量为3，也最多只能装12重量（如果添加22就超载了）

 包最大重量为7，能装12+22

 包最大重量为9，能装 12+22+22（因为有两块巧克力板边长都为2）

 包最大重量为15，也最多能装 12+22+22（如果添加42就超载了）
 */
@SuppressWarnings("all")
public class M3小美爱吃巧克力 {

    /**
     * 贪心 ：但我超时了只过了83%
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] n_k_split = input.readLine().split("[ ]+");
        int n = Integer.valueOf(n_k_split[0]);
        int m = Integer.valueOf(n_k_split[1]);

        double[] qiaokeli = new double[n+1];
        double[] ask_count = new double[m];
        String[] qiaokeli_split = input.readLine().split("[ ]+");
        for (int i = 1; i <= n; i++) {
            qiaokeli[i] = qiaokeli[i-1]+Math.pow(Double.valueOf(qiaokeli_split[i-1]),2);
        }


        String[] ask_split = input.readLine().split("[ ]+");
        for (int i = 0; i < m; i++) {
            ask_count[i] =Double.valueOf(ask_split[i]);
        }
        Arrays.sort(qiaokeli);

        for (double qi : ask_count) {
            boolean flag = true;
            for (int i = 1; i < qiaokeli.length; i++) {
                if (qi<qiaokeli[i]){
                    System.out.print(i-1+" ");
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.print(n+" ");
            }
        }

    }


}
