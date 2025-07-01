package org.LukDT.utils;

import org.LukDT.comparatorModel.student.*;
import org.LukDT.comparatorModel.university.*;
import org.LukDT.enums.StudentComparatorOptions;
import org.LukDT.enums.UniversityComparatorOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class SortedUtils {
    private static final Logger logger = Logger.getLogger(SortedUtils.class.getName());

    private SortedUtils() {}

    public static StudentComparator getStudentComparator(StudentComparatorOptions sco) {
        logger.info("Старт метода getStudentComparator()");
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
                logger.log(Level.WARNING, "Получит недопустимый аргумент");
                throw new IllegalArgumentException(String.valueOf(sco));

        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorOptions uco) {
        logger.info("Старт метода getUniversityComparator()");
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
                logger.log(Level.WARNING, "Получит недопустимый аргумент");
                throw new IllegalArgumentException(String.valueOf(uco));
        }
    }
}
