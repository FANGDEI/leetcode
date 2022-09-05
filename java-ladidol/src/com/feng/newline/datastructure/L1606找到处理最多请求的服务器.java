package com.feng.newline.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L1606找到处理最多请求的服务器
 * @author: Ladidol
 * @description: 你有 k 个服务器，编号为 0 到 k-1 ，它们可以同时处理多个请求组。每个服务器有无穷的计算能力但是 不能同时处理超过一个请求 。请求分配到服务器的规则如下：
 * 第 i （序号从 0 开始）个请求到达。
 * 如果所有服务器都已被占据，那么该请求被舍弃（完全不处理）。
 * 如果第 (i % k) 个服务器空闲，那么对应服务器会处理该请求。
 * 否则，将请求安排给下一个空闲的服务器（服务器构成一个环，必要的话可能从第 0 个服务器开始继续找下一个空闲的服务器）。比方说，如果第 i 个服务器在忙，那么会查看第 (i+1) 个服务器，第 (i+2) 个服务器等等。
 * 给你一个 严格递增 的正整数数组 arrival ，表示第 i 个任务的到达时间，和另一个数组 load ，其中 load[i] 表示第 i 个请求的工作量（也就是服务器完成它所需要的时间）。你的任务是找到 最繁忙的服务器 。最繁忙定义为一个服务器处理的请求数是所有服务器里最多的。
 * 请你返回包含所有 最繁忙服务器 序号的列表，你可以以任意顺序返回这个列表。
 * 示例 1：
 * 输入：k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
 * 输出：[1]
 * 解释：
 * 所有服务器一开始都是空闲的。
 * 前 3 个请求分别由前 3 台服务器依次处理。
 * 请求 3 进来的时候，服务器 0 被占据，所以它被安排到下一台空闲的服务器，也就是服务器 1 。
 * 请求 4 进来的时候，由于所有服务器都被占据，该请求被舍弃。
 * 服务器 0 和 2 分别都处理了一个请求，服务器 1 处理了两个请求。所以服务器 1 是最忙的服务器。
 * 示例 2：
 * <p>
 * 输入：k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
 * 输出：[0]
 * 解释：
 * 前 3 个请求分别被前 3 个服务器处理。
 * 请求 3 进来，由于服务器 0 空闲，它被服务器 0 处理。
 * 服务器 0 处理了两个请求，服务器 1 和 2 分别处理了一个请求。所以服务器 0 是最忙的服务器。
 * 示例 3：
 * <p>
 * 输入：k = 3, arrival = [1,2,3], load = [10,12,11]
 * 输出：[0,1,2]
 * 解释：每个服务器分别处理了一个请求，所以它们都是最忙的服务器。
 * 示例 4：
 * <p>
 * 输入：k = 3, arrival = [1,2,3,4,8,9,10], load = [5,2,10,3,1,2,2]
 * 输出：[1]
 * 示例 5：
 * <p>
 * 输入：k = 1, arrival = [1], load = [1]
 * 输出：[0]
 * @date: 2022/9/5 17:19
 * @version: 1.0
 */
public class L1606找到处理最多请求的服务器 {
    class Solution {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

            int[] count = new int[k];//记录每一个server进行的任务数。
            int max = 0;//最多任务数。
            //优先队列存储当前忙碌的服务器索引及其任务结束时间,根据结束时间升序排列
            PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            // 红黑树集合 存储当前任务开始时刻，所有空闲的服务器索引
            TreeSet<Integer> freeServers = new TreeSet<>();
            for (int i = 0; i < k; i++) {
                freeServers.add(i);
            }
            //依次遍历所有任务
            for (int i = 0; i < arrival.length; i++) {
                int startTime = arrival[i], endTime = arrival[i] + load[i];
                //找出所有当前忙碌的服务器的任务结束时刻早于待分配任务的开始时刻的，都加入到free集合中等待筛选
                while (!busy.isEmpty() && busy.peek()[1] <= startTime) {
                    freeServers.add(busy.poll()[0]);//维护servers列表。
                }

                //取执行当前任务的服务器：
                //1. >= i%k
                Integer curServer = freeServers.ceiling(i % k);//注意的是没找到是返回null，所以这里用Integer包装类。
                //2. >= 0
                if (curServer == null) curServer = freeServers.ceiling(0);

                if (curServer == null) continue;//丢掉当前任务。

                //取到服务器后，开始处理当前任务，维护busy和freeServers
                freeServers.remove(curServer);
                busy.add(new int[]{curServer, endTime});

                //维护最多任务数
                max = Math.max(max, ++count[curServer]);
            }

            // 取出最多任务执行的servers
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < count.length; i++) {
                if (max == count[i]) res.add(i);
            }
            return res;
        }
    }
}
