package org.LukDT.comparatorModel.university;

import org.LukDT.model.University;

import java.util.Comparator;

public class MainProfileComparator implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        return u1.getMainProfile().compareTo(u2.getMainProfile());
    }
}
