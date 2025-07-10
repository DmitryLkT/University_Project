package org.LukDT.model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "student")
public class Student implements Serializable {

    @SerializedName("fullNameStudent")
    private String fullName;

    @SerializedName("Id")
    private String universityId;

    @SerializedName("courseNumber")
    private int currentCourseNumber;

    @SerializedName("avg")
    private float avgExamScore;

    public Student() {}

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "Student\n{" +
                "Full name = '" + fullName + '\'' +
                ",\n University ID = '" + universityId + '\'' +
                ",\n Current course number = " + currentCourseNumber +
                ",\n Avg exam score = " + avgExamScore +
                '}';
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    @XmlElement
    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    @XmlElement
    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }
}
