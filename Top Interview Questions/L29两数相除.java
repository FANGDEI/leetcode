public class L29两数相除 {
    class Solution {
        public int divide(int dividend, int divisor) {

            int i=0;
            int ans=0;
            int dividends=Math.abs(dividend);
            int divisors=Math.abs(divisor);
            ans=dividends;
            // System.out.print(dividend+" "+dividends);
            if(dividend==Integer.MIN_VALUE&&divisor==-1){
                return Integer.MAX_VALUE;
            }
            if(dividend==Integer.MIN_VALUE&&divisor==1){
                return Integer.MIN_VALUE;
            }
            if(dividend==Integer.MAX_VALUE&&divisor==1){
                return Integer.MAX_VALUE;
            }
            if(dividend==Integer.MAX_VALUE&&divisor==-1){
                return -Integer.MAX_VALUE;
            }
            while (true){
                ans-=divisors;
                if(ans>=0){
                    i++;
                }else{
                    break;
                }
            }
            if(dividend<0&&divisor>0){
                return -i;
            }
            if(dividend>0&&divisor<0){
                return -i;
            }
            if(dividend<0&&divisor<0){

                return i;
            }
            return i;
        }
    }
}
