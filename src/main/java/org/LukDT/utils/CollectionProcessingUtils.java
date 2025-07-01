package org.LukDT.utils;

import org.LukDT.enums.StudyProfile;
import org.LukDT.model.Statistics;
import org.LukDT.model.Student;
import org.LukDT.model.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class CollectionProcessingUtils {
    private static final Logger logger = Logger.getLogger(CollectionProcessingUtils.class.getName());

    private CollectionProcessingUtils() {}

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {
        logger.info("Старт метода createStatistics()");

        List<Statistics> list = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            list.add(statistics);
            statistics.setStatisticsProfile(profile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setStatisticsCountUniversity(profileUniversityIds.size());
            statistics.setStatisticsNameUniversity(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setStatisticsNameUniversity(
                            statistics.getStatisticsNameUniversity() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setStatisticsCountStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setStatisticsAvg(0);
            avgExamScore.ifPresent(value -> statistics.setStatisticsAvg(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        return list;
    }
}
