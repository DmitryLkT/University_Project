package org.LukDT;

import org.LukDT.File.ReadXlsx;
import org.LukDT.model.Student;
import org.LukDT.model.University;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(ReadXlsx.readStudent());

       List<University> universities = new ArrayList<>(ReadXlsx.readUniversity());

        for(Student s : students) {
            System.out.println(s);
        }

    }
}
