package com.feng.newline.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L676实现一个魔法字典
 * @author: Ladidol
 * @description:
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 *
 * 示例:
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 *
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 * @date: 2022/7/11 9:30
 * @version: 1.0
 */


public class L676实现一个魔法字典 {

    class MagicDictionary {
        Map<Integer, ArrayList<String>> map;
        public MagicDictionary() {
            map = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            //构建hashtable
            for (String str : dictionary) {
                if (!map.containsKey(str.length())){
                    map.put(str.length(),new ArrayList<>());
                }
                map.get(str.length()).add(str);
            }
        }

        public boolean search(String searchWord) {
            if (!map.containsKey(searchWord.length())){
                return false;
            }
            List<String> list = map.get(searchWord.length());
            int count = 0;
            for (String str : list) {
                count = 0;
                for (int i = 0; i < searchWord.length(); i++) {
                    if (searchWord.charAt(i)!=str.charAt(i)){
                        count++;
                    }
                }
                //注意流程, 只要有一个字符串符合count==1就行
                if (count == 1){
                    return true;
                }
            }

            return false;
        }
    }
}
