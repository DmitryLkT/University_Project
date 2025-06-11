package org.LukDT.model;

import com.google.gson.annotations.SerializedName;
import org.LukDT.enums.StudyProfile;

import java.io.Serializable;

public class University implements Serializable {
    @SerializedName("number")
    private String id;
    @SerializedName("fullNameUn")
    private String fullName;
    @SerializedName("shortNameUn")
    private String shortName;
    @SerializedName("foundation")
    private int yearOfFoundation;
    @SerializedName("profile")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation,
               StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University\n{" +
                "id = '" + id + '\'' +
                ",\n Full name = '" + fullName + '\'' +
                ",\n Short name = '" + shortName + '\'' +
                ",\n Year of foundation = " + yearOfFoundation +
                ",\n Main profile = " + mainProfile +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }
}
