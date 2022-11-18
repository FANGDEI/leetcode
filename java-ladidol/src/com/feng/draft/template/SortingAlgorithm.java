package com.feng.draft.template;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

/**
 * @author 冯小强
 */
public class SortingAlgorithm {
    final static int maxa = 100;
    final static int maxb = 1000;
    final static int maxc = 5000;
    final static int maxd = 10000;
    final static int maxe = 20000;

    static int[] a = new int[maxa];
    static int[] b = new int[maxb];
    static int[] c = new int[maxc];
    static int[] d = new int[maxd];
    static int[] e = new int[maxe];
    static{
        initShuZu();
    }


    static int[] a1 = Arrays.copyOf(a,a.length);
    static int[] b1 = Arrays.copyOf(b,b.length);
    static int[] c1 = Arrays.copyOf(c,c.length);
    static int[] d1 = Arrays.copyOf(d,d.length);
    static int[] e1= Arrays.copyOf(e,e.length);

    static int[] a2 = Arrays.copyOf(a,a.length);
    static int[] b2 = Arrays.copyOf(b,b.length);
    static int[] c2 = Arrays.copyOf(c,c.length);
    static int[] d2 = Arrays.copyOf(d,d.length);
    static int[] e2 = Arrays.copyOf(e,e.length);

    static int[] a3 = Arrays.copyOf(a,a.length);
    static int[] b3 = Arrays.copyOf(b,b.length);
    static int[] c3 = Arrays.copyOf(c,c.length);
    static int[] d3 = Arrays.copyOf(d,d.length);
    static int[] e3 = Arrays.copyOf(e,e.length);

    static int[] a4 = Arrays.copyOf(a,a.length);
    static int[] b4 = Arrays.copyOf(b,b.length);
    static int[] c4 = Arrays.copyOf(c,c.length);
    static int[] d4 = Arrays.copyOf(d,d.length);
    static int[] e4 = Arrays.copyOf(e,e.length);

    static int[] a5 = Arrays.copyOf(a,a.length);
    static int[] b5 = Arrays.copyOf(b,b.length);
    static int[] c5 = Arrays.copyOf(c,c.length);
    static int[] d5 = Arrays.copyOf(d,d.length);
    static int[] e5 = Arrays.copyOf(e,e.length);

    static int[] a6 = Arrays.copyOf(a,a.length);
    static int[] b6 = Arrays.copyOf(b,b.length);
    static int[] c6 = Arrays.copyOf(c,c.length);
    static int[] d6 = Arrays.copyOf(d,d.length);
    static int[] e6 = Arrays.copyOf(e,e.length);

    static int[] a7 = Arrays.copyOf(a,a.length);
    static int[] b7 = Arrays.copyOf(b,b.length);
    static int[] c7 = Arrays.copyOf(c,c.length);
    static int[] d7 = Arrays.copyOf(d,d.length);
    static int[] e7 = Arrays.copyOf(e,e.length);

    static int[] a8 = Arrays.copyOf(a,a.length);
    static int[] b8 = Arrays.copyOf(b,b.length);
    static int[] c8 = Arrays.copyOf(c,c.length);
    static int[] d8 = Arrays.copyOf(d,d.length);
    static int[] e8 = Arrays.copyOf(e,e.length);

    static int[] a9 = Arrays.copyOf(a,a.length);
    static int[] b9 = Arrays.copyOf(b,b.length);
    static int[] c9 = Arrays.copyOf(c,c.length);
    static int[] d9 = Arrays.copyOf(d,d.length);
    static int[] e9 = Arrays.copyOf(e,e.length);

    static int[] a10 = Arrays.copyOf(a,a.length);
    static int[] b10 = Arrays.copyOf(b,b.length);
    static int[] c10 = Arrays.copyOf(c,c.length);
    static int[] d10 = Arrays.copyOf(d,d.length);
    static int[] e10 = Arrays.copyOf(e,e.length);

    static int[] a11 = Arrays.copyOf(a,a.length);
    static int[] b11 = Arrays.copyOf(b,b.length);
    static int[] c11 = Arrays.copyOf(c,c.length);
    static int[] d11 = Arrays.copyOf(d,d.length);
    static int[] e11 = Arrays.copyOf(e,e.length);


    static long biJiaoCount = 0;
    static long swapCount = 0;


    public static void Swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }


    public static void Buddle_Sort(int a[], int n) {//冒泡排序
        int flag = 1;
        for (int i = n; i >= 0 && flag == 1; i--) {
            flag = 0;
            for (int j = 1; j < i; j++) {
                biJiaoCount++;
                if (a[j - 1] > a[j]) {
                    swapCount++;
                    Swap(a[j], a[j - 1]);
                    flag = 1;
                }
            }
        }

    }

    public static void Insert_Sort(int a[], int n) {//插入排序
        int temp;
        int j;
        for (int i = 1; i < n; i++) {
            temp = a[i];
            for (j = i; j > 0 && a[j - 1] > temp; j--) {
                biJiaoCount++;
                swapCount++;
                a[j] = a[j - 1];//如果i前面的数字有大于a[i]的,就将其后移
            }
            swapCount++;
            a[j] = temp;
        }
    }

    //希尔排序
    public static void Shell_Sort(int a[], int n) {
        int h = 1, D;
        int temp;
        int j, i;
        while (h < n / 3) {
            h = 3 * h + 1;  // 1 , 4 , 13 , 40 , 121 , 364 , 1093...
        }//先找到,1/3的长度;
        while (h >= 1) {
            D = h;//D为间隔
            for (i = D; i < n; i++) {

                biJiaoCount++;
                temp = a[i];
                for (j = i; j >= D && a[j - D] > temp; j -= D) {
                    swapCount++;
                    a[j] = a[j - D];
                }
                a[j] = temp;
            }
            h = h / 3;
        }
    }

    public static void Selection_Sort(int a[], int n) {//选择排序
        int j, i;
        for (i = 0; i < n; i++) {
            int max = 0;
            for (j = 1; j < n - i; j++) {
                biJiaoCount++;
                if (a[j] > a[max]) {
                    max = j;
                }
            }
            biJiaoCount++;
            if (max != (n - i - 1)) {
                swapCount++;

                int tmp = a[max];
                a[max] = a[n-i-1];
                a[n-i-1] = tmp;
            }
        }
    }

    //堆排序
    public static void PercDown(int A[], int p, int N) {
        int Parent, Child;
        int X;
        X = A[p];//x暂存父亲节点
        for (Parent = p; (Parent * 2 + 1) < N; Parent = Child) {
            //找到Child的值,
            Child = Parent * 2 + 1;
            biJiaoCount++;
            if ((Child != N - 1) && (A[Child] < A[Child + 1])) {
                Child++;
            }
            biJiaoCount++;
            if (X >= A[Child]) {
                break;
            } else {
                swapCount++;
                A[Parent] = A[Child];
            }
        }
        A[Parent] = X;
    }

    public static void Heap_Sort(int a[], int n) {
        int i;
        for (i = n / 2 - 1; i >= 0; i--) {
            //从最后一个节点的父亲开始判断,父子关系;
            PercDown(a, i, n);
        }
        for (i = n - 1; i > 0; i--) {
            //每次从堆底向上遍历完后
            // 都要将最上面的数
            // 给换到当前最后面的位置上去
            swapCount++;
            Swap(a[0], a[i]);
            //每一次遍历后,数组的可活动长度都要减一;
            // 直到,有序数组长度为n-1为止,就是当i自剪到1的时候就不用了
            PercDown(a, 0, i);
        }
    }

    /*归并排序,循环实现*/


    public static void mergeSort(int[] a) {
        int[] b = new int[a.length];
        int k = 1;
        while (k < a.length) {
            mergePass(a, b, k, a.length - 1);
            k = 2 * k;
            mergePass(b, a, k, a.length - 1);
            k = 2 * k;
        }
    }

    //将a[0...s-1]和a[s...2s-1]归并到b[0..2s-1]
    public static void mergePass(int[] a, int[] b, int s, int n) {
        int i = 0;
        while (i <= n - 2 * s + 1) {
            merge(a, b, i, i + s - 1, i + 2 * s - 1);
            i = i + 2 * s;
        }
        biJiaoCount++;
        if (i < i - s + 1) {
            merge(a, b, i, i + s - 1, n);
        } else {
            for (int j = i; j <= n; j++) {
                b[j] = a[j];
            }
        }

    }

    //将a[i..m]和a[m+1..n]归并到b[]
    public static void merge(int[] a, int[] b, int i, int m, int n) {
        int j;
        int k = i;
        for (j = m + 1; i <= m && j <= n; k++) {
            biJiaoCount++;
            swapCount++;
            if (a[i] < a[j]) {

                b[k] = a[i++];
            } else {
                b[k] = a[j++];
            }
        }
        while (i <= m) {
            biJiaoCount++;
            swapCount++;
            b[k] = a[i];
            k++;
            i++;
        }
        while (j <= n) {
            biJiaoCount++;
            swapCount++;
            b[k] = a[j];
            k++;
            j++;
        }
    }


    /*
     * 归并排序,递归实现*/
    public static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        int j = low, k = mid + 1;  //左边序列和右边序列起始索引
        while (j <= mid && k <= high) {
            biJiaoCount++;
            swapCount++;
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid) {
            biJiaoCount++;
            swapCount++;
            tmp[i++] = arr[j++];
        }

        while (k <= high) {
            biJiaoCount++;
            swapCount++;
            tmp[i++] = arr[k++];
        }

        for (int t = 0; t < i; t++) {
            biJiaoCount++;
            swapCount++;
            arr[low + t] = tmp[t];
        }
    }

    public static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, tmp); //对左边序列进行归并排序
            mergeSort(arr, mid + 1, high, tmp);  //对右边序列进行归并排序
            merge(arr, low, mid, high, tmp);    //合并两个有序序列
        }
    }


    //快排
    public static void quickSort(int[] array,int low,int hight){
        //if (array.length < 1 || low < 0 || hight >= array.length || low > hight) return null;
        if(low < hight){
            int privotpos = partition(array,low,hight);
            quickSort(array,low,privotpos - 1);
            quickSort(array,privotpos + 1,hight);
        }

    }

    public static int partition(int[] array,int low,int hight){
        int privot = array[low];
        while(low < hight){
            while(low < hight && array[hight] >= privot) {
                --hight;
            }
            array[low] = array[hight];
            while(low < hight && array[low] <= privot) {
                ++low;
            }
            array[hight] = array[low];
        }
        array[low] = privot;
        return low;
    }


    //基数排序
    public static void radixSort(int[] arr) {
        // 二维数组，存放 10 个桶和各桶中的元素
        int[][] bucket = new int[10][arr.length];
        // 一维数组，记录每个桶中元素的个数
        int[] elementCounts = new int[10];
        // 获取待排序数组中最大数
        int max = 0;
        for (int num : arr) {
            if (max < num) {
                biJiaoCount++;
                max = num;
            }
        }
        // 获取最大数的位数 ==> 转成字符串求长度
        int digits = ("" + max).length();
        // 排序，K 为当前比较位数，个、十、百、千...
        for (int i = 0, k = 1; i < digits; i++, k *= 10) {
            // 将 arr 中的数据按规则放入桶中
            for (int num : arr) {
                int m = num / k % 10;  // 第 m 个桶
                int n = elementCounts[m];  // 第 m 个桶中的第 n 个位置
                bucket[m][n] = num;
                elementCounts[m]++;
            }
            // 将桶中的数据依次放回 arr 中，进行下一轮排序
            int index = 0;
            for (int j = 0; j < 10; j++) {  // 一共 10 个桶
                biJiaoCount++;
                biJiaoCount++;
                if (elementCounts[j] == 0) {
                    continue;  // 如果第 j 个桶中的元素个数为 0，换下一个桶
                }
                for (int l = 0; l < elementCounts[j]; l++) {
                    biJiaoCount++;
                    arr[index] = bucket[j][l];
                    swapCount++;
                    index++;
                }
                elementCounts[j] = 0;  // 元素个数清零
            }
        }
    }


    //计数排序
    public static void jiShu(int[] arrays) {

        int min = arrays[0], max = arrays[0];

        for (int i = 0; i < arrays.length; i++) {

            biJiaoCount++;
            biJiaoCount++;
            min = min > arrays[i] ? arrays[i] : min;

            max = max < arrays[i] ? arrays[i] : max;

        }


        int[] jiShuArrays = new int[max + 1];

        for (int i = 0; i < arrays.length; i++) {

            biJiaoCount++;
            int value = arrays[i];

            jiShuArrays[value] += 1;

        }


        for (int i = 0, a = 0; i < jiShuArrays.length; i++) {

            if (jiShuArrays[i] > 0) {
                swapCount++;
                arrays[a++] = i;

            }

        }

    }

    //桶排序
    public static void bucketSort(int[] arr){
        // 计算最大值与最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            biJiaoCount++;
            biJiaoCount++;
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            biJiaoCount++;
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            biJiaoCount++;
            swapCount++;
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        // 对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        // 将桶中的元素赋值到原序列
        int index = 0;
        for(int i = 0; i < bucketArr.size(); i++){
            biJiaoCount++;
            for(int j = 0; j < bucketArr.get(i).size(); j++){
                swapCount++;
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }
    /*=======================================================================================*/

    public static void Count(){
        System.out.print(" 比较次数:"+biJiaoCount + " ");
        System.out.print(" 交换次数:"+swapCount + ";         ");
        biJiaoCount = 0;
        swapCount = 0;
    }



    public static void SORT1(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //冒泡
        System.out.println("冒泡排序:");
        long start1 = System.nanoTime();
        Buddle_Sort(a, a.length);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒 ");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Buddle_Sort(b, b.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        Buddle_Sort(c, c.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        Buddle_Sort(d, d.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        Buddle_Sort(e, e.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


    }

    public static void SORT2(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //选择
        System.out.println("选择排序:");
        long start1 = System.nanoTime();
        Selection_Sort(a, a.length);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Selection_Sort(b, b.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Selection_Sort(c, c.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Selection_Sort(d, d.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Selection_Sort(e, e.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

    }

    public static void SORT3(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //插入排序
        System.out.println("插入排序:");
        long start1 = System.nanoTime();
        Insert_Sort(a, a.length);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Insert_Sort(b, b.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Insert_Sort(c, c.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Insert_Sort(d, d.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Insert_Sort(e, e.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

    }

    public static void SORT4(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //希尔
        System.out.println("希尔排序:");
        long start1 = System.nanoTime();
        Shell_Sort(a, a.length);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Shell_Sort(b, b.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Shell_Sort(c, c.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Shell_Sort(d, d.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Shell_Sort(e, e.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

    }

    public static void SORT5(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //堆排序
        System.out.println("堆排序:");
        long start1 = System.nanoTime();
        Heap_Sort(a, a.length);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Heap_Sort(b, b.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Heap_Sort(c, c.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        Heap_Sort(d, d.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        Heap_Sort(e, e.length);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();

        System.out.println();

    }

    public static void SORT6(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //归并排序,循环实现
        System.out.println("归并排序:");

        long start1 = System.nanoTime();
        mergeSort(a);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        mergeSort(b);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        mergeSort(d);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        mergeSort(d);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        mergeSort(e);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();

        System.out.println();

    }


    public static void SORT8(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //基数排序
        System.out.println("基数排序:");

        long start1 = System.nanoTime();
        radixSort(a);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        radixSort(b);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        radixSort(c);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        radixSort(d);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        radixSort(e);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();

        System.out.println();
    }


    public static void SORT9(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //快速排序
        System.out.println("快排:");

        long start1 = System.nanoTime();
        quickSort(a,0, a.length-1);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(10000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        quickSort(b,0, b.length-1);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        quickSort(c,0, c.length-1);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        quickSort(d,0, d.length-1);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        quickSort(e,0, e.length-1);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();

        System.out.println();
    }

    public static void SORT10(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //计数排序
        System.out.println("计数排序:");
        long start1 = System.nanoTime();
        jiShu(a);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        jiShu(b);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        jiShu(c);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        jiShu(d);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        jiShu(e);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();

        System.out.println();
    }

    public static void SORT7(int[] a, int[] b, int[] c, int[] d, int[] e) {
        //桶排序
        System.out.println("桶排序:");
        long start1 = System.nanoTime();
        bucketSort(a);
        long end1 = System.nanoTime();
        BigDecimal start = new BigDecimal(start1);
        BigDecimal end = new BigDecimal(end1);
        System.out.print("  100数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        bucketSort(b);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  1000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        bucketSort(c);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  5000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();


        start1 = System.nanoTime();
        bucketSort(d);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  10000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();
        System.out.println();

        start1 = System.nanoTime();
        bucketSort(e);
        end1 = System.nanoTime();
        start = new BigDecimal(start1);
        end = new BigDecimal(end1);
        System.out.print("  20000数据为:" + (end.subtract(start)).divide(
                new BigDecimal(1000000), 6, RoundingMode.HALF_UP) + "毫秒");
        Count();

        System.out.println();


    }

    //数字混乱数组产生函数
    public static void initShuZu() {
        for (int i = 0; i < maxa; i++) {
            a[i] = new Random().nextInt(500000);
        }
        for (int i = 0; i < maxb; i++) {
            b[i] = new Random().nextInt(500000);
        }
        for (int i = 0; i < maxc; i++) {
            c[i] = new Random().nextInt(500000);
        }
        for (int i = 0; i < maxd; i++) {
            d[i] = new Random().nextInt(500000);
        }
        for (int i = 0; i < maxe; i++) {
            e[i] = new Random().nextInt(500000);
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println();
            System.out.println("||经典排序算法比较||");
            System.out.print("(1) 自己测试;\n(2) 系统内置数据比较;\n(3) 输入3退出系统;\n请输入你的选择:");
            Scanner scan = new Scanner(System.in);
            int m = scan.nextInt();
            if (m == 1) {
                System.out.print("请输入你要对多少个数进行排序:");
                int n = scan.nextInt();
                int[] shu = new int[n];
                System.out.println("请输入这" + n + "个数");
                for (int i = 0; i < n; i++) {
                    shu[i] = scan.nextInt();
                }
                System.out.println("1.冒泡排序2.插入排序3.希尔排序4.选择排序5.堆排序6.归并排序" +
                        "7.桶排序8.快速排序9.基数排序10.计数排序\n请输入你的选择:");
                n = scan.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("冒泡排序:");
                        Buddle_Sort(shu, shu.length);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 2:
                        System.out.println("插入排序:");
                        Insert_Sort(shu, shu.length);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 3:
                        System.out.println("希尔排序:");
                        Shell_Sort(shu, shu.length);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 4:
                        System.out.println("选择排序:");
                        Selection_Sort(shu, shu.length);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 5:
                        System.out.println("堆排序:");
                        Heap_Sort(shu, shu.length);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 6:
                        System.out.println("归并排序:");
                        mergeSort(shu);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 7:
                        System.out.println("桶排序:");
                        bucketSort(shu);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 8:
                        System.out.println("快速排序:");
                        quickSort(shu, 0,shu.length-1);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 9:
                        System.out.println("基数排序:");
                        radixSort(shu);
                        System.out.println(Arrays.toString(shu));
                        break;
                    case 10:
                        System.out.println("计数排序:");
                        jiShu(shu);
                        System.out.println(Arrays.toString(shu));
                        break;
                }
            } else if (m == 2) {
                SORT1(a1, b1, c1, d1, e1);
                SORT2(a2, b2, c2, d2, e2);
                SORT3(a3, b3, c3, d3, e3);
                SORT4(a4, b4, c4, d4, e4);
                SORT5(a5, b5, c5, d5, e5);
                SORT6(a6, b6, c6, d6, e6);
                SORT7(a7, b7, c7, d7, e7);
                SORT8(a8, b8, c8, d8, e8);
                SORT9(a9, b9, c9, d9, e9);
                SORT10(a10, b10, c10, d10, e10);
            } else if (m == 3) {
                break;
            } else {
                /*多少次比较*/

                System.out.println("输入有错请重新输入:");
            }


        }


    }
}
