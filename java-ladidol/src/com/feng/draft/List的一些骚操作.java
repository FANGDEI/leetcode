package com.feng.draft;

import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template
 * @className: List的一些骚操作
 * @author: Ladidol
 * @description:
 * @date: 2022/8/14 21:30
 * @version: 1.0
 */
public class List的一些骚操作 {

    int[][] erWei = new int[10][];

    //泛型可以是一维数组，和之前提到的Arrays.sort()中泛型一样，这里int[]就是个对象咯。不是普通类型。
    LinkedList<int[]> list = new LinkedList<>();

    //碰到需要返回int[][]类型的话，上述的list可以:
    int[][] nums = list.toArray(new int[list.size()][]);


}
