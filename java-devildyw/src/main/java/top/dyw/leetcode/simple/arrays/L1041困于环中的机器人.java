package top.dyw.leetcode.simple.arrays;

/**
 * @author Devildyw
 * @date 2023/12/26 13:10
 **/

@SuppressWarnings("all")
public class L1041困于环中的机器人 {

    public static void main(String[] args) {

    }

    /**
     * 当机器人执行完指令 instructions\textit{instructions}instructions 后，它的位置和方向均有可能发生变化。
     *
     * 如果它的位置仍位于原点，那么不管它此时方向是什么，机器人都将永远无法离开。
     *
     * 如果它的位置不在原点，那么需要考虑此时机器人的方向：
     *
     * 如果机器人仍然朝北，那么机器人可以不会陷入循环。假设执行完一串指令后，机器人的位置是 (x,y)(x, y)(x,y) 且不为原点，方向仍然朝北，那么执行完第二串指令后，机器人的位置便成为 (2×x,2×y)(2\times x, 2\times y)(2×x,2×y)，会不停地往外部移动，不会陷入循环。
     * 如果机器人朝南，那么执行第二串指令时，机器人的位移会与第一次相反，即第二次的位移是 (−x,−y)(-x, -y)(−x,−y)，并且结束后会回到原来的方向。这样一来，每两串指令之后，机器人都会回到原点，并且方向朝北，机器人会陷入循环。
     * 如果机器人朝东，即右转了 90°90\degree90°。这样一来，每执行一串指令，机器人都会右转 90°90\degree90°。那么第一次和第三次指令的方向是相反的，第二次和第四次指令的方向是相反的，位移之和也为 000，这样一来，每四次指令之后，机器人都会回到原点，并且方向朝北，机器人会陷入循环。如果机器人朝西，也是一样的结果。
     * 因此，机器人想要摆脱循环，在一串指令之后的状态，必须是不位于原点且方向朝北。
     *
     * @param instructions
     * @return
     */
    public boolean isRobotBounded(String instructions) {
        //位移数组
        int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}};
        //表示朝向 0表示北 3表示西 1表示东 2表示南
        int direcIndex = 0;
        //坐标 初始为0 用来判断最后是否回到原点
        int x = 0, y = 0;
        int n = instructions.length();

        for (int i = 0; i < n; i++) {
            char instruction = instructions.charAt(i);
            if (instruction=='G'){
                x+=direc[direcIndex][0];
                y+=direc[direcIndex][1];
            } else if (instruction == 'L'){
                direcIndex+=3;
                direcIndex%=4;
            } else{
                direcIndex++;
                direcIndex%=4;
            }
        }
        //如果最后朝向不为北也不会成为成为环 如果最后在原点的话会成为环
        //因此拜托循环的条件就是执行一整条指令后 不位于原点切方向朝北
        return direcIndex!=0||(x==0&&y==0);
    }

}
