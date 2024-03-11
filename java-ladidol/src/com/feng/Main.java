package com.feng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main implements Callable<String>{

    static long count = 0;

    public static void main(String[] args) {
        m4();
    }

    private static void m4() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
            sum += nums[i];
        }
        dfs(nums, 0, 0, sum);

        ArrayList list =new ArrayList<>();
//        list.

        FutureTask<String> stringFutureTask = new FutureTask<>(new Main());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(stringFutureTask);
        try {
            String s = stringFutureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        //并发非阻塞容器
        ConcurrentLinkedQueue<Integer> concurrentLinkedDeque = new ConcurrentLinkedQueue<>();
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();


        //并发阻塞容器
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedBlockingQueue<Integer> linkedBlockingDeque = new LinkedBlockingQueue<>();
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
//        DelayQueue<> delayQueue = new DelayQueue<>();//需要传入一个Delay的子类，方便判断是否过期，优先级队列排序



        System.out.println(count % (1000000000 + 7));
    }

    private static void dfs(int[] nums, int curIndex, int curSum, int sum) {
        if (curSum > sum) {//超过sum还没到最后，的会直接return剪枝
            return;
        }

        if (curIndex == nums.length) {//数组末尾
            if (curSum != sum) {
                return;
            } else {
                count++;
                return;
            }
        }
        for (int i = 1; i <= sum - curSum - (nums.length - curIndex) + 1; i++) {
            if (nums[curIndex] == i) {
                continue;//避免相同位置相等
            }
            dfs(nums, curIndex + 1, curSum + i, sum);

        }


    }

    private static void m333() {
        //方法一就是通过找到每一个子串，然后对每一个子串进行判断，这个（判断：可以通过直接判断，也可以通过其他巧妙地方法尝试使用位运算，但是感觉都是比较n^2的复杂度，等会再看看）
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = s.length();
        long ans = 0;

        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                dp[i + 1][0] = dp[i][1];
                dp[i + 1][1] = dp[i][0] + 1;
            } else {
                dp[i + 1][0] = dp[i][1] + 1;
                dp[i + 1][1] = dp[i][0];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += Math.min(dp[j + 1][0] - dp[i][1 - (j - i) % 2], dp[j + 1][1] - dp[i][(j - i) % 2]);
            }
        }
        System.out.println(ans);
    }


    private static void m3() {
        //方法一就是通过找到每一个子串，然后对每一个子串进行判断，这个（判断：可以通过直接判断，也可以通过其他巧妙地方法尝试使用位运算，但是感觉都是比较n^2的复杂度，等会再看看）
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = s.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += check(s, i, j);
            }
        }
        System.out.println(ans);
    }

    private static long check(String s, int i, int j) {
        char c = '0';
        int cnt0 = 0, cnt1 = 0;
        for (int k = i; k <= j; k++) {
            if (s.charAt(k) != c) {
                cnt0++;
            } else {
                cnt1++;
            }
            c ^= 1;
        }
        return Math.min(cnt0, cnt1);
    }


    /**
     * 感觉可以用dp来优化不用，直接暴力就行了
     */
    private static void m2() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextLong();
        }
//        System.out.println("nums = " + Arrays.toString(nums));
        long sum = Arrays.stream(nums).sum();
        long ans = Integer.MIN_VALUE;
        for (int i = 0, j = 1; j < n; i++, j++) {
            long tmp = nums[i] * nums[j] + sum - nums[i] - nums[j];
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }


    @Override
    public String call() throws Exception {
        return "nihao";
    }
}