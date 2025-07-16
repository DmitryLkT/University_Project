package org.LukDT.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "allStudent")
public class StudentList {
    private List<Student> student;

    public StudentList() {}

    public StudentList(List<Student> student) {
        this.student = student;
    }

    @XmlElement
    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> list) {
        this.student = list;
    }
}
