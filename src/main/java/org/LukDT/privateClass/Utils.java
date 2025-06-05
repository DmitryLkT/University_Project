package org.LukDT.privateClass;

import org.LukDT.comparatorModel.student.*;
import org.LukDT.comparatorModel.university.*;
import org.LukDT.enums.StudentComparatorOptions;
import org.LukDT.enums.UniversityComparatorOptions;

public final class Utils {
    private Utils() {}

    public static StudentComparator getStudentComparator(StudentComparatorOptions sco) {
        switch(sco) {
            case FULL_NAME:
                return new StudFullNameComparator();
            case UNIVERSITY_ID:
                return new UniversityIdComparator();
            case CURRENT_COURSE_NUMBER:
                return new CurrentCourseNumberComparator();
            case AVG_EXAM_SCOPE:
                return new AvgExamScoreComparator();
            default:
                throw new IllegalArgumentException(String.valueOf(sco));

        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorOptions uco) {
        switch(uco) {
            case ID:
                return new idComparator();
            case FULL_NAME:
                return new FullNameComparator();
            case SHORT_NAME:
                return new ShortNameComparator();
            case MAIN_PROFILE:
                return new MainProfileComparator();
            case YEAR_OF_FOUNDATION:
                return new YearOfFoundationComparator();
            default:
                throw new IllegalArgumentException(String.valueOf(uco));
        }
    }
}
