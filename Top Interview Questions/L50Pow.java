public class L50Pow {
    class Solution {
        public double myPow(double x, int n) {
            if(n==0){
                return  1;
            }else if(n>0){
                double ans=x;
                for(int i=1;i<n;i++){
                    ans*=x;
                }
                return ans;
            }else{
                x=1/x;
                double ans=x;
                for(int i=1;i<n;i++){
                    ans*=x;
                }
                return ans;
            }
        }
    }
}
