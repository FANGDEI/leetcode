package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-19-14:54
 * <p>
 * 给定一个n x n的二进制矩阵image，先 水平 翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。
 * <p>
 * 例如，水平翻转[1,1,0]的结果是[0,1,1]。
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。
 * <p>
 * 例如，反转[0,1,1]的结果是[1,0,0]。
 */
@SuppressWarnings("all")
public class L832翻转图像 {
    public static void main(String[] args) {
        int[][] ints = new L832翻转图像().flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        for (int[] anInt : ints) {
            for (int i = 0; i < anInt.length; i++) {
                System.out.println(anInt[i]);
            }
        }
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                image[i][j] = image[i][j] + image[i][m - j - 1];
                image[i][m - j - 1] = image[i][j] - image[i][m - j - 1];
                image[i][j] = image[i][j] - image[i][m - j - 1];
            }

            for (int j = 0; j < m; j++) {
                image[i][j] = (image[i][j] + 1) % 2;
            }
        }


        return image;

    }
}
