package com.feng.newline.list;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L1206设计跳表
 * @author: Ladidol
 * @description:
 * 今日的每日一题, 可以参考一下三叶的题解:https://leetcode.cn/problems/design-skiplist/solution/by-ac_oier-38rd/
 * @date: 2022/7/26 15:27
 * @version: 1.0
 */
public class L1206设计跳表 {

//    // 本质：多层次的链表；Node[MAX_LEVEL]存储的是从当前层往下层的指针；
//// 结点存在自己随机得到的层及其以下
//
//    class Skiplist {
//        //参考redis源码
//        private  double P = 0.25;
//        private  int MAX_LEVEL = 32;
//
//        class Node{
//            int val;
//            //存储每层的下一个结点
//            Node[] next;
//            Node(int val, int level){
//                this.val = val;
//                this.next = new Node[level];
//            }
//        }
//        Node head = new Node(-1, MAX_LEVEL);
//
//        //随机获取待插入的元素的行
//        private int getRandomLevel(){
//            int level = 1;
//            while(Math.random() < P && level < MAX_LEVEL) level++;
//            return level;
//        }
//        public Skiplist() {
//
//        }
//        public boolean search(int target) {
//            Node pre = head;
//            for(int i = MAX_LEVEL - 1; i >= 0; i--){
//                while(pre.next[i] != null && pre.next[i].val <= target)pre = pre.next[i];
//                // if(pre.next[i] == null || pre.next[i].val > target)continue;//去下一层--下一层可能会有target
//                // if(pre.next[i].val == target)return true;
//                if(pre.val == target)return true;
//            }
//            return false;
//        }
//
//        public void add(int num) {
//            int level = getRandomLevel();
//            Node addNode = new Node(num, level);
//            Node pre = head;
//            //从随机得到的层数 以下都要进行插入
//
//            //错误的写法：最特殊情况，如果上层都没有，那岂不是又退化为O(n)？，因此还是得从MAX_LEVEL开始
//            // for(int i = level - 1; i >= 0; i--){
//
//            for(int i = MAX_LEVEL - 1; i >= 0; i--){
//                while(pre.next[i] != null && pre.next[i].val < num) pre = pre.next[i];
//                if(i >= level)continue;//在这里做判断进而对随机的level以下所有层都进行插入元素的操作
//
//                addNode.next[i] = pre.next[i];
//                pre.next[i] = addNode;
//            }
//        }
//
//
//        public boolean erase(int num) {
//            boolean flag = false;
//            Node pre = head;
//            //从最上层往下查找待删除的元素
//            for(int i = MAX_LEVEL - 1; i >= 0; i--){
//                while(pre.next[i] != null && pre.next[i].val < num) pre = pre.next[i];
//                if(pre.next[i] == null || pre.next[i].val > num)continue;
//
//                //大坑：找到待删除元素——需要删除元素及以下所有层的该元素
//                pre.next[i] = pre.next[i].next[i];
//                flag = true;
//            }
//            return flag;
//        }
//    }
}
