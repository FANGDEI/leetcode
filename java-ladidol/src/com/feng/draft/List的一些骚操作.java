package com.feng.draft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {
        // Integer.MAX_VALUE = 2147483647
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        // 生成的list不可变
        List<String> list = Arrays.asList("1", "2", "3");
        // 如果要可变需要用ArrayList包装一下
        List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3"));

    }



    LinkedList<Integer> addListTmp = new LinkedList<>();

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * 在列表中的指定位置插入指定元素。将当前处于该位置的元素(如果有的话)和任何后续元素向右移动(将其添加到索引中)。
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void add(int index, int element) {
        add(index,element);//
    }


}
