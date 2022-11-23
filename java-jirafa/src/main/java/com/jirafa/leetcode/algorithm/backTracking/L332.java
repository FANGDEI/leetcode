package com.jirafa.leetcode.algorithm.backTracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class L332 {
    LinkedList<String> result;
    Boolean[] used;

    public List<String> findItinerary(List<List<String>> tickets){
        Collections.sort(tickets,(a,b)->a.get(1).compareTo(b.get(1)));
        used=new Boolean[tickets.size()];
        result=new LinkedList<>();
        result.add("JFK");
        Arrays.fill(used,false);
        backTracking(tickets);
        return result;
    }

    public boolean backTracking(List<List<String>> tickets){
        if(result.size()==tickets.size()+1){
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if(!used[i]&&tickets.get(i).get(0).equals(result.getLast())){
                result.add(tickets.get(i).get(1));
                used[i]=true;

                if(backTracking(tickets))
                    return true;

                result.removeLast();
                used[i]=false;
            }
        }

        return false;

    }
}
