package com.feng.leetcode.LCCUP;

/**
 * @projectName: leetcode
 * @package: com.feng.leetcode.LCCUP
 * @className: 第三题弹珠游戏
 * @author: Ladidol
 * @description:
 * @date: 2022/9/24 16:03
 * @version: 1.0
 */
public class _3第三题弹珠游戏 {


    // 感觉可以用dp来做：两个dp：横向和纵向。
    class Solution {

        public int[][] ballGame(int num, String[] plate) {
            return null;
        }
    }
    //别人的答案
    class Solution2 {
        char arr[][];
        //1为上 2为左 3为下 4为右
        int n,m;
        int res[][]=new int [5000][2];int k=0;
        int dfs(int i,int j,int c,int num){
            int sum=num;
            int a=i;int b=j;
            if(arr[i][j]!='.')return 0;
            while(sum>=0){

                if(arr[i][j]=='E'){c++;if(c>4)c=1;}
                if(arr[i][j]=='W'){c--;if(c<1)c=4;}
                if(arr[i][j]=='O'){
                    res[k][0]=a;res[k][1]=b;k++;
                    //System.out.println(i+" "+j+" "+num);
                    return 1;
                }
                if(c==1){
                    i--;
                }
                else if(c==2){
                    j++;
                }
                else if(c==3){
                    i++;
                }
                else if(c==4){
                    j--;
                }
                if(i<0||i>=n||j<0||j>=m)break;
                sum--;
            }
            return 0;
        }
        public int[][] ballGame(int num, String[] plate) {

            int nn=plate.length;int mm=plate[0].length();
            n=nn;m=mm;
            arr=new char[n][m];
            int v=0;
            for(String s:plate){
                arr[v++]=s.toCharArray();
            }

            for(int j=1;j<m-1;j++){
                dfs(0,j,3,num);
            }
            for(int j=1;j<m-1;j++){
                dfs(n-1,j,1,num);
            }
            for(int i=1;i<n-1;i++){
                dfs(i,0,2,num);
            }
            for(int i=1;i<n-1;i++){
                dfs(i,m-1,4,num);
            }
            v=0;
            int res1[][]=new int [k][2];
            for(int i=0;i<k;i++){
                res1[i][0]=res[i][0];
                res1[i][1]=res[i][1];
            }
            return res1;
        }
    }
}
