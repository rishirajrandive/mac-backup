package com.rishi.string;

public class StudentAttendanceRecordI {

	/**
	 * Its simple
	 * @param s
	 * @return
	 */
	public boolean checkRecord(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        
        char[] records = s.toCharArray();
        int absentVal = 0;
        for(int i=0; i<records.length; i++){
            if(records[i] == 'A'){
                absentVal++;
            }else if(records[i] == 'L'){
                if(i+2 < records.length && records[i+1] == 'L' && records[i+2] == 'L'){
                    return false;
                }
            }
            
            if(absentVal > 1){
                return false;
            }
        }
        return true;
    }
}
