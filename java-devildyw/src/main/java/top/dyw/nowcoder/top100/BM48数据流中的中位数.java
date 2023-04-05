package top.dyw.nowcoder.top100;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2023-02-01-18:56
 */
@SuppressWarnings("all")
public class BM48数据流中的中位数 {
    public static void main(String[] args) {

    }

    private ArrayList<Integer> val = new ArrayList<Integer>();

    public void Insert(Integer num) {
        if (val.isEmpty()){
            //val 中没有数据直接加入
            val.add(num);
        }//如果val 中有数据需要插入排序
        else {
            int i=0;
            //遍历找到插入点
            for (; i < val.size(); i++) {
                if (num<=val.get(i)){
                    break;
                }
            }
            //插入相应位置
            val.add(i,num);
        }
    }

    public Double GetMedian() {
        int n = val.size();
        //奇数个数字
        if (n%2==1){
            return (double)val.get(n/2);
        }//偶数个
        else {
            double a = val.get(n / 2);
            double b = val.get(n / 2 - 1);

            return (a+b)/2;
        }
    }
}
