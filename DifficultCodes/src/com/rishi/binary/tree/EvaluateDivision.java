package com.rishi.binary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EvaluateDivision {

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, ArrayList<String>> pairs = new HashMap<>();
		HashMap<String, ArrayList<Double>> valuePairs = new HashMap<>();
		
		for(int i=0; i<equations.length; i++){
			String[] eqs = equations[i];
			if(!pairs.containsKey(eqs[0])){
				pairs.put(eqs[0], new ArrayList<>());
				valuePairs.put(eqs[0], new ArrayList<>());
			}
			
			if(!pairs.containsKey(eqs[1])){
				pairs.put(eqs[1], new ArrayList<>());
				valuePairs.put(eqs[1], new ArrayList<>());
			}
			
			pairs.get(eqs[0]).add(eqs[1]);
			pairs.get(eqs[1]).add(eqs[0]);
			valuePairs.get(eqs[0]).add(values[i]);
			valuePairs.get(eqs[1]).add(1/values[i]);
		}
		
		double[] result = new double[queries.length];
		for(int i=0; i<queries.length; i++){
			String[] q = queries[i];
			result[i] = dfs(q[0], q[1], pairs, valuePairs, new HashSet<>(), 1.0);
			if(result[i] == 0.0)
				result[i] = -1.0;
		}
		
		return result;
	}
	
	public double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> valuePairs, HashSet<String> set, double value){
		if(set.contains(start))
			return 0.0;
		if(!pairs.containsKey(start))
			return 0.0;
		if(start.equals(end))
			return value;
		
		set.add(start);
		ArrayList<String> strList = pairs.get(start);
		ArrayList<Double> valueList = valuePairs.get(start);
		double temp = 0;
		for(int i=0; i<strList.size(); i++){
			temp = dfs(strList.get(i), end, pairs, valuePairs, set, value*valueList.get(i));
			if(temp != 0.0){
				break;
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		String[][] equations = {{"a", "b"}, {"b", "c"}};
		String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
		double[] values = {2.0, 3.0};
		
		System.out.println(12%26);
		EvaluateDivision obj = new EvaluateDivision();
		double[] result = obj.calcEquation(equations, values, queries);
		for(double val : result){
			System.out.print(val + ", ");
		}
		
	}
}
