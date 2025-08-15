package com.feng.面试题.海港城科技;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 区域分区算法 - 贪心策略
 * 目标：将城市按数据量分配到固定大小的区域中，使得每个区域的数据量尽可能接近目标值
 * 
 * 算法思路：
 * 1. 按数据量降序排列城市（贪心策略：优先处理大数据量城市）
 * 2. 遍历每个城市，尝试将其放入现有区域
 * 3. 如果现有区域都无法容纳，则创建新区域
 * 
 * 时间复杂度：O(n * m)，其中 n 是城市数量，m 是区域数量
 * 空间复杂度：O(n)
 */
public class RegionPartition {

    public static void main(String[] args) {
        // 生成测试数据
        List<City> cities = generateTestCities(100);

        // 设置目标区域大小
        int targetRegionSize = 1000000;

        System.out.println("=== 原始贪心算法（First Fit） ===");
        // 执行原始分区算法
        Map<Integer, List<City>> regions1 = partitionCities(cities, targetRegionSize);
        printResults(regions1, targetRegionSize);

        System.out.println("\n" + createSeparator(50) + "\n");

        System.out.println("=== 优化版贪心算法（Worst Fit） ===");
        // 执行优化版分区算法
        Map<Integer, List<City>> regions2 = partitionCitiesOptimized(cities, targetRegionSize);
        printResults(regions2, targetRegionSize);

        System.out.println("\n" + createSeparator(50) + "\n");

        System.out.println("=== 平衡版贪心算法（Best Fit） ===");
        // 执行平衡版分区算法
        Map<Integer, List<City>> regions3 = partitionCitiesBalanced(cities, targetRegionSize);
        printResults(regions3, targetRegionSize);

        System.out.println("\n" + createSeparator(50) + "\n");

        System.out.println("=== 最佳适配算法（Best Fit） ===");
        // 执行最佳适配算法
        Map<Integer, List<City>> regions4 = partitionCitiesBestFit(cities, targetRegionSize);
        printResults(regions4, targetRegionSize);
    }

    /**
     * 创建分隔线
     * 
     * @param length 分隔线长度
     * @return 分隔线字符串
     */
    private static String createSeparator(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("=");
        }
        return sb.toString();
    }

    /**
     * 生成测试城市数据
     * 
     * @param count 城市数量
     * @return 城市列表
     */
    private static List<City> generateTestCities(int count) {
        List<City> cities = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String cityName = "City" + (i + 1);
            // 生成 100000-300000 之间的随机数据量
            int dataCount = random.nextInt(200000) + 100000;
            cities.add(new City(cityName, dataCount));
        }

        return cities;
    }

    /**
     * 贪心算法：将城市分区到固定大小的区域中
     * 
     * 算法步骤：
     * 1. 按数据量降序排序城市（贪心策略）
     * 2. 遍历每个城市，寻找最适合的区域
     * 3. 如果找不到合适的区域，创建新区域
     * 
     * @param cities           城市列表
     * @param targetRegionSize 目标区域大小
     * @return 区域映射（区域ID -> 城市列表）
     */
    public static Map<Integer, List<City>> partitionCities(List<City> cities, int targetRegionSize) {
        // 第一步：按数据量降序排序（贪心策略 - 优先处理大数据量城市）
        Collections.sort(cities, Comparator.comparingInt(c -> -c.dataCount));

        Map<Integer, List<City>> regions = new HashMap<>();
        int regionCount = 0;

        // 第二步：遍历每个城市，进行分区
        for (City city : cities) {
            boolean added = false;

            // 尝试将城市添加到现有区域
            for (int regionIndex : regions.keySet()) {
                List<City> region = regions.get(regionIndex);
                int currentSize = calculateRegionSize(region);

                // 检查是否可以添加到当前区域
                if (currentSize + city.dataCount <= targetRegionSize) {
                    region.add(city);
                    added = true;
                    break; // 找到合适区域，跳出循环
                }
            }

            // 如果现有区域都无法容纳，创建新区域
            if (!added) {
                List<City> newRegion = new ArrayList<>();
                newRegion.add(city);
                regions.put(regionCount, newRegion);
                regionCount++;
            }
        }

        return regions;
    }

    /**
     * 优化版贪心算法：使用优先队列优化区域选择
     * 
     * 优化点：
     * 1. 使用优先队列维护区域剩余空间，优先选择剩余空间最大的区域
     * 2. 减少遍历次数，提高效率
     * 
     * @param cities           城市列表
     * @param targetRegionSize 目标区域大小
     * @return 区域映射（区域ID -> 城市列表）
     */
    public static Map<Integer, List<City>> partitionCitiesOptimized(List<City> cities, int targetRegionSize) {
        // 按数据量降序排序
        Collections.sort(cities, Comparator.comparingInt(c -> -c.dataCount));

        Map<Integer, List<City>> regions = new HashMap<>();
        // 优先队列：按剩余空间降序排列（剩余空间大的优先）
        PriorityQueue<RegionInfo> regionQueue = new PriorityQueue<>((a, b) -> b.remainingSpace - a.remainingSpace);
        int regionCount = 0;

        for (City city : cities) {
            RegionInfo bestRegion = null;

            // 寻找最适合的区域（剩余空间最大的且能容纳当前城市）
            while (!regionQueue.isEmpty()) {
                RegionInfo region = regionQueue.poll();
                if (region.remainingSpace >= city.dataCount) {
                    bestRegion = region;
                    break;
                }
            }

            if (bestRegion != null) {
                // 添加到现有区域
                regions.get(bestRegion.id).add(city);
                bestRegion.remainingSpace -= city.dataCount;
                regionQueue.offer(bestRegion);
            } else {
                // 创建新区域
                List<City> newRegion = new ArrayList<>();
                newRegion.add(city);
                regions.put(regionCount, newRegion);

                RegionInfo newRegionInfo = new RegionInfo(regionCount, targetRegionSize - city.dataCount);
                regionQueue.offer(newRegionInfo);
                regionCount++;
            }
        }

        return regions;
    }

    /**
     * 区域信息类（用于优先队列）
     */
    private static class RegionInfo {
        int id; // 区域ID
        int remainingSpace; // 剩余空间

        RegionInfo(int id, int remainingSpace) {
            this.id = id;
            this.remainingSpace = remainingSpace;
        }
    }

    /**
     * 平衡版贪心算法：优先选择利用率最高的区域
     * 
     * 优化策略：
     * 1. 优先选择当前利用率最高的区域（剩余空间最小的）
     * 2. 这样可以避免某些区域利用率过低
     * 3. 确保数据量分布更加均匀
     * 
     * @param cities           城市列表
     * @param targetRegionSize 目标区域大小
     * @return 区域映射（区域ID -> 城市列表）
     */
    public static Map<Integer, List<City>> partitionCitiesBalanced(List<City> cities, int targetRegionSize) {
        // 按数据量降序排序
        Collections.sort(cities, Comparator.comparingInt(c -> -c.dataCount));

        Map<Integer, List<City>> regions = new HashMap<>();
        // 优先队列：按剩余空间升序排列（剩余空间小的优先，即利用率高的优先）
        PriorityQueue<RegionInfo> regionQueue = new PriorityQueue<>((a, b) -> a.remainingSpace - b.remainingSpace);
        int regionCount = 0;

        for (City city : cities) {
            RegionInfo bestRegion = null;
            List<RegionInfo> tempList = new ArrayList<>();

            // 寻找最适合的区域（优先选择利用率高的区域）
            while (!regionQueue.isEmpty()) {
                RegionInfo region = regionQueue.poll();
                tempList.add(region);

                if (region.remainingSpace >= city.dataCount) {
                    bestRegion = region;
                    break;
                }
            }

            // 将其他区域重新放回队列
            for (RegionInfo region : tempList) {
                if (region != bestRegion) {
                    regionQueue.offer(region);
                }
            }

            if (bestRegion != null) {
                // 添加到现有区域
                regions.get(bestRegion.id).add(city);
                bestRegion.remainingSpace -= city.dataCount;
                regionQueue.offer(bestRegion);
            } else {
                // 创建新区域
                List<City> newRegion = new ArrayList<>();
                newRegion.add(city);
                regions.put(regionCount, newRegion);

                RegionInfo newRegionInfo = new RegionInfo(regionCount, targetRegionSize - city.dataCount);
                regionQueue.offer(newRegionInfo);
                regionCount++;
            }
        }

        return regions;
    }

    /**
     * 最佳适配算法：选择剩余空间最接近当前城市大小的区域
     * 
     * 优化策略：
     * 1. 选择剩余空间最接近且不小于当前城市大小的区域
     * 2. 这样可以最小化空间浪费
     * 3. 确保数据量分布最均匀
     * 
     * @param cities           城市列表
     * @param targetRegionSize 目标区域大小
     * @return 区域映射（区域ID -> 城市列表）
     */
    public static Map<Integer, List<City>> partitionCitiesBestFit(List<City> cities, int targetRegionSize) {
        // 按数据量降序排序
        Collections.sort(cities, Comparator.comparingInt(c -> -c.dataCount));

        Map<Integer, List<City>> regions = new HashMap<>();
        int regionCount = 0;

        for (City city : cities) {
            int bestRegionId = -1;
            int minWaste = Integer.MAX_VALUE;

            // 寻找最佳适配的区域（剩余空间最接近且不小于当前城市大小）
            for (int regionId : regions.keySet()) {
                List<City> region = regions.get(regionId);
                int currentSize = calculateRegionSize(region);
                int remainingSpace = targetRegionSize - currentSize;

                if (remainingSpace >= city.dataCount) {
                    int waste = remainingSpace - city.dataCount; // 计算浪费的空间
                    if (waste < minWaste) {
                        minWaste = waste;
                        bestRegionId = regionId;
                    }
                }
            }

            if (bestRegionId != -1) {
                // 添加到最佳适配区域
                regions.get(bestRegionId).add(city);
            } else {
                // 创建新区域
                List<City> newRegion = new ArrayList<>();
                newRegion.add(city);
                regions.put(regionCount, newRegion);
                regionCount++;
            }
        }

        return regions;
    }

    /**
     * 计算区域的总数据量
     * 
     * @param region 区域城市列表
     * @return 总数据量
     */
    private static int calculateRegionSize(List<City> region) {
        return region.stream().mapToInt(c -> c.dataCount).sum();
    }

    /**
     * 输出分区结果
     * 
     * @param regions    区域映射
     * @param targetSize 目标区域大小
     */
    private static void printResults(Map<Integer, List<City>> regions, int targetSize) {
        System.out.println("=== 区域分区结果 ===");
        System.out.println("目标区域大小: " + targetSize);
        System.out.println("总区域数量: " + regions.size());
        System.out.println();

        for (Map.Entry<Integer, List<City>> entry : regions.entrySet()) {
            int regionId = entry.getKey();
            List<City> region = entry.getValue();
            int actualSize = calculateRegionSize(region);

            System.out.println("Region " + regionId + " (实际大小: " + actualSize +
                    ", 利用率: " + String.format("%.2f%%", (double) actualSize / targetSize * 100) + "):");

            for (City city : region) {
                System.out.println("  " + city.name + " - " + city.dataCount);
            }
            System.out.println();
        }

        // 统计信息
        printStatistics(regions, targetSize);
    }

    /**
     * 打印统计信息
     * 
     * @param regions    区域映射
     * @param targetSize 目标区域大小
     */
    private static void printStatistics(Map<Integer, List<City>> regions, int targetSize) {
        System.out.println("=== 统计信息 ===");

        int totalCities = regions.values().stream().mapToInt(List::size).sum();
        int totalData = regions.values().stream()
                .mapToInt(region -> calculateRegionSize(region))
                .sum();

        double avgUtilization = regions.values().stream()
                .mapToDouble(region -> (double) calculateRegionSize(region) / targetSize)
                .average()
                .orElse(0.0);

        System.out.println("总城市数量: " + totalCities);
        System.out.println("总数据量: " + totalData);
        System.out.println("平均区域利用率: " + String.format("%.2f%%", avgUtilization * 100));
    }

    /**
     * 城市类
     */
    static class City {
        String name; // 城市名称
        int dataCount; // 数据量

        City(String name, int dataCount) {
            this.name = name;
            this.dataCount = dataCount;
        }
    }
}