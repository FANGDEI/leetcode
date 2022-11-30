package com.feng.saike.第五届.B组初赛;

import java.util.Scanner;

/**
 * @author: ladidol
 * @date: 2022/11/26 17:19
 * @description:
 */
public class S4 {


    /**
     * 作者：Ladidol
     * 描述：得到第x块的最左边的头位置
     */
    static long getIndex(long x) {
        return 2 * x * x - x + 1;
    }

    /**
     * 作者：Ladidol
     * 描述：用二分查找得到第k个位置是在第几块图形中
     */
    static long find(long k) {
        long res = -1, mid, l = 0, r = k;
        while (l <= r) {
            mid = (l + r) / 2;
            if (getIndex(mid) < k) {
                res = mid;
                l = mid + 1;
            } else if (getIndex(mid) == k) {
                return mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    /**
     * 作者：Ladidol
     * 描述：得到k在这个块中的位置
     */
    static long solve(long k, long pos) {
        long dis = k - getIndex(pos);
        //
        if (dis <= pos) {//在块一
            return dis;
        } else if (dis <= 2 * pos) {
            return 2 * pos - dis;
        } else if (dis <= 3 * pos) {
            return 2 * pos - dis;
        } else {
            return dis - 4 * pos;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            long k = scan.nextLong();
            System.out.println(solve(k,find(k)));
        }
    }
}

//
//    #include<bits/stdc++.h>
//    using namespace
//    std;
//    typedef long
//    long ll;
//const
//    int N = 2e5 + 3;
//
//    __int128 func(__int128 x) {
//        return 2l l * x * x - x + 1;
//    }
//
//    __int128 find(__int128 k) {
//        __int128 res, mid, l = 0, r = k;
//        while (l <= r) {
//            mid = (l + r) / 2;
//            if (func(mid) < k) {
//                res = mid;
//                l = mid + 1;
//            } else if (func(mid) == k)
//                return mid;
//            else
//                r = mid - 1;
//        }
//        return res;
//    }
//
//
//    ll solve(__int128 k, __int128 pos) {
//        __int128 dis = k - func(pos);
//        if (dis <= pos)
//            return dis;
//        else if (dis <= 2 * pos)
//            return 2 * pos - dis;
//        else if (dis <= 3 * pos)
//            return 2 * pos - dis;
//        else
//            return dis - 4 * pos;
//    }
//
//    int main() {
//        ios::sync_with_stdio (false);
//        cin.tie(0);
//        cout.tie(0);
//        int T;
//        ll n;
//        cin >> T;
//        for (int kase = 1; kase <= T; ++kase) {
//            cin >> n;
//            cout << solve(n, find(n));
//        }
//        return 0;
//    }
///*
//2i^2-i+1
//0 1 1
//1 2 6
//2 7 15
//3 16 28
//[-i,i],k
//*/
//
//
//}