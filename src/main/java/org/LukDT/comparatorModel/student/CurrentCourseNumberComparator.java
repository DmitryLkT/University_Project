package org.LukDT.comparatorModel.student;

import org.LukDT.model.Student;

import java.util.Comparator;

public class CurrentCourseNumberComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getCurrentCourseNumber(), s2.getCurrentCourseNumber());
    }

}
