package com.dima.testing_big_dig.View.fragments.History_fragment.HistorySort;

import android.util.Log;

import com.dima.testing_big_dig.View.fragments.History_fragment.Reference;

import java.util.Comparator;
import java.util.Date;

public class ComparatorTime {


    static public Comparator<Reference> sort_time= new Comparator<Reference>(){
        private  int year1;
        private  int mounth1;
        private  int day1;
        private  int hour1;
        private  int minute1;
        private  int second1;

        private  int year2;
        private  int mounth2;
        private  int day2;
        private  int hour2;
        private  int minute2;
        private  int second2;

        private  Date date1;
        private  Date date2;
        @Override
        public int compare(Reference reference, Reference t1) {
            parse_time(reference.getTimeAt(),t1.getTimeAt());
            if(date1.compareTo(date2)<0){
                return 1;
            }
            else if(date1.compareTo(date2)>0){
                return -1;
            }
            return 0;
        }
        void parse_time(String time1, String time2){

            year1 = Integer.parseInt(time1.substring(0,4));
            mounth1 = Integer.parseInt(time1.substring(5,7));
            day1 = Integer.parseInt(time1.substring(8,10));
            hour1 = Integer.parseInt(time1.substring(11,13));
            minute1 = Integer.parseInt(time1.substring(14,16));
            second1 = Integer.parseInt(time1.substring(17,19));

            year2 = Integer.parseInt(time2.substring(0,4));
            Log.d("time",year2+"");
            mounth2 = Integer.parseInt(time2.substring(5,7));
            Log.d("time",mounth2+"");
            day2 = Integer.parseInt(time2.substring(8,10));
            Log.d("time",day2 +"");
            hour2 = Integer.parseInt(time2.substring(11,13));
            Log.d("time",hour2+"");
            minute2 = Integer.parseInt(time2.substring(14,16));
            Log.d("time",minute2+"");
            second2 = Integer.parseInt(time2.substring(17,19));
            Log.d("time",second2+"");

            date1 = new Date(year1,mounth1,day1,hour1,minute1,second1);
            date2 = new Date(year2,mounth2,day2,hour2,minute2,second2);
        }
    };

}
