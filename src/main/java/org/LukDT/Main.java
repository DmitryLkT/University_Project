package org.LukDT;

import org.LukDT.File.ReadXlsx;
import org.LukDT.comparatorModel.student.StudentComparator;
import org.LukDT.comparatorModel.university.UniversityComparator;

import org.LukDT.enums.StudentComparatorOptions;
import org.LukDT.enums.UniversityComparatorOptions;
import org.LukDT.model.Student;
import org.LukDT.model.University;
import org.LukDT.privateClass.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(ReadXlsx.readStudent());
        List<University> universities = new ArrayList<>(ReadXlsx.readUniversity());

        StudentComparator studentComparator = Utils.getStudentComparator(StudentComparatorOptions.FULL_NAME);
        UniversityComparator universityComparator = Utils.getUniversityComparator(UniversityComparatorOptions.SHORT_NAME);

        students.stream().sorted(studentComparator).forEach(System.out::println);
        universities.stream().sorted(universityComparator).forEach(System.out::println);
    }
}
