package com.jirafa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(1,k,n);
        return result;
    }
    public void backTracking(int start,int k,int sum){
        if(path.size()==k){
            int s=0;
            for(int i:path){
                s+=i;
            }
            if(s==sum)
                result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=9-(k-path.size())+1;i++){
            if(!path.contains(i))
            path.add(i);
            backTracking(start+1,k,sum);
            path.removeLast();
        }
    }
}
