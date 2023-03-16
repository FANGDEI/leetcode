package top.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2023-02-07-15:10
 */
@SuppressWarnings("all")
public class BM56有重复项数字的全排列 {

    public static void main(String[] args) {
        System.out.println(new BM56有重复项数字的全排列().permuteUnique(new int[]{1, 1, 2}));
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        HashSet<Integer> set = new HashSet<>();
        backTracking(num,set);
        return result;
    }

    private void backTracking(int[] num, HashSet<Integer> set) {
        if (path.size()==num.length){
            ArrayList<Integer> integers = new ArrayList<>(path);
            if (!result.contains(integers)){
                result.add(integers);
            }
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (set.contains(i)){
                continue;
            }

            path.add(num[i]);
            set.add(i);

            backTracking(num,set);

            set.remove(i);
            path.removeLast();
        }
    }
}
