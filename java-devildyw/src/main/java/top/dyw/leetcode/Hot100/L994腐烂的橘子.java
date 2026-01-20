package top.dyw.leetcode.Hot100;

public class L994腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        Deque<int[]> queue = new LinkedList<>();
        int freshCount = 0; // 新鲜的橘子数量

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount==0) {
            return 0;
        }

        int minutes = 0;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        //BFS
        while (!queue.isEmpty() && freshCount>0) {
            minutes++;
            int size = queue.size();
            while (size-->0){
                int[] bad = queue.poll();
                int r = bad[0];
                int c = bad[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return freshCount==0 ? minutes : -1;
    }
}
