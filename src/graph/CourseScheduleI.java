package graph;//

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
    public static void main(String[] args){
        int numCourses = 2;
        int[][]  prerequisites = new int[][] {{1,0}};
        System.out.println(canFinish(numCourses,prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0 || prerequisites==null || prerequisites.length==0){
            return true;
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int count = queue.size();
        while(!queue.isEmpty()){
            int top=queue.remove();

            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==top){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]]==0){
                        count++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return count==numCourses;
    }
}

//    There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//
//
//        Example 1:
//
//        Input: numCourses = 2, prerequisites = [[1,0]]
//        Output: true
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0. So it is possible.
//        Example 2:
//
//        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//        Output: false
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0, and to take course 0 you should
//        also have finished course 1. So it is impossible.
//
//
//        Constraints:
//
//        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.
//        1 <= numCourses <= 10^5