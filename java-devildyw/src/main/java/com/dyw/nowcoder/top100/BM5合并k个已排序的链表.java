package com.dyw.nowcoder.top100;


import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-12-13-12:04
 */
@SuppressWarnings("all")
public class BM5合并k个已排序的链表 {

    public static void main(String[] args) {

    }


    /**
     * 思路：借助之前写过的合并两个有序链表的方法 不断地将k个有序链表中的每两个有序链表进行合并
     * 这里还使用了 分治 归并来合并提升效率
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divideMerge(lists,0,lists.size()-1);
    }

    private ListNode divideMerge(ArrayList<ListNode> lists, int left, int right) {
        //跳出递归
        if (left>right){
            return null;
        }
        //根据传入参数这里的 left是可以等于 right 的 这时返回左右链表任意一个都可以 并且退出递归 无需合并
        else if (left==right){
            return lists.get(left);
        }
        //除上述两种情况外
        //找到中间位置 从中间分成两段，再将合并好的两段合并
        int mid = (left+right)/2;
        return Merge(divideMerge(lists,left,mid),divideMerge(lists,mid+1,right));
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }

        ListNode head = null, node = null;

        while (list1!=null&&list2!=null){
            int temp;
            if (list1.val<=list2.val){
                temp = list1.val;
                list1 = list1.next;
            }else{
                temp = list2.val;
                list2 = list2.next;
            }

            if (head==null){
                head = new ListNode(temp);
                node = head;
            }else{
                node.next = new ListNode(temp);
                node = node.next;
            }
        }

        if (list1!=null){
            node.next = list1;
        }
        if (list2!=null){
            node.next = list2;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
