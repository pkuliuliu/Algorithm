package com.liu.string;

/**
 * Created by liu on 17-7-7.
 */
public class StudentAttendanceRecordI {
    /**
     * You are given a string representing an attendance record for a student. The record only contains the following three characters:
     *
     * 'A' : Absent.
     * 'L' : Late.
     * 'P' : Present.
     * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
     * You need to return whether the student could be rewarded according to his attendance record.
     * Example 1:
     * Input: "PPALLP"Output: True
     *
     * Example 2:
     * Input: "PPALLL"
     * Output: False
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int acnt = 0;
        int lcnt = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if(chars[i]=='A'&&++acnt>1){
                return false;
            }
            if(chars[i]=='L'){
                if (++lcnt>2)
                    return false;
            }else {
                lcnt = 0;
            }
            System.out.println(acnt+"\t"+lcnt);
        }
        return true;
    }

    public boolean checkRecord2(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL")) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StudentAttendanceRecordI().checkRecord("PPALLP"));
        System.out.println(new StudentAttendanceRecordI().checkRecord("PPALLL"));
    }
}
