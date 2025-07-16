package org.LukDT;

import org.LukDT.File.XlsRead;
import org.LukDT.File.XlsWriter;
import org.LukDT.File.XmlWriter;
import org.LukDT.comparatorModel.student.StudentComparator;
import org.LukDT.comparatorModel.university.UniversityComparator;

import org.LukDT.enums.StudentComparatorOptions;
import org.LukDT.enums.UniversityComparatorOptions;
import org.LukDT.model.*;
import org.LukDT.utils.CollectionProcessingUtils;
import org.LukDT.utils.JsonUtils;
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

        //Выполняем сериализацию и десериализацию отдельных объектов и коллекций
        JsonUtils.StudentSerialization(students.get(1));;

        universities.stream()
                //Выбираем отдельные объекты, которые основали полсе 1980 года
                .filter(u -> u.getYearOfFoundation() > 1980).
                forEach(u -> {
        });

        students.stream()
                //Выбираем студентов 1-го курса
                .filter(s -> s.getCurrentCourseNumber() == 1)
                .forEach(s -> {
                });

        //Вызываем обработку статистики
        List<Statistics> statistics = CollectionProcessingUtils.createStatistics(students, universities);
        //Записываем статистику в отдельный файл
        XlsWriter.writeUniversity(statistics);

        //Генирируем XML-Структура для Student через "классы-обертку"
        XmlWriter.writeToXml(new StudentList(students), "Students");
        XmlWriter.writeToXml(new UniversityList(universities), "University");



    }
}
