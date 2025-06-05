package org.LukDT.comparatorModel.student;

import org.LukDT.model.Student;

import java.util.Comparator;

public class AvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return Float.compare(s2.getAvgExamScore(), s1.getAvgExamScore());
    }
}
