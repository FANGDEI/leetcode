package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-02-15:51
 * <p>
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在(0, 0) 处结束。
 * <p>
 * 移动顺序由字符串moves表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有R（右），L（左），U（上）和 D（下）。
 * <p>
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * <p>
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 */
@SuppressWarnings("all")
public class L657机器人能否返回原点 {
    public static void main(String[] args) {
        System.out.println(new L657机器人能否返回原点().judgeCircle("UD"));
    }

    public boolean judgeCircle(String moves) {
        int height = 0;
        int lenght = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'U':
                    height++;
                    break;
                case 'D':
                    height--;
                    break;
                case 'R':
                    lenght++;
                    break;
                default:
                    lenght--;
                    break;
            }
        }
        return height == 0 && lenght == 0;
    }
}
