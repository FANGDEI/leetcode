package top.dyw.write_exam.meituan.meituan_2023_3_25;

/**
 * @author Devildyw
 * @date 2023/03/25 21:05
 **/

import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目描述：
 * 小美因为自己差劲的表达能力而苦恼，小美想制作一个解释器，这样她可以在无法表达的情况下让解释器帮她解释。
 * 好巧不巧小美翻开了编译原理的书，找到了解释器的制作方式，她决定先制作一个书上习题中描述的小小解释器试试。
 *
 * 小美需要读入一行字符串，其格式为"key1=val1; key2=val2;  ...;
 * keyn-1=valn-1; keyn=valn;"(不包含引号)这样的n对key,value对，其中keyi和vali为第 i 对key,value对，且均为仅包含大小写英文字母、数字与斜杠的非空字符串。例如对于字符串"SHELL=/bin/bash;HOME=/home/xiaomei;LOGNAME=xiaomei;"，那么其中包含三对key,value对，以(key,value)形式展示，分别为(SHELL,/bin/bash)、(HOME,/home/xiaomei)、(LOGNAME,xiaomei)。
 *
 * 接下来，小美的解释器需要接受q次询问，每次询问给出一个仅包含大小写英文字母、数字与斜杠的非空字符串，如果存在某对key,value对的key值与之相同，那么输出对应的value；如果存在多对key,value对的key值与之相同，那么输出其中编号最大的，也即最后那一对的value值；如果一对也不存在，那么输出EMPTY。
 *
 * 输入描述
 * 第一行一个字符串S，满足题中所述格式。
 *
 * 接下来一个整数q，表示有q个询问。
 *
 * 接下来q行，每行一个仅包含大小写英文字母、数字与斜杠的非空字符串，分别为S1,S2,...,Sq，依次表示q次询问。
 *
 * 令|S|表示字符串S的长度。
 *
 *  S中至少包含一对key,value对。
 *
 *  样例输入
 * LOGNAME=default;SHELL=/bin/bash;HOME=/home/xiaomei;LOGNAME=xiaomei;
 * 4
 * SHELL
 * HOME
 * LOGNAME
 * logname
 * 样例输出
 * /bin/bash
 * /home/xiaomei
 * xiaomei
 * EMPTY
 *
 * 提示
 * 第3个询问有两对满足，分别是第1对和第4对，选择编号大的（也就是后者），为xiaomei而不是default。
 *
 * 第4个询问不存在满足的，输出EMPTY。
 */
@SuppressWarnings("all")
public class M4小美的解释器 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        String[] split = line.split(";");
        HashMap<String, String> map = new HashMap<>();

        for (String s : split) {
            String[] split1 = s.split("=");
            map.put(split1[0],split1[1]);
        }

        int n  =input.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println(map.getOrDefault(input.next(),"EMPTY"));
        }
    }
}
