package com.feng.newline.string;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/29 20:06
 * @description: {}
 */
public class L2423删除字符使频率相同 {
    class Solution {
        public boolean equalFrequency(String word) {
            int[] count = new int[26];
            char[] chars = word.toCharArray();
            for (char a : chars) {
                count[a - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    count[i]--;//搜索
                    int pre = 0;
                    boolean ok = true;
                    for (int j = 0; j < 26; j++) {
                        if (count[j] == 0) {
                            continue;
                        }
                        if (pre > 0 && count[j] != pre) {
                            //出现两种个数，直接跳出这种删除可能
                            ok = false;
                            break;
                        }
                        pre = count[j];//更新次数
                    }
                    if (ok) {
                        return true;
                    }
                    count[i]++;//回溯
                }

            }
            return false;
        }
    }





}
