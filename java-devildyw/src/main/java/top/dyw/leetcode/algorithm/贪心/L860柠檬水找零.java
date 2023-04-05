package top.dyw.leetcode.algorithm.贪心;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。
 *
 * @author Devil
 * @since 2022-10-23-23:19
 */
@SuppressWarnings("all")
public class L860柠檬水找零 {

    public static void main(String[] args) {

    }

    /**
     * 情况一：账单是5，直接收下。
     * 情况二：账单是10，消耗一个5，增加一个10
     * 情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
     * <p>
     * 情况三需要贪心，20找零优先消耗掉10 其次消耗掉5 因为10只能给20找零 而5元可以给10和20找零 较为万能
     * <p>
     * 局部最优：遇到账单20，优先消耗美元10，完成本次找零。全局最优：完成全部账单的找零。
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        //模拟 但第三种情况是贪心
        for (int i = 0; i < bills.length; i++) {
            if (bills[i]==5){
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten>0){
                    ten--;
                    five--;
                }else{
                    five-=3;
                }
            }
            if (five<0||ten<0) return false;
        }
        return true;
    }


}
