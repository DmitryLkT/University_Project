package org.LukDT.comparatorModel.university;

import org.LukDT.model.University;

import java.util.Comparator;

public class YearOfFoundationComparator implements Comparator<University> {
    @Override
    public int compare(University u1, University u2) {
        return Integer.compare(u1.getYearOfFoundation(), u2.getYearOfFoundation());
    }
}
