package com.rishi.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * We will be given course nos form 0 to n-1, and each course will be paired with its pre-req 
 * class. Finally we need return the sequence in which we need to take the course.
 * 
 * Idea is to:
 * 1. Have 2 arrays with numCourses length to save the given course appeared in the input array
 * 2. Second is to save the final order of courses
 * 3. A queue to save the courses while iterating
 * 4. Populate one array with number of time the given course appears
 * 5. Where the value is 0 is our starting point, add this to queue
 * 6. Start iterating over queue till its empty, for each queue element:
 * 		a. Loop over the give pre reqs
 * 		b. Check if queue element is same as given pre req
 * 		c. If yes, then reduce the value of times it appeared in the array
 * 		d. If in the process the value is 0, add it to queue and order (result array)
 * @author rishi
 *
 */
public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        char[] arr = {'a', 't', 's', 'e', 'a'};
        
        Arrays.sort(arr);
        System.out.println(arr);
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<prerequisites.length; i++){
        	inDegree[prerequisites[i][0]]++;
        }
        
        for(int i=0; i<numCourses; i++){
        	if(inDegree[i] == 0){
        		queue.offer(i);
        		order[index++] = i;
        	}
        }
        
        while(!queue.isEmpty()){
        	int prereq = queue.poll();
        	for(int i=0; i<prerequisites.length; i++){
        		if(prerequisites[i][1] == prereq){
        			inDegree[prerequisites[i][0]]--;
        			if(inDegree[prerequisites[i][0]] == 0){
        				order[index++] = prerequisites[i][0];
        				queue.offer(prerequisites[i][0]);
        			}
        		}
        	}
        }
        
        return (index == numCourses) ? order : new int[0];
    }
	
	public static void main(String[] args) {
		CourseScheduleII obj = new CourseScheduleII();
		int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
		int[] result = obj.findOrder(4, prerequisites);
		for(int i=0; i<result.length; i++){
			System.out.print(result[i] + ",");
		}
	}
}
