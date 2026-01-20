package top.dyw.leetcode.Hot100;

public class L207课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 核心优化：使用数组代替 HashMap
        // 因为课程编号是 0 ~ numCourses-1，天然适合数组下标
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        // 2. 预先初始化所有的 List，避免在循环中判空或创建
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // 3. 构建图
        for (int[] p : prerequisites) {
            // 题目描述：想修课程 p[0]，先修 p[1]。
            // 依赖关系： p[1] -> p[0]
            int course = p[0];
            int pre = p[1];

            adj[pre].add(course); // 邻接表记录指向
            inDegree[course]++;   // 入度增加
        }

        // 4. 将入度为 0 的节点加入队列
        // 使用 ArrayDeque 比 LinkedList 稍微快一点点（数组实现 vs 链表实现）
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0; // 记录已修课程数量

        // 5. BFS
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            // 直接通过数组下标拿邻居，不需要哈希查找，速度极快
            for (int neighbor : adj[cur]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}
