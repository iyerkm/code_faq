package graph;

import java.util.Arrays;
import java.util.HashSet;

//use union find
public class LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] arr = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(findLongestConsecutiveSequence(arr));
        //should be 4
    }
    public static int findLongestConsecutiveSequence(int[] arr){
        if(arr==null || arr.length==0) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num:arr){ set.add(num);}
        int result=0;

        for(int num:arr){
            int count=1;
            int down=num-1;
            while(set.contains(down)){
                count++;
                down--;
            }
            int up=num+1;
            while(set.contains(up)){
                count++;
                up++;
            }
            result=Math.max(result,count);
        }
        return result;
    }
}

//    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//        Your algorithm should run in O(n) complexity.
//
//        Example:
//
//        Input: [100, 4, 200, 1, 3, 2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.