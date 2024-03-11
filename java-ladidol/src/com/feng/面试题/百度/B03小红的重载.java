package com.feng.面试题.百度;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/10 20:26
 * @description: {}
 */
public class B03小红的重载 {
    static class XiaoHong {
        String fanhui;
        String name;
        int size;

        public XiaoHong(String fanhui, String name, int size) {
            this.fanhui = fanhui;
            this.name = name;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            XiaoHong xiaoHong = (XiaoHong) o;
            return size == xiaoHong.size && Objects.equals(fanhui, xiaoHong.fanhui) && Objects.equals(name, xiaoHong.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fanhui, name, size);
        }
    }

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        Scanner scan = new Scanner(System.in);
        Set<XiaoHong> set = new HashSet<>();
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String[] fanhuis = line.split(" ");
//            System.out.println("fanhuis = " + Arrays.toString(fanhuis));//要删
            String fanhui = fanhuis[0];
            String[] names = fanhuis[1].split("\\(");
//            System.out.println("names = " + Arrays.toString(names));//要删
            String name = names[0];
            String[] sizes = line.split(",");
//            System.out.println("sizes = " + Arrays.toString(sizes));//要删//需要判断一下是不是有逗号，不然会出现逗号
            int size = sizes.length;

//            if (size == 1) {
//                if (line.indexOf("(") + 1 == line.indexOf(")")) {
//                    size = 0;
//                }
//            }

            XiaoHong xiaoHong = new XiaoHong(fanhui, name, size);
            if (set.contains(xiaoHong)) {
                System.out.println("No");
            } else {
                set.add(xiaoHong);
                System.out.println("Yes");
            }


        }


    }
}
