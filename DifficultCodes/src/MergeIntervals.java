import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start != o2.start){
					return o1.start - o2.start;
				}else {
					return o1.end - o2.end;
				}
			}
		});
        
        Interval prev = intervals.get(0);
        List<Interval> result = new ArrayList<>();
        for(int i=0; i<intervals.size(); i++){
        	Interval current = intervals.get(i);
        	if(current.start > prev.end){
        		result.add(prev);
        		prev = current;
        	}else {
        		Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));
        		prev = merged;
        	}
        }
        result.add(prev);
        return result;
    }
	
	public static void main(String[] args) {
		MergeIntervals obj = new MergeIntervals();
		List<Interval> intervals = new ArrayList<>();
		Interval first = new Interval(1, 3);
		Interval second = new Interval(2, 6);
		Interval third = new Interval(8, 10);
		Interval fourth = new Interval(15, 18);
		
		intervals.add(fourth);
		intervals.add(second);
		intervals.add(third);
		intervals.add(first);
		
		obj.merge(intervals);
	}
}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
