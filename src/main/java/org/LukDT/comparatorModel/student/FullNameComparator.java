package org.LukDT.comparatorModel.student;

import org.LukDT.model.Student;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class FullNameComparator implements StudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return StringUtils.compare(s1.getFullName(), s2.getFullName());
    }
}
