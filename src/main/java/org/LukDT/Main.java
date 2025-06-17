package org.LukDT;

import org.LukDT.File.XlsRead;
import org.LukDT.comparatorModel.student.StudentComparator;
import org.LukDT.comparatorModel.university.UniversityComparator;

import org.LukDT.enums.StudentComparatorOptions;
import org.LukDT.enums.UniversityComparatorOptions;
import org.LukDT.utils.JsonUtils;
import org.LukDT.model.Student;
import org.LukDT.model.University;
import org.LukDT.utils.SortedUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создаем коллекции полученных данный из xlsx
        List<Student> students = new ArrayList<>(XlsRead.readStudent());
        List<University> universities = new ArrayList<>(XlsRead.readUniversity());

        //Сортируем объекты при помощи компаратора
        StudentComparator studentComparator = SortedUtils.getStudentComparator(StudentComparatorOptions.FULL_NAME);
        UniversityComparator universityComparator = SortedUtils.getUniversityComparator(UniversityComparatorOptions.SHORT_NAME);

        //Выводем отсортированые объекты
        students.stream().sorted(studentComparator).forEach(System.out::println);
        System.out.println("---------------------");
        universities.stream().sorted(universityComparator).forEach(System.out::println);

        //Выполняем сериализацию и десериализацию отдельных объектов и коллекций
        JsonUtils.StudentSerialization(students.get(1));
        System.out.println(JsonUtils.StudentDeserialization());

        JsonUtils.UniversitySerialization(universities.get(0));
        System.out.println(JsonUtils.UniversityDeserialization());

        System.out.println(JsonUtils.StudentCollectionSerialization(students));
        System.out.println(JsonUtils.StudentCollectionDeserialization());

        System.out.println("---------------------");

        System.out.println(JsonUtils.UniversityCollectionSerialization(universities));
        System.out.println(JsonUtils.UniversityCollectionDeserialization());

        System.out.println("---------------------");

        universities.stream()
                //Выбираем отдельные объекты, которые основали полсе 1980 года
                .filter(u -> u.getYearOfFoundation() > 1980).
                forEach(u -> {
                    //Выводим получившиеся JSON-строки
                    System.out.println(JsonUtils.UniversitySerialization(u));
                    //Выводим десериализованный объект
                    System.out.println(JsonUtils.UniversityDeserialization());
        });

        students.stream()
                //Выбираем студентов 1-го курса
                .filter(s -> s.getCurrentCourseNumber() == 1)
                .forEach(s -> {
                    //Выводим получившиеся JSON-строки
                    System.out.println(JsonUtils.StudentSerialization(s));
                    //Выводим десериализованный объект
                    System.out.println(JsonUtils.StudentDeserialization());
                });
    }
}
