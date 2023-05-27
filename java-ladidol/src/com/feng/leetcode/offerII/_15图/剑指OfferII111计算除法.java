package com.feng.leetcode.offerII._15图;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/26 17:16
 * @description: {}
 */
public class 剑指OfferII111计算除法 {

    //bfs，加权图
    class Solution {
        /**
         * 类似于图，queries是求一个start->end的路径可行吗？我们直接反向查询
         * @param equations
         * @param values
         * @param queries
         * @return
         */
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            //先排序再赋值，按着图的排序拍
            return null;
        }
        List<List<String>> equations;
        double[] values;
        List<List<String>> queries;
//        public void dfs()




    }



//    官解：：：：：：：
    class Solution官解 {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int nvars = 0;
            Map<String, Integer> variables = new HashMap<String, Integer>();

            int n = equations.size();
            for (int i = 0; i < n; i++) {
                if (!variables.containsKey(equations.get(i).get(0))) {
                    variables.put(equations.get(i).get(0), nvars++);
                }
                if (!variables.containsKey(equations.get(i).get(1))) {
                    variables.put(equations.get(i).get(1), nvars++);
                }
            }

            // 对于每个点，存储其直接连接到的所有点及对应的权值
            List<Pair>[] edges = new List[nvars];
            for (int i = 0; i < nvars; i++) {
                edges[i] = new ArrayList<Pair>();
            }
            for (int i = 0; i < n; i++) {
                int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
                edges[va].add(new Pair(vb, values[i]));
                edges[vb].add(new Pair(va, 1.0 / values[i]));
            }

            int queriesCount = queries.size();
            double[] ret = new double[queriesCount];
            for (int i = 0; i < queriesCount; i++) {
                List<String> query = queries.get(i);
                double result = -1.0;
                if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                    int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                    if (ia == ib) {
                        result = 1.0;
                    } else {
                        Queue<Integer> points = new LinkedList<Integer>();
                        points.offer(ia);
                        double[] ratios = new double[nvars];
                        Arrays.fill(ratios, -1.0);
                        ratios[ia] = 1.0;

                        while (!points.isEmpty() && ratios[ib] < 0) {
                            int x = points.poll();
                            for (Pair pair : edges[x]) {
                                int y = pair.index;
                                double val = pair.value;
                                if (ratios[y] < 0) {
                                    ratios[y] = ratios[x] * val;
                                    points.offer(y);
                                }
                            }
                        }
                        result = ratios[ib];
                    }
                }
                ret[i] = result;
            }
            return ret;
        }
    }

    class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

}
