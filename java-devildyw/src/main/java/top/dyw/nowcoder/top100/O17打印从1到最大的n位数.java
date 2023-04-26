package top.dyw.nowcoder.top100;

/**
 * @author Devildyw
 * @date 2023/04/26 19:43
 **/
@SuppressWarnings("all")
public class O17打印从1到最大的n位数 {

    public static void main(String[] args) {

    }

    int[] res;

    //todo 再看一次
    //start 记录当前找到第几位数了,从后往前 当后面满9了就往前进一位
    int nine = 0,count = 0,start,n;
    char[] num, loop = {'0','1','2','3','4','5','6','7','8','9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) (Math.pow(10,n)-1)]; //记录结果
        num = new char[n];
        start = n-1;
        dfs(0);
        return res;
    }

    private void dfs(int x) {
        if (x==n){
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);
            if (n-start==nine) start--;
        }
        for (char i:loop){
            if (i=='9') nine++;
            num[x] = i;
            dfs(x+1);
        }
        nine--;
    }

}
