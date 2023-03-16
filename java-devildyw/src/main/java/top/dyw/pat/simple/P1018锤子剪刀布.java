package top.dyw.pat.simple;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-17-12:42
 */
@SuppressWarnings("all")
public class P1018锤子剪刀布 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("C", 0);
        map1.put("J", 0);
        map1.put("B", 0);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("C", 0);
        map2.put("J", 0);
        map2.put("B", 0);
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("C", 0);
        map3.put("J", 0);
        map3.put("B", 0);
        for (int i = 0; i < n; i++) {
            String jia = input.next();
            String yi = input.next();
            if (jia.equals("C") && yi.equals("J")) {
                map1.put(jia, map1.get(jia) + 1);
            } else if (jia.equals(yi)) {
                map2.put(jia, map2.get(jia) + 1);
            } else if (jia.equals("J") && yi.equals("B")) {
                map1.put(jia, map1.get(jia) + 1);
            } else if (jia.equals("B") && yi.equals("C")) {
                map1.put(jia, map1.get(jia)+ 1);
            }else {
                map3.put(jia,map3.get(jia)+1);
            }
        }
        int win = map1.get("B") + map1.get("J") + map1.get("C");
        int equal = map2.get("B")+map2.get("J")+map2.get("C");
        System.out.println(win+" "+ equal +" "+ (n-win-equal));
        System.out.println((n-win-equal)+" "+equal+" "+win);
        Map.Entry<String, Integer> entry1 = map1.entrySet().stream().max(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        }).get();
        Map.Entry<String, Integer> entry2 = map2.entrySet().stream().max(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        }).get();
        System.out.println(entry1.getKey()+" "+entry2.getKey());
    }
}
