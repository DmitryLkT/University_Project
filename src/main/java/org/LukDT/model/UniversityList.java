package org.LukDT.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "allUniversity")
public class UniversityList {
    private List<University> university;

    public UniversityList() {}

    public UniversityList(List<University> university) {
        this.university = university;
    }

    @XmlElement
    public List<University> getUniversity() {
        return university;
    }

    public void setUniversity(List<University> university) {
        this.university = university;
    }
}
