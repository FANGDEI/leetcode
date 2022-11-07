package com.feng.draft;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @author FANG
 * @create 2021-10-21 22:19
 * 能够显示当前仓库中每件商品的id，商品名称，当前数量，总数量，要求能够添加商品，借出商品
 * 能够根据商品名称模糊查询商品的全部信息
 */
@SuppressWarnings({"all"})
public class Warehouse implements Serializable {
    /** Default warehouse's capacity */
    private static final int DEFAULT_CAPACITY = 15;
    /** Default increment */
    private static final int INCREMENT = 5;
    /** The id of the goods */
    public int id;
    /** The total nums of the warehouse */
    public int capacity;
    /** The current nums of the warehouse */
    public int currentNums;
    /** Reference to the goods */
    public Goods[] data;
    /** Similar goods count */
    private HashMap<String, Integer> map;
    /** The total number of similar products */
    private HashMap<String, Integer> totalCnt;

    /** No-args Constructor */
    Warehouse() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initialize the warehouse with the incoming capacity
     *
     * @param size The capacity of the warehouse
     */
    Warehouse(int size) {
        totalCnt = new HashMap<>();
        map = new HashMap<>();
        data = new Goods[size];
        capacity = size;
        currentNums = 0;
        id = 1;
    }

    /**
     * Whether the warehouse is empty
     *
     * @return Boolean true if the warehouse is empty, otherwise false
     */
    public boolean isEmpty() {
        return currentNums == 0;
    }

    /**
     * Whether the warehouse is full
     *
     * @return Boolean true for the warehouse is full, otherwise false
     */
    public boolean isFull() {
        return currentNums == capacity;
    }

    /**
     * Reset the capacity of the warehouse
     *
     * @param newCapacity The new capacity of the warehouse
     */
    private void reSize(int newCapacity) {
        Goods[] newData = new Goods[currentNums + newCapacity];
        for (int i = 0; i < currentNums; i++) {
            newData[i] =  data[i];
        }
        data = newData;
        newData = null; // gc recycling
        capacity += newCapacity;
    }

    /**
     * Add goods into the warehouse
     *
     * @param name The name of the new goods
     */
    public void addGoods(String name) {
        if (isFull()) {
            reSize(INCREMENT);
        }
        data[currentNums] = new Goods(name, id);
        id++;
        currentNums++;
        // 该商品的现有数量计数
        if (map.containsKey(name)) {
            map.put(name, map.get(name) + 1);
        } else {
            map.put(name, 1);
        }
        // 该商品的总数计数
        if (totalCnt.containsKey(name)) {
            totalCnt.put(name, totalCnt.get(name) + 1);
        } else {
            totalCnt.put(name, 1);
        }
        System.out.println("添加成功");
    }

    /**
     * Lend goods out
     *
     * @param name The name of the goods
     */
    public void lendGoods(String name) {
        if (isEmpty()) {
            System.out.println("仓库为空");
            return ;
        }
        int i;
        for (i = 0; i < this.currentNums; i++) {
            if (this.data[i].getName().equals(name)) {
                break;
            }
        }
        if (i >= this.currentNums) {
            System.out.println("未找到商品");
            return ;
        }
        for (int j = i; j < this.currentNums - 1; j++) {
            this.data[j] = this.data[j + 1];
        }
        map.put(name, map.get(name) - 1);
        currentNums--;
        System.out.println("出借成功");
    }

    /**
     * Query product information
     *
     * @param name The name of the goods
     */
    public void findGoods(String name) {
        boolean isFind = false;
        for (int i = 0; i < this.currentNums; i++) {
            if (this.data[i].getName().equals(name)) {
                isFind = true; // 根据名字找到商品 输出所有符合条件的商品
                System.out.println(data[i]);
            }
        }
        if (isFind) {
            return ;
        }
        // 没直接按名字找到商品, 进行模糊查找
        for (int i = 0; i < this.currentNums; i++) {
            if (this.data[i].getName().startsWith(name)) {
                isFind = true; // 模糊匹配成功
                System.out.println(data[i]);
            }
        }
        if (!isFind) {
            System.out.println("未找到商品");
        }
    }

    /**
     * Main method
     *
     * @param args null
     */
    public static void main(String[] args) {
        // Default store path
        String storePath = "D:\\store.txt";

        Scanner in = new Scanner(System.in);
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        File file = new File(storePath);

        Warehouse warehouse = null;

        try { // 文件不存在创建文件
            if (!file.exists()) {
                file.createNewFile();
                warehouse = new Warehouse();
            } else { // 文件存在则读出文件中存储的warehouse对象
                ois = new ObjectInputStream(new FileInputStream(storePath));
                Object o = null;
                try {
                    o = ois.readObject();
                    if (o != null) {
                        warehouse = (Warehouse) o;
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    ois.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------欢迎使用仓库管理系统----------");
        while (true) {
            System.out.println("1. 添加货品");
            System.out.println("2. 查询货品信息");
            System.out.println("3. 全部商品信息");
            System.out.println("4. 商品出借");
            System.out.println("0. 退出系统");

            int operator = 0;
            operator = in.nextInt();
            if (operator == 0) {
                break;
            }

            switch (operator) {
                case 1: {
                    System.out.println("输入添加的商品名:");
                    String name;
                    name = in.next();
                    warehouse.addGoods(name);
                    break;
                }
                case 2: {
                    System.out.println("请输入要查询的商品名");
                    String name;
                    name = in.next();
                    System.out.println("查询结果: ");
                    warehouse.findGoods(name);
                    break;
                }
                case 3: {
                    if (warehouse.isEmpty()) {
                        System.out.println("仓库为空");
                        break;
                    }
                    System.out.println("全部商品信息为:");
                    Set<String> set = warehouse.totalCnt.keySet();
                    for (String s : set) {
                        System.out.print(s + "总数为: " + warehouse.totalCnt.get(s) + " ");
                    }
                    System.out.println();
                    set = warehouse.map.keySet();
                    for (String s : set) {
                        System.out.print(s + "现有数为: " + warehouse.map.get(s) + " ");
                    }
                    System.out.println();
                    for (int i = 0; i < warehouse.currentNums; i++) {
                        System.out.println(warehouse.data[i]);
                    }
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("请输入要出借的商品名");
                    String name;
                    name = in.next();
                    warehouse.lendGoods(name);
                    break;
                }
                default:
                    System.out.println("输入有误, 请重新输入");
            }

            // 一次操作结束后 默认将内容写入到文件
            try {
                oos = new ObjectOutputStream(new FileOutputStream(storePath));
                oos.writeObject(warehouse);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // Exit close stream
        in.close();
    }
}

@SuppressWarnings({"all"})
class Goods implements Serializable {
    /** The name of the goods */
    public String name;
    /** The id of the goods */
    public int id;

    /**
     * Constructor
     *
     * @param name The name of the goods
     * @param id The id of the goods
     */
    Goods(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id = " + id + " name = " + name;
    }
}