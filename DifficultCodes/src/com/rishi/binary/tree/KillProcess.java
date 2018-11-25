package com.rishi.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two lists
 * 1. PIDs [1, 3, 10, 5]
 * 2. PPIDs [3, 0, 5, 3]
 * 
 * 0 is for root
 * Idea is to:
 * 1. Create map of PPIDs and their relevant PIDs
 * 2. Then use BFS method using queues to store the nodes
 * @author rishi
 *
 */
public class KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		 HashMap < Integer, List < Integer >> map = new HashMap < > ();
	        for (int i = 0; i < ppid.size(); i++) {
	            if (ppid.get(i) > 0) {
	                List < Integer > l = map.getOrDefault(ppid.get(i), new ArrayList < Integer > ());
	                l.add(pid.get(i));
	                map.put(ppid.get(i), l);
	            }
	        }
	        Queue < Integer > queue = new LinkedList < > ();
	        List < Integer > l = new ArrayList < > ();
	        queue.add(kill);
	        while (!queue.isEmpty()) {
	            int r = queue.remove();
	            l.add(r);
	            if (map.containsKey(r))
	                for (int id: map.get(r))
	                    queue.add(id);
	        }
	        return l;
    }
	
	public static void main(String[] args) {
		KillProcess obj = new KillProcess();
		List<Integer> pid = Arrays.asList(1, 3, 10, 5);
		List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
		int kill = 5;
		
		System.out.println("Result "+ obj.killProcess(pid, ppid, kill));
	}
}
