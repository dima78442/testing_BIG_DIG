package com.dima.testing_big_dig.View.fragments.History_fragment.HistorySort;

import com.dima.testing_big_dig.View.fragments.History_fragment.Reference;

import java.util.Comparator;

public class ComparatorStatus {
    static public Comparator<Reference> sort_status= new Comparator<Reference>(){
        @Override
        public int compare(Reference reference, Reference t1) {
            if(Integer.parseInt(reference.getStatus())>Integer.parseInt(t1.getStatus())){
                return 1;
            }
            else if(Integer.parseInt(reference.getStatus())<Integer.parseInt(t1.getStatus())){
                return -1;
            }
            return 0;
        }
    };
}
