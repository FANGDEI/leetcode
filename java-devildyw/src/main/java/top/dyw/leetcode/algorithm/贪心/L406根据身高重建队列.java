package top.dyw.leetcode.algorithm.贪心;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 * @author Devil
 * @since 2022-10-23-23:30
 */
@SuppressWarnings("all")
public class L406根据身高重建队列 {

    public static void main(String[] args) {

    }

    /**
     * 按照身高h来排序，身高一定是从大到小排（身高相同的话则k小的站前面），让高个子在前面。
     * <p>
     * 此时我们可以确定一个维度了，就是身高，前面的节点一定都比本节点高！
     * <p>
     * 那么只需要按照k为下标重新插入队列就可以了
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            //如果身高相同 那么按照k排序 k小的在前面
            if (a[0]==b[0]) return a[1] - b[1];
            return b[0]-a[0];
        });

        //用链表 原因是 链表增删比数组快
        LinkedList<int[]> que = new LinkedList<>();

        for (int[] person : people) {
            //根据身高排序后的数组 按照k为下标插入即可(因为前面的节点一定比本节点高 所以根据根据k排序的话那么该节点前一定有k个大于或相同的身高)
            que.add(person[1],person);
        }

        return que.toArray(new int[people.length][]);

    }

}
