package top.dyw.leetcode.simple.hash;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2023-02-01-17:53
 */
@SuppressWarnings("all")
public class L2325解密消息 {

    public static void main(String[] args) {
        System.out.println(new L2325解密消息().decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> hash = new HashMap<>();

        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i)!=' '&&!hash.containsKey(key.charAt(i))){
                hash.put(key.charAt(i),(char) (index+'a'));
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))){
                sb.append(hash.get(message.charAt(i)));
            }else{
                sb.append(message.charAt(i));
            }
        }
        return sb.toString();
    }
}
