import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SkylineProblem {
	
	public List<int[]> getSkyline(int[][] buildings){
		if(buildings == null || buildings.length == 0){
			return null;
		}
		BuildingPoints[] buildingPoints = new BuildingPoints[buildings.length*2];
		int index = 0;
		for(int[] building : buildings){
			buildingPoints[index] = new BuildingPoints();
			buildingPoints[index].x = building[0];
			buildingPoints[index].height = building[2];
			buildingPoints[index].isStart = true;
			
			buildingPoints[index + 1] = new BuildingPoints();
			buildingPoints[index + 1].x = building[1];
			buildingPoints[index + 1].height = building[2];
			buildingPoints[index + 1].isStart = false;
			index += 2;
		}
		
		Arrays.sort(buildingPoints);
		TreeMap<Integer, Integer> maxQueue = new TreeMap<>();
		maxQueue.put(0, 1);
		List<int[]> result = new ArrayList<>();
		int max = 0;
		for(int i=0; i<buildingPoints.length; i++){
			BuildingPoints buildingPoint = buildingPoints[i];
			if(buildingPoint.isStart){
				maxQueue.compute(buildingPoint.height, (key, value) -> {
					if(value != null){
						return value+1;
					}
					return 1;
				});
			}else {
				maxQueue.compute(buildingPoint.height, (key, value) -> {
					if(value == 1){
						return null;
					}
					return value-1;
				});
			}
			
			int currentMax = maxQueue.lastKey();
			if(currentMax != max){
				result.add(new int[] {buildingPoint.x, currentMax});
				max = currentMax;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
		SkylineProblem obj = new SkylineProblem();
		List<int[]> result = obj.getSkyline(buildings);
		
		for(int[] each : result){
			System.out.println(each[0] + ", " + each[1]);
		}
	}
}

class BuildingPoints implements Comparable<BuildingPoints>{
	public int x;
	public int height;
	public boolean isStart;
	
	@Override
	public int compareTo(BuildingPoints o) {
		if(this.x != o.x){
			return this.x - o.x;
		}else {
			return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
		}
	}
}
