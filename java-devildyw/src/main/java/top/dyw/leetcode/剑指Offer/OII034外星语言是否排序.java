package top.dyw.leetcode.剑指Offer;


import java.util.HashMap;

/**
 * @author Devildyw
 * @date 2023/07/06 10:56
 **/
@SuppressWarnings("all")
public class OII034外星语言是否排序 {

    public static void main(String[] args) {
        String[] words = new String[]{"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean alienSorted = new OII034外星语言是否排序().isAlienSorted(words, order);
    }

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }


        for (int i = 1; i < words.length; i++) {
            boolean flag = false;

            String s1 = words[i - 1];
            String s2 = words[i];

            int j = 0;
            int k = 0;
            while (j<s1.length()&&k<s2.length()){
                char c1 = s1.charAt(j++);
                char c2 = s2.charAt(k++);
                if (map.get(c1)>map.get(c2)){
                    return false;
                }else if (map.get(c1)<map.get(c2)){
                    flag = true;
                    break;
                }
            }
            if (!flag&&s1.length()>s2.length()){
                return false;
            }
        }
        return true;
    }
}
