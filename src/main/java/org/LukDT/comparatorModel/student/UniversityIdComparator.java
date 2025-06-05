package org.LukDT.comparatorModel.student;

import org.LukDT.model.Student;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class UniversityIdComparator implements StudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return StringUtils.compare(s1.getUniversityId(), s2.getUniversityId());
    }
}
