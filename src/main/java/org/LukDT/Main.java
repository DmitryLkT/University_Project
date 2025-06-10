package org.LukDT;

import org.LukDT.File.ReadXlsx;
import org.LukDT.comparatorModel.student.StudentComparator;
import org.LukDT.comparatorModel.university.UniversityComparator;

import org.LukDT.enums.StudentComparatorOptions;
import org.LukDT.enums.UniversityComparatorOptions;
import org.LukDT.json.JsonUtil;
import org.LukDT.model.Student;
import org.LukDT.model.University;
import org.LukDT.privateClass.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создаем коллекции полученных данный из xlsx
        List<Student> students = new ArrayList<>(ReadXlsx.readStudent());
        List<University> universities = new ArrayList<>(ReadXlsx.readUniversity());

        //Сортируем объекты при помощи компаратора
        StudentComparator studentComparator = Utils.getStudentComparator(StudentComparatorOptions.FULL_NAME);
        UniversityComparator universityComparator = Utils.getUniversityComparator(UniversityComparatorOptions.SHORT_NAME);

        //Выводем отсортированые объекты
        students.stream().sorted(studentComparator).forEach(System.out::println);
        System.out.println("---------------------");
        universities.stream().sorted(universityComparator).forEach(System.out::println);

        //Выполняем сериализацию и десериализацию отдельных объектов и коллекций
        JsonUtil.StudentSerialization(students.get(1));
        System.out.println(JsonUtil.StudentDeserialization());

        JsonUtil.UniversitySerialization(universities.get(0));
        System.out.println(JsonUtil.UniversityDeserialization());

        JsonUtil.StudentCollectionSerialization(students);
        System.out.println(JsonUtil.StudentCollectionDeserialization());

        System.out.println("---------------------");

        JsonUtil.UniversityCollectionSerialization(universities);
        System.out.println(JsonUtil.UniversityCollectionDeserialization());
    }
}
