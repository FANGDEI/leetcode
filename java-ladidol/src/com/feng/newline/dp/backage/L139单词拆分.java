package com.feng.newline.dp.backage;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.backage
 * @className: L139单词拆分
 * @author: Ladidol
 * @description: 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * @date: 2022/9/1 16:01
 * @version: 1.0
 */
public class L139单词拆分 {

    // 最朴素的回溯（TLE）
    // 一些基础剪枝操作无。比如每层循环中的startWith最初没有写上
    // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]这个测试用例没过。
    class Solution1 {
        List<String> wordDict;
        String target;
        Boolean res = false;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
            this.target = s;
            backtracking("");
            return res;
        }

        void backtracking(String cur) {// 纯回溯还是要注意下返回，不能一直走下。
            if (res) return;
            if (Objects.equals(cur, target)) {
                res = true;
                return;
            }
            if (cur.length() >= target.length()) return;
            for (String s : wordDict) {
                if (!target.startsWith(cur)) return;
                backtracking(cur + s);
            }
        }
    }

    // 换一个思路 (和131分割回文串有异曲同工之妙) 这里我们不拼接，我们用拆分s目标串。有了startIndex就好记忆性。
    // 记忆性dfs + 回溯
    class Solution2 {

        //        Set<String> wordDict;
        List<String> wordDict;
        String target;
        int[] cache;

        public boolean wordBreak(String s, List<String> wordDict) {
//            this.wordDict = new HashSet<>(wordDict);//这里用hashset判断存在问题就会快很多。
            this.wordDict = wordDict;
            this.target = s;
            cache = new int[s.length()];
            return backtracking(0);
        }

        boolean backtracking(int startIndex) {
            if (startIndex == target.length()) return true;//到这里了说明成功了。
            if (cache[startIndex] == -1) return false;
            for (int i = startIndex; i < target.length(); i++) {
                String cur = target.substring(startIndex, i + 1);
                if (!wordDict.contains(cur)) {// contains不是set或map独有技能。
                    continue;// 这里不满足只能说明是当前分割不好，continue一下就行了
                }
                boolean res = backtracking(i + 1);
                if (res) {// 回溯传递答案。
                    return true;
                }
            }
            //维护cache记忆性
            //从startindex到length都没有找到匹配的，说明该startIndex不可以行
            cache[startIndex] = -1;
            return false;
        }
    }

    // 完全背包dp，排列问题：先背包再物品。
    // 设dp[]数组表示字符串的0至i这一截匹配成功。
    // 那么dp[i]=dp[i-word.size()]&&word==s.substr(i-word.size(),word.size())
    // 即0至i这一截的匹配成功取决于：
    // 0至i-word.size()这一截是否匹配成功以及s的i-word.size()至i这一截与word是否相等。
    class Solution3 {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i <= dp.length; i++) {// 背包
                for (String word : wordDict) {// 物品
                    if (i + word.length() < dp.length && dp[i] && word.equals(s.substring(i, i + word.length()))) {// subString的使用
                        dp[i + word.length()] = true;//用if保证修改后的true不会被后面拿到相同长度的false给覆盖。
                    }
                }
            }
            return dp[s.length()];
        }
    }


    // 完全背包dp，排列问题：先背包再物品。
    // 设dp[]数组表示字符串的0至i这一截匹配成功。
    // 那么dp[i]=dp[i-word.size()]&&word==s.substr(i-word.size(),word.size())
    // 即0至i这一截的匹配成功取决于：
    // 0至i-word.size()这一截是否匹配成功以及s的i-word.size()至i这一截与word是否相等。
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i <= dp.length; i++) {// 背包
                for (String word : wordDict) {// 物品
                    if (i - word.length() >= 0 && dp[i - word.length()] && s.startsWith(word, i - word.length())) {//startWith的使用
                        dp[i] = true;//用if保证修改后的true不会被后面拿到相同长度的false给覆盖。
                    }
                }
            }
            return dp[s.length()];
        }
    }

}
