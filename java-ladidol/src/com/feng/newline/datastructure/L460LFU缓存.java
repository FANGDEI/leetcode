package com.feng.newline.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L460LFU缓存
 * @author: Ladidol
 * @description: 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量capacity 时，
 * 则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 示例：
 * <p>
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * <p>
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // 返回 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // 返回 4
 * // cache=[3,4], cnt(4)=2, cnt(3)=3
 * 提示：
 * <p>
 * 0 <= capacity<= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * 最多调用 2 * 105 次 get 和 put 方法
 * @date: 2022/9/9 10:40
 * @version: 1.0
 */
public class L460LFU缓存 {// 表示这种题我要做吐了；

    // 这个算是146LRU的升级版了，多了一个指标：对使用次数的计数，在使用次数相同的情况下在判断谁最后使用。
    // get：不存在就返回-1，存在就从对应的bucket中取出来item，再添加到对应的新bucket中去；
    // put：不存在就就创造一个item存在对应的bucket中去，存在就改变对应item的值（get使用加一）再添加到询bucket中去

    class LFUCache {

        class Item {// 内层双链表单位
            Item l, r;
            int k, v;

            public Item(int key, int value) {
                k = key;
                v = value;
            }
        }

        class Bucket {// 外层双链表单位（类比于LRU中的大类）
            Bucket l, r;
            int idx;
            Item head, tail;
            Map<Integer, Item> map = new HashMap();// 用于快速拿到item

            public Bucket(int index) {
                idx = index;
                head = new Item(-1, -1);
                tail = new Item(-1, -1);
                head.r = tail;
                tail.l = head;
            }


            void put(int key, int value) {// √
                // 将对应节点加到该桶的头部
                Item cur = null;
                if (map.containsKey(key)) {
                    cur = map.get(key);
                    //将它从原来的位置中删除
                    cur.l.r = cur.r;
                    cur.r.l = cur.l;

                    cur.v = value;//更新值哦；
                } else {
                    cur = new Item(key, value);
                    map.put(key, cur);
                }
                // 添加到桶的首部；
                cur.l = head;
                cur.r = head.r;
                head.r = cur;
                cur.r.l = cur;

            }


            Item remove(int key) { // √
                // remove是为了移动key，（移动=先从旧桶中删除+再从新桶中添加）
                if (map.containsKey(key)) {
                    Item cur = map.get(key);
                    // 从双向链表中移除
                    Item pre = cur.l;
                    pre.r = cur.r;
                    cur.r.l = pre;
                    // 从哈希表中移除
                    map.remove(key);
                    return cur;
                }
                return null;
            }

            Item clear() {
                // clear是对空间满的时候进行该桶最后一个元素删除
                Item lastest = tail.l;
                lastest.l.r = tail;
                tail.l = lastest.l;

                map.remove(lastest.k);//维护map大小
                return lastest;//返回被删除的最后一个元素：为了把总map中的删除掉。有点小迷惑。
            }

            boolean isEmpty() {
                return map.isEmpty();
            }
        }


        Map<Integer, Bucket> map = new HashMap<>();// 用来记录哪些 key 在哪个桶内
        Bucket head, tail;
        int n;
        int cnt;


        public LFUCache(int capacity) {
            n = capacity;
            cnt = 0;
            head = new Bucket(-1);
            tail = new Bucket(-1);
            head.r = tail;
            tail.l = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Bucket cur = map.get(key);
                Bucket target = null;

                //去拿桶
                if (cur.r.idx != cur.idx + 1) {
                    // cur的后面没有目标同的话。
                    target = new Bucket(cur.idx + 1);
                    target.r = cur.r;
                    cur.r.l = target;
                    cur.r = target;
                    target.l = cur;
                } else {
                    target = cur.r;
                }

                //桶间操作
                Item curItem = cur.remove(key);
                target.put(curItem.k, curItem.v);

                // 更新当前键值所在通的信息
                map.put(key, target);

                if (cur.isEmpty()) {//对空桶进行删除操作。
                    cur.l.r = cur.r;
                    cur.r.l = cur.l;
                }
                return curItem.v;
            }
            return -1;//cache中没有这个东西。
        }

        public void put(int key, int value) {
            // put：不存在就就创造一个item存在对应的bucket中去，存在就改变对应item的值（get使用加一）再添加到询bucket中去
            if (n == 0) return;
            if (map.containsKey(key)) {
                Bucket cur = map.get(key);
                cur.put(key, value);
                get(key);//put使用1等价于get使用1；
            } else {
                // 容器满了就要进行容器操作
                if (cnt == n) {
                    // 第一个桶（编号最小的即次数最小的）中去删除尾节点；
                    Bucket cur = head.r;
                    Item clear = cur.clear();
                    map.remove(clear.k);
                    cnt--;
                    // 每一次删除的话都要判断桶是不是空
                    if (cur.isEmpty()) {//对空桶进行删除操作。
                        cur.l.r = cur.r;
                        cur.r.l = cur.l;
                    }
                }
                // 这里排查了一个多小时的错误，因为这个创建新的Bucket时，必须是以前没有1Bucket，这段代码，写错地方了；
                Bucket theOneBucket = null;
                // 如果第一个桶不是一号桶的话，就创建一下。
                if (head.r.idx != 1) {
                    theOneBucket = new Bucket(1);
                    theOneBucket.l = head;
                    theOneBucket.r = head.r;
                    head.r = theOneBucket;
                    theOneBucket.r.l = theOneBucket;
                } else {
                    theOneBucket = head.r;
                }
                theOneBucket.put(key, value);
                map.put(key, theOneBucket);
                cnt++;
            }
        }
    }
}
