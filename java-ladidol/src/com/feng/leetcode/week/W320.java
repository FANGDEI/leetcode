package com.feng.leetcode.week;

import com.feng.newline.binarytree.TreeNode;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/11/20 10:37
 * @description:
 */
public class W320 {

    class Solution1 {
        public int unequalTriplets(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) continue;
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] == nums[k] || nums[j] == nums[k]) continue;
                        ans++;
                    }
                }
            }
            return ans;
        }
    }


    //(TLE)
    class Solution222 {
        /**
         * 作者：Ladidol
         * 描述：先前序遍历得到递增的，然后就开始二分查找（或者直接暴力）
         */
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            dfs(root);
            List<List<Integer>> ans = new ArrayList<>();
            int n = path.size();
            //二分查找
            for (int query : queries) {
                List<Integer> tmpList = null;
                out:
                for (int i = 0; i < n; i++) {
                    if (path.get(0) > query) {
                        tmpList = Arrays.asList(-1, path.get(0));
                    }
                    if (path.get(i) == query && path.get(i) == query) {
                        tmpList = Arrays.asList(path.get(i), path.get(i));
                        break out;
                    }
                    if (path.get(i) <= query && i + 1 == n) {
                        if (tmpList == null) tmpList = Arrays.asList(path.get(i), -1);
                    } else if (path.get(i) <= query && path.get(i + 1) > query) {
                        if (tmpList == null) tmpList = Arrays.asList(path.get(i), path.get(i + 1));
                    } else if (path.get(i) < query && path.get(i + 1) >= query) {
                        if (tmpList == null) tmpList = Arrays.asList(path.get(i), path.get(i + 1));
                    }
                }
                if (tmpList != null)
                    ans.add(tmpList);

            }
            return ans;
        }

        List<Integer> path = new ArrayList<>();

        void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            path.add(root.val);
            dfs(root.right);
        }
    }
    //二分查找法的ac
    class Solution2222 {
        /**
         * 作者：Ladidol
         * 描述：先前序遍历得到递增的序列，然后就开始二分查找（或者直接暴力）
         */
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            dfs(root);
            List<List<Integer>> ans = new ArrayList<>();
            int n = path.size();
            //二分查找
            for (int query : queries) {
                int a = search(path, 0, path.size(), query);
                if (a != -1) ans.add(Arrays.asList(path.get(a), path.get(a)));
                else {
                    a = lower_bound(path, 0, path.size(), query);
                    int b = upper_bound(path, 0, path.size(), query);
                    if (a == 0) ans.add(Arrays.asList(-1, path.get(a)));//排除第一个
                    else if (a == n) ans.add(Arrays.asList(path.get(a - 1), -1));//排除第二个
                    else ans.add(Arrays.asList(path.get(a - 1), path.get(a)));
                }


            }
            return ans;
        }

        List<Integer> path = new ArrayList<>();

        void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            path.add(root.val);
            dfs(root.right);
        }

        int search(List<Integer> nums, int l, int r, int value) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums.get(mid) == value)
                    return mid;
                else if (nums.get(mid) > value)
                    r = mid;
                else
                    l = mid + 1;
            }
            return -1; //说明数列中没有v
        }

        /**
         * 作者：Ladidol
         * 描述：正常的话，直接找l和l后一个
         */
        int lower_bound(List<Integer> nums, int l, int r, int value) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums.get(mid) >= value)
                    r = mid;
                else
                    l = mid + 1;
            }
            return l; // 返回的是出现value的坐标范围[l,r)的l。
        }

        int upper_bound(List<Integer> nums, int l, int r, int value) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums.get(mid) <= value)
                    l = mid + 1;
                else
                    r = mid;
            }
            return l; // 返回的是出现value的坐标范围[l,r)的r,这里是上界。
        }

    }
    //用TreeSet就能得到上下界范围呜呜呜。anya的答案
    class Solution2 {
        TreeSet<Integer> treeSet;

        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            treeSet = new TreeSet<>();
            dfs(root);
            List<List<Integer>> ans = new ArrayList<>();
            for (Integer q : queries) {
                Integer minI = treeSet.floor(q);//天花板
                Integer maxI = treeSet.ceiling(q);//地板
                int min = minI == null ? -1 : minI;
                int max = maxI == null ? -1 : maxI;
                ans.add(Arrays.asList(min, max));
            }
            return ans;
        }

        void dfs(TreeNode root) {
            if (root == null) return;
            treeSet.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }

    }





    class Solution3 {
        long count;
        public long minimumFuelCost(int[][] roads, int seats) {
            HashMap<Integer,List<Integer>> listHashMap = new HashMap<>();
            int n = roads.length + 1;
            for (int i = 0; i < n; i++) {
                listHashMap.put(i,new ArrayList<>());
            }
            for (int[] road : roads) {
                int left = road[0];
                int right = road[1];
                listHashMap.get(left).add(right);
                listHashMap.get(right).add(left);
            }
            count = 0;
            boolean[] visited = new boolean[n];
            visited[0] = true;
            dfs(listHashMap,0,seats,visited);
            return count;
        }

        public long dfs(HashMap<Integer,List<Integer>> listHashMap, int index, int seats, boolean[] visited){
            long res = 1;
            List<Integer> list = listHashMap.get(index);
            for (Integer integer : list) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    long dfs = dfs(listHashMap, integer, seats, visited);
                    count += (dfs + seats - 1) / seats;
                    res += dfs;
                }
            }
            return res;
        }
    }

    //一个人的的做法
    class Solution333 {
        private int dfs(ArrayList<Integer>[] edges, boolean[] visit, int node, int seats, long[] total) {
            visit[node] = true;
            int childCount = 0;
            for (int i = 0; i < edges[node].size(); ++i) {
                int m = edges[node].get(i);
                if (!visit[m]) {
                    int cnt = dfs(edges, visit, m, seats, total);

                    total[0] += cnt / seats;
                    if(cnt % seats != 0) {
                        ++total[0];
                    }

                    childCount += cnt;
                }
            }

            // System.out.println(node+":"+childCount+","+total[0]);
            return childCount + 1;
        }

        public long minimumFuelCost(int[][] roads, int seats) {
            ArrayList<Integer>[] edges = new ArrayList[roads.length + 1];
            boolean[] visit = new boolean[edges.length];
            for (int i = 0; i < edges.length; ++i) {
                edges[i] = new ArrayList<Integer>();
                visit[i] = false;
            }
            for (int i = 0; i < roads.length; ++i) {
                int a = roads[i][0];
                int b = roads[i][1];

                edges[a].add(b);
                edges[b].add(a);
            }

            long[] total = {0};
            // System.out.println("case----");
            dfs(edges, visit, 0, seats, total);
            return total[0];
        }
    }






}