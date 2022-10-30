package com.feng.draft;

import java.util.*;

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
//        // Integer.MAX_VALUE = 2147483647
//        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
//        // 生成的list不可变
//        List<String> list = Arrays.asList("1", "2", "3");
//        // 如果要可变需要用ArrayList包装一下
//        List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3"));
//


        //test3
        List<String[]> list3 = new ArrayList<>();
        //["alice","bob","alice","chris"], ids = ["one","two","three","four"], views = [5,10,5,4]
        list3.add(new String[]{"5","1abc","alice"});
        list3.add(new String[]{"10","2abc","bob"});
        list3.add(new String[]{"5","3abc","alice"});
        list3.add(new String[]{"4","2abc","chris"});
//        list3.add(new String[]{"0abc","1abc"});
//        list3.add(new String[]{"1__abc","1abc"});



        stringAdd(list3);

        for (String[] strings : list3) {
            System.out.println("strings = " + Arrays.toString(strings));
        }





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
        add(index, element);//
    }

    /**
     * 参数：[list]
     * 返回值：void
     * 作者： ladidol
     * 描述：尝试通过String[] 数组的不同的维度的指标来进行 比较排序。
     */
    public static void stringAdd(List<String[]> list) {
        Collections.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
                return a[0].compareTo(b[0]);
            }
        });


    }


}
