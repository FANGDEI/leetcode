package top.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * @author Devil
 * @since 2022-10-12-12:55
 */
@SuppressWarnings("all")
public class L93复原IP地址 {

    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12){ //如果超过12的长度 则说明这不是一个有效的ip
            return result;
        }
        //回溯算法 分割
        restoreIpAddressesHelper(s,0,0);
        return result;
    }

    /**
     *
     * @param s 待分割的字符串
     * @param startIndex 搜索的起始位置
     * @param pointNum 添加点的数量 如果点的数量为3则说明字符串已经被分割为了4段
     */
    private void restoreIpAddressesHelper(String s, int startIndex, int pointNum) {
        //终止条件 判断点的数量是否达到了3
        if (pointNum==3){
            //判断第四段子字符串是否合法，如果合法就放入结果集
            if (isValid(s,startIndex,s.length()-1)){
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i<s.length();i++){
            //如果是有效ip分段
            if (isValid(s,startIndex,i)){
                //因为这里没有使用辅助链表 所以这里对原字符串进行修改 在分段处进行加点分割操作 说明我们完成了一段分组
                s = s.substring(0,i+1)+"."+s.substring(i+1);
                pointNum++;
                //将分割后的字符串 传入下层进行下一段的分割
                restoreIpAddressesHelper(s,i+2,pointNum);
                //回溯
                pointNum--;
                //i+2 是为了将“.”给屏蔽掉
                s = s.substring(0,i+1)+s.substring(i+2);
            }
        }
    }

    /**
     * 验证是否是有效的ip地址分段
     * @param s
     * @param startIndex
     * @param end
     * @return
     */
    private boolean isValid(String s, int startIndex, int end) {
        if (startIndex>end){
            return false;
        }
        if (s.charAt(startIndex)=='0'&&startIndex!=end){
            return false;
        }
        int num = 0;
        for (int i = startIndex; i <= end; i++) {
            if (s.charAt(i)>'9'||s.charAt(i)<'0'){
                return false;
            }
            num = num * 10 + (s.charAt(i)-'0');
            if (num>255){
                return false;
            }
        }
        return true;
    }

}
